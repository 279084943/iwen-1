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
		jb1 = new JButton("��ѡ");
		jb2 = new JButton("��ѡ");
		//jb3 = new JButton("�ʴ�");
		jb4 = new JButton("���");
		
		jb1.addActionListener(this);  
	    jb2.addActionListener(this);
	  //  jb3.addActionListener(this);
	    jb4.addActionListener(this);
	    
	    jlb = new JLabel("ѡ����Ҫ��ӵ��������ͣ�");
	    
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
		this.setTitle("�ʾ���ɽ���");
		this.setLayout(new GridLayout(3,1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    this.setBounds(500, 200, 300, 180); 
	}
	
	public void actionPerformed(ActionEvent e) {  
        
        //����������ť  
        if(e.getActionCommand()=="��ѡ")  
        {  
        	this.dispose();
        	new OneChoice_Creat();
        	
        }else if(e.getActionCommand()=="��ѡ")  
        {  
            //����UI
        	this.dispose();
        	new MultChoice_Creat();
        }else if(e.getActionCommand()=="���")  
        {  
            //����UI
        	this.dispose();
        	new UI();
        }
          
    }
}
