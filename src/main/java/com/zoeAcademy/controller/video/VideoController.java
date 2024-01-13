package com.zoeAcademy.controller.video;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.zoeAcademy.models.GenericReturn;
import com.zoeAcademy.models.video.Video;
import com.zoeAcademy.service.video.VideoService;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/get-videos-by-lessonId/{lessonId}")
    public ResponseEntity<GenericReturn<List<Video>>> getVideosByLessonId(@PathVariable("lessonId") Long lessonId) {
        return ResponseEntity.ok(videoService.getVideosByLessonId(lessonId));
    }

    @PostMapping("")
    public ResponseEntity<GenericReturn<Video>> createVideo(@RequestBody Video video) {
        return ResponseEntity.ok(videoService.createVideo(video));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericReturn<?>> deleteVideo(@PathVariable("id") Long id) {
        return ResponseEntity.ok(videoService.deleteVideo(id));
    }
}
