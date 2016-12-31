import java.io.*;

import javax.swing.JOptionPane;


public class User_Data {
	
	public void confirm(String str1,String str2){
		File fi = new File("C:/javacode/iwen/User",str1+".txt");
		try{
			if(!fi.exists()){
			JOptionPane.showMessageDialog(null, "注册成功","提示消息",JOptionPane.WARNING_MESSAGE);     
			fi.createNewFile();
			writeFileContent(str1,str2);
			createfile(str1);
			}else    {     
			JOptionPane.showMessageDialog(null, "注册失败！该用户名已存在","提示消息",JOptionPane.ERROR_MESSAGE); 
			} 
	}catch (Exception e){
	e.printStackTrace();
		}
	}
	
	public void Login(String str1,String str2){
		File fi = new File("C:/javacode/iwen/User",str1+".txt");
		try{
			if(!fi.exists()){
			JOptionPane.showMessageDialog(null, "用户名不存在","提示消息",JOptionPane.WARNING_MESSAGE);     
			}else    { 
			Login_Confirm(str1,str2);
			//JOptionPane.showMessageDialog(null, "注册失败！该用户名已存在","提示消息",JOptionPane.ERROR_MESSAGE); 
			} 
	}catch (Exception e){
	e.printStackTrace();
		}
		
	}
	public static void Login_Confirm (String str1,String str2) throws IOException{
		FileInputStream fis = null;
		InputStreamReader isr = null;
		  BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
		  try {
		   String str = "";
		   String temp = "";
		   fis = new FileInputStream("C:/javacode/iwen/User/"+str1+".txt");// FileInputStream
		   // 从文件系统中的某个文件中获取字节
		    isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
		    br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
		  /* while ((str = br.readLine()) != null) {
		    temp += str;
		   }*/
		    str = br.readLine();
		    temp += str;
		 if(temp.equals(str2)){
			 JOptionPane.showMessageDialog(null, "登陆成功！","提示消息",JOptionPane.WARNING_MESSAGE);
			 //this.dispose();  //关闭当前界面  
			 createstate(str1);
	         new UI();   //打开新界面  
			 
		 }else{
			 JOptionPane.showMessageDialog(null, "密码错误！","提示消息",JOptionPane.WARNING_MESSAGE); 
		 }
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
		//如果文件夹不存在则创建    
		if  (!file .exists()  && !file .isDirectory())      
		{       
		    //System.out.println("//不存在");  
		    file.mkdir();    
		} else   
		{  
		   // System.out.println("//目录存在");  
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
