import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Banglaex extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HomeFrame homeframe;
    int k=0,i,j=0;
    AudioClip stop;
    String x;
    
    ImageIcon image=new ImageIcon(getClass().getResource("kkh.jpg"));
    Image background=new ImageIcon(getClass().getResource("ExaminationEnglish.jpg")).getImage();
    JPanel banglamainPanel = new JPanel();
    CardLayout cardlayout=new CardLayout();
    
    JPanel panel[]=new JPanel[11];
    JLabel label[]=new JLabel[11];
    JPanel buttonpanel=new JPanel(){
    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.setColor(java.awt.Color.black);
		arg0.drawImage(background,0,0,750,200,null);
		arg0.drawImage(background,750,0,750,200,null);
	}
};
    
    
    JButton alphabetButton[]=new JButton[26];
    Icon icon[]=new ImageIcon[11];
    JPanel p=new JPanel();
    AudioClip clip[]=new AudioClip[11];
    JLabel l;
    
    public Banglaex(HomeFrame hf) throws ClassCastException
    {
    	this.homeframe=hf;
    	setLayout(null);
    	JScrollPane scrollPane = new JScrollPane();
    	scrollPane.setBounds(0, 500, 900, 700);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    	scrollPane.getVerticalScrollBar().setUnitIncrement(30);
    	scrollPane.getHorizontalScrollBar().setUnitIncrement(40);
    	l=new JLabel(image);
    	
    	
        banglamainPanel.setLayout(cardlayout);
    	banglamainPanel.setBounds(0, 0, 900, 500);
    	buttonpanel.setBounds(0,504,900,200);
    	buttonpanel.setLayout(new FlowLayout()); 
    	banglamainPanel.add(l,"l");
    	
    	
    	for(i=0;i<11;i++)
    	{
    		String con = Integer.toString(i+1);
    		x="S"+con+".png";
    		
    		label[i]=new JLabel(new ImageIcon(getClass().getResource(x)));
    		panel[i]=new JPanel();
    		panel[i].add(label[i]);
    		banglamainPanel.add(panel[i],"panel["+i+"]");
    	}
    	
    	for(i=0;i<11;i++)
    	{
    		String con = Integer.toString(i+1);
    		x="Sor"+con+".png";
    		icon[i]=new ImageIcon(getClass().getResource(x));
    		alphabetButton[i]=new JButton();
    		alphabetButton[i].setIcon(icon[i]);
    	    buttonpanel.add(alphabetButton[i]);
    	}
    	Thehandler handler=new Thehandler();
    	for(i=0;i<11;i++)
    	{
    		alphabetButton[i].addActionListener(handler);
    	}
    	
        add(banglamainPanel);
         
    	scrollPane.setViewportView(buttonpanel);
    	add(scrollPane);
    }
    private class Thehandler implements ActionListener
    {
		public void actionPerformed(ActionEvent arg0) {
		
		for(i=0;i<11;i++)
		{
				if(alphabetButton[i]==arg0.getSource())
				{
					if(k==1)
					{
						stop.stop();
						k=0;
					}
					String con = Integer.toString(i+1);
					show("panel["+i+"]");
					x="Sx"+con+".wav";
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
		arg0.setColor(java.awt.Color.BLUE);
		for(i=0;i<5;i++)
		{
			arg0.drawLine(0, 500+i, 900, 500+i);
		}
	}
    public void show(String panelName)
    {
    	cardlayout.show(banglamainPanel,panelName);
    }
}