package com.guorui.springboottest03.config.MybatisConfig;



import com.guorui.springboottest03.dao.StudentDao;
import com.guorui.springboottest03.dao.TeacherDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class GetTeacherMapperDao {

    @Bean
    public TeacherDao teacherDao() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapDao.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        SqlSession ss = sqlSessionFactory.openSession(true);
        TeacherDao teacherDao = (TeacherDao) ss.getMapper(TeacherDao.class);
        return teacherDao;
    }
    @Bean
    public StudentDao studentDao() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapDao.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        SqlSession ss = sqlSessionFactory.openSession(true);
        StudentDao studentDao = (StudentDao) ss.getMapper(StudentDao.class);
        return studentDao;
    }
}
