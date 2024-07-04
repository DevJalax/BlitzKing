package com.superapp.BlitzKing.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superapp.BlitzKing.Entity.Photo;
import com.superapp.BlitzKing.Entity.Post;
import com.superapp.BlitzKing.Entity.Video;
import com.superapp.BlitzKing.Repo.PhotoRepository;
import com.superapp.BlitzKing.Repo.PostRepository;
import com.superapp.BlitzKing.Repo.VideoRepository;

import jakarta.transaction.Transactional;

@Service
public class PostService {
	
    private final PostRepository postRepository;
    
    private final PhotoRepository photoRepository;
    
    private final VideoRepository videoRepository;
    
    @Autowired
    public PostService(PostRepository postRepository, PhotoRepository photoRepository, VideoRepository videoRepository) {
        this.postRepository = postRepository;
        this.photoRepository = photoRepository;
        this.videoRepository = videoRepository;
    }
    
    @Transactional
    public Post createPost(Post post) {
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        Post savedPost = postRepository.save(post);
        
        for (Photo photo : post.getPhotos()) {
            photo.setPost(savedPost);
            photoRepository.save(photo);
        }
        
        for (Video video : post.getVideos()) {
            video.setPost(savedPost);
            videoRepository.save(video);
        }
        
        return savedPost;
    }
    
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }
    
    public List<Post> getPostsByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }
}

