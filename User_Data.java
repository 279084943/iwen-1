import java.io.*;

import javax.swing.JOptionPane;


public class User_Data {
	
	public void confirm(String str1,String str2){
		File fi = new File("C:/javacode/iwen/User",str1+".txt");
		try{
			if(!fi.exists()){
			JOptionPane.showMessageDialog(null, "ע��ɹ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);     
			fi.createNewFile();
			writeFileContent(str1,str2);
			createfile(str1);
			}else    {     
			JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ����û����Ѵ���","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE); 
			} 
	}catch (Exception e){
	e.printStackTrace();
		}
	}
	
	public void Login(String str1,String str2){
		File fi = new File("C:/javacode/iwen/User",str1+".txt");
		try{
			if(!fi.exists()){
			JOptionPane.showMessageDialog(null, "�û���������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);     
			}else    { 
			Login_Confirm(str1,str2);
			//JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ����û����Ѵ���","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE); 
			} 
	}catch (Exception e){
	e.printStackTrace();
		}
		
	}
	public static void Login_Confirm (String str1,String str2) throws IOException{
		FileInputStream fis = null;
		InputStreamReader isr = null;
		  BufferedReader br = null; //���ڰ�װInputStreamReader,��ߴ������ܡ���ΪBufferedReader�л���ģ���InputStreamReaderû�С�
		  try {
		   String str = "";
		   String temp = "";
		   fis = new FileInputStream("C:/javacode/iwen/User/"+str1+".txt");// FileInputStream
		   // ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
		    isr = new InputStreamReader(fis);// InputStreamReader ���ֽ���ͨ���ַ���������,
		    br = new BufferedReader(isr);// ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new InputStreamReader�Ķ���
		  /* while ((str = br.readLine()) != null) {
		    temp += str;
		   }*/
		    str = br.readLine();
		    temp += str;
		 if(temp.equals(str2)){
			 JOptionPane.showMessageDialog(null, "��½�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			 //this.dispose();  //�رյ�ǰ����  
			 createstate(str1);
	         new UI();   //���½���  
			 
		 }else{
			 JOptionPane.showMessageDialog(null, "�������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); 
		 }
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

	}
	public static boolean writeFileContent(String str1,String str2) throws IOException{
		Boolean bool = false;
		String filein = str2 +"\r\n";
		String temp = "";
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		FileOutputStream fos = null;
		PrintWriter pw = null;
		try{
			File file = new File("C:/javacode/iwen/User",str1+".txt");
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();
			for (int i = 0;(temp = br.readLine())!=null;i++){
				buffer.append(temp);
				buffer = buffer.append(System.getProperty("line.separator"));
			}
			buffer.append(filein);
			
			fos = new FileOutputStream(file);
			pw = new PrintWriter(fos);
			pw.write(buffer.toString().toCharArray());
			pw.flush();
			bool = true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pw != null){
				pw.close();
			}
			if(fos != null){
				fos.close();
			}
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
		return bool;
	}
	public void createfile(String str1){
		File file =new File("C:/javacode/iwen/User/"+str1);    
		//����ļ��в������򴴽�    
		if  (!file .exists()  && !file .isDirectory())      
		{       
		    //System.out.println("//������");  
		    file.mkdir();    
		} else   
		{  
		   // System.out.println("//Ŀ¼����");  
		}
	}
	 public static void createstate(String str1){
	    	File fi1 = new File("C:/javacode/iwen/User/state.txt");
			try{
					fi1.createNewFile();
					PrintWriter pw = new PrintWriter( new FileWriter( "C:/javacode/iwen/User/state.txt" ) );
			        pw.print(str1);
			        pw.close(); 
		}catch (Exception e){
		e.printStackTrace();
			}
	    }
	
}
