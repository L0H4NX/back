package com.zoeAcademy.service.video;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zoeAcademy.models.GenericReturn;
import com.zoeAcademy.models.video.Video;
import com.zoeAcademy.repository.video.VideoRepository;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public GenericReturn<List<Video>> getVideosByLessonId(Long lessonId) {

        List<Video> videos = videoRepository.findAllByLessonId(lessonId);

        if (videos.size() == 0) {
            return new GenericReturn<>(true, "Nenhum Vídeo Encontrado", null);
        }

        return new GenericReturn<>(true, "Vídeos Encontrados com Sucesso", videos);
    }

    public GenericReturn<Video> createVideo(Video video) {
        return new GenericReturn<>(true, "Vídeo criado com sucesso", videoRepository.save(video));
    }

    public GenericReturn<?> deleteVideo(Long id) {

        Video video = videoRepository.findById(id).get();

        if (video == null) {
            return new GenericReturn<>(true, "Vídeo não encontrado", null);
        }

        videoRepository.deleteById(id);
        return new GenericReturn<>(true, "Vídeo excluído com sucesso", null);
    }

}
