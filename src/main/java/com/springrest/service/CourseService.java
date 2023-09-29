package com.springrest.service;

import com.springrest.entity.Courses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    public List<Courses>getCourses();

    Courses getSingleCourses(long id);

    Courses addNewCourse(Courses courses);

    ResponseEntity<HttpStatus> updateCourse(String id,Courses courses);

    void deleteCourse(String id);
}
