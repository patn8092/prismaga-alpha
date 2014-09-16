package igi.prismaga.entities;

import igi.prismaga.gfx.AnimationManager;
import igi.prismaga.main.Game;
import igi.prismaga.main.KeyManager;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Entity {
	
	public KeyManager km = Game.getKeyManager();
	
	protected int x, y, xo, yo, xs, ys, direction, width, height;
	protected int UP = 1, DOWN = 0, LEFT = 2, RIGHT = 3;
	protected AnimationManager am;
	
	protected int frameCount = 0;
	protected int delay = 0;
	
	protected boolean reachedLeftBorder = false,
					reachedRightBorder = false,
					reachedTopBorder = false,
					reachedBottomBorder = false;
	
	protected boolean canSpeak;
	
	protected BufferedImage currentFrame;
	protected BufferedImage speech = Game.imageLoader.load("/gfx/hud/canspeak.png");
	
	public int SPEED = (int) 1 * Game.SCALE;
	public int health = 100;
	public int maxHealth = 100;
	public int mana = 100;
	public int maxMana = 100;
	
	public int status;
	public final int DEAD = -1,
					NORMAL = 0,
					ON_FIRE = 1;
	
	public int action;
	public final int IDLE = 0,
			WALKING = 1,
			SWIMMING = 2,
			SKATING = 3;
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void move(int xs, int ys);
	
	public abstract void checkTile(int xs, int ys);
	
	public abstract boolean collision(int xs, int ys);
	
}
