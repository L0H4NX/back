package com.zoeAcademy.service.lesson;

import org.springframework.stereotype.Service;

import com.zoeAcademy.models.GenericReturn;
import com.zoeAcademy.models.lesson.Lesson;

import java.util.List;

import com.zoeAcademy.repository.lesson.LessonRepository;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public GenericReturn<List<Lesson>> getLessonsByCourseId(Long courseId) {

        List<Lesson> lessons = lessonRepository.findAllByCourseId(courseId);

        if (lessons.size() == 0) {
            return new GenericReturn<>(true, "Nenhuma Aula Encontrada", null);
        }

        return new GenericReturn<>(true, "Aulas Encontradas com Sucesso", lessons);
    }

    public GenericReturn<Lesson> createLesson(Lesson lesson) {

        Lesson newLesson = lessonRepository.save(lesson);

        return new GenericReturn<>(true, "Aula Criada com Sucesso", newLesson);
    }

    public GenericReturn<Lesson> deleteLesson(Long lessonId) {

        Lesson lesson = lessonRepository.findById(lessonId).get();

        if (lesson == null) {
            return new GenericReturn<>(true, "Nenhuma Aula Encontrada", null);
        }

        lessonRepository.delete(lesson);

        return new GenericReturn<>(true, "Aula Excluída com Sucesso", null);
    }

}
