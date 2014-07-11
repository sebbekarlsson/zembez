package nu.sebka.dark.instances.tiles;

import nu.sebka.dark.main.Tile;
import nu.sebka.dark.main.tools.ImageLoader;


public class CobbleTile extends Tile {

	public CobbleTile(int x, int y) {
		super(x, y);
		sprite.images.add(ImageLoader.loadImage("images/tiles/cobble.png"));
	}

}
