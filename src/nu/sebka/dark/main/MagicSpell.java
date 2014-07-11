package nu.sebka.dark.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import nu.sebka.dark.graphics.Light;
import nu.sebka.dark.main.tools.ImageLoader;
import nu.sebka.dark.main.tools.ParticleEmitter;



public class MagicSpell extends Entity {

	public int damage, range, speed;
	public ParticleEmitter emitter = new ParticleEmitter();
	public float direction = 0;
	protected Random random = new Random();
	public Color color = Color.BLUE;
	
	protected Sprite animation = new Sprite();
	
	
	public MagicSpell(int x, int y, int speed ,float direction) {
		super(x, y);
		this.direction = direction;
		this.speed = speed;
		light = new Light(x,y,32,Color.BLACK);
		animation.images.add(ImageLoader.loadImage("images/magic/spell/1.png"));
		animation.images.add(ImageLoader.loadImage("images/magic/spell/2.png"));
		animation.images.add(ImageLoader.loadImage("images/magic/spell/3.png"));
		animation.images.add(ImageLoader.loadImage("images/magic/spell/4.png"));
		sprite = animation;
		
		
	}
	
	public void onCreation(){
		
		Game.getCurrentScene().instantiate(light);
	}
	
	public void onDestroy(){
		Game.getCurrentScene().destroyInstance(light);
	}
	
	public void defaultTick(){
		
		if(sprite.imageIndex < sprite.images.size()-1){
			sprite.imageIndex += 1;
		}else{
			sprite.imageIndex = 0;
		}
		
		
		light.x = x;
		light.y = y;
		move(direction,speed);
		
	}
	
	public void draw(Graphics g){
		this.drawColoredSprite((Graphics2D) g,sprite.getCurrentSprite(),color);
	}
	
	
	
	
	

}
