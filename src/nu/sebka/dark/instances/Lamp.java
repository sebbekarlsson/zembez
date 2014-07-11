package nu.sebka.dark.instances;

import java.awt.Color;

import nu.sebka.dark.graphics.Light;
import nu.sebka.dark.main.tools.ImageLoader;

public class Lamp extends Light {

	public Lamp(int x, int y, int strength, Color color) {
		super(x, y, strength, color);
		this.sprite.images.add(ImageLoader.loadImage("images/objects/lamp.png"));
	}

}
