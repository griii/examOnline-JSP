package com.guorui.springboottest03.service;

import com.guorui.springboottest03.bean.*;
import com.guorui.springboottest03.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherDao teacherDao;

    public List<Student> findAllStudent(){
        return teacherDao.findAllStudent();
    }

    public String login(String id,String password){
        Teacher teacher = teacherDao.loginId(id);
        if (teacher==null){
            return "教工号不存在!!!";
        }else{
            teacher = teacherDao.loginP(id,password);
        }
        if (teacher==null){
            return "密码错误!!!";
        }else{
            return teacher.getName();
        }
    }

    public Student findStudent(String id){
        return teacherDao.findStudent(id);
    }

    public void deleteStudent(String id){
        teacherDao.deleteStudent(id);
    }

    public void killP(String id){
        teacherDao.killP(id);
    }

    public List<Question> findAllQuestion(){return teacherDao.findAllQuestion();}

    public void deleteQuestion(String id){teacherDao.deleteQuestion(id);}

    public Question findQuestion(String id){return teacherDao.findQuestion(id);}

    public void questionUpdata(Question question){teacherDao.questionUpdata(question);}

    public void updateStudent(Student student){
        teacherDao.updateStudent(student);
    }

    public void examInsert(Exam exam){
        teacherDao.examInsert(exam);
    }

    public List<Exam> findAllExam(){
        return teacherDao.findAllExam();
    }

    public ExamStudentInfor[] findAllExamInfor(int examId){
        return teacherDao.findAllExamInfor(examId);
    }

}
