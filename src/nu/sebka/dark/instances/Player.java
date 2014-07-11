package nu.sebka.dark.instances;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;








import nu.sebka.dark.graphics.Light;
import nu.sebka.dark.instances.magic.FireMagic;
import nu.sebka.dark.main.Entity;
import nu.sebka.dark.main.Game;
import nu.sebka.dark.main.Sprite;
import nu.sebka.dark.main.tools.ImageLoader;
import nu.sebka.dark.main.tools.ParticleEmitter;



public class Player extends Entity{

	int speed = 2;
	int spriteTimer = 10;
	Sprite downSprite = new Sprite();
	Sprite upSprite = new Sprite();
	Sprite leftSprite = new Sprite();
	Sprite rightSprite = new Sprite();
	ParticleEmitter emitter = new ParticleEmitter();
	
	private static int xx = 0;
	private static int yy = 0;
	
	public static Light light;
	
	
	
	

	public Player(int x, int y) {
		super(x, y);
		this.sprite = downSprite;
		
		downSprite.images.add(ImageLoader.loadImage("images/player/down/1.png"));
		downSprite.images.add(ImageLoader.loadImage("images/player/down/2.png"));
		downSprite.images.add(ImageLoader.loadImage("images/player/down/3.png"));
		
		upSprite.images.add(ImageLoader.loadImage("images/player/up/1.png"));
		upSprite.images.add(ImageLoader.loadImage("images/player/up/2.png"));
		upSprite.images.add(ImageLoader.loadImage("images/player/up/3.png"));
		
		leftSprite.images.add(ImageLoader.loadImage("images/player/left/1.png"));
		leftSprite.images.add(ImageLoader.loadImage("images/player/left/2.png"));
		leftSprite.images.add(ImageLoader.loadImage("images/player/left/3.png"));
		
		rightSprite.images.add(ImageLoader.loadImage("images/player/right/1.png"));
		rightSprite.images.add(ImageLoader.loadImage("images/player/right/2.png"));
		rightSprite.images.add(ImageLoader.loadImage("images/player/right/3.png"));
		
		

	}
	
	public void init(){
		light = new Light(x,y,100,Color.BLACK);
		Game.getCurrentScene().instantiate(light);
		
	}

	public void tick(){
		if(spriteTimer > 0){
			spriteTimer -= 1;
		}else{
			spriteTimer = 10;
		}

		
		
		light.x = x;
		light.y = y;
		
		xx = x;
		yy = y;

		
		if(mana < 100){
			mana += manaRegen;
		}
		
		if(Game.keyPress[KeyEvent.VK_DOWN]){

			direction = 90;
			this.sprite = downSprite;
			y += speed;
			animate();

			//x += Math.cos(Math.toRadians(r)) * speed;
			//y += Math.sin(Math.toRadians(r)) * speed;
		}

		if(Game.keyPress[KeyEvent.VK_LEFT]){
			direction = 180;
			
			this.sprite = leftSprite;

			
			x -= speed;
			animate();
		}

		if(Game.keyPress[KeyEvent.VK_RIGHT]){
			direction = 0;
			
			this.sprite = rightSprite;
			x += speed;
			animate();

		}
		
		if(Game.keyPress[KeyEvent.VK_UP]){
			direction = 270;
			this.sprite = upSprite;
			y -= speed;
			animate();
			

		}		
		
		if(Game.keyPress[KeyEvent.VK_ENTER]){
			
			Game.getCurrentScene().instantiate(new Lamp(x,y,64,Color.BLACK));
			Game.keyPress[KeyEvent.VK_ENTER] = false;
		}
		
		if(Game.keyPress[KeyEvent.VK_X]){
			
			castSpell(new FireMagic(x,y,10,direction));
			
			Game.keyPress[KeyEvent.VK_X] = false;
		}	



	}

	public void draw(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		drawSprite(g2d,sprite.getCurrentSprite());

		g.setColor(Color.WHITE);
		g.drawString(direction+"", x, y-16);
	}
	
	public void animate(){
		if(sprite.imageIndex < sprite.images.size()-1){

			if(spriteTimer > 9){
			sprite.imageIndex += 1;
			}
		}else{
			sprite.imageIndex = 0;
		}
	}
	
	public static int getX(){
		return xx;
	}
	
	public static int getY(){
		return yy;
	}




}
