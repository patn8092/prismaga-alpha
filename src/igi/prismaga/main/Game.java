/*
 * Project Prismaga
 * Copyright (c) 2014 Catfish Games.
 * Date: 8/8/2014
 * Author(s): Patrick Nichols
 */

package igi.prismaga.main;

import igi.prismaga.gfx.AnimationManager;
import igi.prismaga.gfx.GameFont;
import igi.prismaga.gfx.ImageLoader;
import igi.prismaga.gfx.ImageManager;
import igi.prismaga.gfx.SpriteSheet;
import igi.prismaga.menus.GamePanel;
import igi.prismaga.menus.MenuManager;
import igi.prismaga.sfx.Music;
import igi.prismaga.sfx.SoundLoader;
import igi.prismaga.sfx.SoundManager;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("unused")

public class Game extends Canvas implements Runnable {
	
	public static final long serialVersionUID = 1L;
	public static int WIDTH = 320, HEIGHT = 240, SCALE = 2, TILESIZE = 16;

	public static int mouseX;
	public static int mouseY;
	
	public static boolean running = false;
	public static boolean fullscreen = false;
	public static boolean showUsername = false;
	
	public static Thread gameThread;
	public static JFrame frame;
	
	public static SpriteSheet tiles;
	public static SpriteSheet playerFrames;
	public static SpriteSheet oldManFrames;
	
	private static KeyManager km;
	private static ImageManager im;
	private static AnimationManager am;
	private static MouseHandler mh;
	public static SoundManager sm;
	
	public static ImageLoader imageLoader;
	public static SoundLoader soundLoader;
	public static GameFont fontRenderer;
	
	public static Music backgroundMusic;
		
	public void init() {

		mouseX = MouseInfo.getPointerInfo().getLocation().x;
		mouseY = MouseInfo.getPointerInfo().getLocation().y;
		
		imageLoader = new ImageLoader();
		soundLoader = new SoundLoader();
		fontRenderer = new GameFont();
		
		
		tiles = new SpriteSheet(imageLoader.load("/gfx/tile/tiles.png"));
		playerFrames = new SpriteSheet(imageLoader.load("/gfx/entity/playersheet.png"));
		oldManFrames = new SpriteSheet(imageLoader.load("/gfx/entity/oldman.png"));
		
		im = new ImageManager();
		am = new AnimationManager();
		
		sm = new SoundManager();
	
		km = new KeyManager();
		mh = new MouseHandler();
		
		this.addKeyListener(km);
		this.addMouseListener(mh);
		
		MenuManager.setCurrentMenu(new GamePanel());
		
		backgroundMusic = new Music("/sfx/prismagatheme.mid");
		/*
		if(!MenuManager.getCurrentMenu().equals(new GamePanel())) {
			backgroundMusic.loop();
			backgroundMusic.start();
		}
		*/
	}
	
	public synchronized void start() {
		if(running) return;
		running = true;
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public synchronized void stop() {
		if(!running) return;
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60D;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;

		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				render();
				delta--;
			}
		}
		stop();
	}
	
	public void tick() {
		mouseX = MouseInfo.getPointerInfo().getLocation().x - this.getLocationOnScreen().x;
		mouseY = MouseInfo.getPointerInfo().getLocation().y - this.getLocationOnScreen().y;
	
		if(MenuManager.getCurrentMenu() != null) {
			MenuManager.getCurrentMenu().tick();
		}
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		//RENDER HERE
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		
		if(MenuManager.getCurrentMenu() != null) {
			MenuManager.getCurrentMenu().render(g);
		}
		
		//END RENDER
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {

		Game game = new Game();
		
			game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
			game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
			game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
	
		
	    frame = new JFrame("Project Prismaga Alpha");

		
		if(System.getProperty("os.name").contains("Windows")) {
			frame.setSize(WIDTH * SCALE + 6, HEIGHT * SCALE + 26);
		} else {
			frame.setSize(WIDTH * SCALE, HEIGHT * SCALE);
		}
		
		frame.setUndecorated(false);
		frame.setLocationRelativeTo(null);
		
		ImageIcon img = new ImageIcon(Game.class.getResource("/icon.png")); //setting icon for game
		frame.setIconImage(img.getImage());
		
		frame.setUndecorated(false);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(game, BorderLayout.CENTER);
		frame.pack();
		
		frame.setVisible(true);
		
		System.out.println(frame.getWidth()+","+frame.getHeight());
		
		game.start();
	}
	
	public static ImageManager getImageManager() {
		return im;
	}
	
	public static AnimationManager getAnimationManager() {
		return am;
	}
	
	public static KeyManager getKeyManager() {
		return km;
	}
	
	public static MouseHandler getMouseHandler() {
		return mh;
	}
}