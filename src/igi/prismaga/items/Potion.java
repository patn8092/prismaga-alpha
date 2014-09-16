package igi.prismaga.items;

import igi.prismaga.main.Game;
import igi.prismaga.menus.GamePanel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Potion extends Item{
	
	public boolean isCollected = false;
	public BufferedImage image = Game.imageLoader.load("/gfx/potion.png");
	
	public int xo;
	public int yo;
	
	public Potion(int xo, int yo) {
		super();
		this.xo = xo;
		this.yo = yo;
	}
	
	public void tick() {
		
	}
	 
	public void render(Graphics g, int x, int y) {
		g.drawImage(image, 
				xo - GamePanel.getPlayer().getXOffset(), 
				yo - GamePanel.getPlayer().getYOffset(), 
				image.getWidth() * Game.SCALE,
				image.getHeight() * Game.SCALE, 
				null);
	}
}
