package com.zoeAcademy.controller.exercise;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zoeAcademy.models.GenericReturn;
import com.zoeAcademy.models.exercise.Exercise;
import com.zoeAcademy.service.exercise.ExerciseService;

import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/get-exercises-by-lessonId")
    public ResponseEntity<GenericReturn<List<Exercise>>> getExercisesByLessonId(
            @RequestParam("lessonId") Long lessonId) {
        return ResponseEntity.ok(exerciseService.getExercisesByLessonId(lessonId));
    }

    @PostMapping("")
    public ResponseEntity<GenericReturn<Exercise>> createExercise(@RequestBody Exercise exercise) {
        return ResponseEntity.ok(exerciseService.createExercise(exercise));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericReturn<?>> deleteExercise(@PathVariable("id") Long id) {
        return ResponseEntity.ok(exerciseService.deleteExercise(id));
    }

}
