package com.mybatis.StuMapperTest;

import com.mybatis.mapperInt.StuMapperInter;
import com.mybatis.po.Student;
import com.mybatis.sqlSessionFac.SqlSessionFact;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class StuMapperInterTest {
    private StuMapperInter stuMapperInter;
    private SqlSession sqlSession;
    @BeforeEach
    void setUp() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFact.getSqlSessionFactory();
        sqlSession = sqlSessionFactory.openSession();
        stuMapperInter = sqlSession.getMapper(StuMapperInter.class);
    }

    @AfterEach
    void tearDown() {
        sqlSession.close();
    }

    @Test//根据ID查找学生信息，返回单条信息
    void selectStudent() throws Exception{
        Student student = stuMapperInter.selectStudent(1);
        System.out.println(student);
    }

    @Test//对学生表进行模糊查询，返回列表
    void selectStudentByMoHu() throws Exception{
        List<Student> studentList = stuMapperInter.selectStudentByMoHu("L");

        System.out.println(studentList);
    }

    @Test//添加一条信息
    void selectStudentInsert() throws Exception{
        Student student = new Student();
        student.setStuname("Jack");
        student.setStuage(18);
        stuMapperInter.insertStudent(student);
        sqlSession.commit();
    }

    @Test//根据ID删除学生信息
    void deleteStudent() throws Exception{
        stuMapperInter.deleteStudent(4);
        sqlSession.commit();
    }

    @Test//根据ID更新学生信息
    void update() throws Exception{
        stuMapperInter.update(1,"Lucky",23);
        sqlSession.commit();
    }

}