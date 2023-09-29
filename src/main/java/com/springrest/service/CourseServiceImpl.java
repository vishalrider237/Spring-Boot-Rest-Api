package com.springrest.service;

import com.springrest.entity.Courses;
import com.springrest.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CoursesRepository coursesRepository;
  /*  List<Courses>list;

    public CourseServiceImpl(List<Courses> list) {
        this.list = new ArrayList<>();
        this.list.add(new Courses(145,"Spring Boot","This course contains the Spring Boot"));
        this.list.add(new Courses(1232,"Django","This course contains the Django courses"));
    }*/

    @Override
    public List<Courses> getCourses() {
        return this.coursesRepository.findAll();
    }

    @Override
    public Courses getSingleCourses(long id) {
        return this.coursesRepository.getOne(id);
      /*  Courses c=null;
        for (Courses courses:list){
            if (courses.getId() == id){
                c=courses;
                break;
            }
        }
        return c;*/
    }

    @Override
    public Courses addNewCourse(Courses courses) {
        courses.setId(UUID.randomUUID().toString());
       return this.coursesRepository.save(courses);
    }

    @Override
    public ResponseEntity<HttpStatus> updateCourse(String id,Courses courses) {
        try {
            courses.setId(id);
            this.coursesRepository.save(courses);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


      /*  for (Courses course:list){
            if (course.getId()== id){
                course.setTitle(courses.getTitle());
                course.setDescription(courses.getDescription());
                break;
            }
        }
        return courses;*/

    }

    @Override
    public void deleteCourse(String id) {
        Courses courses=this.coursesRepository.findById(id);
  this.coursesRepository.delete(courses);
    /*    for (Courses course:list){
            if (course.getId()== id){
                list.remove(course);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);*/
    }
}
