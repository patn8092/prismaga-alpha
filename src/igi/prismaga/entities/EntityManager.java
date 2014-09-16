package igi.prismaga.entities;

import java.awt.Graphics;
import java.util.ArrayList;

public class EntityManager {
	
	public static ArrayList<Entity> entities = new ArrayList<Entity>();
	
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public static void removeEntity(Entity e) {
		entities.remove(e);
	}
	
	public void tick() {
		for(Entity e : entities) {
			e.tick();
		}
	}
	
	public void render(Graphics g) {
		for(Entity e : entities) {
			e.render(g);
		}
	}
	
}
