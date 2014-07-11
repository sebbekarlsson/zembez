package nu.sebka.dark.main;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;



public class Particle extends Entity {

	public int lifetime = 0;
	public float speed = 0;
	double speedChange = 0.5;
	float r = 0;
	Random random = new Random();
	public int scale = 1;
	
	public Particle(int x, int y,Image image) {
		super(x, y);
		this.sprite.images.add(image);
		
		r = random.nextInt(360);
		scale += random.nextInt(16);
	}
	
	
	
	
	public void tick(){
		move(direction,speed);
		if(lifetime > 0){
			lifetime -= 1;
		}else{
			Game.getCurrentScene().destroyInstance(this);
		}
		
		if(speed > 0){
			speed -= speedChange;
		}
	}
	
	public void draw(Graphics g){
		this.drawScaledRotatedSprite((Graphics2D) g, sprite.getCurrentSprite(),scale,scale,(float) Math.toRadians(r));
	}

}
