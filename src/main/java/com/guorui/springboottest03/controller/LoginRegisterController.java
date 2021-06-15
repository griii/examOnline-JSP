package com.guorui.springboottest03.controller;


import com.guorui.springboottest03.bean.Result;
import com.guorui.springboottest03.service.StudentService;
import com.guorui.springboottest03.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginRegisterController {
    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    //在登录的时候对session进行检测 若已经登陆过了 则直接跳转到主界面
    @RequestMapping("/studentLogin")
    public String studentLogin(HttpSession session){
        if ((session.getAttribute("name"))!=null){
            return "redirect:/student/studentHome";
        }else {
            return "login/studentLogin";
        }
    }
    @RequestMapping("/teacherLogin")
    public String teacherLogin(HttpSession session){
        if ((session.getAttribute("name"))!=null){
         return "redirect:/teacher/studentTable";
        }else {
            return "login/teacherLogin";
        }

    }



   //教师端登录 对session进行操作 用ajax的形式 返回一个结果值json
   @ResponseBody
   @RequestMapping("/teacherLogining")
   public Result teacherLogin(@RequestParam("teacherId") String id, @RequestParam("password") String password, HttpSession session, Model model){
        Result result = new Result();
        String teacherName = teacherService.login(id,password);
        result.setMsg(teacherName);
        if (teacherName!="教工号不存在!!!" &&teacherName != "密码错误!!!"){
            session.setAttribute("name",teacherName);
       }
        return result;
   }

    @ResponseBody
    @RequestMapping("/studentLogining")
    public Result studentLogin(@RequestParam("studentId") String id, @RequestParam("password") String password, HttpSession session, Model model){
        Result result = new Result();
        String studentName = studentService.login(id,password);
        result.setMsg(studentName);
        if (studentName!="学号不存在!!!" &&studentName != "密码错误!!!"){
            session.setAttribute("studentId",id);
        }
        System.out.println(studentName);
        return result;
    }

    @ResponseBody
    @RequestMapping("/studentRegister")
    public String studentRegister(String id,String password,String name){
        return studentService.register(id, password, name);
    }


}
