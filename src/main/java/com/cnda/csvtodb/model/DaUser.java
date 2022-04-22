package com.cnda.csvtodb.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DA_USER")
public class DaUser {

	@Id
	@Column(name = "DA_GROUP_ID")
	private int groupId;
	@Column(name = "DA_GROUP_NAME", length = 30)
	private String groupName;
	@Column(name = "DA_GROUP_DESC", length = 30)
	private String groupDesc;
	@Column(name = "DA_GROUP_STATUS", length = 1)
	private String groupStatus;
	@Column(name = "CREATED_DT")
	private LocalDateTime createdDate;
	@Column(name = "CREATED_USER", length = 30)
	private String createdUser;
	@Column(name = "LASTUPDATE_DATE")
	private LocalDateTime lastUpdateDate;
	@Column(name = "LASTUPDATE_USER", length = 30)
	private String lastupdateUser;
	@Column(name = "RECORD_SOURCE", length = 30)
	private String recordSource;
	@Column(name = "OBJECT_VERSION_NUMBER")
	private int objectVersionNumber;

	public DaUser() {
	}

	public DaUser(int groupId, String groupName, String groupDesc, String groupStatus, LocalDateTime createdDate,
			String createdUser, LocalDateTime lastUpdateDate, String lastupdateUser, String recordSource,
			int objectVersionNumber) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupDesc = groupDesc;
		this.groupStatus = groupStatus;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
		this.lastUpdateDate = lastUpdateDate;
		this.lastupdateUser = lastupdateUser;
		this.recordSource = recordSource;
		this.objectVersionNumber = objectVersionNumber;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	public String getGroupStatus() {
		return groupStatus;
	}

	public void setGroupStatus(String groupStatus) {
		this.groupStatus = groupStatus;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public LocalDateTime getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLastupdateUser() {
		return lastupdateUser;
	}

	public void setLastupdateUser(String lastupdateUser) {
		this.lastupdateUser = lastupdateUser;
	}

	public String getRecordSource() {
		return recordSource;
	}

	public void setRecordSource(String recordSource) {
		this.recordSource = recordSource;
	}

	public int getObjectVersionNumber() {
		return objectVersionNumber;
	}

	public void setObjectVersionNumber(int objectVersionNumber) {
		this.objectVersionNumber = objectVersionNumber;
	}

	@Override
	public String toString() {
		return "DaUser [groupId=" + groupId + ", groupName=" + groupName + ", groupDesc=" + groupDesc + ", groupStatus="
				+ groupStatus + ", createdDate=" + createdDate + ", createdUser=" + createdUser + ", lastUpdateDate="
				+ lastUpdateDate + ", lastupdateUser=" + lastupdateUser + ", recordSource=" + recordSource
				+ ", objectVersionNumber=" + objectVersionNumber + "]";
	}

}
