package com.example.supriyak.cleanindia;

/**
 * Created by supriya.k on 07-04-2018.
 */
public class Feedback {
    private String Email;
    private String Feedback;
    private String Trashcanid;

    public Feedback() {

    }

    public Feedback(String feedback, String email, String trashcanid) {
        Feedback = feedback;
        Email = email;
        Trashcanid = trashcanid;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFeedback() {
        return Feedback;
    }

    public void setFeedback(String feedback) {
        Feedback = feedback;
    }

    public String getTrashcanid() {
        return Trashcanid;
    }

    public void setTrashcanid(String trashcanid) {
        Trashcanid = trashcanid;
    }
}
