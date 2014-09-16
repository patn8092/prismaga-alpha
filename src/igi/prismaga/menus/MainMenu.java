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
import igi.prismaga.sfx.SoundManager;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class MainMenu extends Menu {
	
	public KeyManager km;
	private int choice = 0;
	private long lastIteration = System.currentTimeMillis();
	private BufferedImage logo;

	public MainMenu() {
		logo = Game.imageLoader.load("/logo.png");
		
		km = Game.getKeyManager();	
	}
	
	public void tick() {
		
		if(choice == 0 && km.keys[KeyEvent.VK_ENTER]) {
			Game.backgroundMusic.stop();
			SoundManager.select.play();
			MenuManager.setCurrentMenu(new GamePanel());
		}
		
		if(choice == 1 && km.keys[KeyEvent.VK_ENTER]) {
			SoundManager.select.play();
			MenuManager.setCurrentMenu(new LoadMenu());
		}
		
		if(choice == 3 && km.keys[KeyEvent.VK_ENTER]) {
			Game.backgroundMusic.stop();
			System.exit(10);
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
		
		Game.fontRenderer.renderMessage(g, "Start New Game", (Game.WIDTH), Game.HEIGHT + (16 * 0));
		Game.fontRenderer.renderMessage(g, "Load Game", (Game.WIDTH), Game.HEIGHT + (16 * 1));
		Game.fontRenderer.renderMessage(g, "Options", (Game.WIDTH), Game.HEIGHT + (16 * 2));
		Game.fontRenderer.renderMessage(g, "exit", (Game.WIDTH), Game.HEIGHT + (16 * 3));
	}

}
