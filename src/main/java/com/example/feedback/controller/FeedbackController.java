package com.example.feedback.controller;

import java.util.List;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.feedback.dto.FeedbackDetails;
import com.example.feedback.entity.Feedback;
import com.example.feedback.exception.IdNotFoundException;
import com.example.feedback.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
@CrossOrigin(origins = "http://localhost:3000")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/addfeedback")
	public ResponseEntity<FeedbackDetails> addFeedback(@RequestBody FeedbackDetails request){
		return new ResponseEntity<>( feedbackService.addFeedback(request),HttpStatus.OK);
		
	}
	
	@PutMapping("/updatefeedback/{id}")
	public ResponseEntity<FeedbackDetails> updateFeedback(@PathVariable ("id") Long feedbackId,@RequestBody FeedbackDetails request){
		return new ResponseEntity<>( feedbackService.updateFeedback(feedbackId,request),HttpStatus.OK);
		
	}
	@GetMapping("/getallfeedback")
	public ResponseEntity<List<Feedback>> getAllFeedback(){
		return new ResponseEntity<>( feedbackService.getAllFeedback(),HttpStatus.OK);
		
	}
	
	@GetMapping("/getbyfeedbackid/{id}")
	public ResponseEntity<?> findFeedbackDetailsById (@PathVariable ("id") Long feedbackId ){
		
		try {
			return new ResponseEntity<>( feedbackService.findFeedbackDetailsById(feedbackId),HttpStatus.OK);
		}
		catch(IdNotFoundException e) {
			return new ResponseEntity<>("Id Not Found",HttpStatus.NOT_FOUND);
			
		}
		
		
		
	}
	
	@DeleteMapping("/deletebyfeedbackid/{id}")
	public ResponseEntity<String> deleteFeedbackDetailsById(@PathVariable("id")Long feedbackId){
		return new ResponseEntity<>(feedbackService.deleteFeedbackById(feedbackId),HttpStatus.OK);
		
	}
}
