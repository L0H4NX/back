package com.zoeAcademy.service.exercise;

import org.springframework.stereotype.Service;

import com.zoeAcademy.models.GenericReturn;
import com.zoeAcademy.models.exercise.Exercise;
import com.zoeAcademy.repository.exercise.ExerciseRepository;

import java.util.List;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public GenericReturn<List<Exercise>> getExercisesByLessonId(Long lesson) {

        List<Exercise> exercises = exerciseRepository.findAllByLessonId(lesson);

        if (exercises.size() == 0) {
            return new GenericReturn<>(true, "Nenhum Exercício Encontrado", null);
        }

        return new GenericReturn<>(true, "Exercicios Encontrados com Sucesso", exercises);
    }

    public GenericReturn<Exercise> createExercise(Exercise exercise) {
        Exercise newExercise = exerciseRepository.save(exercise);

        return new GenericReturn<>(true, "Exercício Criado com Sucesso", newExercise);
    }

    public GenericReturn<?> deleteExercise(Long id) {

        Exercise exercise = exerciseRepository.findById(id).get();

        if (exercise == null) {
            return new GenericReturn<>(true, "Nenhum Exercício Encontrado", null);
        }

        exerciseRepository.deleteById(id);

        return new GenericReturn<>(true, "Exercício Excluído com Sucesso", null);
    }
}
