import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;


public class getstate {
	
	public String Get_State() throws IOException{
	FileInputStream fis = null;
	InputStreamReader isr = null;
	String str = "";
	String temp = "";
	BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
	try {
	   fis = new FileInputStream("C:/javacode/iwen/User/state.txt");// FileInputStream
	   // 从文件系统中的某个文件中获取字节
	    isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
	    br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
	    str = br.readLine();
	    temp += str;
	  } catch (FileNotFoundException e) {
	   System.out.println("找不到指定文件");
	  } catch (IOException e) {
	   System.out.println("读取文件失败");
	  }finally{
				if(br != null){
					br.close();
				}
				if(isr != null){
					isr.close();
				}
				if(fis != null){
					fis.close();
				}
			
	  }
	return temp;
	}
}
