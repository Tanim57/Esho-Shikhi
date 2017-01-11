import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;
import java.util.Timer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRootPane;


public class ExaminationBangla extends JPanel{
       /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Random random=new Random();
       HomeFrame homeframe;
       int i,j,k=0,num;
	   int count=20;
       String x;
       char s;
       JLabel l,l1;
       javax.swing.Timer t;
       JProgressBar pbr=new JProgressBar(0,15);
       
       int sheck=1;
       Icon startIcon;
       
       JButton alpabetButton[]=new JButton[5];
       Icon icon[]=new ImageIcon[5];
       public int a[]=new int[5];
       public Timer time=new Timer ();
       private JButton start= new JButton("Start");
       AudioClip clip;
       ResultDialog dialog;
       Image background=new ImageIcon(getClass().getResource("ExaminationEnglish.jpg")).getImage();
       JProgressBar timecount;
       Font banglafont=new Font("SolaimanLipi",Font.PLAIN,35);
 	   int x1[]=new int[5];
 	   int y1[]=new int[5];
       public ExaminationBangla(HomeFrame hf) throws IllegalStateException,ClassCastException
       {
    	   
    	   this.homeframe=hf;

    	   for(i=0;i<5;i++)
    	   {
    		   a[i]=-1;
    	   }
    	   for(i=0;i<5;i++)
    	   {
    		   num=random.nextInt(11);
    			   for(j=0;j<i;)
    			   {
    				   if(num==a[j])
    				   {
    					   num=random.nextInt(11);
    					   j=0;
    				   }
    				   else
    				   {
    					   j++;
    				   }
    			   }
    			   a[i]=num;
    			   String con = Integer.toString(a[i]+1);
    		   x="Sor"+con+".png";
    		   alpabetButton[i]=new JButton();
    		   icon[i]=new ImageIcon(getClass().getResource(x));
     		   alpabetButton[i].setIcon(icon[i]);
    	   }
    	   setLayout(null);
    	   alpabetButton[0].setBounds(60, 50,120, 120);
    	   add(alpabetButton[0]);
    	   alpabetButton[1].setBounds(250, 180,120, 120);
    	   add(alpabetButton[1]);
    	   alpabetButton[2].setBounds(30, 265,120, 120);
    	   add(alpabetButton[2]);
    	   alpabetButton[3].setBounds(200, 450,120, 120);
    	   add(alpabetButton[3]);
    	   alpabetButton[4].setBounds(400, 380,120, 120);
    	   add(alpabetButton[4]);
    	   start.setBounds(750, 140, 120, 40);
    	   startIcon=new ImageIcon(getClass().getResource("startIcon.png"));
    	   start.setIcon(startIcon);
    	   add(start);
    	    l=new JLabel();
			l.setBounds(700,50,205,50);
			l.setFont(l.getFont().deriveFont(64.0f));
		    l.setForeground(Color.black);
		
			
		    add(l);
		  
		    pbr.setBounds(700,90,180,40);
		    pbr.setStringPainted(true);
         
    	   start.addActionListener(new ActionListener() {
    		   
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0)  { 
				try{
					if(count==20)
					{
						add(pbr);
					}
				if(k==0)
				{
					t= new javax.swing.Timer(800, new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
							
					    	startIcon=new ImageIcon(getClass().getResource("reset.png"));
					    	start.setIcon(startIcon);
					    	start.setText("Reset");
							if(count>=10)
							l.setText("সময়ঃ  00:" +count+" ");
							else
							{
								l.setText("সময়ঃ  00:0" +count+" ");
							}
							l.setFont(banglafont);
							//int x[]=new int [5];
					        //int y[]=new int [5];
//							i=0;
//					        while(i<5)
//					        {
//					        	x[i]=random.nextInt(580);
//					        	y[i]=random.nextInt(500);
//					        	alpabetButton[i].setBounds(x[i], y[i], 120, 120);
//					        	i++;
//					        }
					        i=0;
					        j=1;
					        int num1=random.nextInt(50000);
					        int num2=random.nextInt(50000);
							
					        alpabetButton[0].setBounds((num1+350)%580, ((num2+580))%520,120, 120);
							alpabetButton[1].setBounds((num1+450)%580, (num2+300)%520,120, 120);
							alpabetButton[2].setBounds((num1+150)%580 ,(num2+450)%520,120, 120);
							alpabetButton[3].setBounds((num1+10)%580, (num2+150)%520,120, 120);
							alpabetButton[4].setBounds((num1+600)%580, (num2+10)%520,120, 120);
							
//							if(sheck==1 || sheck==3 || sheck==6 || sheck== 9 || sheck==13){
//								alpabetButton[0].setBounds(550+(count*30)%200, 333+(count*400)%150,120, 120);
//								alpabetButton[1].setBounds(120+(count*77)%550, (count*33)%550,120, 120);
//								alpabetButton[2].setBounds((count*333)%467, 80+(count*5)%500,120, 120);
//								alpabetButton[3].setBounds(count*25+(100*count)%200,260+(count*200)%350,120, 120);
//								alpabetButton[4].setBounds(100+(10*count)%600,280+(count*77)%220,120, 120);
//								}
//								else if(sheck==7 || sheck==8 || sheck ==9)
//								{
//									alpabetButton[0].setBounds(200+(count*11)%400, 42+(count*42)%250,120, 120);
//									alpabetButton[1].setBounds(5*(count*77)%550, (count*55)%550,120, 120);
//									alpabetButton[2].setBounds((count*333)%167, 80+(count*5)%500,120, 120);
//									alpabetButton[3].setBounds(count*25+(100*count)%200,260+(count*200)%350,120, 120);
//									alpabetButton[4].setBounds((10*count)%600,280+(count*77)%220,120, 120);
//								}
//								else if(sheck==10 || sheck == 14 || sheck ==15)
//								{
//									alpabetButton[0].setBounds(350+(count*87)%150, 42+(count*42)%250,120, 120);
//									alpabetButton[1].setBounds(200+(count*77)%50,300+ (count*55)%250,120, 120);
//									alpabetButton[2].setBounds((count*2)%167, 180+(count*5)%400,120, 120);
//									alpabetButton[3].setBounds(count*count+(100*count)%200,260+(count*200)%350,120, 120);
//									alpabetButton[4].setBounds(550+(20*count)%150,(count*77)%300,120, 120);
//								}
//								else
//								{
//									alpabetButton[0].setBounds(20+(count*77)%120, 380+(count*55)%120,120, 120);
//									alpabetButton[1].setBounds(140+(count*77)%120,370+ (count*55)%120,120, 120);
//									alpabetButton[2].setBounds(260+(count*77)%120, 150+(count*5)%120,120, 120);
//									alpabetButton[3].setBounds(380+(count*77)%120,250+(count*200)%120,120, 120);
//									alpabetButton[4].setBounds(500+(count*77)%120,380+(count*77)%120,120, 120);
//								}
								//sheck++;
								count --;
								pbr.setValue(count);
								if(count==-1)
						    	  {
						    		  t.stop();
						    		  dialog=new ResultDialog("Timeout.jpg","Try Again");
										dialog.setTitle("RESULT");
										homeframe.homeMenu.enable();
										homeframe.menu.enable();
						    	  }
						}
					});
			    t.start();
		
			homeframe.homeMenu.disable();
			homeframe.menu.disable();
			
			num=random.nextInt(5);
			String con = Integer.toString(a[num]+1);
			x="S"+con+".wav";
			java.net.URL url= getClass().getResource(x);
			clip=Applet.newAudioClip(url);
			clip.play();
			}
			k++;
			if(k==2)
			{
				t.stop();
				k=0;
				homeframe.homeMenu.enable();
				homeframe.menu.enable();
				ExaminationBangla examination=new ExaminationBangla(homeframe);
				homeframe.mainPanel.add(examination,HomeFrame.EXAMINATION_BANGLA);
				homeframe.show(HomeFrame.EXAMINATION_BANGLA);
			}
		}	
				catch(ClassCastException e)
				{
					    
					homeframe.homeMenu.enable();
					homeframe.menu.enable();
					    ExaminationBangla examination1=new ExaminationBangla(homeframe);
						homeframe.mainPanel.add(examination1,HomeFrame.EXAMINATION_BANGLA);
						homeframe.show(HomeFrame.EXAMINATION_BANGLA);
				}
			}
		}); 
    	   Thehandler handler=new Thehandler();
    	   for(i=0;i<5;i++)
    	   {
    		   alpabetButton[i].addActionListener(handler);
    	   }
       }
       private class Thehandler implements ActionListener
       {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent event) {
			try{
		    if(alpabetButton[num]==event.getSource() && k==1)
			{
				t.stop();
				homeframe.homeMenu.enable();
				homeframe.menu.enable();
				new ResultDialog("Rightans.jpg","OK");
				k=0;
			}
			else if(alpabetButton[num]!=event.getSource() && k==1)
			{
				t.stop();
				homeframe.homeMenu.enable();
				homeframe.menu.enable();
				new ResultDialog("Wrongans.jpg","Try Again");
				k=0;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Click Start First", "Message", JOptionPane.WARNING_MESSAGE);
			}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Click Start First", "Message", JOptionPane.WARNING_MESSAGE);
			}
		}   
       }
       public class ResultDialog extends JDialog
       {
	     /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		JButton tryAgain;
	     ExaminationBangla examination;
		public ResultDialog(String image,String x)
    	   {
    		   setTitle("Result");
    		   setLayout(null);
			   setSize(500, 300);
    		   setLocationByPlatform(true);
    		   setLocationRelativeTo(null);
    		   setUndecorated(true);
    		   setModal(true);
    		   setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    		   setContentPane(new JLabel(new ImageIcon(getClass().getResource(image))));
    		   tryAgain=new JButton(x);
    		   tryAgain.setBounds(25, 150, 100, 30);
    		   add(tryAgain);
			   getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
			   
			  Thehandler handler=new Thehandler();
    		  tryAgain.addActionListener(handler);
			   setVisible(true);
			   setResizable(false);  
    	   }
		private class Thehandler implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) {
			    examination=new ExaminationBangla(homeframe);
				homeframe.mainPanel.add(examination,HomeFrame.EXAMINATION_BANGLA);
				homeframe.show(HomeFrame.EXAMINATION_BANGLA);
				dispose();
			}
		}
		
       }
     
       protected void paintComponent(Graphics arg0) {
   		super.paintComponent(arg0);
   		arg0.drawImage(background, 0, 0, this);
   	}
}