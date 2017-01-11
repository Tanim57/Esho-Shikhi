import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;



public class ABCexmaple extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HomeFrame homeframe;
    int k=0,i,j=0;
    String x;
    ImageIcon image=new ImageIcon(getClass().getResource("ABCex.jpg"));
    String s="B12.png";
    JPanel abcmainPanel = new JPanel();
    CardLayout cardlayout=new CardLayout();
    JPanel panel[]=new JPanel[26];
    JLabel label[]=new JLabel[26];
    AudioClip stop;
    JPanel buttonpanel=new JPanel(){
    	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		protected void paintComponent(Graphics arg0) {
    		super.paintComponent(arg0);
    		arg0.setColor(java.awt.Color.black);
    		arg0.drawImage(image.getImage(),0,0,3500,200,null);
    	}
    };
    
    JButton alphabetButton[]=new JButton[26];
    Icon icon[]=new ImageIcon[26];
    JPanel p=new JPanel();
    AudioClip clip[]=new AudioClip[26];
    
    JLabel l;
    
    public ABCexmaple(HomeFrame hf) throws ClassCastException
    {
    	this.homeframe=hf;
    	setLayout(null);
    	JScrollPane scrollPane = new JScrollPane();
    	scrollPane.setBounds(0, 500, 900, 700);
    	JScrollBar scroll=new JScrollBar(JScrollBar.HORIZONTAL);
    	scrollPane.setHorizontalScrollBar(scroll);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    	scrollPane.getVerticalScrollBar().setUnitIncrement(30);
    	scrollPane.getHorizontalScrollBar().setUnitIncrement(40);
    	l=new JLabel(image);
    	abcmainPanel.setLayout(cardlayout);
    	abcmainPanel.setBounds(0, 0, 900, 500);
    	buttonpanel.setBounds(0,504,900,200);
    	buttonpanel.setLayout(new FlowLayout()); 
    	abcmainPanel.add(l,"l");
    	
    	char s='A';
    	
    	for(i=0;i<26;i++)
    	{
    		String con=Character.toString(s);
    		x=con+"x.png";
    		s=(char) (s+1);
    		label[i]=new JLabel(new ImageIcon(getClass().getResource(x)));
    		panel[i]=new JPanel();
    		panel[i].add(label[i]);
    		abcmainPanel.add(panel[i],"panel["+i+"]");
    	}
    	s='A';
    	for(i=0;i<26;i++)
    	{
    		String con=Character.toString(s);
    		x=con+"_I.png";
    	    s=(char) (s+1);
    		icon[i]=new ImageIcon(getClass().getResource(x));
    		alphabetButton[i]=new JButton();
    		alphabetButton[i].setIcon(icon[i]);
    	    buttonpanel.add(alphabetButton[i]);
    	}
    	Thehandler handler=new Thehandler();
    	for(i=0;i<26;i++)
    	{
    		alphabetButton[i].addActionListener(handler);
    	}
    	
        add(abcmainPanel);
         
    	scrollPane.setViewportView(buttonpanel);
    	add(scrollPane);
    }
    private class Thehandler implements ActionListener
    {
	  
		public void actionPerformed(ActionEvent arg0) {
		char s='A';
			for(i=0;i<26;i++)
		{
			s= (char) (s+1);	
				if(alphabetButton[i]==arg0.getSource())
				{
					show("panel["+i+"]");
					if(k==1)
					{
						stop.stop();
						k=0;
					}
					
					s=(char) (s-1);
					String con=Character.toString(s);
					x=con+"_sound.wav";
					URL url = getClass().getResource(x);
					clip[i] =  Applet.newAudioClip(url);
					clip[i].play();
					stop=clip[i];
					k++;
				}
		}
		}
    }
    protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.setColor(java.awt.Color.black);
		for(i=0;i<5;i++)
		{
			arg0.drawLine(0, 500+i, 900, 500+i);
		}
		
		
	}
    public void show(String panelName)
    {
    	cardlayout.show(abcmainPanel,panelName);
    }
}