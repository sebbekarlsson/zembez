package nu.sebka.dark.instances.magic;




import java.awt.Color;

import nu.sebka.dark.main.MagicSpell;
import nu.sebka.dark.main.tools.ImageLoader;
import nu.sebka.dark.main.tools.MathHandler;

public class FireMagic extends MagicSpell{





	public FireMagic(int x, int y, int speed, float direction) {
		super(x, y, speed, direction);
		color = Color.red;

	}




	public void tick(){

		if(random.nextInt(3) == 0){
			for(int i = 0; i < random.nextInt(32); i++){
				emitter.emitParticles(x, y, ImageLoader.loadImage("images/particles/fire.png"), 100, 4, random.nextInt(360));
			}
		}

		
		
		light.strength = MathHandler.chooseInt(60,50,40);
	}

}
