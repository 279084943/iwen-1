import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Choice_Diff extends JFrame implements ActionListener{
	JButton jb1,jb2,jb3,jb4= null;
	JLabel jlb = null;
	JPanel jp1,jp2,jp3 = null;
	public Choice_Diff(){
		jb1 = new JButton("单选");
		jb2 = new JButton("多选");
		//jb3 = new JButton("问答");
		jb4 = new JButton("完成");
		
		jb1.addActionListener(this);  
	    jb2.addActionListener(this);
	  //  jb3.addActionListener(this);
	    jb4.addActionListener(this);
	    
	    jlb = new JLabel("选择您要添加的问题类型：");
	    
	    jp1 = new JPanel();
	    jp2 = new JPanel();
	    jp3 = new JPanel();
	    
	    jp1.add(jlb);
	    
	    jp2.add(jb1);
	    jp2.add(jb2);
	    
	 //   jp3.add(jb3);
	    jp3.add(jb4);
	    
	    this.add(jp1);  
	    this.add(jp2);  
	    this.add(jp3); 
	    
	    this.setVisible(true);
		this.setResizable(false);
		this.setTitle("问卷组成界面");
		this.setLayout(new GridLayout(3,1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    this.setBounds(500, 200, 300, 180); 
	}
	
	public void actionPerformed(ActionEvent e) {  
        
        //监听各个按钮  
        if(e.getActionCommand()=="单选")  
        {  
        	this.dispose();
        	new OneChoice_Creat();
        	
        }else if(e.getActionCommand()=="多选")  
        {  
            //返回UI
        	this.dispose();
        	new MultChoice_Creat();
        }else if(e.getActionCommand()=="完成")  
        {  
            //返回UI
        	this.dispose();
        	new UI();
        }
          
    }
}
