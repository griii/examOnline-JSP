package com.guorui.springboottest03.controller.teacher;

import com.guorui.springboottest03.bean.*;
import com.guorui.springboottest03.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    TeacherService teacherService;
    //获取使用者的名字 在主界面显示 "欢迎,xxx!"
    @ResponseBody
    @RequestMapping("/getUserTeacherName")
    public Result getUserTeacherName(HttpSession session){
        Result result = new Result();
        result.setMsg(session.getAttribute("name").toString());
        return result;
    }

    @ResponseBody
    @RequestMapping("/teacher/findAllStudent")
    public List<Student> findAllStudent(){
        return teacherService.findAllStudent();
    }

    @ResponseBody
    @RequestMapping("/teacher/studentTableEditor/{id}")
    public Student studentEditor(@PathVariable("id") String id, HttpSession session){
        return teacherService.findStudent(id);
    }

    @RequestMapping("/teacher/studentUpdata")
    public String studentUpdata(@RequestParam("editorStudentId") String id,
                                @RequestParam("editorStudentSex") String sex,
                                @RequestParam("editorStudentName") String name,
                                @RequestParam("editorStudentP") String password){
        teacherService.updateStudent(new Student(id,name,sex,password));
        return "redirect:/teacher/studentTable";
    }

    @RequestMapping("/teacher/killP")
    public String killP(@RequestParam("studentId") String id){
        teacherService.killP(id);
        return "redirect:/teacher/studentTable";
    }

    @RequestMapping("/teacher/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") String id){
        teacherService.deleteStudent(id);
        return "redirect:/teacher/studentTable";
    }

    @ResponseBody
    @RequestMapping("/teacher/findAllQuestion")
    public List<Question> findAllQuestion(){
        return teacherService.findAllQuestion();
    }

    @RequestMapping("/teacher/deleteQuestion")
    public String deleteQuestion(@RequestParam("questionId") String id){
        System.out.println("删除"+id+"题目");
        teacherService.deleteQuestion(id);
        return "redirect:/teacher/examQuestionTable";
    }

    @ResponseBody
    @RequestMapping("/teacher/questionTableEditor/{id}")
    public Question questionTableEditor(@PathVariable("id") String id){

        return teacherService.findQuestion(id);
    }

    @RequestMapping(value = "/teacher/questionUpdata")
    public String questionUpdata(Question question){
        System.out.println(question);
        teacherService.questionUpdata(question);
        return "redirect:/teacher/examQuestionTable";
    }
    @RequestMapping("/teacher/examSet")
    public String examSetting(Exam exam,String examName,String examQuestion,HttpSession session){
            exam.setExamSetter(session.getAttribute("name").toString());
            System.out.println(exam);
            teacherService.examInsert(exam);
        return "redirect:/teacher/examSetting"; }
        @ResponseBody
    @RequestMapping("/teacher/findAllExam")
    public List<Exam> findAllExam(){
        return teacherService.findAllExam();
    }


    @ResponseBody
    @RequestMapping("/teacher/findAllExamInfor")
    public ExamStudentInfor[] findAllExamInfor(int examId){
        return teacherService.findAllExamInfor(examId);
    }

}



