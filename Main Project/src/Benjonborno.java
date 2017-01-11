import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;



public class Benjonborno extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Icon benjonBornoIcon[]=new ImageIcon[39];
	JButton benjonBornoButton[]=new JButton[39];
	int i,k=0;
	String x;
	Image background=new ImageIcon(getClass().getResource("pic1.jpg")).getImage();
	HomeFrame homeFrame;
	AudioClip clip[]=new AudioClip[39];
	AudioClip stop;
	public Benjonborno(HomeFrame hf) throws ClassCastException
	{
		this.homeFrame=hf;
		setLayout(new FlowLayout());
		for(i=0;i<39;i++)
		{
			String con = Integer.toString(i+1);
			x="Bx"+con+".png";
			benjonBornoIcon[i]=new ImageIcon(getClass().getResource(x));
		}
		
		for(i=0;i<39;i++){
		    benjonBornoButton[i]=new JButton();
			benjonBornoButton[i].setIcon(benjonBornoIcon[i]);
			add(benjonBornoButton[i]);
			}
		Thehandler handler=new Thehandler();
		for(i=0;i<39;i++)
		{
			benjonBornoButton[i].addActionListener(handler);
		}
	}
	private class Thehandler implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) {
			for(i=0;i<39;i++)
			{
				if(benjonBornoButton[i]==arg0.getSource())
				{
					String con = Integer.toString(i+1);
					x="Ben"+con+".wav";
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