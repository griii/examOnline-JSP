package com.guorui.springboottest03.bean;
public class Exam {
    private String examId;
    private String examName;
    private String examTime;
    private String examSetter;
    private String examQuestion;
    @Override
    public String toString() {
        return "Exam{" +
                "examId='" + examId + '\'' +
                ", examName='" + examName + '\'' +
                ", examTime='" + examTime + '\'' +
                ", examSetter='" + examSetter + '\'' +
                ", examQuestion='" + examQuestion + '\'' +
                '}';
    }
    public String getExamId() {
        return examId;
    }
    public void setExamId(String examId) {
        this.examId = examId;
    }
    public String getExamName() {
        return examName;
    }
    public void setExamName(String examName) {
        this.examName = examName;
    }
    public String getExamTime() {
        return examTime;
    }
    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }
    public String getExamSetter() {
        return examSetter;
    }
    public void setExamSetter(String examSetter) {
        this.examSetter = examSetter;
    }
    public String getExamQuestion() {
        return examQuestion;
    }
    public void setExamQuestion(String examQuestion) {
        this.examQuestion = examQuestion;
    }
}
