package com.zoeAcademy.models.lesson;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.zoeAcademy.models.course.Course;
import com.zoeAcademy.models.exercise.Exercise;
import com.zoeAcademy.models.video.Video;

import java.util.List;

import lombok.Data;

@Entity
@Data
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<Video> videos;

    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<Exercise> exercises;
}
