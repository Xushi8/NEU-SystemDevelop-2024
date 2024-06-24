package com.NEUSystemDevelop2024.controller;

import com.NEUSystemDevelop2024.biz.CourseBiz;
import com.NEUSystemDevelop2024.entity.Course;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    @RequestMapping("/upload")
    Map upload(MultipartFile file) {
        Map map = new HashMap();
        if (file == null ||  file.isEmpty()) {
            map.put("isOk", false);
            map.put("msg", "图片不能为空");
            return map;
        }

        // file 重命名
        String oldName = file.getOriginalFilename();
        String ext = oldName.substring(oldName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String newName = uuid + ext;

        // 上传图片
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());
        String prepath = applicationHome.getDir().getParentFile().getParentFile().getAbsolutePath() +
                "\\src\\main\\resources\\static\\images\\";
        String path = prepath + newName;

        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            map.put("isOk", false);
            map.put("msg", e.getMessage());
            return map;
        }

        map.put("isOk", true);
        map.put("msg", path);
        return map;
    }
}
