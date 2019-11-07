package postsocialproject.entities;

public class Comment {

	private String text;
	
	public Comment() {
	}

	public Comment(String text) {
		this.setText(text);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}