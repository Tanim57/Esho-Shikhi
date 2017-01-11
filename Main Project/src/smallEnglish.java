
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.URL;

import java.applet.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JMenu;
import javax.swing.JPanel;



public class smallEnglish extends JPanel {
	            
	/**
	 * 
	 */
	private static final long serialVersionUID = 787207322273517402L;
	Icon smallIcon[]=new ImageIcon[26];
	int count;
	JButton smallButton[]=new JButton[26];
    int i=0;
    int j=0,k=0;
	String x;
	AudioClip stop;
	AudioClip clip[]=new AudioClip[26];
	Icon a[]=new ImageIcon[26];
    JMenu homeMenu=new JMenu("Home");
    java.awt.Image background=new ImageIcon(getClass().getResource("Alphabet.jpg")).getImage();
    HomeFrame homeframe;
	public smallEnglish(HomeFrame hf)throws ClassCastException
	{
		this.homeframe=hf;
		setLayout(new FlowLayout());
		char s='a';
		for(int i=0;i<26;i++)
		{
			String con = Integer.toString(i+1);
			x="Es"+con+".png";
			smallIcon[i]=new ImageIcon(getClass().getResource(x));
			s=(char) (s+1)	;
		}
		//JButton button[]=new JButton[26];
		for(int i=0;i<26;i++){
	    smallButton[i]=new JButton();
	    smallButton[i].setIcon(smallIcon[i]);
		add(smallButton[i]);
		}
		Thehandler handler=new Thehandler();
		for(int i=0;i<smallButton.length;i++)
		{
			smallButton[i].addActionListener(handler);
		}
	}
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.drawImage(background, 0, 0, this);
	}
	private class Thehandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event) {
			
			char s='a';
			for(i=0;i<26;i++){
				s= (char) (s+1);
			if(event.getSource()==smallButton[i])
			{
				if(k==1)
				{
					stop.stop();
					k=0;
				}
				s=(char) (s-1);
				String con=Character.toString(s);
				x="Audio_"+con+".wav";
				URL url = getClass().getResource(x);
				clip[i] =  Applet.newAudioClip(url);
				clip[i].play();
				stop=clip[i];
				k++;
			}
			}
		}	
		
	}
}