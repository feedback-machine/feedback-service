package com.example.demo.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "feedback")
public class Feedback {

    @Id
    private String id;

    private String event;

    private String comment;

    private boolean delivered;

    public Feedback(String event, String comment) {
        this.event = event;
        this.comment = comment;
    }

    public Feedback() {
    }

    public String getId() {
        return id;
    }

    public String getEvent() {
        return event;
    }

    public String getComment() {
        return comment;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }
}
