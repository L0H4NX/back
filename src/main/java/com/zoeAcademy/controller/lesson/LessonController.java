package com.zoeAcademy.controller.lesson;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.zoeAcademy.models.GenericReturn;
import com.zoeAcademy.models.lesson.Lesson;

import java.util.List;

import com.zoeAcademy.service.lesson.LessonService;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/get-lessons-by-courseId/{courseId}")
    public ResponseEntity<GenericReturn<List<Lesson>>> getLessonsByCourseId(@PathVariable("courseId") Long courseId) {
        return ResponseEntity.ok(lessonService.getLessonsByCourseId(courseId));
    }

    @PostMapping("")
    public ResponseEntity<GenericReturn<Lesson>> createLesson(@RequestBody Lesson lesson) {
        return ResponseEntity.ok(lessonService.createLesson(lesson));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericReturn<?>> deleteLesson(@PathVariable("id") Long id) {
        return ResponseEntity.ok(lessonService.deleteLesson(id));
    }
}
