package com.guorui.springboottest03.bean;


import java.util.Date;

public class Exam {
    private String examId;
    private String examName;
    private String examTime;
    private String examSetter;
    private String examQuestion;
    private String examStartTime;
    private int score;
    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getExamStartTime() {
        return examStartTime;
    }

    public void setExamStartTime(String examStartTime) {
        this.examStartTime = examStartTime;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId='" + examId + '\'' +
                ", examName='" + examName + '\'' +
                ", examTime='" + examTime + '\'' +
                ", examSetter='" + examSetter + '\'' +
                ", examQuestion='" + examQuestion + '\'' +
                ", examStartTime='" + examStartTime + '\'' +
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
