package igi.prismaga.hud;

import igi.prismaga.items.Item;
import igi.prismaga.main.Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Inventory {
	
	public InventoryCell[][]	inventory;
	
	private BufferedImage cellImage = Game.imageLoader.load("/gfx/hud/inventory_cell.png");
	
	private int w, h;
	private int spacing = 4;
	private int mode; //1 = expand, -1 = collapse
	
	private boolean showFullInventory = false;
	
	public boolean UIIsVisible = true;
	
	public InventoryUIButton inventoryUIButton;
	
	public Inventory(int w, int h) {
		this.w = w;
		this.h = h;
		this.mode = 1;
		
		inventory = new InventoryCell[w][h];
		
		for(int y = 0; y < h; y++) {
			for(int x = 0; x < w; x++) {
				inventory[x][y] = new InventoryCell();
			}
		}
		
		inventoryUIButton = new InventoryUIButton(
				((spacing * Game.SCALE) + ((spacing * Game.SCALE) + (cellImage.getWidth() * Game.SCALE)) * w + 1) + spacing * Game.SCALE,
				(Game.HEIGHT * Game.SCALE) - ((spacing * Game.SCALE) + (cellImage.getHeight() * Game.SCALE) - spacing)
				);
		
	}
	
	public void render(Graphics g) {
		if(UIIsVisible) {
			if(mode == -1) {
				for(int y = 0; y < h; y++) { //displays entire inventory
					for(int x = 0; x < w; x++) { 
						inventory[x][y].render(g, 
								(spacing * Game.SCALE) + (x + (spacing * Game.SCALE) + (cellImage.getWidth() * Game.SCALE)) * x, 
								(Game.HEIGHT * Game.SCALE) - (y + (spacing * Game.SCALE) + (cellImage.getHeight() * Game.SCALE)) * (y + 1));
						
						g.drawImage(inventoryUIButton.currentImage, 
								inventoryUIButton.x, 
								inventoryUIButton.y, 
								inventoryUIButton.currentImage.getWidth() * Game.SCALE, 
								inventoryUIButton.currentImage.getHeight() * Game.SCALE, 
								null
								);
					}
				}
			} else if(mode == 1){
				for(int x = 0; x < w; x++) { //displays only hotbar
					inventory[x][0].render(g, 
							(spacing * Game.SCALE) + (x + (spacing * Game.SCALE) + (cellImage.getWidth() * Game.SCALE)) * x, 
							(Game.HEIGHT * Game.SCALE) - (0 + (spacing * Game.SCALE) + (cellImage.getHeight() * Game.SCALE)) * (0 + 1));
					
					
					g.drawImage(inventoryUIButton.currentImage, 
								inventoryUIButton.x, 
								inventoryUIButton.y, 
								inventoryUIButton.currentImage.getWidth() * Game.SCALE, 
								inventoryUIButton.currentImage.getHeight() * Game.SCALE, 
								null
								);
				}
			}
		}
	}
	
	public void isHidden(boolean b) {
		this.showFullInventory = !b;
	}
	
	public void tick() {
		
		if(Game.mouseX < inventoryUIButton.x + inventoryUIButton.width && Game.mouseX > inventoryUIButton.x &&
				Game.mouseY < inventoryUIButton.y + inventoryUIButton.height && Game.mouseY > inventoryUIButton.y) {
			inventoryUIButton.CursorIsHovering = true;
		} else { 
			inventoryUIButton.CursorIsHovering = false; 
			Game.getMouseHandler().LEFT_BUTTON_PRESSED = false; //prevents flickering
		}
		
		if(Game.getMouseHandler().LEFT_BUTTON_PRESSED && inventoryUIButton.CursorIsHovering) {
			
			if(mode == 1) {
				mode = -1; //autosets button mode to collapse
				showFullInventory = true; //shows full inventory
				inventoryUIButton.setImage(inventoryUIButton.image1); //sets button image
				Game.getMouseHandler().LEFT_BUTTON_PRESSED = false; //prevents flickering
				return;
			} else if(mode == -1) {
				mode = 1; //autosets button mode to expand
				showFullInventory = false; //collapses inventory to hotbar
				inventoryUIButton.setImage(inventoryUIButton.image0); //sets button image
				Game.getMouseHandler().LEFT_BUTTON_PRESSED = false; //prevents flickering
				return;
			}
		}
		if(showFullInventory) {
			for(int y = 0; y < h; y++) {
				for(int x = 0; x < w; x++) {
					inventory[x][y].tick();
				}
			}
		} else {
			for(int x = 0; x < w; x++) {
				inventory[x][0].tick();
			}
		}
	}
	
	public void addItem(Item i) {
		for(int y = 0; y < h; y++) {
			for(int x = 0; x < w; x++) {
				if(inventory[x][y].item != null) {
					continue;
				} else {
					inventory[x][y].item = i;
				}
			}
		}
	}
}
