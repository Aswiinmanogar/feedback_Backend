package com.example.feedback.util;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.feedback.dto.FeedbackDetails;
import com.example.feedback.entity.Feedback;

@Component
public class FeedbackUtil {
	public FeedbackDetails toDetails(Feedback feedback) {
		FeedbackDetails response = new FeedbackDetails();
		response.setFeedbackId(feedback.getFeedbackId());
		response.setCustomerName(feedback.getCustomerName());
		response.setEmailId(feedback.getEmailId());
		response.setConnectionType(feedback.getConnectionType());
		response.setDescription(feedback.getDescription());
		response.setRating(feedback.getRating());
		
		return response;
	}
	public List<FeedbackDetails> toDetailsList(Collection<Feedback> feedback){
		return feedback.stream().map(feedback1->toDetails(feedback1)).collect(Collectors.toList());
	}

}
