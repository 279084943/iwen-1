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
	BufferedReader br = null; //���ڰ�װInputStreamReader,��ߴ������ܡ���ΪBufferedReader�л���ģ���InputStreamReaderû�С�
	try {
	   fis = new FileInputStream("C:/javacode/iwen/User/state.txt");// FileInputStream
	   // ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
	    isr = new InputStreamReader(fis);// InputStreamReader ���ֽ���ͨ���ַ���������,
	    br = new BufferedReader(isr);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new InputStreamReader�Ķ���
	    str = br.readLine();
	    temp += str;
	  } catch (FileNotFoundException e) {
	   System.out.println("�Ҳ���ָ���ļ�");
	  } catch (IOException e) {
	   System.out.println("��ȡ�ļ�ʧ��");
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
