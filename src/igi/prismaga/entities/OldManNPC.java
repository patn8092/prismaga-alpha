package igi.prismaga.entities;

import igi.prismaga.hud.Textbox;
import igi.prismaga.levels.LevelManager;
import igi.prismaga.main.Game;
import igi.prismaga.menus.GamePanel;

import java.awt.Graphics;
import java.util.Random;


public class OldManNPC extends Entity {

	private String message;
	public boolean showMessage = false;
	private long directionTimer = System.currentTimeMillis();
	private Textbox textbox;
	
	public OldManNPC(int x, int y) {
		this.x = x;
		this.y = y;
		this.xo = x;
		this.yo = y;
		this.xs = 0;
		this.ys = 0;
		this.frameCount = 0;
		this.action = 0;
		this.delay = 0;
		this.direction = 0;
		this.status = 0;
		this.width = 16;
		this.height = 16;
		this.message = getMessage();
		this.canSpeak = true;
		am = Game.getAnimationManager();
		
		textbox = new Textbox(0,(Game.HEIGHT * Game.SCALE) - 56,1);
		textbox.setCurrentTextbox(1);
		
		getMessage();
		
		
	}
	
	public void tick() {
		
		if(xo < 0)
			xo = 0;
		if(xo > LevelManager.getCurrentLevel().w * Game.TILESIZE - Game.TILESIZE)
			xo = LevelManager.getCurrentLevel().w * Game.TILESIZE - Game.TILESIZE;
		if(yo < 0)
			yo = 0;
		if(yo > LevelManager.getCurrentLevel().h * Game.TILESIZE - Game.TILESIZE)
			yo = LevelManager.getCurrentLevel().h * Game.TILESIZE - Game.TILESIZE;
		
		if(delay % 8 == 0) {
			if(frameCount >= 3) {
				frameCount = 0; 
			} else {
				frameCount++;
			}
			delay++;
			currentFrame = am.findEntityFrame(this,
					direction,
					action,
					frameCount,
					Game.oldManFrames
					);
		} else {
			if(delay > 100) { delay = 0; } else { delay++; }
		}
		
		action = IDLE;
		
		if(hasPlayerInSight()) {
			showMessage = true;
		} else {
			showMessage = false;
		}
		
		setDirection();
	}

	public void render(Graphics g) {
		
		if(message != null && showMessage) {
			textbox.render(g,message);
			GamePanel.getHUD().getInventory().UIIsVisible = false;
		} else {
			GamePanel.getHUD().getInventory().UIIsVisible = true;
		}
		
		if(canSpeak) {
			g.drawImage(speech, 
				this.xo - GamePanel.getPlayer().getXOffset() + 16 - (speech.getWidth()), 
				this.yo - (speech.getHeight() * Game.SCALE + 2) - GamePanel.getPlayer().getYOffset(),
				speech.getWidth() * Game.SCALE,
				speech.getHeight() * Game.SCALE,
				null
				);
		}
		
		g.drawImage(currentFrame, 
				this.xo - GamePanel.getPlayer().getXOffset(), 
				this.yo - GamePanel.getPlayer().getYOffset(), 
				Game.TILESIZE * Game.SCALE, 
				Game.TILESIZE * Game.SCALE, 
				null
		);
	}
	
	private String getMessage() {
		
		String[] messages = new String[]{
			"Hey Youngster!",
			"I can't make up my mind!",
			"I need a nap!",
			"Green shirt + blue pants = crazy",
			"Those yellow plants are not corn.",
			"I should probably get back home..."
			
		};
		
		Random r = new Random();
		
		return messages[r.nextInt(messages.length)];
	}
	
	public boolean hasPlayerInSight(){
		
		int pxo = GamePanel.getPlayer().getXOffset() + GamePanel.getPlayer().getX();
		int pyo = GamePanel.getPlayer().getYOffset() + GamePanel.getPlayer().getY();
		
		if(pxo - xo < 32 && xo - pxo < 32){
			if(pyo - yo < 48 && yo - pyo < 48){
				return true;
			}
		}
		
		return false;
	}
	
	public void setDirection() {
		
		Random r = new Random();
		int d = r.nextInt(RIGHT + 1);
		
		if(hasPlayerInSight()) {
			
			if(GamePanel.getPlayer().direction == UP) this.direction = DOWN;
			if(GamePanel.getPlayer().direction == DOWN) this.direction = UP;
			if(GamePanel.getPlayer().direction == LEFT) this.direction = RIGHT;
			if(GamePanel.getPlayer().direction == RIGHT) this.direction = LEFT;
		
		} else if(System.currentTimeMillis() - directionTimer >= 1000) {
			
			directionTimer = System.currentTimeMillis();
			this.direction = d;
		
		}
	}

	public void move(int xs, int ys) {}

	public void checkTile(int xs, int ys) {}

	public boolean collision(int xs, int ys) {return false;}
}
