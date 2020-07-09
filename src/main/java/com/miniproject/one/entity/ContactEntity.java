package com.miniproject.one.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Contact_Dtls")
public class ContactEntity {

	@Id
	@Column(name = "contact_id")
	@SequenceGenerator(
			name="cid_seq_gen",
			sequenceName="CONTACT_ID_SEQ",
			allocationSize=1
	)
	@GeneratedValue(
			generator="cid_seq_gen",
			strategy=GenerationType.SEQUENCE
	)
	private Integer contactId;
	@Column(name = "CONTACT_NAME")
	private String contactName;
	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;
	@Column(name = "CONTACT_NUMBER")
	private Integer contactNumber;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)	
	@Column(name = "CREATED_DATE",updatable = false )
	private Date insertDate;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)	
	@Column(name = "UPDATED_DATE",insertable = false)

	private Date updatedDate;

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
		return "ContactEntity [contactId=" + contactId + ", contactName=" + contactName + ", contactEmail="
				+ contactEmail + ", contactNumber=" + contactNumber + ", insertDate=" + insertDate + ", updatedDate="
				+ updatedDate + "]";
	}

}
