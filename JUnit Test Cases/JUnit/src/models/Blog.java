package models;

public class Blog {
	private String username;
	private String title;
	private String text;
	private String tags;
	private String mention;
	private String photo;
	private String videos;
	private String audio;
	
	
	
	public Blog(String username, String title, String text, String tags,
			String mention, String photo, String videos, String audio) {
		super();
		this.username = username;
		this.title = title;
		this.text = text;
		this.tags = tags;
		this.mention = mention;
		this.photo = photo;
		this.videos = videos;
		this.audio = audio;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getMention() {
		return mention;
	}
	public void setMention(String mention) {
		this.mention = mention;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getVideos() {
		return videos;
	}
	public void setVideos(String videos) {
		this.videos = videos;
	}
	public String getAudio() {
		return audio;
	}
	public void setAudio(String audio) {
		this.audio = audio;
	}
	
	
}
