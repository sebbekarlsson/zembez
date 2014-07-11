package nu.sebka.dark.main.tools;

import java.awt.Image;

import nu.sebka.dark.main.Game;
import nu.sebka.dark.main.Particle;


public class ParticleEmitter {



	public void emitParticles(int x, int y,Image image, int lifetime, float speed, float direction){


		Particle particle = new Particle(x,y,image);
		particle.speed = speed;
		particle.lifetime = lifetime;
		particle.direction = direction;
		Game.getCurrentScene().instantiate(particle);

	}
}
