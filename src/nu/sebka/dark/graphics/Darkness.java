package nu.sebka.dark.graphics;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;


import nu.sebka.dark.main.Game;



public class Darkness {

	int x, y;
	double distance = 0;
	Light light = null;
	double alpha = 1;
	public static List<Light> lights = new ArrayList<Light>();
	Color color = Color.black;





	public Darkness(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g){
		
		

		Graphics2D g2d = (Graphics2D) g;



		for(int i = 0; i < lights.size(); i++){
			Light  light = lights.get(i);
			if(light != null){
				if(!light.isOutsideView()){

					


					distance = Math.sqrt((light.x+8-x-Game.camera.x)*(light.x+8-x-Game.camera.x) + (light.y+8-y-Game.camera.y)*(light.y+8-y-Game.camera.y));

					int strength = light.strength;

					double percentage = 0;

					if(distance < strength){
						percentage = distance/strength;
						percentage = Math.abs(percentage-1);
						color = light.color;
					}
					alpha -= percentage;

					alpha = Math.max(0, Math.min(1, alpha));

				}
			}
		}


		g2d.fillRect(x, y, Game.darkSize, Game.darkSize);
		g2d.setColor(color);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,(float)alpha));








	}






	public void resetDarkness(){

		alpha = 1;
		color = Color.black;


	}

}
