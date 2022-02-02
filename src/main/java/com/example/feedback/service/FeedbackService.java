package com.example.feedback.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.feedback.dto.FeedbackDetails;
import com.example.feedback.entity.Feedback;
import com.example.feedback.exception.IdNotFoundException;
import com.example.feedback.repository.FeedbackRepository;
import com.example.feedback.util.FeedbackUtil;
import com.sun.istack.NotNull;

@Service
public class FeedbackService {
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Autowired
	private FeedbackUtil utility;

	public FeedbackDetails addFeedback( @NotNull FeedbackDetails response) {
		Feedback feedback = new Feedback();
		feedback.setFeedbackId(response.getFeedbackId());
		feedback.setCustomerName(response.getCustomerName());
		feedback.setEmailId(response.getEmailId());
		feedback.setConnectionType(response.getConnectionType());
		feedback.setRating(response.getRating());
		feedback.setDescription(response.getDescription());
		feedback = feedbackRepository.save(feedback);
		return utility.toDetails(feedback);
	}
	
	public FeedbackDetails updateFeedback(Long feedbackId, @NotNull FeedbackDetails response) {
		Feedback feedback = findById(feedbackId);
		feedback.setCustomerName(response.getCustomerName());
		feedback.setEmailId(response.getEmailId());
		feedback.setConnectionType(response.getConnectionType());
		feedback.setRating(response.getRating());
		feedback.setDescription(response.getDescription());
		feedback = feedbackRepository.save(feedback);
		return utility.toDetails(feedback);
	}
	
	public List<Feedback> getAllFeedback(){
		return feedbackRepository.findAll();
	}
	
	
	public FeedbackDetails findFeedbackDetailsById(Long feedbackId) {
		Feedback feedback = findById(feedbackId);
		return utility.toDetails(feedback);
	}


	public Feedback findById(Long feedbackid) {
		Optional<Feedback> optional = feedbackRepository.findById(feedbackid);
		if (!optional.isPresent()) {
			throw new IdNotFoundException("Feedback Not Found for this id =" + feedbackid);
		}
		return optional.get();
	}

	public String deleteFeedbackById(Long feedbackId) {
		feedbackRepository.deleteById(feedbackId);
		return "Deleted";
	}

	
}
