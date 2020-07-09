package com.miniproject.one.dto;

import java.io.Serializable;
import java.util.Date;

public class ContactDTO implements Serializable {
	
	
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Integer contactNumber;
	private Date insertDate;
	private Date updatedDate;
	
	public ContactDTO() {
	}
	
	
	
	public ContactDTO(Integer contactId, String contactName, String contactEmail, Integer contactNumber, Date insertDate,
			Date updatedDate) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactEmail = contactEmail;
		this.contactNumber = contactNumber;
		this.insertDate = insertDate;
		this.updatedDate = updatedDate;
	}



	public Integer getContactId() {
		return contactId;
	}




	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}




	public String getContactName() {
		return contactName;
	}




	public void setContactName(String contactName) {
		this.contactName = contactName;
	}




	public String getContactEmail() {
		return contactEmail;
	}




	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}




	public Integer getContactNumber() {
		return contactNumber;
	}




	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}




	public Date getInsertDate() {
		return insertDate;
	}




	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}




	public Date getUpdatedDate() {
		return updatedDate;
	}




	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}




	@Override
	public String toString() {
		return "ContactDTO [contactId=" + contactId + ", contactName=" + contactName + ", contactEmail=" + contactEmail
				+ ", contactNumber=" + contactNumber + ", insertDate=" + insertDate + ", updatedDate=" + updatedDate
				+ "]";
	}


}
