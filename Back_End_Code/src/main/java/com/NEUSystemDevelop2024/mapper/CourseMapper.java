package com.NEUSystemDevelop2024.mapper;

import com.NEUSystemDevelop2024.entity.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Select("select * from t_course")
    List<Course> listCourse();

    @Select("select * from t_course where companyName=#{companyName}")
    List<Course> listCourseByCompanyName(String companyName);

    @Insert("insert into t_course values(null, #{courseName}, #{companyName}, #{description}, #{courseOrder}, #{author}, null, null, #{imageUrl}, #{videoUrl})")
    int insertCourse(Course course);
}
