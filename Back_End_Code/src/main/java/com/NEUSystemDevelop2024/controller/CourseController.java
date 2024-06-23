package com.NEUSystemDevelop2024.controller;

import com.NEUSystemDevelop2024.biz.CourseBiz;
import com.NEUSystemDevelop2024.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseBiz courseBiz;

    @RequestMapping("/list")
    public Map list()
    {
        List<Course> userList = courseBiz.getCourseList();
        Map map = new HashMap();
        map.put("isOk", true);
        map.put("users", userList);
        map.put("msg","查询成功");
        return map;
    }
}
