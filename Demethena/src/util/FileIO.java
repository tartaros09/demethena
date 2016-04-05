package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author sahil
 * This class provides various tools to handle inputs and
 * outputs to files on the disk.
 */
public class FileIO
{
	/******************************  ******************************/
	
	/**
	 * @description append content to file pointed to by filepath
	 */
	public static void appendToFile(String filepath, String content) {
		try {
			File file = new File(filepath);
			if(!file.exists())
				file.createNewFile();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			bw.write(content);
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done writing to file.");
	}

	/******************************  ******************************/
	
	/**
	 * @description write content to file pointed to by filepath
	 */
	public static void writeToFile(String filepath, String content) {
		try {
			File file = new File(filepath);
			if(!file.exists())
				file.createNewFile();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(content);
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done writing to file.");
	}
}
