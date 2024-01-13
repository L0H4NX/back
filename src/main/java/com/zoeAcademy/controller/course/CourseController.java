package com.zoeAcademy.controller.course;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoeAcademy.models.GenericReturn;
import com.zoeAcademy.models.course.Course;
import com.zoeAcademy.service.course.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("find-all-by-product-id/{id}")
    public ResponseEntity<GenericReturn<List<Course>>> getAllCourses(@PathVariable("id") Long id) {
        return ResponseEntity.ok(courseService.getAllCoursesByProductId(id));
    }

    @PostMapping("")
    public ResponseEntity<GenericReturn<Course>> createCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.createCourse(course));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericReturn<?>> deleteCourse(@PathVariable("id") Long id) {
        return ResponseEntity.ok(courseService.deleteCourse(id));
    }

}
