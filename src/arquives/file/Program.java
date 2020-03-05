package arquives.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
	
	private	static String path = "file_folders_example\\in.txt";

	public static void main(String[] args) {
		String path = "file_folders_example\\out.txt";
		String[] lines = new String[] { "Good Morning", "Good Afternoom", "Good Night"};
		//new FileWriter(path, true) - Com o TRUE não cria outro arquivo apenas acrescenta.
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + e);
		}
		
	}
	
	public static void readFileBufferReader() {
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (Exception e) { 
			System.out.println(e.getMessage() + e);
		}
	}
	
	public static void scannerOpenAndReadFile() {
		File file = new File(path);
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNext()) {
				System.out.println(sc.nextLine());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage() + e);
		}
	}
}