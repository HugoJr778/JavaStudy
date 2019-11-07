package postsocialproject.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import postsocialproject.entities.Comment;
import postsocialproject.entities.Post;

public class Program {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public static void main(String[] args) throws ParseException {
		
		Comment c1 = new Comment("Have a Nice Trip!");
		Comment c2 = new Comment("Wow that's Awesome!");
		Post p1 = new Post(sdf.parse("21/06/2018 13:05:44"), "Traveling to new Zealand", "I'm going to visit this wonderful country!", 12);
		p1.addComment(c1);
		p1.addComment(c2);
		
		System.out.println(p1);
		
		Comment c3 = new Comment("Good Nigth!");
		Comment c4 = new Comment("May the Force be with you");
		Post p2 = new Post(sdf.parse("28/07/2018 23:14:19"), "Good Nigth Guys", "See you Tomorrow", 5);
		p2.addComment(c3);
		p2.addComment(c4);
		
		System.out.println("\n\n" + p2);
	}
}