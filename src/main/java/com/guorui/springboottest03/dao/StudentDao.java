package com.guorui.springboottest03.dao;

import com.guorui.springboottest03.bean.Exam;
import com.guorui.springboottest03.bean.ExamInfor;
import com.guorui.springboottest03.bean.Question;
import com.guorui.springboottest03.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentDao {

    Student loginId(String ID);

    Student loginP(String ID,String password);

    Question getQuestionById(int questionId);

    String getQuestionInforByExamId(int examId);

    String getSolutionByQuestionId(int questionId);

    ExamInfor getExamInforByExamIdAndStudentId(int examId,String studentId);

    void insertExamInfor(ExamInfor examInfor);

    List<Exam> findAllExam(String studentId);

    String getErroAnswer(int examId,String studentId);

    int getScore(int examId,String studentId);

    void insert(String id,String password,String name);

}
