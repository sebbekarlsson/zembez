package nu.sebka.dark.main;

import nu.sebka.dark.graphics.Light;
import nu.sebka.dark.instances.magic.FireMagic;



public class Entity extends Instance {

	public float direction = 0;
	public Light light = null;

	public int health = 100;
	public double mana = 100;
	public double manaRegen = 0.1;

	public Entity(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}


	public void castSpell(MagicSpell spell){

		if(mana > 0){

			Game.getCurrentScene().instantiate(spell);

			if(spell instanceof FireMagic){
				mana -= 10;
			}

		}
		
		

	}
	
	public void defaultTick(){
		
		
		if(light != null){
			light.x = x;
			light.y = y;
		}
	}
	
	
	public void move(float direction, float speed){
		
		x += Math.cos(Math.toRadians(direction)) * speed;
		y += Math.sin(Math.toRadians(direction)) * speed;
	}




}
