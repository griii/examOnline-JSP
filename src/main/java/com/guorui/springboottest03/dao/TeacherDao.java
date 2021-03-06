package com.guorui.springboottest03.dao;

import com.guorui.springboottest03.bean.*;
import org.springframework.beans.factory.parsing.QualifierEntry;

import java.util.List;

public interface TeacherDao {


    //查询所有学生信息
    public List<Student> findAllStudent();

    //登录教师端
    Teacher loginId(String ID);

    Teacher loginP(String ID,String password);

    Student findStudent(String ID);

    void deleteStudent(String ID);

    void killP(String ID);

    List<Question> findAllQuestion();

    void deleteQuestion(String ID);

    Question findQuestion(String questionId);

    void questionUpdata(Question question);

    void examInsert(Exam exam);

    ExamStudentInfor[] findAllExamInfor(int examId);

    List<Exam> findAllExam();

    void updateStudent(Student student);
}
