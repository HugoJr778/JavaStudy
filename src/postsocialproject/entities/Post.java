package postsocialproject.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date moment;
	private String title;
	private String content;
	private Integer likes;
	private List<Comment> commets = new ArrayList<>();
	
	public Post() {
	}

	public Post(Date moment, String title, String content, Integer likes) {
		this.content = content;
		this.moment = moment;
		this.title = title;
		this.likes = likes;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(title + "\n");
		str.append(likes);
		str.append(" LIKES - ");
		str.append(sdf.format(moment) + "\n");
		str.append(content + "\n");
		str.append("Comments:\n");
		for(Comment c : commets) {
			str.append(c.getText() + "\n");
		}
		return str.toString();
	}
	
	public void addComment(Comment comment) {
		commets.add(comment);
	}
	
	public void removeComment(Comment comment) {
		commets.remove(comment);
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public List<Comment> getCommets() {
		return commets;
	}
}