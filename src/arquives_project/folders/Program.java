package arquives_project.folders;

import java.io.File;
import java.util.Scanner;

public class Program {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		//Pega todas as pastas dado o diretório
		File[] folders = path.listFiles(File::isDirectory);
		System.out.println("FODERS: ");
		for (File folder : folders) {
			System.out.println(folder);
		}
		
		//Pega todos os arquivos dado o diretório
		File[] files = path.listFiles(File::isFile);
		System.out.println("FILES: ");
		for (File file : files) {
			System.out.println(file);
		}
		
		System.out.println("Directory created successfully: " + new File(strPath + "\\example").mkdir());
		
		//Nome do arquivo
		System.out.println("getName() - " + path.getName());
		//Caminho sem o nome do arquivo
		System.out.println("getParent() - " + path.getParent());
		//Camino completo com o nome do arquivo
		System.out.println("getPath() - " + path.getPath());
		
		sc.close();
	}
}