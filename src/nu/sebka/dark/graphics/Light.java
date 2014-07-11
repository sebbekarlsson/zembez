package nu.sebka.dark.graphics;

import java.awt.Color;

import nu.sebka.dark.main.Instance;

public class Light extends Instance {

	public int strength = 0;
	public Color color = Color.BLACK;
	
	public Light(int x, int y,int strength, Color color) {
		super(x, y);
		this.strength = strength;
		this.color = color;
	}

}
