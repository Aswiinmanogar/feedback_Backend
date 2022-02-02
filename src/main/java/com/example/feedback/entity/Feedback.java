package com.example.feedback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="Feedback")
public class Feedback {
	
	@Id
	@GeneratedValue	
	@NotNull(message = "feedbackId should not be empty")
	private Long feedbackId;
	@NotNull(message = "customerName should not be empty")
	@Size(min=2, message="First name must not be less than 2 characters")
	private String customerName;
	@Email
	private String emailId;
	@NotNull( message = "connectionType should not be empty")
	private String connectionType;
	@Size(min = 0, max = 10, message = "rating should be from 0 to 10")
	private Long rating;
	@NotNull( message = "description should not be empty")
	private String description;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getConnectionType() {
		return connectionType;
	}
	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}
	public Long getRating() {
		return rating;
	}
	public void setRating(Long rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 
	
	

}
