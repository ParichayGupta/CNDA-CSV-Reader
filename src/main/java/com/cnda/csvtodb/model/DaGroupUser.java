package com.cnda.csvtodb.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DA_GROUP_USER")
public class DaGroupUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DA_GROUP_USER_ID")
	private int groupUserId;
	@Column(name = "DA_GROUP_ID")
	private int groupId;
	@Column(name = "USER_CAP_NUMBER", length = 30)
	private String userCapNumber;
	@Column(name = "GROUP_USER_STATUS", length = 1)
	private String groupUserStatus;
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
	private int objectVersionNumber;

	public DaGroupUser() {
		// TODO Auto-generated constructor stub
	}

	public DaGroupUser(int groupUserId, int groupId, String userCapNumber, String groupUserStatus,
			LocalDateTime createdDate, String createdUser, LocalDateTime lastUpdateDate, String lastupdateUser,
			String recordSource, int objectVersionNumber) {
		super();
		this.groupUserId = groupUserId;
		this.groupId = groupId;
		this.userCapNumber = userCapNumber;
		this.groupUserStatus = groupUserStatus;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
		this.lastUpdateDate = lastUpdateDate;
		this.lastupdateUser = lastupdateUser;
		this.recordSource = recordSource;
		this.objectVersionNumber = objectVersionNumber;
	}

	public int getGroupUserId() {
		return groupUserId;
	}

	public void setGroupUserId(int groupUserId) {
		this.groupUserId = groupUserId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getUserCapNumber() {
		return userCapNumber;
	}

	public void setUserCapNumber(String userCapNumber) {
		this.userCapNumber = userCapNumber;
	}

	public String getGroupUserStatus() {
		return groupUserStatus;
	}

	public void setGroupUserStatus(String groupUserStatus) {
		this.groupUserStatus = groupUserStatus;
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
		return "DaGroupUser [groupUserId=" + groupUserId + ", groupId=" + groupId + ", userCapNumber=" + userCapNumber
				+ ", groupUserStatus=" + groupUserStatus + ", createdDate=" + createdDate + ", createdUser="
				+ createdUser + ", lastUpdateDate=" + lastUpdateDate + ", lastupdateUser=" + lastupdateUser
				+ ", recordSource=" + recordSource + ", objectVersionNumber=" + objectVersionNumber + "]";
	}

}
