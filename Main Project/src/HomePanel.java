import java.applet.Applet;
import java.applet.AudioClip;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JPanel;



public class HomePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Image icon = new ImageIcon(getClass().getResource("HomeBackground.jpg")).getImage();

	JButton banglaButton;
	JButton englishButton;
	HomeFrame homeFrame;
    AudioClip clip;
    Font banglaFont=new Font("SolaimanLipi",Font.PLAIN,15);
	public HomePanel(HomeFrame hf) throws ClassCastException
	{
		homeFrame = hf;
		setLayout(null);

		// Create Primary and Advance Buton
		banglaButton = new JButton();
		Icon banglaIcon = new ImageIcon(getClass().getResource("BanglaButton.jpg"));
		banglaButton.setIcon(banglaIcon);
		banglaButton.setBounds(400, 300, 153, 50);
		add(banglaButton);
		englishButton = new JButton();
		Icon englishIcon = new ImageIcon(getClass().getResource("EnglishButton.jpg"));
		englishButton.setIcon(englishIcon);
		englishButton.setBounds(400, 360, 153, 50);
		add(englishButton);
		
		banglaButton.addActionListener(new Thehandler());
		englishButton.addActionListener(new Thehandler());
		
	}
	
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.drawImage(icon, 0, 0, this);
	}
	// The Handler Class
	private class Thehandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()==banglaButton){
				homeFrame.setTitle("BANGLA");
				URL url = getClass().getResource("click.wav");
				clip =  Applet.newAudioClip(url);
				clip.play();
				
				homeFrame.show(HomeFrame.PRIMARY_BANGLA);
			}
			else if(event.getSource()==englishButton)
			{
				homeFrame.setTitle("ENGLISH");
				URL url = getClass().getResource("click.wav");
				clip =  Applet.newAudioClip(url);
				clip.play();
				
				homeFrame.show(HomeFrame.PRIMARY_ENGLISH);
			}
		}
	}

}