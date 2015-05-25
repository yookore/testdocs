import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;

import models.Blog;

import org.junit.Test;


public class PostContentTest {
	PostContent postCont = new PostContent();
	
	@Test
	public void testPostBlog() {
		String username = "johnbap";
		String title="Apsotle";
		String text = "This is a blog post text";
		String tags = "#myblog";
		String mention = "@ginald";
		String photo = "photoUrl";
		String videos = "videoUrl";
		String audio = "audioUrl";
		
		Blog blog = new Blog(username, title, text, tags, mention, photo, videos, audio);
		HashMap<String,String> actual = new HashMap<String, String>();
		actual.put("username", blog.getUsername());
		actual.put("title", blog.getTitle());
		actual.put("text", blog.getText());
		actual.put("tags", blog.getTags());
		actual.put("mention", blog.getMention());
		actual.put("photo", blog.getPhoto());
		actual.put("videos", blog.getVideos());
		actual.put("audio", blog.getAudio());
		
		assertEquals("Posting a blog returned unexpected response",
				postCont.postBlog(username, title, text, tags, mention, photo, videos, audio)
				, actual);
	}

	@Test
	public void testGetPost() {
		String postId = "postid";
		
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
		
		assertEquals("Getting a post returned unexpected response",
				postCont.getPost(postId)
				, postDetails);
	}

	@Test
	public void testPostAudio() {
		String username = "johnap"; 
		String caption = "Photo caption"; 
		String audioData = "audioData";
		
		HashMap<String,String> audio = new HashMap<String,String>();
		audio.put("caption",caption);
		
		assertEquals("Posting audio returned unexpected response",
				postCont.postAudio(username, caption, audioData)
				, audio);
	}

	@Test
	public void testGetAudioPost() {
		String audioId = "audioId";
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
		
		assertEquals("Posting audio returned unexpected response",
				postCont.getAudioPost(audioId)
				, audioResults);
	}

	@Test
	public void testUpdateStatus() {
		String username="johnbap";
		String text= "This is a status Update Text";
		String photo ="photoUrl";
		String video = "videoUrl";
		String mention = "@gianld";
		String location = "Randburg";
		
		HashMap<String,String> statusUpdate = new HashMap<String,String>();
		statusUpdate.put("username", username);
		statusUpdate.put("text", text);
		
		assertEquals("Updating a status returned unexpected response",
				postCont.updateStatus(username, text, photo, video, mention, location)
				, statusUpdate);
	}

	@Test
	public void testGetStatusUpdate() {
		String statusUpdateId = "statusId";
		
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
		
		assertEquals("Getting a status returned unexpected response",
				postCont.getStatusUpdate(statusUpdateId)
				, statusDetails);
	}

}
