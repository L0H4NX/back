package com.zoeAcademy.repository.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoeAcademy.models.exercise.Exercise;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findAllByLessonId(Long lessonId);
}
