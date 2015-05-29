import java.util.ArrayList;
import java.util.HashMap;

import models.Blog;


public class PostContent {
	public HashMap<String,String> postBlog(String username, String title, String text, String tags, String mention, String photo, String videos, String audio)
	{
		Blog blog = new Blog(username, title, text, tags, mention, photo, videos, audio);
		
		HashMap<String,String> post = new HashMap<String, String>();
		post.put("username", blog.getUsername());
		post.put("title", blog.getTitle());
		post.put("text", blog.getText());
		post.put("tags", blog.getTags());
		post.put("mention", blog.getMention());
		post.put("photo", blog.getPhoto());
		post.put("videos", blog.getVideos());
		post.put("audio", blog.getAudio());
		
		return post;
	}
	
	public HashMap<String,Object> getPost(String postId)
	{
		HashMap<String,Object> postDetails = new HashMap<String,Object>();
		postDetails.put("blogpostid", postId);
		postDetails.put("text", "Blog text here");
		
		HashMap<String,String> actor = new HashMap<String,String>();
		actor.put("firstname", "John");
		actor.put("lastname", "Baptist");
		actor.put("profilepicture", "imgurl");
		
		postDetails.put("actor",actor);
		postDetails.put("creationdate", "17/05/2015");
		postDetails.put("modificationdate", "17/05/2015");
		
		ArrayList<HashMap> comments = new ArrayList<HashMap>();
		HashMap<String,String> comment = new HashMap<String,String>();
		comment.put("link", "https://commentlink");
		comment.put("action", "remove");
		comment.put("firstname", "John");
		comment.put("lastname", "Baptist");
		comment.put("profilepic", "imgUrl");
		comment.put("creationdate", "17/05/2015");
		comment.put("username", "johnbap");
		
		comments.add(comment);
		
		postDetails.put("comments",comments);
		
		ArrayList<HashMap> likes = new ArrayList<HashMap>();
		HashMap<String,String> like = new HashMap<String,String>();
		like.put("link", "https://likelink");
		like.put("action", "unlike");
		like.put("firstname", "John");
		like.put("lastname", "Baptist");
		
		likes.add(like);
		
		postDetails.put("likes",likes);
		postDetails.put("commentcount","23");
		postDetails.put("likecount","44");
		postDetails.put("viewcount","56");
		
		ArrayList<HashMap> mentions = new ArrayList<HashMap>();
		HashMap<String,String> mention = new HashMap<String,String>();
		mention.put("profilelink", "https://profile/johnbap");
		mention.put("firstname", "John");
		mention.put("lastname", "Baptist");
		
		mentions.add(mention);
		
		postDetails.put("mentions",mentions);
		postDetails.put("tag","#john");
		postDetails.put("attachment", "attachUrl");
		
		
		return postDetails;
	}
	
	public HashMap<String,String> postAudio(String username, String caption, String audioData)
	{
		HashMap<String,String> audio = new HashMap<String,String>();
		audio.put("caption",caption);
		return audio;
	}
	
	public HashMap<String,Object> getAudioPost(String audioId)
	{
		HashMap<String,Object> audioResults = new HashMap<String,Object>();
		audioResults.put("audio", audioId);
		audioResults.put("text", "audio text here");
		audioResults.put("title", "audio title here");
		
		HashMap<String,String> actor = new HashMap<String,String>();
		actor.put("firstname", "John");
		actor.put("lastname", "Baptist");
		actor.put("profilepicture", "imgurl");
		
		audioResults.put("actor",actor);
		audioResults.put("creationdate", "17/05/2015");
		audioResults.put("modificationdate", "17/05/2015");
		
		ArrayList<HashMap> comments = new ArrayList<HashMap>();
		HashMap<String,String> comment = new HashMap<String,String>();
		comment.put("link", "https://commentlink");
		comment.put("action", "remove");
		comment.put("firstname", "John");
		comment.put("lastname", "Baptist");
		comment.put("profilepic", "imgUrl");
		comment.put("creationdate", "17/05/2015");
		comment.put("username", "johnbap");
		
		comments.add(comment);
		
		audioResults.put("comments",comments);
		
		ArrayList<HashMap> likes = new ArrayList<HashMap>();
		HashMap<String,String> like = new HashMap<String,String>();
		like.put("link", "https://likelink");
		like.put("action", "unlike");
		like.put("firstname", "John");
		like.put("lastname", "Baptist");
		
		likes.add(like);
		
		audioResults.put("likes",likes);
		audioResults.put("commentcount","23");
		audioResults.put("likecount","44");
		audioResults.put("viewcount","56");
		
		ArrayList<HashMap> mentions = new ArrayList<HashMap>();
		HashMap<String,String> mention = new HashMap<String,String>();
		mention.put("profilelink", "https://profile/johnbap");
		mention.put("firstname", "John");
		mention.put("lastname", "Baptist");
		
		mentions.add(mention);
		
		audioResults.put("mentions",mentions);
		audioResults.put("tag","#john");
		
		
		return audioResults;
	}
	
	public HashMap<String,String> updateStatus(String username, String text, String photo, String video, String mention, String location)
	{
		HashMap<String,String> statusUpdate = new HashMap<String,String>();
		statusUpdate.put("username", username);
		statusUpdate.put("text", text);
		return statusUpdate;
	}
	
	public HashMap<String,Object> getStatusUpdate(String statusUpdateId)
	{
		HashMap<String,Object> statusDetails = new HashMap<String,Object>();
		statusDetails.put("statusupdateid", statusUpdateId);
		statusDetails.put("text", "Status text here");
		
		HashMap<String,String> actor = new HashMap<String,String>();
		actor.put("firstname", "John");
		actor.put("lastname", "Baptist");
		actor.put("profilepicture", "imgurl");
		
		statusDetails.put("actor",actor);
		statusDetails.put("creationdate", "17/05/2015");
		statusDetails.put("modificationdate", "17/05/2015");
		
		ArrayList<HashMap> comments = new ArrayList<HashMap>();
		HashMap<String,String> comment = new HashMap<String,String>();
		comment.put("link", "https://commentlink");
		comment.put("action", "remove");
		comment.put("firstname", "John");
		comment.put("lastname", "Baptist");
		comment.put("profilepic", "imgUrl");
		comment.put("creationdate", "17/05/2015");
		comment.put("username", "johnbap");
		
		comments.add(comment);
		
		statusDetails.put("comments",comments);
		
		ArrayList<HashMap> likes = new ArrayList<HashMap>();
		HashMap<String,String> like = new HashMap<String,String>();
		like.put("link", "https://likelink");
		like.put("action", "unlike");
		like.put("firstname", "John");
		like.put("lastname", "Baptist");
		
		likes.add(like);
		
		statusDetails.put("likes",likes);
		statusDetails.put("commentcount","23");
		statusDetails.put("likecount","44");
		statusDetails.put("viewcount","56");
		
		ArrayList<HashMap> mentions = new ArrayList<HashMap>();
		HashMap<String,String> mention = new HashMap<String,String>();
		mention.put("profilelink", "https://profile/johnbap");
		mention.put("firstname", "John");
		mention.put("lastname", "Baptist");
		
		mentions.add(mention);
		
		statusDetails.put("mentions",mentions);
		statusDetails.put("tag","#john");
		statusDetails.put("attachment", "attachUrl");
		
		
		return statusDetails;
	}

}
