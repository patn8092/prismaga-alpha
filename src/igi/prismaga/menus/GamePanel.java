/*
 * Project Prismaga
 * Copyright (c) 2014 Igadabif Interactive LLC.
 * Date: 8/8/2014
 * Author(s): Patrick Nichols
 */

package igi.prismaga.menus;

import igi.prismaga.entities.EntityManager;
import igi.prismaga.entities.OldManNPC;
import igi.prismaga.entities.Player;
import igi.prismaga.hud.HUD;
import igi.prismaga.items.Potion;
import igi.prismaga.levels.Level;
import igi.prismaga.levels.LevelManager;
import igi.prismaga.main.Game;

import java.awt.Graphics;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class GamePanel extends Menu	{
	
	private static EntityManager entityManager;

	public ArrayList<Object> tempPlayerData;
	private static Player player;
	private static HUD hud;
	private Properties playerData;
	
	
	//Constructor

	public GamePanel() {
		tempPlayerData = new ArrayList<Object>();
		entityManager = new EntityManager();
		
		loadPlayerData();
		
		entityManager.addEntity(new OldManNPC(64,64));
		
		for(int x = 0; x < 10; x++)
			entityManager.addEntity(new Potion(x * 32, new Random().nextInt(64)));
		
		LevelManager.setCurrentLevel(new Level(Game.imageLoader.load("/maps/level.png")));
		
		hud = new HUD();
	}
	
	public void tick() {
		hud.tick();
		if(LevelManager.getCurrentLevel() != null) {
			LevelManager.getCurrentLevel().tick();
		}
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		//bottom
		if(LevelManager.getCurrentLevel() != null) {
			LevelManager.getCurrentLevel().render(g);
		}
		
		entityManager.render(g);

		hud.render(g);
		//top
	}
	
	public static Player getPlayer() {
		return player;
	}
	
	public void loadPlayerData() {
		/*
		playerData = new Properties();
		try {
			InputStream is = Game.class.getResourceAsStream("/player.properties");
			playerData.load(is);
			System.out.println("[INFO]:Successfully loaded player data from file");
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		player = new Player(
				Game.WIDTH, 
				Game.HEIGHT, 
				Game.getImageManager(),
				Game.getAnimationManager(),
				"patrick"
				);
		/*
		player.setXOffset(new Integer(playerData.getProperty("xo")));
		player.setYOffset(new Integer(playerData.getProperty("yo")));
		player.maxHealth = new Integer(playerData.getProperty("maxhealth"));
		player.health = new Integer(playerData.getProperty("health"));
		*/
		
		entityManager.addEntity(player);
		
	}
	
	public void save() {
		playerData.setProperty("xo", new Integer(player.getXOffset()).toString());
		playerData.setProperty("yo", new Integer(player.getYOffset()).toString());
		playerData.setProperty("health", new Integer(player.health).toString());
		playerData.setProperty("maxHealth", new Integer(player.maxHealth).toString());
		try {
			System.out.println("Saved");
			playerData.store(new FileOutputStream(new File(Game.class.getResource("/player.properties").toURI())), null);
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public static HUD getHUD() {
		return hud;
	}
}
