/*
 * Project Prismaga
 * Copyright (c) 2014 Igadabif Interactive LLC.
 * Date: 8/8/2014
 * Author(s): Patrick Nichols
 */

package igi.prismaga.levels;

public class LevelManager {
	
	private static Level currentLevel;
	
	public static void setCurrentLevel(Level lvl) {
		currentLevel = lvl;
	}
	
	public static Level getCurrentLevel()	{
		return currentLevel;
	}
}
