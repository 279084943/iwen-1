import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class UI extends JFrame implements ActionListener{
	JButton jb1,jb2,jb3,jb4=null;  
	JPanel jp1,jp2,jp3,jp4 = null; 
	JFrame jf = null;
	public UI(){
		jb1 = new JButton("�½��ʾ�");  
        jb2 = new JButton("��д�ʾ�");  
        jb3 = new JButton("�ҵ��ʾ�");
        jb4 = new JButton("   �˳�     "); 

        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
        jb3.addActionListener(this); 
        jb4.addActionListener(this); 
        
        jp1=new JPanel();  
        jp2=new JPanel();  
        jp3=new JPanel(); 
        jp4=new JPanel();
        
        jp1.add(jb1);    
        jp2.add(jb2);  
        jp3.add(jb3); 
        jp4.add(jb4);
        
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        
        this.setVisible(true);  
        this.setResizable(false);  
        this.setTitle("ѡ��˵�����");  
        this.setLayout(new GridLayout(2,2));  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setBounds(500, 200, 300, 180); 
	}
	
	public void actionPerformed (ActionEvent e) {  
        
        //����������ť  
        if(e.getActionCommand()=="�½��ʾ�")  
        {  
            //�����½�����
        	this.dispose();
        	this.newobject();
        }else if(e.getActionCommand()=="��д�ʾ�")  
        {  
            //������д����  
           this.writeobject();  
        }else if(e.getActionCommand()=="�ҵ��ʾ�")  
        {  
            //���ò鿴����  
           this.showobject();  
        }else if(e.getActionCommand()=="   �˳�     ")  
        {  
            //�˳�
        	System.exit(0);  
        }  
          
    }
	public void newobject(){
		new New_Object();
	}
	public void writeobject(){
		new OneChoice();
	}
	public void showobject(){
		new Show_Pro();
	}
	
}
