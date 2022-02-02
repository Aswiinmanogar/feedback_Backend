package com.example.feedback.ManualTesting;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.feedback.FeedbackApplication;
import com.example.feedback.dto.FeedbackDetails;
import com.example.feedback.entity.Feedback;
import com.example.feedback.service.FeedbackService;

@Component
public class ManualTesting {
private static final Logger Log = LoggerFactory.getLogger(FeedbackApplication.class);
	
	@Autowired
	private FeedbackService service;
	
	@PostConstruct
	public void add() {
		FeedbackDetails request = new FeedbackDetails();
		request.setFeedbackId(3L);
		request.setCustomerName("Atchu");;
		request.setEmailId("aswiin@gmail.com");
		request.setConnectionType("Domestic");
		request.setDescription("Good");
		request.setRating(7L);
		request = service.addFeedback(request);
		System.out.println(request);
		System.out.println("added.......");
		
		//fetch by feedbackId
		Log.info("FoundById=" + service.findFeedbackDetailsById(1L).toString());
		
		// all feedback
		List<Feedback> list = service.getAllFeedback();
		Log.info("All Feedback Details =" + list.toString());
	}

}
