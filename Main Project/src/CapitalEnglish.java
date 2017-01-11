


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



public class CapitalEnglish extends JPanel {
	            
	/**
	 * 
	 */
	private static final long serialVersionUID = 787207322273517402L;
	Icon alphabetIcon[]=new ImageIcon[26];
	int count;
	JButton alphabetButton[]=new JButton[26];
    int i=0;
    int j=0,k=0;
	String x;
	AudioClip clip[]=new AudioClip[26];
	AudioClip stop;
	Icon a[]=new ImageIcon[26];
    JMenu homeMenu=new JMenu("Home");
   java.awt.Image background=new ImageIcon(getClass().getResource("Alphabet.jpg")).getImage();
    HomeFrame homeframe;
	public CapitalEnglish(HomeFrame hf) throws ClassCastException
	{
		this.homeframe=hf;
		setLayout(new FlowLayout());
		char s='A';
		
		for(int i=0;i<26;i++)
		{
			String con=Character.toString(s);
			x=con+"_I.png";
			alphabetIcon[i]=new ImageIcon(getClass().getResource(x));
			s=(char) (s+1);
		}
		for(int i=0;i<26;i++){
	    alphabetButton[i]=new JButton();
		alphabetButton[i].setIcon(alphabetIcon[i]);
		add(alphabetButton[i]);
		}
		Thehandler handler=new Thehandler();
		for(int i=0;i<alphabetButton.length;i++)
		{
			alphabetButton[i].addActionListener(handler);
		}
	}
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.drawImage(background, 0, 0,900,700, this);
	}
	private class Thehandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event) {
			char s='A';
			
			for(i=0;i<26;i++){
				s= (char) (s+1);
			if(event.getSource()==alphabetButton[i])
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
