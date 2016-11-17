/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author boss
 */
public class Utils {
    public static String[] stringListToArr(List<String> list) {
        String[] arr = new String[list.size()];
        for(int i = 0; i < list.size(); ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    
     public static List<String> stringArrToList(String[] arr) {
        List<String> list = new ArrayList();
        for(String s : arr) {
            list.add(s);
        }
        return list;
    }
    
    public static <E> List<E> deepCopyList(List<E> l) {
        List<E> createdList = new ArrayList<E>(l.size());
        for(E curr : l) {
            createdList.add(curr);
        }
        return createdList;
    }
   
    public static void WriteStringLinesToFile(String[] text, String path, String fileName) 
            throws FileNotFoundException, UnsupportedEncodingException {        
        PrintWriter writer = new PrintWriter(path + '/' + fileName, "UTF-8");
        for(String s : text) {
            writer.println(s);
        }
        writer.close();
    }
    
    public static void writeStringToFile(String text, String path, String fileName) 
            throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(path + '/' + fileName, "UTF-8");
        writer.print(text);
        writer.close();
    }

	public static List<String> readListFromFile(Path path) 
			throws IOException {
		
		Files.readAllLines(path);
		return Files.readAllLines(path, Charset.defaultCharset());
	}
	
	public static void deleteFile(String toDelete) throws IOException {
		File file = new File("src/res/" + toDelete);
		Files.delete(file.toPath());
	}
	
	public static String getFileFromRes(String fileName) {
		return new File("src/res/" + fileName).getAbsolutePath();
	}
	 
}
