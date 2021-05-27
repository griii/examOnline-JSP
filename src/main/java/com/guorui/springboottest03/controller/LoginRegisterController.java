package com.guorui.springboottest03.controller;


import com.guorui.springboottest03.bean.Result;
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


    //在登录的时候对session进行检测 若已经登陆过了 则直接跳转到主界面
    @RequestMapping("/studentLogin")
    public String studentLogin(HttpSession session){
        if ((session.getAttribute("name"))!=null){
            return "redirect:/examHome";
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


    //学生端主界面
   @RequestMapping("/examHome")
   public String examHome(){
        return "student/examHome";
   }

   //教师端登录 对session进行操作 用ajax的形式 返回一个结果值json
   @ResponseBody
   @RequestMapping("/teacherLogining")
   public Result teacherLogin(@RequestParam("teacherId") String id, @RequestParam("password") String password, HttpSession session, Model model){
        Result result = new Result();
        String teacherName = teacherService.login(id,password);
        result.setMsg(teacherName);
       System.out.println("教师登录...");
       System.out.println(id+password);
        if (teacherName!="教工号不存在!!!" &&teacherName != "密码错误!!!"){
            System.out.println("登陆成功");
            session.setAttribute("name",teacherName);
       }
        return result;
   }


}
