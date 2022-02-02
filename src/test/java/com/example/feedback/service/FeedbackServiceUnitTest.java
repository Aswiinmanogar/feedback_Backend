package com.example.feedback.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.feedback.dto.FeedbackDetails;
import com.example.feedback.entity.Feedback;
import com.example.feedback.exception.IdNotFoundException;
import com.example.feedback.repository.FeedbackRepository;
import com.example.feedback.util.FeedbackUtil;

@ExtendWith(MockitoExtension.class)
class FeedbackServiceImplUnitTest {


	@Mock
	FeedbackRepository repository;

	@InjectMocks
	@Spy
	FeedbackService service;
	
	private FeedbackUtil utility;

	@Test
	public FeedbackDetails testFindFeedbackDetailsById() {
		long feedbackId = 10;
		Feedback feedback = mock(Feedback.class);
		Optional<Feedback> optional = Optional.of(feedback);
		when(repository.findById(feedbackId)).thenReturn(optional);
		FeedbackDetails result = service.findFeedbackDetailsById(feedbackId);
		assertEquals(feedback, result);
		verify(repository).findById(feedbackId);
		return utility.toDetails(feedback);
	}

	@Test
	public void testFindFeedbackDetailsById_2() {
		long feedbackId = 10;
		Executable executable = () -> {
			Optional<Feedback> optional = Optional.empty();
			when(repository.findById(feedbackId)).thenReturn(optional);
			service.findFeedbackDetailsById(feedbackId);
		};
		assertThrows(IdNotFoundException.class, executable);
	}

	@Test
	public FeedbackDetails testaddFeedback() {

		FeedbackDetails request = new FeedbackDetails();
		
		request.setFeedbackId(1L);
		request.setCustomerName("Aswiin");
		request.setEmailId("aswiinmanogar@gmail.com");
		request.setConnectionType("Domestic");
		request.setRating(7L);
		request.setDescription("Good");


		Feedback feedback = mock(Feedback.class);
		when(repository.save(request)).thenReturn(feedback);
		FeedbackDetails result = service.addFeedback(request);
		assertEquals(feedback, result);
		verify(repository).save(request);
		return utility.toDetails(feedback);

	}

}