package com.guorui.springboottest03.controller;

import com.guorui.springboottest03.bean.Exam;
import com.guorui.springboottest03.bean.ExamInfor;
import com.guorui.springboottest03.bean.Question;
import com.guorui.springboottest03.service.StudentService;
import com.guorui.springboottest03.service.TeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @RequestMapping("/getQuestions")
    public List<Question> getQuestions(int examId){
        return studentService.getQuestions(examId);
    }

    @PostMapping("/submitExam")
    public String submitExam(@ModelAttribute ExamInfor examInfor, HttpSession session){
        System.out.println(examInfor);
        examInfor.setStudentId((session.getAttribute("studentId").toString()));
        return studentService.submitExam(examInfor.getExamId(),examInfor.getStudentId(),examInfor.getAnswer());
    }

    @RequestMapping("/findAllExam")
    public List<Exam> findAllExam(HttpSession session){
        return studentService.findAllExam(session.getAttribute("studentId").toString());
    }


    @RequestMapping("/getErroAnswer")
    public String getErroAnswer(String studentId,int examId){
        return studentService.getErroAnswer(studentId,examId);
    }

    @RequestMapping("/getScore")
    public int getScore(int examId,String studentId){
        return studentService.getScore(examId,studentId);
    }
}
