/*
 * Project Prismaga
 * Copyright (c) 2014 Igadabif Interactive LLC.
 * Date: 8/8/2014
 * Author(s): Patrick Nichols
 */

package igi.prismaga.hud;

import igi.prismaga.gfx.GameFont;
import igi.prismaga.main.Game;
import igi.prismaga.menus.GamePanel;

import java.awt.Graphics;

@SuppressWarnings("unused")
public class HUD {
	
	private int health,maxhealth,status,manaLevel,maxManaLevel;
	private Textbox statusbar;
	private Inventory inv;
	
	public HUD() {
		//initializing stuff
		health = GamePanel.getPlayer().health;
		maxhealth = GamePanel.getPlayer().maxHealth;
		status = GamePanel.getPlayer().status;		
		
		statusbar = new Textbox(0,0,4);
		
		inv = new Inventory(4,4);
	}
	
	public void tick() {
		//gets all these values from the player
		health = GamePanel.getPlayer().health;
		maxhealth = GamePanel.getPlayer().maxHealth;
		status = GamePanel.getPlayer().status;	
		manaLevel = GamePanel.getPlayer().mana;
		maxManaLevel = GamePanel.getPlayer().maxMana;
		inv.tick();
	}
	
	public void render(Graphics g) {
		Game.fontRenderer.setAlign(GameFont.LEFT);//sets all HUD font rendering to left alignment
		
		statusbar.render(g, "HP:"+health+"/"+maxhealth+" Mana:"+manaLevel+"/"+maxManaLevel);
		
		inv.render(g); //renders inventory slots
	}

	public Inventory getInventory() {
		return inv;
	}
}
