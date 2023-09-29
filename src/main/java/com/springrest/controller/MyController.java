package com.springrest.controller;

import com.springrest.entity.Courses;
import com.springrest.service.CourseService;
import com.springrest.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MyController {
    @Autowired
    private CourseService courseService;
    // Get all courses
    @GetMapping("/courses")
    public List<Courses>getAllCourses(){
        return this.courseService.getCourses();
    }

    // Get Single Courses
    @GetMapping("/courses/{id}")
    public Courses getSingleCourse(@PathVariable("id") String id){
        return this.courseService.getSingleCourses(Long.parseLong(id));
    }
    // add new Courses
    @PostMapping("/courses")
    public Courses addNewCourse(@RequestBody Courses courses){
  return this.courseService.addNewCourse(courses);
    }

    // Update Courses
    @PutMapping("/courses/{id}")
    public Courses updateCourse(@PathVariable("id") String id,@RequestBody Courses courses){
         this.courseService.updateCourse(id,courses);
         return courses;
    }

    // Delete Courses
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") String id){
        try {
            this.courseService.deleteCourse(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
