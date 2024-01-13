package com.zoeAcademy.repository.course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoeAcademy.models.course.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByProductId(Long productId);
}
