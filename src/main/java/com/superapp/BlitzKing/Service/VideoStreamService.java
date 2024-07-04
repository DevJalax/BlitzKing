package com.superapp.BlitzKing.Service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.superapp.BlitzKing.Entity.VideoStream;
import com.superapp.BlitzKing.Repo.VideoStreamRepository;

@Service
public class VideoStreamService {
    
	private final VideoStreamRepository videoRepository;
    
	private final TranscoderService transcoderService;

    public VideoStreamService(VideoStreamRepository videoRepository, TranscoderService transcoderService) {
        this.videoRepository = videoRepository;
        this.transcoderService = transcoderService;
    }

    public VideoStream createVideo(VideoStream video) {
        video.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        video.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return videoRepository.save(video);
    }

    public VideoStream updateVideo(Long id, VideoStream updatedVideo) {
        VideoStream video = videoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Video not found"));
        video.setTitle(updatedVideo.getTitle());
        video.setDescription(updatedVideo.getDescription());
        video.setUrl(updatedVideo.getUrl());
        video.setThumbnailUrl(updatedVideo.getThumbnailUrl());
        video.setLive(updatedVideo.isLive());
        video.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return videoRepository.save(video);
    }

    public List<VideoStream> getAllVideos() {
        return videoRepository.findAll();
    }

    public List<VideoStream> getLiveVideos() {
        return videoRepository.findByLiveTrue();
    }

    public void deleteVideo(Long id) {
        videoRepository.deleteById(id);
    }

    public void transcodeVideo(Long id) {
        VideoStream video = videoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Video not found"));
        transcoderService.transcodeVideo(video);
    }
    
    public Video downloadVideo(String title, String url) {
        try {
            String filePath = downloadVideoFile(url);
            Video video = new Video(title, url, filePath);
            return videoRepository.save(video);
        } catch (IOException e) {
            throw new RuntimeException("Error downloading video", e);
        }
    }

    private String downloadVideoFile(String url) throws IOException {
        URL videoUrl = new URL(url);
        String fileName = videoUrl.getFile().substring(videoUrl.getFile().lastIndexOf('/') + 1);
        Path path = Paths.get("downloads", fileName);
        Files.copy(videoUrl.openStream(), path, StandardCopyOption.REPLACE_EXISTING);
        return path.toString();
    }
}
