import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class New_Object extends JFrame implements ActionListener {
	JButton jb1,jb2 = null;
	JPanel jp1,jp2,jp3 = null;
	JTextField jtf = null;
	JLabel jlb1,jlb2 = null;
	String getsit;
	public New_Object(){
	jb1 = new JButton("确认");	
	jb2 = new JButton("返回");
	
	//设置监听  
    jb1.addActionListener(this);  
    jb2.addActionListener(this);
    
    jlb1 = new JLabel ("新问卷的名字：");
	
    jtf = new JTextField(10);
    jtf.setToolTipText("问卷名必须为3-10位中文");  
    jp1=new JPanel();  
    jp2=new JPanel();  
    jp3=new JPanel(); 
    
    jp1.add(jlb1);  
    jp1.add(jtf); 
    
    jp3.add(jb1);
    jp3.add(jb2);
   
    this.add(jp1);  
    this.add(jp2);  
    this.add(jp3); 
    
    this.setVisible(true);
	this.setResizable(false);
	this.setTitle("新建问卷界面");
	this.setLayout(new GridLayout(3,1));
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    this.setBounds(500, 200, 300, 180); 
	}
	
	 public void actionPerformed(ActionEvent e) {  
         
	        //监听各个按钮  
	        if(e.getActionCommand()=="确认")  
	        {  
	        	String regex1="[\\u4e00-\\u9fa5]{3,10}"; 
	   		 	//题目必须是3-10位  中文
	   		 	boolean flag1 = jtf.getText().matches(regex1);
	        	if(flag1==false)    {    
	    			 JOptionPane.showMessageDialog(null, "问卷名填写错误,必须为3-10位中文", "提示信息", JOptionPane.WARNING_MESSAGE);    
	    			 jtf.setText("");  
	    			 }else{ 
	        	try {
					this.Creat(jtf.getText());					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
	    		}
	        }else if(e.getActionCommand()=="返回")  
	        {  
	            //返回UI
	        	this.dispose();
	        	new UI();
	        }
	          
	    }
	 public void Creat(String str1) throws IOException{
		String temp = "";
		 String tmp = "";
		 getstate ss = new getstate(); 
		 temp = ss.Get_State();
		 tmp = "C:/javacode/iwen/Project/"+str1 ;
		 File file =new File(tmp);
		 File fi1 = new File(tmp+"/one.txt");
		 File fi2 = new File(tmp+"/mult.txt");
		 File fi3 = new File(tmp+"/mult_num.txt");
		 File fi4 = new File(tmp+"/one_num.txt");
		try{
			if  (!file .exists()  && !file .isDirectory())      
			{       
			 	JOptionPane.showMessageDialog(null, "创建成功","提示消息",JOptionPane.WARNING_MESSAGE);     
			 	createtmp(str1);
			 	file.mkdir(); 
			    fi1.createNewFile();
			    fi2.createNewFile();
			    fi3.createNewFile();
			    fi4.createNewFile();
			    this.dispose();
			    
			    new Choice_Diff();
			    
			   /* File fi = new File("C:/javacode/iwen/Project/name.txt");
			    FileWriter pw = new FileWriter(fi,true);
			    pw.write(str1+"\r\n");
			    pw.close();*/
			} else   
			{  
				JOptionPane.showMessageDialog(null, "创建失败，问卷已存在","提示消息",JOptionPane.ERROR_MESSAGE); 
				this.jtf.setText("");
			}	
		}catch (Exception e){
		e.printStackTrace();
			}
	 }
	 
	 public static void createtmp(String str1){
	    	File fi1 = new File("C:/javacode/iwen/User/tmp.txt");
			try{
					fi1.createNewFile();
					PrintWriter pw = new PrintWriter( new FileWriter( "C:/javacode/iwen/User/tmp.txt" ) );
			        pw.print(str1);
			        pw.close();
		}catch (Exception e){
		e.printStackTrace();
			}
	    }
	 
}
