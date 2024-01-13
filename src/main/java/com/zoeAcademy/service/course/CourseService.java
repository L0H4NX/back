package com.zoeAcademy.service.course;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zoeAcademy.models.GenericReturn;
import com.zoeAcademy.models.course.Course;
import com.zoeAcademy.repository.course.CourseRepository;

import net.bytebuddy.description.type.TypeDescription.Generic;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public GenericReturn<List<Course>> getAllCoursesByProductId(Long productId) {

        List<Course> courses = courseRepository.findAllByProductId(productId);

        if (courses.size() == 0) {
            return new GenericReturn<>(true, "Nenhum Curso Encontrado", null);
        }

        return new GenericReturn<>(true, "Cursos Encontrados com Sucesso", courses);
    }

    public GenericReturn<Course> createCourse(Course course) {
        return new GenericReturn<>(true, "Curso criado com sucesso", courseRepository.save(course));
    }

    public GenericReturn<?> deleteCourse(Long id) {

        Course course = courseRepository.findById(id).get();

        if (course == null) {
            return new GenericReturn<>(true, "Nenhum Curso Encontrado", null);
        }

        courseRepository.deleteById(id);

        return new GenericReturn<>(true, "Curso Excluído com Sucesso", null);
    }
}
