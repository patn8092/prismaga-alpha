package igi.prismaga.entities;

import igi.prismaga.gfx.AnimationManager;
import igi.prismaga.gfx.ImageManager;
import igi.prismaga.levels.Level;
import igi.prismaga.levels.LevelManager;
import igi.prismaga.main.Game;
import igi.prismaga.menus.GamePanel;
import igi.prismaga.tiles.Tile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class Player extends Entity {
	
	private final String username;
	private final int width;
	private final int height;
	private long hurtTimer = System.currentTimeMillis();
	private Rectangle bounds;
	
	public Player(int x, int y, ImageManager im, AnimationManager am, String username) {
		this.x = x;
		this.y = y;
		this.am = am;
		this.username = username;
		xo = 0;
		yo = 0;
		xs = 0;
		ys = 0;
		this.health = 100;
		this.maxHealth = 100;
		this.direction = 0;
		this.width = 16;
		this.height = 16;
		this.canSpeak = false;
		this.bounds = new Rectangle(this.x, this.y, this.width * Game.SCALE, this.height * Game.SCALE);
	}
	
	public void tick() {		
		if(health == 0) {
			status = DEAD;
			GamePanel.getEntityManager().removeEntity(this);
		}
		
		if(delay % 8 == 0) {
			if(frameCount >= 3) {
				frameCount = 0; 
			} else {
				frameCount++;
			}
			delay++;
			currentFrame = am.findEntityFrame(this,direction,action,frameCount,Game.playerFrames);
		} else {
			if(delay > 100) { delay = 0; } else { delay++; }
		}
		
		if(status == ON_FIRE) {
			if(System.currentTimeMillis() - hurtTimer >= 250) {
				hurtTimer = System.currentTimeMillis();
				health--;
			}
		}
		
		xs = 0;
		ys = 0;
	
		if(km.keys[KeyEvent.VK_W]) {
			direction = UP;
			ys -= SPEED;
		} else if(km.keys[KeyEvent.VK_S]) {
			direction = DOWN;
			ys += SPEED;
		} if(km.keys[KeyEvent.VK_A]) {
			direction = LEFT;
			xs -= SPEED;
		} else if(km.keys[KeyEvent.VK_D]) {
			direction = RIGHT;
			xs += SPEED;
		}	
		move(xs, ys);
		
		System.out.println(GamePanel.getEntityManager().entities.size());
	}
	
	public void render(Graphics g) {
		if(username != null && Game.showUsername) {
			Game.fontRenderer.renderMessage(g, 
					username, 
					this.x - ((username.length() - 1) / 2 * 8) - (username.length() * Game.SCALE), 
					this.y - (8 * Game.SCALE)
			);
		}
		g.drawImage(currentFrame, 
			x, 
			y, 
			Game.TILESIZE * Game.SCALE, 
			Game.TILESIZE * Game.SCALE, 
			null
		);
		
		g.setColor(Color.CYAN);
		g.drawRect(this.x, this.y, this.width * Game.SCALE, this.height * Game.SCALE);
	}
	
	public void move(int xs, int ys) {
		if(!collision(xs, 0)) {xo += xs;}
		if(!collision(0, ys)) {yo += ys;}
		checkTile(xs, ys);
	}
	
	public void checkTile(int xs, int ys) {
		Level level = LevelManager.getCurrentLevel();
		Tile tile = level.getTile((xo + xs + x + (Game.TILESIZE)) / (Game.TILESIZE * Game.SCALE), (yo + ys + y + (Game.TILESIZE)) / (Game.TILESIZE * Game.SCALE));
		if(!km.keys[KeyEvent.VK_W] && 
				!km.keys[KeyEvent.VK_S] && 
				!km.keys[KeyEvent.VK_A] && 
				!km.keys[KeyEvent.VK_D] &&
				action != SWIMMING) {
			action = IDLE;
			return;
		} if(tile != null) {
			if(tile == Tile.water) {
				action = SWIMMING;
				if(status == ON_FIRE) status = NORMAL;
				SPEED = (int) Game.SCALE / 2;
				return;
			} else {
				action = WALKING;
				SPEED = (int) 1 * Game.SCALE;
			}
			if(tile == Tile.lava) {
				action = SWIMMING;
				status = ON_FIRE;
				SPEED = (int) Game.SCALE / 2; 
				return;
			} else {
				action = WALKING;
				SPEED = (int) 1 * Game.SCALE;
			}
			if(tile == Tile.ice) {
				SPEED = (int) 2 * Game.SCALE;
				action = SKATING;
				return;
			} else {
				action = WALKING;
				SPEED = (int) 1 * Game.SCALE;
			}
		}
	}
	
	public boolean collision(int xs, int ys) {	
		if(LevelManager.getCurrentLevel().getTile((xo + xs + x) / (Game.TILESIZE * Game.SCALE), 
				(yo + ys + y) / (Game.TILESIZE * Game.SCALE)).isSolid())		
			return true;
		if(LevelManager.getCurrentLevel().getTile((xo + xs + x + getWidth() * Game.SCALE - 1) / (Game.TILESIZE * Game.SCALE), 
				(yo + ys + y) / (Game.TILESIZE * Game.SCALE)).isSolid())			
			return true;
		if(LevelManager.getCurrentLevel().getTile((xo + xs + x) / (Game.TILESIZE * Game.SCALE), 
				(yo + ys + y + getHeight() * Game.SCALE - 1) / (Game.TILESIZE * Game.SCALE)).isSolid())			
			return true;
		if(LevelManager.getCurrentLevel().getTile((xo + xs + x + getWidth() * Game.SCALE - 1) / (Game.TILESIZE * Game.SCALE), 
				(yo + ys + y + getHeight() * Game.SCALE - 1) / (Game.TILESIZE * Game.SCALE)).isSolid())			
			return true;
		return false;
	}
	
	public int getXOffset() {return xo;}
	public int getYOffset() {return yo;}
	public void setXOffset(int xo) {this.xo = xo;}
	public void setYOffset(int yo) {this.yo = yo;}
	public String getUsername() {return username;}
	public int getX() {return x;}
	public int getY() {return y;}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
}
