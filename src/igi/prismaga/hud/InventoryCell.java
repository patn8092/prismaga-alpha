package igi.prismaga.hud;

import igi.prismaga.items.Item;
import igi.prismaga.main.Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class InventoryCell {
	
	private BufferedImage cellImage = Game.imageLoader.load("/gfx/hud/inventory_cell.png");
	private BufferedImage cellImageHover = Game.imageLoader.load("/gfx/hud/inventory_cell_hover.png");
	private BufferedImage currentImage;
	
	public Item item = null;
	public BufferedImage itemImage = null;
	public int amount;
	private boolean isHovering = false;
	private int x,y,width,height;
	
	public InventoryCell() {
		this.width = cellImage.getWidth() * Game.SCALE;
		this.height = cellImage.getHeight() * Game.SCALE;
		currentImage = cellImage;
	}
	
	public void tick() {
		if(Game.mouseX < this.x + this.width && Game.mouseX > this.x &&
		   Game.mouseY < this.y + this.height && Game.mouseY > this.y) {
			this.isHovering = true;
		} else {
			this.isHovering = false;
		}
		
		if(this.isHovering) {
			this.currentImage = cellImageHover;
			
			if(Game.getMouseHandler().LEFT_BUTTON_PRESSED) {
				this.subtract(1);
				Game.getMouseHandler().LEFT_BUTTON_PRESSED = false; //prevents mass reduction
			}
			
		} else {	
			this.currentImage = cellImage;
		}
		
		
		if(this.amount == 0) {
			this.item = null;
		}
		
		if(this.item == null) {
			this.amount = 0;
		}
		
	}
	
	public void render(Graphics g, int x, int y) {
		
		this.x = x;
		this.y = y;

		g.drawImage(currentImage,
					x,
					y,
					currentImage.getWidth() * Game.SCALE,
					currentImage.getHeight() * Game.SCALE,
					null
					);
		
		if(this.item != null) {
			g.drawImage(
					itemImage,
					this.x + 8,
					this.y + 8,
					itemImage.getWidth() * Game.SCALE,
					itemImage.getHeight() * Game.SCALE,
					null
					);
		}
	}
	
	public void add(int i) {
		this.amount += i;
	}
	
	public void subtract(int i) {
		this.amount -= i;
	}
	
	public BufferedImage getImage() {
		return this.currentImage;
	}
}
