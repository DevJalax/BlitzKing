# Microservices in this super app

Content Service
Handles creation, storage, and distribution of user-generated content like posts, photos, videos
Provides APIs to fetch content feeds based on user subscriptions and interests
photos and videos should be stored in db.

Social Graph Service
Manages connections between users like friends, followers, subscriptions
Provides APIs to fetch user connections and activity

Lens Service: Provides APIs to create and apply augmented reality lenses

Stories Service: Manages creation, sharing, and viewing of ephemeral stories, also has provision to store 100 stores as a single highlight(image or video format)

Trends Service: Identifies and surfaces trending topics and hashtags in real-time

Video Service: Manages live streams, on-demand videos and clips

Streaming Service
Handles video streaming and playback
Transcodes videos to different bitrates and resolutions
Provides low-latency streaming for live content

Parental Control Service: Enforces age-appropriate content restrictions

Offline Service: Allows downloading videos for offline viewing
