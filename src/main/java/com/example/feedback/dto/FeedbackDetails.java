package com.example.feedback.dto;

public class FeedbackDetails {
	private Long feedbackId;
	private String customerName;
	private String emailId;
	private String connectionType;
	private Long rating;
	private String description;
	public Long getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}
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
	
	@Override
	public String toString() {
		return "FeedbackDetails [feedbackId=" + feedbackId + ", customerName=" + customerName + ", emailId=" + emailId + ", connectionType=" + connectionType
				+ ", rating=" + rating + "]";
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
