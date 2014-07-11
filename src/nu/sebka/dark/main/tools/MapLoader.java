package nu.sebka.dark.main.tools;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import nu.sebka.dark.instances.tiles.CobbleTile;
import nu.sebka.dark.instances.tiles.GrassTile;
import nu.sebka.dark.instances.tiles.StoneTile;
import nu.sebka.dark.main.Scene;

public class MapLoader {

	public static void loadMap(Scene scene,String map) throws IOException{
		
		BufferedImage image = ImageIO.read(new File(map));
		
		for (int y = 0; y < image.getHeight(); y++) {
		    for (int x = 0; x < image.getWidth(); x++) {
		          int  clr   = image.getRGB(x, y); 
		          int  red   = (clr & 0x00ff0000) >> 16;
		          int  green = (clr & 0x0000ff00) >> 8;
		          int  blue  =  clr & 0x000000ff;
		          
		          if(red == 45 && green == 45 && blue == 45){
		        	  scene.instantiate(new CobbleTile(x*16,y*16));
		          }
		          else if(red == 90 && green == 90 && blue == 90){
		        	  scene.instantiate(new StoneTile(x*16,y*16));
		          }
		          else if(red == 0 && green == 90 && blue == 0){
		        	  scene.instantiate(new GrassTile(x*16,y*16));
		          }
		    }
		}
	}
}
