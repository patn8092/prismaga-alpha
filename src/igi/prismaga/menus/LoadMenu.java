/*
 * Project Prismaga
 * Copyright (c) 2014 Igadabif Interactive LLC.
 * Date: 8/8/2014
 * Author(s): Patrick Nichols
 */

package igi.prismaga.menus;

import igi.prismaga.gfx.GameFont;
import igi.prismaga.main.Game;
import igi.prismaga.main.KeyManager;
import igi.prismaga.sfx.Music;
import igi.prismaga.sfx.SoundManager;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

@SuppressWarnings("unused")

public class LoadMenu extends Menu{
	
	public KeyManager km;
	private BufferedImage logo;
	private int choice = 0;
	private long lastIteration = System.currentTimeMillis();
	
	public LoadMenu() {
		logo = Game.imageLoader.load("/logo.png");
		km = Game.getKeyManager();
	}
	
	public void tick() {
		if(choice == 0 && km.keys[KeyEvent.VK_ENTER]) {
			SoundManager.select.play();
		}
		
		if(choice == 1 && km.keys[KeyEvent.VK_ENTER]) {
			SoundManager.select.play();
		}
		
		if(choice == 3 && km.keys[KeyEvent.VK_ENTER]) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			MenuManager.setCurrentMenu(new MainMenu());
		}
		
		if(System.currentTimeMillis() - lastIteration >= 100) {
			lastIteration = System.currentTimeMillis();
			if(km.keys[KeyEvent.VK_W] && choice > 0) {
				choice--;
			}
			
			if(km.keys[KeyEvent.VK_S] && choice < 3) {
				choice++;
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE);
		
		g.drawImage(logo, Game.WIDTH - logo.getWidth(), 48, logo.getWidth() * Game.SCALE, logo.getHeight() * Game.SCALE, null);
		
		Game.fontRenderer.setAlign(GameFont.LEFT);
		Game.fontRenderer.renderMessage(g, ">", (Game.WIDTH / 2) + 32, Game.HEIGHT + choice * (GameFont.getFontHeight() * Game.SCALE));
		
		Game.fontRenderer.setAlign(GameFont.CENTER);
		
		Game.fontRenderer.renderMessage(g, "slot 1", (Game.WIDTH), Game.HEIGHT + (16 * 0));
		Game.fontRenderer.renderMessage(g, "slot 2", (Game.WIDTH), Game.HEIGHT + (16 * 1));
		Game.fontRenderer.renderMessage(g, "slot 3", (Game.WIDTH), Game.HEIGHT + (16 * 2));
		Game.fontRenderer.renderMessage(g, "back", (Game.WIDTH), Game.HEIGHT + (16 * 3));
	}
}
