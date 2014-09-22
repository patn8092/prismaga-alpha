package igi.prismaga.items;

import igi.prismaga.main.Game;
import igi.prismaga.menus.GamePanel;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Potion extends Item{
	
	public boolean isCollected = false;
	public BufferedImage image;
	
	public int x;
	public int y;
	public int xo;
	public int yo;
	private Rectangle bounds;
	
	public Potion(int xo, int yo) {
		super();
		this.xo = xo;
		this.yo = yo;
		this.image = Game.imageLoader.load("/gfx/potion.png");
		this.bounds = new Rectangle();
	}
	
	public void tick() {
		
		this.bounds.setBounds(this.x, this.y, this.image.getWidth() * Game.SCALE, this.image.getHeight() * Game.SCALE);
		
		if(!isCollected) {
			this.x = this.xo - GamePanel.getPlayer().getXOffset();
			this.y = this.yo - GamePanel.getPlayer().getYOffset();
//			
//			if(GamePanel.getPlayer().getX() + GamePanel.getPlayer().getWidth() >= this.x 
//					&& GamePanel.getPlayer().getX() + GamePanel.getPlayer().getWidth() <= this.x + (this.image.getWidth() * Game.SCALE)
//					&& GamePanel.getPlayer().getY() + GamePanel.getPlayer().getHeight() >= this.y 
//					&& GamePanel.getPlayer().getY() + GamePanel.getPlayer().getHeight() <= this.y + (this.image.getHeight() * Game.SCALE)) {
			if(this.bounds.intersects(GamePanel.getPlayer().getBounds())) {
				this.isCollected = true;
				GamePanel.getHUD().getInventory().addItem(this,this.image);
			}
		}
	}
	 
//	public void render(Graphics g, int x, int y) {
//		if(!isCollected)
//			g.drawImage(image, 
//						this.x, 
//						this.y, 
//						image.getWidth() * Game.SCALE,
//						image.getHeight() * Game.SCALE, 
//						null);
//	}

	@Override
	public void render(Graphics g) {
		if(!isCollected) {
			g.drawImage(image, 
						this.x, 
						this.y, 
						image.getWidth() * Game.SCALE,
						image.getHeight() * Game.SCALE, 
						null);
		
			g.drawRect(this.x, this.y, this.image.getWidth() * Game.SCALE, this.image.getHeight() * Game.SCALE);
		}
	}

	@Override
	public void render(Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
