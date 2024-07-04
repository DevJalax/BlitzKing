package com.superapp.BlitzKing.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.superapp.BlitzKing.Entity.VideoStream;
import com.superapp.BlitzKing.Service.VideoStreamService;

@RestController
@RequestMapping("/api/videos")
public class VideoController {
	
    private final VideoStreamService videoService;

    @Autowired
    public VideoController(VideoStreamService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
    public VideoStream createVideo(@RequestBody VideoStream video) {
        return videoService.createVideo(video);
    }

    @PutMapping("/{id}")
    public VideoStream updateVideo(@PathVariable Long id, @RequestBody VideoStream video) {
        return videoService.updateVideo(id, video);
    }

    @GetMapping
    public List<VideoStream> getAllVideos() {
        return videoService.getAllVideos();
    }

    @GetMapping("/live")
    public List<VideoStream> getLiveVideos() {
        return videoService.getLiveVideos();
    }

    @DeleteMapping("/{id}")
    public void deleteVideo(@PathVariable Long id) {
        videoService.deleteVideo(id);
    }

    @PostMapping("/{id}/transcode")
    public void transcodeVideo(@PathVariable Long id) {
        videoService.transcodeVideo(id);
    }
    
    @PostMapping
    public Video downloadVideo(@RequestParam String title, @RequestParam String url) {
        return videoService.downloadVideo(title, url);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FileSystemResource> getVideo(@PathVariable Long id) {
        Video video = videoRepository.findById(id).orElseThrow(() -> new VideoNotFoundException(id));
        File file = new File(video.getFilePath());
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + video.getTitle() + ".mp4");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new FileSystemResource(file));
    }
}
