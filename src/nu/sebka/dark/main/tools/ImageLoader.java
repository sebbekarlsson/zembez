package nu.sebka.dark.main.tools;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static Image loadImage(String imagePath){
		return Toolkit.getDefaultToolkit().getImage(imagePath);
	}
	
	public static BufferedImage loadColoredImage(String imagePath, int red, int green, int blue) {
		BufferedImage loadImg;
		try {
			loadImg = ImageIO.read(new File(imagePath));
			System.out.println(loadImg.toString()+"");
		
	    BufferedImage img = new BufferedImage(loadImg.getWidth(), loadImg.getHeight(),
	        BufferedImage.TRANSLUCENT);
	    Graphics2D graphics = img.createGraphics(); 
	    Color newColor = new Color(red, green, blue, 0 /* alpha needs to be zero */);
	    graphics.setXORMode(newColor);
	    graphics.drawImage(loadImg, null, 0, 0);
	    graphics.dispose();
	    return img;
	    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
