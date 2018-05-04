package com.mybatis.mapperInt;

import com.mybatis.po.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuMapperInter {
    // 根据ID查询信息
    Student selectStudent(int id) throws Exception;

    //模糊查询
     List<Student> selectStudentByMoHu(String name)throws Exception;//方法的返回值类型应该为一个列表

    // 添加信息
     void insertStudent(Student student) throws Exception;

    // 删除信息
     void deleteStudent(int id) throws Exception;

    //更新信息
    void update(@Param("id") int id, @Param("stuname") String stuname,@Param("stuage") int stuage);
}
