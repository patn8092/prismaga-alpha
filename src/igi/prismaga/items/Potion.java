package igi.prismaga.items;

import igi.prismaga.main.Game;
import igi.prismaga.menus.GamePanel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Potion extends Item{
	
	public boolean isCollected = false;
	public BufferedImage image;
	
	public int x;
	public int y;
	public int xo;
	public int yo;
	
	public Potion(int xo, int yo) {
		super();
		this.xo = xo;
		this.yo = yo;
		this.image = Game.imageLoader.load("/gfx/potion.png");
	}
	
	public void tick() {
		if(!isCollected) {
			this.x = this.xo - GamePanel.getPlayer().getXOffset();
			this.y = this.yo - GamePanel.getPlayer().getYOffset();
			System.out.println(this.x +"," + this.y +","+ GamePanel.getPlayer().getX() + "," +
			GamePanel.getPlayer().getY());
			if(GamePanel.getPlayer().getX() >= this.x
			&& GamePanel.getPlayer().getX() <= this.x + (this.image.getWidth() * Game.SCALE)
			&& GamePanel.getPlayer().getY() >= this.y
			&& GamePanel.getPlayer().getY() <= this.y + (this.image.getHeight() * Game.SCALE)) {
				this.isCollected = true;
				GamePanel.getHUD().getInventory().addItem(this);
			}
		}
	}
	 
	public void render(Graphics g, int x, int y) {
		if(!isCollected)
			g.drawImage(image, 
						this.x, 
						this.y, 
						image.getWidth() * Game.SCALE,
						image.getHeight() * Game.SCALE, 
						null);
	}
}
