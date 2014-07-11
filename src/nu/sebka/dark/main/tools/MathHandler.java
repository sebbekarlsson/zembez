package nu.sebka.dark.main.tools;

import java.util.Random;

public class MathHandler {

	public static Random random = new Random();
	
	public static int chooseInt(int...args){
		return args[random.nextInt(args.length)];
	}
	
}
