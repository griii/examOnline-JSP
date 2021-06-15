package com.guorui.springboottest03.service;

import com.guorui.springboottest03.bean.Exam;
import com.guorui.springboottest03.bean.ExamInfor;
import com.guorui.springboottest03.bean.Question;
import com.guorui.springboottest03.bean.Student;
import com.guorui.springboottest03.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public String login(String id,String password){
        Student student = studentDao.loginId(id);
        if (student==null){
            return "学号不存在!!!";
        }else{
            student = studentDao.loginP(id,password);
        }
        if (student==null){
            return "密码错误!!!";
        }else{
            return student.getName();
        }
    }

    public String register(String id,String password,String name){
        try{
            long id1 = Long.valueOf(id);
        }catch (Exception e){
            return "学号有误!";
        }
        if (name == null || name == "" || name.length() > 10){
            return "姓名有误!";
        }
        Student student = studentDao.loginId(id);
        if (student != null){
            return "该学号已被注册!";
        }
        if (password.length() < 8){
            return "密码需要大于8位!";
        }
        try{
            studentDao.insert(id,password,name);
        }catch (Exception e){
            return "出现异常,注册失败!";
        }
        return "注册成功!";
    }

    public List<Question> getQuestions(int examId){
        //先从考试信息表中提取考试题目
        String examInfor = studentDao.getQuestionInforByExamId(examId);
        System.out.println(examId);
        System.out.println(examInfor);
        String[] infors = examInfor.split("\\|\\|");
        List<String> questionId = new ArrayList<>();
        System.out.println(Arrays.toString(infors));
        Map<String,String> scoreMap = new HashMap();
        for (String i:infors){
            int s = i.indexOf("$");
            questionId.add(i.substring(0,s));
            scoreMap.put(i.substring(0,s),i.substring(s+1,i.length()));
        }
        System.out.println(questionId.toString());
        //然后去获取实际的
        List<Question> questions = new ArrayList<>();
        for (String s:questionId){
            Question q = studentDao.getQuestionById(Integer.valueOf(s));
            q.setScore(Integer.valueOf(scoreMap.get(q.getQuestionId())));
            questions.add(q);
        }
        return questions;
    }

    //提交试卷，计算分数...
    public String submitExam(int examId,String studentId,String answer){
        if (studentDao.getExamInforByExamIdAndStudentId(examId,studentId) != null){
            return "请不要重复提交试卷!";
        }
        String[] as = answer.split("!!");
        int scoreAll = 0;
        StringBuilder erroQuestion = new StringBuilder();
        for (int index=0;index<as.length;index++){
            String a = as[index];
            int index1 = a.indexOf(':');
            int index2 = a.indexOf('$');
            String ans = a.substring(index1+1,index2);
            int qId = Integer.valueOf(a.substring(0,index1));
            int score = Integer.valueOf(a.substring(index2+1,a.length()));
            String solution = studentDao.getSolutionByQuestionId(qId);
            if (ans.equals(solution)){
                //答对了...
                scoreAll += score;
            }else{
                erroQuestion.append(index+1+":" + ans + "/" + solution + "||");
            }
        }
        //计算完毕..
        System.out.println("总得分" + scoreAll + "错题" + erroQuestion.toString());
        ExamInfor examInfor = new ExamInfor(examId,studentId,answer,scoreAll);
        examInfor.setErroAnswer(erroQuestion.toString());
        examInfor.setScore(scoreAll);
        studentDao.insertExamInfor(examInfor);
        return "试卷提交成功！";
    }

    public List<Exam> findAllExam(String studentId){
        return studentDao.findAllExam(studentId);
    }

    public String getErroAnswer(String studentId,int examId){
        return studentDao.getErroAnswer(examId,studentId);
    }

    public int getScore(int examId,String studentId){
        return studentDao.getScore(examId,studentId);
    }

}
