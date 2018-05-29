package com.rajubd49.bs195.myapplication

/**
 * Created by bs195 on 4/5/18.
 */


class HomeFeed (
        val videos: List<Video>
)

class Video(
        val id: Int,
        val name: String,
        val link: String,
        val imageUrl: String,
        val numberOfViews: String,
        val channel: Channel
)

class Channel(
        val name: String,
        val profileImageUrl: String,
        val numberOfSubscribers: Int
)

/*

//Sample JSON

id: 1,
name: "Instagram Firebase - Learn How to Create Users, Follow, and Send Push Notifications",
link: "https://www.letsbuildthatapp.com/course/instagram-firebase",
imageUrl: "https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/04782e30-d72a-4917-9d7a-c862226e0a93",
numberOfViews: 20000,
channel: {
name: "Lets Build That App",
profileImageUrl: "https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/dda5bc77-327f-4944-8f51-ba4f3651ffdf",
numberOfSubscribers: 100000
}
 */