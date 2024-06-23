package com.NEUSystemDevelop2024.mapper;

import com.NEUSystemDevelop2024.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Select("select * from t_course")
    List<Course> listCourse();
}
