
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRootPane;



public class HomeFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String HOME_PANEL = "homePanel";
	public static String PRIMARY_BANGLA= "primaryBangla";
	public static String PRIMARY_ENGLISH="primaryEnglish";
	public static String SORBORNO="sorborno";
	public static String BENJONBORNO="benjonborno";
	public static String CAPITAL_ENGLISH="capitalenglish";
	public static String EXAMINATION_ENGLISH="examinationEnglish";
	public static String EXAMINATION_BANGLA="examinationBangla";
	public static String EXAMINATION_BANGLA2="examinationBangla2";
	public static String EXAMINATION_ENGLISH2="examinationEnglish2";
	public static String SMALL_ENGLISH="smallenglish";
	public static String ABC_EXAMPLE="abcExlample";
	public static String BANGLA_EXAMPLE="banglaExObj";
	public static String BANGLA_EXAMPLE2="banglaExObj2";
	
	
	
	HomePanel homePanel;
	PrimaryBangla primaryBangla;
	PrimaryEnglish primaryEnglish;
	Sorborno sorborno;
	Benjonborno benjonborno;
	CapitalEnglish capitalenglish;
	ExaminationEnglish examinationEnglish;
	ExaminationBangla examinationBangla;
	ExaminationBangla2 examinationBangla2;
	ExaminationEnglish2 examinationEnglish2;
	smallEnglish smallenglish;
	Banglaex banglaEx;
	BanglaEx2 banglaEx2;
	ABCexmaple abcEx;
	ImageIcon aboutbackground=new ImageIcon(getClass().getResource("aboutBackground.jpg"));
	JPanel about=new JPanel(){
		
		private static final long serialVersionUID = 1L;

		protected void paintComponent(Graphics arg0) {
			arg0.drawImage(aboutbackground.getImage(),0,0,900,700,this);
		};
	};
	
	JMenuBar menuBar = new JMenuBar();
	JPanel mainPanel = new JPanel();
	CardLayout cardLayout = new CardLayout();
	JMenu homeMenu;
	JMenu menu;
	JMenu primaryMenu;
	JMenu aboutMenu;
	JMenu banglaPrimay ;
	JMenu englishPrimary;
	JMenu sorBornoItem;
	JMenu benjonBornoItem;
	JMenu capitalLetter;
	JMenu smallLetter;
	JMenuItem capital_letter=new JMenuItem("অক্ষর");
	JMenuItem small_Letter=new JMenuItem("অক্ষর");
	JMenuItem sorAkkhor=new JMenuItem("অক্ষর");
	JMenuItem benAkkhor=new JMenuItem("অক্ষর");
	JMenuItem sorDekhi=new JMenuItem("দেখি ও শিখি");
	JMenuItem Bendekhi=new JMenuItem("দেখি ও শিখি");
	JMenuItem englishDekhi=new JMenuItem("দেখি ও শিখি");
	
	JMenuItem sorBachai;
	JMenuItem benBachai;
	JMenuItem capitalBachai;
	JMenuItem smallBachai;
	JLabel aboutlabel=new JLabel();
	
	
	Font banglafont=new Font("SolaimanLipi", Font.BOLD,15);
	public HomeFrame() throws Exception  , IllegalAccessException , ClassCastException
	{
		setTitle("HOME");
		setSize(900, 700);
		setUndecorated(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setLocationRelativeTo(null);
		
		
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		mainPanel.setLayout(cardLayout);
		
		homePanel = new HomePanel(this);
		primaryBangla=new PrimaryBangla(this);
		primaryEnglish=new PrimaryEnglish(this);
		sorborno=new Sorborno(this);
		benjonborno=new Benjonborno(this);
		capitalenglish=new CapitalEnglish(this);
		examinationEnglish=new ExaminationEnglish(this);
		examinationEnglish2=new ExaminationEnglish2(this);
		smallenglish=new smallEnglish(this);
		examinationBangla=new ExaminationBangla(this);
		examinationBangla2=new ExaminationBangla2(this);
		banglaEx=new Banglaex(this);
	    banglaEx2=new BanglaEx2(this);
	    abcEx=new ABCexmaple(this);
		
		mainPanel.add(homePanel, HomeFrame.HOME_PANEL);
		mainPanel.add(primaryBangla,HomeFrame.PRIMARY_BANGLA);
		mainPanel.add(primaryEnglish,HomeFrame.PRIMARY_ENGLISH);
		mainPanel.add(sorborno, HomeFrame.SORBORNO);
		mainPanel.add(benjonborno , HomeFrame.BENJONBORNO);
		mainPanel.add(capitalenglish, HomeFrame.CAPITAL_ENGLISH);
		mainPanel.add(smallenglish,HomeFrame.SMALL_ENGLISH);
		mainPanel.add(examinationEnglish,HomeFrame.EXAMINATION_ENGLISH);
		mainPanel.add(examinationBangla,HomeFrame.EXAMINATION_BANGLA);
		mainPanel.add(examinationBangla2,HomeFrame.EXAMINATION_BANGLA2);
		mainPanel.add(examinationEnglish2,HomeFrame.EXAMINATION_ENGLISH2);
		mainPanel.add(banglaEx,HomeFrame.BANGLA_EXAMPLE);
		mainPanel.add(banglaEx2,HomeFrame.BANGLA_EXAMPLE2);
		mainPanel.add(abcEx,HomeFrame.ABC_EXAMPLE);
		mainPanel.add(about,"about");
		
		
		add(mainPanel);
		
		about.setLayout(null);
		aboutlabel.setText("<html>This Project is supervised by Saifuddin Mahmud Sir.<br>The Project is done by Mahmudur Rahman and Armanuzzaman Tomal<html>");
		
		aboutlabel.setFont(banglafont);
		aboutlabel.setBounds(100,50,700,220);
		about.add(aboutlabel);
		
		// Create Menu For Menu Bar
		homeMenu = new JMenu("প্রথম পাতা");
		homeMenu.setFont(banglafont);
		menu = new JMenu("বিষয় সমূহ");
		menu.setFont(banglafont);
		aboutMenu = new JMenu("সম্পর্কে");
        aboutMenu.setFont(banglafont);
        
		Icon homeIcon = new ImageIcon(HomeFrame.class.getResource("home.png"));
		Icon aboutIcon = new ImageIcon(getClass().getResource("about.jpg"));
		Icon menuIcon = new ImageIcon(getClass().getResource("menuIcon.png"));

		homeMenu.setIcon(homeIcon);
		menu.setIcon(menuIcon);
		aboutMenu.setIcon(aboutIcon);

		// Create Menu Item For Menu
		
		Icon micon = new ImageIcon(getClass().getResource("Primary.png"));
		

		banglaPrimay = new JMenu("বাংলা");
		banglaPrimay.setFont(banglafont);
		banglaPrimay.setIcon(micon);
		englishPrimary = new JMenu("ইংরেজি");
		englishPrimary.setFont(banglafont);
		englishPrimary.setIcon(micon);
		menu.add(banglaPrimay);
		menu.addSeparator();
		menu.add(englishPrimary);

		sorBornoItem = new JMenu("স্বরবর্ণ");
		sorBornoItem.setFont(banglafont);
		sorBornoItem.setIcon(micon);
		
		sorBachai=new JMenuItem("বর্ণ বাছাই");
		sorBachai.setFont(banglafont);
		sorBachai.setIcon(micon);
		
		
		benjonBornoItem = new JMenu("ব্যঞ্জনবর্ণ");
		benjonBornoItem.setFont(banglafont);
		benjonBornoItem.setIcon(micon);
		benBachai=new JMenuItem("বর্ণ বাছাই");
		
		benBachai.setFont(banglafont);
		benBachai.setIcon(micon);
		sorAkkhor.setFont(banglafont);
		sorAkkhor.setIcon(micon);
		benAkkhor.setFont(banglafont);
		benAkkhor.setIcon(micon);
		sorDekhi.setFont(banglafont);
		sorDekhi.setIcon(micon);
		Bendekhi.setFont(banglafont);
		Bendekhi.setIcon(micon);
		
		banglaPrimay.add(sorBornoItem);
		banglaPrimay.addSeparator();
		banglaPrimay.add(benjonBornoItem);
		
		
		
		sorBornoItem.add(sorAkkhor);
		sorBornoItem.addSeparator();
		sorBornoItem.add(sorDekhi);
		sorBornoItem.addSeparator();
		sorBornoItem.add(sorBachai);
		
		benjonBornoItem.add(benAkkhor);
		benjonBornoItem.addSeparator();
		benjonBornoItem.add(Bendekhi);
		benjonBornoItem.addSeparator();
		benjonBornoItem.add(benBachai);
		
		
		

		capitalLetter = new JMenu("বড় হাতের অক্ষর");
		capitalLetter.setFont(banglafont);
		capitalLetter.setIcon(micon);
		smallLetter = new JMenu("ছোট হাতের অক্ষর");
		smallLetter.setFont(banglafont);
		smallLetter.setIcon(micon);
		capitalBachai=new JMenuItem("বর্ণ বাছাই");
		capitalBachai.setFont(banglafont);
		capitalBachai.setIcon(micon);
		smallBachai=new JMenuItem("বর্ণ বাছাই");
		smallBachai.setFont(banglafont);
		smallBachai.setIcon(micon);
		
		capital_letter.setFont(banglafont);
		capital_letter.setIcon(micon);
		small_Letter.setFont(banglafont);
		small_Letter.setIcon(micon);
		
		englishDekhi.setFont(banglafont);
		englishDekhi.setIcon(micon);
		
		
		englishPrimary.add(capitalLetter);
		englishPrimary.addSeparator();
		englishPrimary.add(smallLetter);
		englishPrimary.addSeparator();
		englishPrimary.add(englishDekhi);
		
		capitalLetter.add(capital_letter);
		capitalLetter.addSeparator();
		capitalLetter.add(capitalBachai);
		smallLetter.add(small_Letter);
		smallLetter.addSeparator();
		smallLetter.add(smallBachai);
		
		// add in menu bar
		menuBar.add(homeMenu);
		menuBar.add(menu);
		menuBar.add(aboutMenu);
		setJMenuBar(menuBar);
		
		
		homeMenu.addMouseListener(mouseClick);
		banglaPrimay.addMouseListener(mouseClick);
		englishPrimary.addMouseListener(mouseClick);
		aboutMenu.addMouseListener(mouseClick);

		
		Thehandler handler=new Thehandler();
		sorBachai.addActionListener(handler);
		benBachai.addActionListener(handler);
		capitalLetter.addActionListener(handler);
		smallLetter.addActionListener(handler);
		capitalBachai.addActionListener(handler);
		smallBachai.addActionListener(handler);
		sorAkkhor.addActionListener(handler);
		sorDekhi.addActionListener(handler);
		benAkkhor.addActionListener(handler);
		Bendekhi.addActionListener(handler);
		capital_letter.addActionListener(handler);
		small_Letter.addActionListener(handler);
		englishDekhi.addActionListener(handler);
		
		setVisible(true);
		setResizable(false);
	}
	private class Thehandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource()==sorBachai)
			{
				setTitle("BANGLA");
				show(EXAMINATION_BANGLA);
			}
			else if(event.getSource()==sorAkkhor)
			{
				setTitle("BANGLA");
				show(SORBORNO);
			}
			else if(sorDekhi==event.getSource())
			{
				setTitle("BANGLA");
				show(BANGLA_EXAMPLE);
			}
			
			else if(event.getSource()==benBachai)
			{
				setTitle("BANGLA");
				show(EXAMINATION_BANGLA2);
			}
			else if(event.getSource()==benAkkhor)
			{
				setTitle("BANGLA");
				show(BENJONBORNO);
				
			}
			else if(event.getSource()==Bendekhi)
			{
				setTitle("BANGLA");
				show(BANGLA_EXAMPLE2);
			}
			else if(capital_letter==event.getSource())
			{
				setTitle("ENGLISH");
				show("capitalenglish");
			}
			else if(event.getSource()==small_Letter)
			{
				setTitle("ENGLISH");
				show("smallenglish");
			}
			else if(event.getSource()==capitalBachai)
			{
				setTitle("ENGLISH");
				show(EXAMINATION_ENGLISH);
			}
			else if(event.getSource()==smallBachai)
			{
				setTitle("ENGLISH");
				show(EXAMINATION_ENGLISH2);
			}
			else if(event.getSource()==englishDekhi)
			{
				setTitle("ENGLISH");
				show(ABC_EXAMPLE);
			}
		}	
	}
	MouseAdapter mouseClick=new MouseAdapter() {
		     public void mouseClicked(MouseEvent arg0) {
		    	 
		    if(homeMenu.isSelected())
		    { 
		    	setTitle("HOME");
		    	show(HomeFrame.HOME_PANEL);
		    }
		    
		    else if(banglaPrimay.isSelected())
		    {
		    	setTitle("BANGLA");
		    	show(HomeFrame.PRIMARY_BANGLA);
		   	}
		    else if(englishPrimary.isSelected())
		    {
		    	setTitle("ENGLISH");
		    	show(HomeFrame.PRIMARY_ENGLISH);
		    }
		    else if(aboutMenu.isSelected())
		    {
		    	setTitle("");
		    	show("about");
		    }
		   }
	};
	public void show(String panelName){
		cardLayout.show(mainPanel, panelName);
	}
}