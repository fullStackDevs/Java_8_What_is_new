package Chapter_1_Introduction_To_Lamda;

import java.io.File;
import java.io.FileFilter;

public class Ex_0_FileFilterLamda {

	public static void main(String[] args) {
		
//		FileFilter javaFiles = new FileFilter(){
//			@Override
//			public boolean accept(File pathname) {
//				return pathname.getName().endsWith(".java");
//			}
//		};
		
		FileFilter javaFilesLamda = (f) -> f.getName().endsWith(".java");
		
		FileFilter pdfFileLamda = (f) -> f.getName().endsWith(".pdf");
				

		File dir = new File("d:/temp");
		File[] files = dir.listFiles(javaFilesLamda);
		
		for(File f : files){
			System.out.println(f.getName());
		}
	}

}
