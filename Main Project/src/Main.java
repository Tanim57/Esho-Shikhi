import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import com.sun.prism.paint.Color;

public class Main {

	static Thread t1;
	Thread t2;
	Thread t3;

	static int red;
	static int green;
	static int blue;

	Image icon = new ImageIcon(getClass().getResource("HomeBackground.jpg"))
			.getImage();

	static File file = new File("HomeBackground.jpg");

	static BufferedImage image = new BufferedImage(240, 240,
			BufferedImage.TYPE_INT_ARGB);

	public static void main(String[] args) throws IllegalAccessException,
			Exception, ClassCastException {

		// t1=new Thread(new ExaminationEnglish(new HomeFrame()),"One");
		// new HomeFrame();

		BufferedImage bi = ImageIO.read(new File(
				"F:\\tithy\\IMG-20150810-WA0002.jpg"));
		
		BufferedImage a2 = ImageIO.read(new File(
				"C:\\Users\\Tanim Vai\\Desktop\\check\\DSC_6471.jpg"));
		BufferedImage a3 = ImageIO.read(new File(
				"C:\\Users\\Tanim Vai\\Desktop\\check\\1.jpg"));
		BufferedImage a4 = ImageIO.read(new File(
				"C:\\Users\\Tanim Vai\\Desktop\\check\\1.jpg"));

		float p = 0;

		int count = 0,s=0;
		float d = 0;
		
		float sum=0;

		for (int i = 1; i <= 27; i=i+3) {
			
			BufferedImage a1 = ImageIO.read(new File(
					"C:\\Users\\Tanim Vai\\Desktop\\check\\"+i+".jpg"));
			p=0;
			d=0;
			count=0;
			System.out.println(i + " ");
			for (int x = 0; x < a1.getWidth() && x < a2.getWidth(); x++) {
				for (int y = 0; y < a1.getHeight() && y < a2.getHeight(); y++) {
					java.awt.Color c1 = new java.awt.Color(a1.getRGB(x, y));
					java.awt.Color c2 = new java.awt.Color(a2.getRGB(x, y));

					int r1 = (int) c1.getRed();
					int b1 = (int) c1.getBlue();
					int g1 = (int) c1.getGreen();

					int r2 = (int) c2.getRed();
					int b2 = (int) c2.getBlue();
					int g2 = (int) c2.getGreen();

					d = (float) Math.sqrt((r2 - r1) * (r2 - r1) + (g2 - g1)
							* (g2 - g1) + (b2 - b1) * (b2 - b1));

					d = d / (float) Math.sqrt(3 * 255 * 255);

					p = p + d;
					// if(count%100==0)
					// System.out.println(d);
					count++;

					// System.out.println("red=="+c.getRed()+" green=="+c.getGreen()+"    blue=="+c.getBlue()+"  countloop="+countloop++);
				}
			}
			sum = sum + (float) p / count;
			s++;
		}

		System.out.println(p + " " + count + " " + (float) sum/s*100);

		int rgb = bi.getRGB(200, 200);

		int red = (rgb >> 16) & 0x000000FF;
		int green = (rgb >> 8) & 0x000000FF;
		int blue = (rgb) & 0x000000FF;

		java.awt.Color c1 = new java.awt.Color(rgb);

		System.out.println(red + " " + c1.getRed() + " " + green + " "
				+ c1.getGreen());

		// int[] pixel;

		int countloop = 0;

		for (int x = 0; x < bi.getWidth(); x++) {
			for (int y = 0; y < bi.getHeight(); y++) {
				java.awt.Color c = new java.awt.Color(bi.getRGB(x, y));
				// System.out.println("red=="+c.getRed()+" green=="+c.getGreen()+"    blue=="+c.getBlue()+"  countloop="+countloop++);
			}
		}

		System.out.println(bi.getRGB(0, 10));

		// System.out.println(image.toString());

		// int c =(int) image.getRaster().getPixel(10, 10, 10);

		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {

		}
	}
}