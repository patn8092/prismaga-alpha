package igi.prismaga.hud;

import igi.prismaga.items.Item;
import igi.prismaga.main.Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

@SuppressWarnings("unused")
public class InventoryCell {
	
	private BufferedImage cellImage = Game.imageLoader.load("/gfx/hud/inventory_cell.png");
	private BufferedImage cellImageHover = Game.imageLoader.load("/gfx/hud/inventory_cell_hover.png");
	private BufferedImage currentImage;
	
	public Item item;
	private int amount;
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
		
		if(this.isHovering)
			this.currentImage = cellImageHover;
		else
			this.currentImage = cellImage;
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
		
		if(this.item != null && this.item.image != null) {
			g.drawImage(
					this.item.image,
					this.x + 4,
					this.y + 4,
					this.item.image.getWidth() * Game.SCALE,
					this.item.image.getHeight() * Game.SCALE,
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
