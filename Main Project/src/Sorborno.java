import java.applet.Applet;
import java.applet.AudioClip;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Sorborno extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String x=null;
	int k=0;
	Icon sorbornoIcon[]=new ImageIcon[11];
	JButton sorbornoButton[]=new JButton[11];
	int i;
	HomeFrame homeframe;
	JButton benjonborno;
	Font banglaFont=new Font("SolaimanLipi",Font.PLAIN,15);
	JButton gan=new JButton("গানে গানে শিখি");
	AudioClip stop;
	AudioClip clip[]=new AudioClip[11];
	JPanel panel1=new JPanel();
	JPanel panel2=new JPanel();
	Image background=new ImageIcon(getClass().getResource("pic1.jpg")).getImage();
	JLabel label[]=new JLabel[5];
	JLabel mainlabel=new JLabel();
	JLabel buttonlabel=new JLabel();
	CardLayout card=new CardLayout();
	JMenuBar menuBar;
	
	public Sorborno(HomeFrame hf) throws ClassCastException
	{
		this.homeframe=hf;
		
		setLayout(new FlowLayout());
		
		for(i=0;i<11;i++)
		{
			String con = Integer.toString(i+1);
			x="Sor"+con+".png";
			sorbornoIcon[i]=new ImageIcon(getClass().getResource(x));
		}
		for(i=0;i<11;i++){
		    sorbornoButton[i]=new JButton();
			sorbornoButton[i].setIcon(sorbornoIcon[i]);
			add(sorbornoButton[i]);
			}
		Thehandler handler=new Thehandler();
		for(i=0;i<11;i++)
		{
			sorbornoButton[i].addActionListener(handler);
		}
		
		gan.setFont(banglaFont);
	}
	private class Thehandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			for(i=0;i<11;i++)
			{
				if(sorbornoButton[i]==arg0.getSource())
				{
					String con = Integer.toString(i+1);
					x="S"+con+".wav";
					URL url=getClass().getResource(x);
					clip[i] =  Applet.newAudioClip(url);
					clip[i].play();
					if(k==1)
						{
							stop.stop();
							k=0;
						}
						stop=clip[i];
						k++;
				}
			}
			
		}
	}
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.drawImage(background, 0, 0, this);
	}
}