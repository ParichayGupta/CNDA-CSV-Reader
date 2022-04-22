package com.cnda.csvtodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cnda.csvtodb.service.CNDAService;

@RestController
public class CNDAController {

	@Autowired
	private CNDAService cndaService;


	@RequestMapping(value = "/path", method = RequestMethod.GET)
	public void readAllFilesFromDirectory() {
		cndaService.readFileFromDirectory();
	}

//	@RequestMapping(value = "/saveData", method = RequestMethod.GET)
//	public void saveData() throws IOException {
//		daUserService.savetoDb(new Path() {
//
//			@Override
//			public URI toUri() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Path toRealPath(LinkOption... options) throws IOException {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Path toAbsolutePath() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Path subpath(int beginIndex, int endIndex) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public boolean startsWith(Path other) {
//				// TODO Auto-generated method stub
//				return false;
//			}
//
//			@Override
//			public Path resolve(Path other) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Path relativize(Path other) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public WatchKey register(WatchService watcher, Kind<?>[] events, Modifier... modifiers) throws IOException {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Path normalize() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public boolean isAbsolute() {
//				// TODO Auto-generated method stub
//				return false;
//			}
//
//			@Override
//			public Path getRoot() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Path getParent() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public int getNameCount() {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//
//			@Override
//			public Path getName(int index) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public FileSystem getFileSystem() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public Path getFileName() {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//			@Override
//			public boolean endsWith(Path other) {
//				// TODO Auto-generated method stub
//				return false;
//			}
//
//			@Override
//			public int compareTo(Path other) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		});
//	}

}
