package com.guorui.springboottest03.bean;

public class Question {

    private String questionId;
    private String questionInformation;
    private String questionSolution;
    private String questionType;
    private String questionName;

    @Override
    public String toString() {
        return "Question{" +
                "questionId='" + questionId + '\'' +
                ", questionInformation='" + questionInformation + '\'' +
                ", questionSolution='" + questionSolution + '\'' +
                ", questionType='" + questionType + '\'' +
                ", questionName='" + questionName + '\'' +
                '}';
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionInformation() {
        return questionInformation;
    }

    public void setQuestionInformation(String questionInformation) {
        this.questionInformation = questionInformation;
    }

    public String getQuestionSolution() {
        return questionSolution;
    }

    public void setQuestionSolution(String questionSolution) {
        this.questionSolution = questionSolution;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }
}
