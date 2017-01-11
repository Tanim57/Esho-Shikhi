import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JPanel;



public class PrimaryBangla extends JPanel {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton sorBorno;
	JButton benjonBorno;
	JButton banglaex;
	JButton banglaex2;
	JButton SorBachai;
	JButton BenBachai;
	HomeFrame homeFrame;
	Image backgroundImage = (new ImageIcon(getClass().getResource(
			"PrimaryBackground.jpg"))).getImage();  
	public PrimaryBangla(HomeFrame hf) throws ClassCastException
	{   
		   this.homeFrame=hf;
		   setLayout(null);
		   // Create Button for Primary Bangla
		   Font banglafont=new Font("SolaimanLipi", Font.PLAIN,15);

		   sorBorno = new JButton();
		   Icon Sicon = new ImageIcon(getClass().getResource("Sicon.jpg"));
		   sorBorno.setFont(banglafont);
		   sorBorno.setIcon(Sicon);
		   sorBorno.setForeground(Color.BLACK);
		   sorBorno.setBounds(280,150,120,38);
		   add(sorBorno);
		   Icon Dicon = new ImageIcon(getClass().getResource("DekhiSikhi.jpg"));
		   
		   banglaex= new JButton();
		   banglaex.setFont(banglafont);
		   
		   banglaex.setBounds(280,205,120,38);
		   banglaex.setIcon(Dicon);
		   add(banglaex);
		   
		   Icon BornoBachai=new ImageIcon(getClass().getResource("BornoBachai.jpg"));
		   SorBachai=new JButton();
		   SorBachai.setIcon(BornoBachai);
		   SorBachai.setBounds(280, 260, 120, 38);
		   add(SorBachai);
		   
		   
		  
		   
		   Icon Bicon = new ImageIcon(getClass().getResource("Benjon.jpg"));
		   benjonBorno= new JButton();
		   benjonBorno.setBounds(465,150,120,38);
		   benjonBorno.setIcon(Bicon);
		   add(benjonBorno);
		  
		   banglaex2= new JButton();
		   banglaex2.setFont(banglafont);
		   banglaex2.setBounds(465,205,120,38);
		   banglaex2.setIcon(Dicon);
		   add(banglaex2);
		   
		  
		   
		   BenBachai=new JButton();
		   BenBachai.setIcon(BornoBachai);
		   BenBachai.setBounds(465,260,120, 38);
		   add(BenBachai);
		   
		   Thehandler handler=new Thehandler();
		   sorBorno.addActionListener(handler);
		   benjonBorno.addActionListener(handler);
		   banglaex.addActionListener(handler);
		   banglaex2.addActionListener(handler);
		   SorBachai.addActionListener(handler);
		   BenBachai.addActionListener(handler);
	}
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.drawImage(backgroundImage, 0, 0, this);
		arg0.drawLine(280, 150, 280, 400);
		arg0.drawLine(281, 150, 281, 400);
		
		arg0.drawLine(399, 150, 399, 400);
		arg0.drawLine(398, 150, 398, 400);

		
		arg0.drawLine(465, 150, 465, 400);
		arg0.drawLine(466, 150, 466, 400);
		
		arg0.drawLine(584, 150, 584, 345);
		arg0.drawLine(583, 150, 583, 345);
	}
	private class Thehandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()==sorBorno)
			{
				homeFrame.show(HomeFrame.SORBORNO);
			}
			else if(event.getSource()==benjonBorno)
			{
			    //homeFrame.show(HomeFrame.EXAMINATION_BANGLA2);
				homeFrame.show(HomeFrame.BENJONBORNO);
			}
			else if(event.getSource()==banglaex)
			{
				Banglaex banglaExObj=new Banglaex(homeFrame);
				homeFrame.mainPanel.add(banglaExObj,HomeFrame.BANGLA_EXAMPLE);
				homeFrame.show(HomeFrame.BANGLA_EXAMPLE);
			}
			else if(event.getSource()==banglaex2)
			{
				BanglaEx2 banglaExObj2=new BanglaEx2(homeFrame);
				homeFrame.mainPanel.add(banglaExObj2,HomeFrame.BANGLA_EXAMPLE2);
				homeFrame.show(HomeFrame.BANGLA_EXAMPLE2);
			}
			else if(event.getSource()==SorBachai)
			{
				ExaminationBangla examination=new ExaminationBangla(homeFrame);
				homeFrame.mainPanel.add(examination,HomeFrame.EXAMINATION_BANGLA);
				homeFrame.show(HomeFrame.EXAMINATION_BANGLA);
			}
			else if(event.getSource()==BenBachai)
			{
				ExaminationBangla2 examination2=new ExaminationBangla2(homeFrame);
				homeFrame.mainPanel.add(examination2,HomeFrame.EXAMINATION_BANGLA2);
				homeFrame.show(HomeFrame.EXAMINATION_BANGLA2);
			}
		}
		
	}
}