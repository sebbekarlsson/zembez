package nu.sebka.dark.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;



import nu.sebka.dark.main.tools.ImageHandler;

public class Instance {

	public int x;
	public int y;

	public Sprite sprite = new Sprite();

	public Instance(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void onCreation(){}
	public void onDestroy(){}
	public void init(){}
	public void tick(){}
	public void defaultTick(){}
	public void draw(Graphics g){
		if(sprite.images.size() > 0){
			if(sprite.getCurrentSprite() != null){
				drawSprite(g,sprite.getCurrentSprite());
			}
		}
	}

	public void drawSprite(Graphics g,Image im){

		
		
		g.drawImage(im, x, y, null);

	}

	public void drawScaledSprite(Graphics g,Image im, int width, int height){

		g.drawImage(im, x, y,width, height, null);

	}

	public void drawRotatedSprite(Graphics2D g,Image im,float rotation){

		Graphics2D g2d = (Graphics2D) g;
		AffineTransform t = g2d.getTransform();

		g2d.rotate(rotation, x + im.getWidth(null) / 2, y + im.getHeight(null) / 2);


		drawSprite(g2d,sprite.getCurrentSprite());

		g2d.setTransform(t);


	}


	public void drawScaledRotatedSprite(Graphics2D g,Image im,int width, int height,float rotation){

		Graphics2D g2d = (Graphics2D) g;
		AffineTransform t = g2d.getTransform();

		g2d.rotate(rotation, x + im.getWidth(null) / 2, y + im.getHeight(null) / 2);


		drawScaledSprite(g2d,sprite.getCurrentSprite(),width,height);

		g2d.setTransform(t);


	}

	public void drawColoredSprite(Graphics2D g,Image im,Color color){
		BufferedImage image;
		image = ImageHandler.toBufferedImage(im,32,32);
		
		for(int i = 0; i < image.getWidth(); i++){
			for(int ii = 0; ii < image.getHeight(); ii++){
				if(image.getRGB(i, ii) < 0)
				image.setRGB(i, ii, color.getRGB());
				
			}
		}
		g.drawImage(image, x, y, null);

	}

	public boolean isOutsideView(){

		if(x < Game.camera.x || x > Game.camera.x+Game.RENDERSIZE.width || y < Game.camera.y || y > Game.camera.y+Game.RENDERSIZE.width){
			return true;
		}

		return false;
	}
	
	
	

}
