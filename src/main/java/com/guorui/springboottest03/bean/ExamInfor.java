package com.guorui.springboottest03.bean;

//考试信息
public class ExamInfor {

    private int examId;
    private String studentId;
    private String answer;
    private int score;
    private String erroAnswer;

    public String getErroAnswer() {
        return erroAnswer;
    }

    public void setErroAnswer(String erroAnswer) {
        this.erroAnswer = erroAnswer;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public ExamInfor(int examId, String studentId, String answer, int score) {
        this.examId = examId;
        this.studentId = studentId;
        this.answer = answer;
        this.score = score;
    }

    @Override
    public String toString() {
        return "ExamInfor{" +
                "examId=" + examId +
                ", studentId=" + studentId +
                ", answer='" + answer + '\'' +
                ", score=" + score +
                '}';
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
