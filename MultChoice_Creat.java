import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MultChoice_Creat extends JFrame implements ActionListener{
	JButton jb= null;
	JLabel jlb1,jlb2,jlb3,jlb4,jlb = null;
	JPanel jp,jp1,jp2,jp3,jp4,jp5 = null;
	JTextField jtf,jtf1,jtf2,jtf3,jtf4 = null;
	public MultChoice_Creat(){
		jb = new JButton("完成");
		
		jb.addActionListener(this);
		
		jlb = new JLabel("问题：   ");
		jlb1 = new JLabel("选项A：");
		jlb2 = new JLabel("选项B：");
		jlb3 = new JLabel("选项C：");
		jlb4 = new JLabel("选项D：");
		
		jtf = new JTextField(15);
		jtf1 = new JTextField(15);
		jtf2 = new JTextField(15);
		jtf3 = new JTextField(15);
		jtf4 = new JTextField(15);
		
		jp = new JPanel();
		jp1 = new JPanel();  
	    jp2 = new JPanel();  
	    jp3 = new JPanel(); 
	    jp4 = new JPanel();
	    jp5 = new JPanel();
	    
	    jp.add(jlb);
	    jp.add(jtf);
	
	    jp1.add(jlb1);
	    jp1.add(jtf1);
	    
	    jp2.add(jlb2);
	    jp2.add(jtf2);
	    
	    jp3.add(jlb3);
	    jp3.add(jtf3);
	    
	    jp4.add(jlb4);
	    jp4.add(jtf4);
	    
	    jp5.add(jb);
	    
	    this.add(jp);
	    this.add(jp1);  
	    this.add(jp2);  
	    this.add(jp3);
	    this.add(jp4);
	    this.add(jp5);
	    
	    this.setVisible(true);
		this.setResizable(false);
		this.setTitle("新建多选问卷界面");
		this.setLayout(new GridLayout(6,1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    this.setBounds(500, 200, 300, 180); 
		}
	
	public void actionPerformed(ActionEvent e) {  
        
        //监听各个按钮  
        if(e.getActionCommand()=="完成")  
        {    
            this.dispose();
            try {
				Input(jtf.getText(),jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            new Choice_Diff();
        }
          
    }
	
	public void Input(String str,String str1,String str2,String str3,String str4) throws IOException{
		String tmp1 = "";
		String tmp2 = "";
		getstate ss = new getstate(); 
		tmp1 = ss.Get_State();
		gettmp sa = new gettmp();
		tmp2 = sa.Get_Tmp();
		FileWriter pw = new FileWriter("C:/javacode/iwen/Project/"+tmp2+"/mult.txt",true) ;
	    pw.write(str+"\r\n");
	    pw.write(str1+"\r\n");
	    pw.write(str2+"\r\n");
	    pw.write(str3+"\r\n");
	    pw.write(str4+"\r\n");
	    pw.close();
	    FileWriter pr = new FileWriter("C:/javacode/iwen/Project/"+tmp2+"/mult_num.txt",true);
	    pr.write("0\r\n");
	    pr.write("0\r\n");
	    pr.write("0\r\n");
	    pr.write("0\r\n");	  
	    pr.close();
	}
}
