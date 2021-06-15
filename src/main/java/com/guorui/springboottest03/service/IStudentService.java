package com.guorui.springboottest03.service;

public interface IStudentService {

    String login(int account,String psw);
    String register(int account,String psw,String name);
    String selectScore(int examId);
    String loadExam(int examId);
    String updateExam(int examId,String questionAnwer);

}
