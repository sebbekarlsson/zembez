package nu.sebka.dark.main;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Sprite {

	public List<Image> images = new ArrayList<Image>();
	public int imageIndex = 0;
	
	public Image getCurrentSprite(){
		return images.get(imageIndex);
	}
	
	public Image getSprite(int index){
		return images.get(index);
	}
}
