package nu.sebka.dark.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import nu.sebka.dark.scenes.GameScene;

public class Game extends JFrame implements Runnable, KeyListener, MouseListener {
	private static final long serialVersionUID = 1L;

	private static int WIDTH = 640;
	private static int HEIGHT = WIDTH / 16 * 9;
	private static int SCALE = 3;

	public static Dimension FRAMESIZE = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
	public static Dimension RENDERSIZE = new Dimension(FRAMESIZE.width / 2, FRAMESIZE.height / 2);

	private static BufferedImage offscreen = new BufferedImage(RENDERSIZE.width, RENDERSIZE.height, BufferedImage.TYPE_INT_RGB);

	private static List<Scene> scenes = new ArrayList<Scene>();
	public static int sceneIndex = 0;

	private static boolean running = true;
	private Thread gameloop = new Thread(this,"Game Loop");
	private boolean init = false;

	public static int darkSize = 8;
	
	public static boolean[] keyPress = new boolean[256];


	public static Camera camera = new Camera();



	public Game(){

		scenes.add(new GameScene());

		this.setSize(FRAMESIZE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.addKeyListener(this);
		this.addMouseListener(this);
	}


	public static void main(String[] args){
		Game game = new Game();
		game.start();
	}

	
	public void init(){
		for(int i = 0; i < getCurrentScene().instances.size(); i++){
			Instance instance = getCurrentScene().instances.get(i);
			instance.init();
		}
	}


	public void start(){


		running = true;
		gameloop.start();

	}

	public void run() {
		while(running){
			tick();

			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void tick(){

	
		if(init == false){
			init();
			init = true;
		}
		

		camera.tick();
		getCurrentScene().tick();

		for(int i = 0; i < getCurrentScene().instances.size(); i++){
			Instance instance = getCurrentScene().instances.get(i);
			instance.tick();
			instance.defaultTick();
		}

	}

	public void paint(Graphics g){
		Graphics gr = offscreen.getGraphics();
		Graphics GUI = offscreen.getGraphics();
		gr.clearRect(0, 0, RENDERSIZE.width, RENDERSIZE.height);

		gr.setColor(Color.WHITE);
		gr.fillRect(0, 0, RENDERSIZE.width, RENDERSIZE.height);

		gr.translate(-camera.x,-camera.y);

		getCurrentScene().draw(gr);

		for(int i = 0; i < getCurrentScene().instances.size(); i++){
			Instance instance = getCurrentScene().instances.get(i);
			if(!instance.isOutsideView()){
				instance.draw(gr);
			}

		}
		gr.translate(camera.x,camera.y);
		getCurrentScene().drawGUI(GUI);


		g.drawImage(offscreen.getScaledInstance(FRAMESIZE.width, FRAMESIZE.height, 1), 0, 0, this);
	}



	public static Scene getCurrentScene(){
		return scenes.get(sceneIndex);
	}


	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		keyPress[e.getKeyCode()] = true;

	}

	public void keyReleased(KeyEvent e) {
		keyPress[e.getKeyCode()] = false;

	}


	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseMoved(MouseEvent e) {
		Mouse.x = e.getX();
		Mouse.y = e.getY();

	}


}
