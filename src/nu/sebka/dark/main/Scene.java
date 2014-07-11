package nu.sebka.dark.main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import nu.sebka.dark.graphics.Darkness;
import nu.sebka.dark.graphics.Light;

public class Scene {

	public List<Instance> instances = new ArrayList<Instance>();
	
	public int WIDHT = Game.RENDERSIZE.width;
	public int HEIGHT = Game.RENDERSIZE.height;
	
	
	public void tick(){
		
	}
	
	public void draw(Graphics g){
		
	}
	
	public void drawGUI(Graphics g){
		
	}
	
	public void instantiate(Instance instance){
		if(instance instanceof Light){
			Darkness.lights.add((Light) instance);
		}
		
		instances.add(instance);
		instance.onCreation();
	}
	
	public void destroyInstance(Instance instance){
		if(instance instanceof Light){
			Darkness.lights.remove((Light) instance);
		}
		instance.onDestroy();
		instances.remove(instance);
	}
	
	public void destroyInstance(int index){
		instances.get(index).onDestroy();
		instances.remove(index);
	}
	
	public void replaceInstance(Instance instance0,Instance instance){
		for(int i = 0; i < instances.size(); i++){
			if(instances.get(i).equals(instance0)){
				instances.set(i, instance);
			}
		}
	}
	
	public void replaceInstance(int index,Instance instance){
		instances.set(index, instance);
	}
	
	
	
	
	
}
