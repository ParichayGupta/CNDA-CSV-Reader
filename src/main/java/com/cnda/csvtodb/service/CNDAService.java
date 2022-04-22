package com.cnda.csvtodb.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnda.csvtodb.model.DaGroupUser;
import com.cnda.csvtodb.model.DaUser;
import com.cnda.csvtodb.repository.DaGroupUserRepo;
import com.cnda.csvtodb.repository.DaUserRepo;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CNDAService {

	@Autowired
	private DaUserRepo daUserRepo;
	@Autowired
	private DaGroupUserRepo daGroupUserRepo;

	private String line = "";
	private String directoryPath = "C:\\Users\\896960\\Downloads\\";
	private int fileCount = 0;
	private int csvFileCount = 0;
	private int totalRows = 0;
	private int parsedRows = 0;
	private int skippedRows = -2;
	private int successfullFiles = 0;
	private int failedFiles = 0;

	public void readFileFromDirectory() {
		// Getting all the files from the path
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(directoryPath))) {
			for (Path file : stream) {
				fileCount++;
				// iterating all the files from the path
				System.out.println(file.getFileName());

				// Checking file extension and saving it to the database
				// convert the file name into string
				String fileName = file.toString();
				int index = fileName.lastIndexOf('.');
				if (index > 0) {
					String extension = fileName.substring(index + 1);
//					System.out.println("File extension is " + extension);
					if (extension.equals("csv")) {
						// if we get a CSV file we will store the data into database
						csvFileCount++;
						savetoDb(file);
						totalRows = 0;
						parsedRows = 0;
					}
				}
			}
		} catch (IOException | DirectoryIteratorException e) {
			System.err.println(e);
		}
	}

	public void savetoDb(Path filePath) throws IOException {
		String fileName = filePath.getFileName().toString();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath.toString())); // path
			bufferedReader.readLine(); // skipping the header row

			while ((line = bufferedReader.readLine()) != null) {
				// iterating all rows of the file
				if (line != null) {
					String[] data = line.split(",");
					try {
						if (data[0] != null || data[1] != null || data[2] != null) {
							totalRows++;
							if (data[0] != null && data[1] != null && data[2] != null) {
								parsedRows++;
								DaGroupUser daGroupUser = new DaGroupUser();
								daGroupUser.setGroupId(Integer.parseInt(data[1]));
								daGroupUser.setUserCapNumber(data[2]);
								daGroupUser.setGroupUserStatus("A");
								daGroupUser.setCreatedDate(LocalDateTime.now());
								daGroupUser.setCreatedUser(data[0]);
								daGroupUser.setLastUpdateDate(LocalDateTime.now());
								daGroupUser.setLastupdateUser(data[0]); // Confusion Here
								daGroupUser.setRecordSource("NA");
								daGroupUser.setObjectVersionNumber(0);
								daGroupUserRepo.save(daGroupUser);

								DaUser daUser = new DaUser();
								daUser.setGroupId(Integer.parseInt(data[1]));
								daUser.setGroupName(fileName);
								daUser.setGroupDesc("NA");
								daUser.setGroupStatus("A");
								daUser.setCreatedDate(LocalDateTime.now());
								daUser.setCreatedUser(data[0]); // Confusion Here
								daUser.setLastUpdateDate(LocalDateTime.now());
								daUser.setLastupdateUser(data[0]);
								daUser.setRecordSource("NA");
								daUser.setObjectVersionNumber(0);
								daUserRepo.save(daUser);

							}
							System.out.println("Total Rows:" + totalRows + "\nParsed Rows: " + parsedRows);

						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println(e.getMessage());
						skippedRows++;
						System.out.println("Row skipped in: " + fileName + "\nskippedRows: " + skippedRows);

					}

				} else {
					bufferedReader.close();
					System.out.println("Finished reading file: " + fileName);
				}
			}
			if (totalRows == parsedRows) {
				successfullFiles++;
			} else if (totalRows != parsedRows) {
				failedFiles++;
			}
			System.out.println("Successfull Files: " + successfullFiles + "\nfailed files: " + failedFiles);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 generatePdf();
	}

	public void generatePdf() {
		try {
			OutputStream file = new FileOutputStream(new File("C:\\CNDA\\Test.pdf"));
System.out.println("Document init");
			Document document = new Document();
			PdfWriter.getInstance(document, file);

			document.open();
			document.add(new Paragraph("Total Files in the Directory: " + fileCount));
			document.add(new Paragraph("Total CVS Files in the Directory: " + csvFileCount));
			document.add(new Paragraph("Successfull files: " + successfullFiles));
			document.add(new Paragraph("Failed Files: " + failedFiles));
			System.out.println("document added");
			document.close();
			file.close();
			System.out.println("Document completed");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}