package nu.sebka.dark.scenes;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nu.sebka.dark.graphics.Darkness;
import nu.sebka.dark.instances.Player;
import nu.sebka.dark.main.Game;
import nu.sebka.dark.main.Scene;
import nu.sebka.dark.main.tools.ImageLoader;
import nu.sebka.dark.main.tools.MapLoader;

public class GameScene extends Scene {

	List<Darkness> darkness = new ArrayList<Darkness>();
	public Player player = new Player(this.WIDHT/2,this.HEIGHT/2);
	Image heart = ImageLoader.loadImage("images/gui/heart.png");
	
	


	public GameScene(){


		try {
			MapLoader.loadMap(this,"images/maps/1/1.png");
		} catch (IOException e) {

			e.printStackTrace();
		}

		for(int i = 0; i < Game.RENDERSIZE.width/Game.darkSize; i+=1){
			for(int ii = 0; ii < Game.RENDERSIZE.height/Game.darkSize+1; ii++){

				darkness.add(new Darkness(i*Game.darkSize,ii*Game.darkSize));
			}
		}
		
		

		instantiate(player);




	}

	public void tick(){
		Game.camera.x = Player.getX()-Game.RENDERSIZE.width/2;
		Game.camera.y = Player.getY()-Game.RENDERSIZE.height/2;
	}


	public void drawGUI(Graphics g){
		drawDarkness(g);
		drawHealth(g);
		drawMana(g);

	}
	
	public void drawDarkness(Graphics g){
		for(int i = 0; i < darkness.size(); i++){
			Darkness d = darkness.get(i);
			d.resetDarkness();
			
		}
		for(int i = 0; i < darkness.size(); i++){
			Darkness d = darkness.get(i);
			if(d != null)
			d.draw(g);
		}
	}
	
	public void drawHealth(Graphics g){
		for(int i = 0; i < player.health/10; i++){
			g.drawImage(ImageLoader.loadImage("images/gui/heart.png"), 4+16*Game.GUISize*i, Game.RENDERSIZE.height-(16*Game.GUISize+4), 16*Game.GUISize, 16*Game.GUISize, null);
		}
	}
	
	public void drawMana(Graphics g){
		g.setColor(Color.BLUE);
		for(int i = 0; i < player.mana/10.1; i++){
			
			g.drawImage(ImageLoader.loadImage("images/gui/mana.png"), 4+16*Game.GUISize*i, Game.RENDERSIZE.height-(16*Game.GUISize*2+4), 16*Game.GUISize, 16*Game.GUISize, null);
		}
	}
	
	
	


}
