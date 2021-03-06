package com.example.demo.controller;

import com.example.demo.client.NotificationClient;
import com.example.demo.persistence.Feedback;
import com.example.demo.persistence.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events/feedback")
public class FeedbackController {

    private FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackController(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Autowired
    public NotificationClient notificationClient;

    @PostMapping
    public ResponseEntity createFeedback(@RequestBody Feedback feedback) {
        Feedback savedFeedback = feedbackRepository.save(feedback);
        notificationClient.notify(savedFeedback.getId());

        return new ResponseEntity("Feedback added successfully", HttpStatus.OK);
    }

    @GetMapping
    public List<Feedback> getFeedback() {
        return feedbackRepository.findAll();
    }
}
