
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.Icon;


import java.util.Random;



public class PrimaryEnglish extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton capital;
	JButton small;
	JButton abeex;
	JButton exam1;
	JButton exam2;
	Image background=new ImageIcon(getClass().getResource("PrimaryEnglish.jpg")).getImage();
	HomeFrame homeframe;
	Random random=new Random();
	ExaminationEnglish examination;
	ExaminationEnglish2 examination2;
	Font banglafont=new Font("SolaimanLipi",Font.PLAIN,15);
	
	Thread t1,t2,t3,t4;
	
	public PrimaryEnglish(HomeFrame hf) throws ClassCastException
	{
		  this.homeframe=hf;
		   setLayout(null);
		   
		  
		   
		   // Create Button For Primary English
		   Icon capitalIcon=new ImageIcon(getClass().getResource("CapitalIcon.jpg"));
		   capital=new JButton();
		   capital.setIcon(capitalIcon);
		   capital.setBounds(170,120,120,38);
		   add(capital);
		   
		   Icon bornoBachai=new ImageIcon(getClass().getResource("BornoBachai2.jpg"));
		   exam1=new JButton();
		   exam1.setIcon(bornoBachai);
		   exam1.setBounds(170,170,120,38);
		   add(exam1);
		   
		   Icon smallIcon=new ImageIcon(getClass().getResource("SmallIcon.jpg"));
		   small=new JButton();
		   small.setIcon(smallIcon);
		   small.setFont(banglafont);
		   small.setBounds(500,120,120,38);
		   add(small);
		   
		   exam2=new JButton();
		   exam2.setIcon(bornoBachai);
		   exam2.setBounds(500,170,120,38);
		   add(exam2);
		   
		   Icon dekhi=new ImageIcon(getClass().getResource("DekhiSikhi.jpg"));
		   abeex=new JButton();
		   abeex.setIcon(dekhi);
		   abeex.setFont(banglafont);
		   abeex.setBounds(335,300,120,38);
		   add(abeex);
		   
		   
		   
		   Thehandler handler= new Thehandler();
		   capital.addActionListener(handler);
		   exam1.addActionListener(handler);
		   exam2.addActionListener(handler);
		   small.addActionListener(handler);
		   abeex.addActionListener(handler);
	}
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.drawImage(background, 0, 0, this);
		
		arg0.drawLine(160, 250, 630, 250);
		arg0.drawLine(390, 110, 390, 280);
		
	}
	
	
	private class Thehandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(capital==event.getSource())
			{
				homeframe.show(HomeFrame.CAPITAL_ENGLISH);
			}	
			else if(exam1==event.getSource())
			{
				
                examination=new ExaminationEnglish(homeframe);
				homeframe.mainPanel.add(examination,HomeFrame.EXAMINATION_ENGLISH);
				homeframe.show(HomeFrame.EXAMINATION_ENGLISH);
				
				/*t1= new Thread(examination,"One");
				t2= new Thread(examination,"two");
				t3= new Thread(examination,"three");
				t4= new Thread(examination,"four");
				
				t1.start();
				t2.start();
				t3.start();
				t4.start();*/
				
				//t5= new Thread(examination,"One");
			}
			else if(exam2==event.getSource())
			{
				
                examination2=new ExaminationEnglish2(homeframe);
				homeframe.mainPanel.add(examination2,HomeFrame.EXAMINATION_ENGLISH2);
				homeframe.show(HomeFrame.EXAMINATION_ENGLISH2);
				
			}
			
			else if(small==event.getSource())
			{
				homeframe.show(HomeFrame.SMALL_ENGLISH);
			}
			else if(abeex==event.getSource())
			{
				ABCexmaple abcExlample=new ABCexmaple(homeframe);
				homeframe.mainPanel.add(abcExlample,HomeFrame.ABC_EXAMPLE);
				homeframe.show(HomeFrame.ABC_EXAMPLE);
			}
		}
		
		
	}
	
}