/*
 * Project Prismaga
 * Copyright (c) 2014 Igadabif Interactive LLC.
 * Date: 8/8/2014
 * Author(s): Patrick Nichols
 */

package igi.prismaga.levels;

import igi.prismaga.main.Game;
import igi.prismaga.menus.GamePanel;

import igi.prismaga.tiles.Tile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Level {
	
	public int[][] tiles;
	public int w, h;
	
	public Level(BufferedImage levelImage) {
		loadLevel(levelImage);
		w = levelImage.getWidth();
		h = levelImage.getHeight();
	}

	public void loadLevel(BufferedImage levelImage) {
		tiles = new int[levelImage.getWidth()][levelImage.getHeight()];
		for(int y = 0; y < levelImage.getHeight(); y++) {
			for(int x = 0; x < levelImage.getWidth(); x++) {
				Color c = new Color(levelImage.getRGB(x,y));
				String h = String.format("%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());	
				switch(h) {
				case "000000": //VOIDTILE
					tiles[x][y]	= 0;
					break;
				case "00ff00": //GRASS
					tiles[x][y] = 1;
					break;
				case "ff0000": //BRICK
					tiles[x][y] = 2;
					break;
				case "0094ff": //WATER
					tiles[x][y] = 3;
					break;
				case "ff7e00": //LAVA
					tiles[x][y] = 4;
					break;
				case "b77c45": //BRIDGE TOP
					tiles[x][y] = 5;
					break;
				case "875833": //BRIDGE BOTTOM
					tiles[x][y] = 6;
					break;
				case "00ffff": //ICE
					tiles[x][y] = 7;
					break;
				case "ffde93": //SAND
					tiles[x][y] = 8;
					break;
				case "a3ffff": //SOLID ICE
					tiles[x][y] = 9;
					break;
				case "a0a0a0": //STONE ROAD
					tiles[x][y] = 10;
					break;
				case "00d000": //FLOWER
					tiles[x][y] = 11;
					break;
				case "02ab02": //MUSHROOM1
					tiles[x][y] = 12;
					break;
				case "007f00": //MUSHROOM2
					tiles[x][y] = 13;
					break;
				case "d0d0d0": //STAIR LEFT
					tiles[x][y] = 14;
					break;
				case "d4d4d4": //STAIR RIGHT
					tiles[x][y] = 15;
					break;
				case "c87326": //MTN TOP LEFT
					tiles[x][y] = 16;
					break;
				case "a26e3f"://MTN TOP RIGHT
					tiles[x][y] = 17;
					break;
				case "9d7249"://MTN BOTTOM LEFT
					tiles[x][y] = 18;
					break;
				case "644e39"://MTN BOTTOM RIGHT
					tiles[x][y] = 19;
					break;
				case "a75912"://MTN TOP
					tiles[x][y] = 20;
					break;
				case "83664c"://MTN BOTTOM
					tiles[x][y] = 21;
					break;
				case "936031"://MTN LEFT
					tiles[x][y]	= 22;
					break;
				case "73553a"://MTN RIGHT
					tiles[x][y] = 23;
					break;
				case "d28b11"://HOUSE SIDING LEFT
					tiles[x][y] = 24;
					break;
				case "ae750e"://HOUSE SIDING RIGHT
					tiles[x][y] = 25;
					break;
				case "b57510"://HOUSE SIDING LEFT BOTTOM
					tiles[x][y]	= 26;
					break;
				case "895b0c"://HOUSE SIDING RIGHT BOTTOM
					tiles[x][y] = 27;
					break;
				case "722d00"://HOUSE SIDING BOTTOM
					tiles[x][y] = 28;
					break;
				case "823400"://HOUSE SIDING
					tiles[x][y] = 29;
					break;
				case "a84000"://DOOR
					tiles[x][y] = 30;
					break;
				case "008989"://WINDOW
					tiles[x][y] = 31;
					break;
				case "d80000"://ROOF BOTTOM
					tiles[x][y] = 32;
					break;
				case "e50000"://ROOF MID
					tiles[x][y] = 33;
					break;
				case "ef0000"://ROOF TOP
					tiles[x][y] = 34;
					break;
				case "ff5e5e"://ROOF TOP GRASS
					tiles[x][y] = 35;
					break;
				case "7494ff"://GRAPE HYACINTH
					tiles[x][y] = 36;
					break;
				case "ffe875"://ALOE VERA
					tiles[x][y] = 37;
					break;
				case "b5b5b5"://STONE ROAD LEFT
					tiles[x][y] = 38;
					break;
				case "c6c6c6"://STONE ROAD RIGHT
					tiles[x][y] = 39;
					break;
				case "d8d8d8"://STONE ROAD TOP
					tiles[x][y] = 40;
					break;
				case "919191"://STONE ROAD BOTTOM
					tiles[x][y]	= 41;
					break;
				case "a2b2a3"://STONE ROAD TOP LEFT
					tiles[x][y] = 42;
					break;
				case "c6d8d8"://STONE ROAD TOP RIGHT
					tiles[x][y] = 43;
					break;
				case "a8a8a8"://STONE ROAD BOTTOM LEFT
					tiles[x][y] = 44;
					break;
				case "7f7f7f"://STONE ROAD BOTTOM RIGHT
					tiles[x][y] = 45;
					break;
				case "dbdbdb"://STONE ROAD TOP LEFT CORNER
					tiles[x][y] = 46;
					break;
				case "d8d8c3"://STONE ROAD TOP RIGHT CORNER
					tiles[x][y] = 47;
					break;
				case "c4b0b0"://STONE ROAD BOTTOM LEFT CORNER
					tiles[x][y] = 48;
					break;
				case "c4c4c4"://STONE ROAD BOTTOM RIGHT CORNER
					tiles[x][y] = 49;
					break;
				case "ad703a"://MTN CORNER TOP LEFT
					tiles[x][y] = 50;
					break;
				case "c67227"://MTN CORNER TOP RIGHT
					tiles[x][y] = 51;
					break;
				case "ef892f"://MTN CORNER BOTTOM LEFT
					tiles[x][y] = 52;
					break;
				case "874d1b"://MTN CORNER BOTTOM RIGHT
					tiles[x][y] = 53;
					break;
				case "4b8e4b"://TREE TOP
					tiles[x][y] = 54;
					break;
				case "55a055"://TREE MID
					tiles[x][y] = 55;
					break;
				case "64bc64"://TREE BOTTOM
					tiles[x][y] = 56;
					break;
				case "a56b0e"://FENCE TOP
					tiles[x][y] = 57;
					break;
				case "a38251"://FENCE MIDDLE
					tiles[x][y] = 58;
					break;
				case "bc955e"://FENCE BOTTOM
					tiles[x][y] = 59;
					break;
				case "d39743"://FENCE HORIZONTAL
					tiles[x][y] = 60;
					break;
				default:
					tiles[x][y] = 1;
					break;
				}
			}
		}
	}
	 
	public void tick() {
		int xo = GamePanel.getPlayer().getXOffset();
		int yo = GamePanel.getPlayer().getYOffset();

		int x0 = Math.max(xo / (Game.TILESIZE * Game.SCALE), 0);
		int y0 = Math.max(yo / (Game.TILESIZE * Game.SCALE), 0);
		int x1 = Math.min((xo + Game.WIDTH * Game.SCALE) / (Game.TILESIZE * Game.SCALE) + 1, w);
		int y1 = Math.min((yo + Game.HEIGHT * Game.SCALE) / (Game.TILESIZE * Game.SCALE) + 1, h);
		
		for(int y = y0; y < y1; y++) {
			for(int x = x0; x < x1; x++) {
				getTile(x,y).tick();
			}
		}	
	}
	
	public void render(Graphics g) {
		int xo = GamePanel.getPlayer().getXOffset();
		int yo = GamePanel.getPlayer().getYOffset();

		int x0 = Math.max(xo / (Game.TILESIZE * Game.SCALE), 0);
		int y0 = Math.max(yo / (Game.TILESIZE * Game.SCALE), 0);
		int x1 = Math.min((xo + Game.WIDTH * Game.SCALE) / (Game.TILESIZE * Game.SCALE) + 1, w);
		int y1 = Math.min((yo + Game.HEIGHT * Game.SCALE) / (Game.TILESIZE * Game.SCALE) + 1, h);
		
		for(int y = y0; y < y1; y++) {
			for(int x = x0; x < x1; x++) {
				getTile(x,y).render(g, x * Game.TILESIZE * Game.SCALE - xo, y * Game.TILESIZE * Game.SCALE - yo);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if( x < 0 || y < 0 || x >= w || y >= h) 
			return null;
		
		switch(tiles[x][y]) {
		case 0: return null;
		case 1: return Tile.grass;
		case 2: return Tile.brick;
		case 3: return Tile.water;
		case 4: return Tile.lava;
		case 5: return Tile.bridgeTop;
		case 6: return Tile.bridgeBottom;
		case 7: return Tile.ice;
		case 8: return Tile.sand;
		case 9: return Tile.solidIce;
		case 10: return Tile.stoneRoad;
		case 11: return Tile.flower;
		case 12: return Tile.mushroom_brown;
		case 13: return Tile.mushroom_red;
		case 14: return Tile.stair;
		case 15: return Tile.stair2;
		case 16: return Tile.mtnTopLeft;
		case 17: return Tile.mtnTopRight;
		case 18: return Tile.mtnBottomLeft;
		case 19: return Tile.mtnBottomRight;
		case 20: return Tile.mtnTop;
		case 21: return Tile.mtnBottom;
		case 22: return Tile.mtnLeft;
		case 23: return Tile.mtnRight;
		case 24: return Tile.houseSidingLeft;
		case 25: return Tile.houseSidingRight;
		case 26: return Tile.houseSidingLeftBottom;
		case 27: return Tile.houseSidingRightBottom;
		case 28: return Tile.houseSidingMiddleBottom;
		case 29: return Tile.houseSidingMiddle;
		case 30: return Tile.houseDoor;
		case 31: return Tile.houseWindow;
		case 32: return Tile.houseRoofBottom;
		case 33: return Tile.houseRoofMiddle;
		case 34: return Tile.houseRoofTop;
		case 35: return Tile.houseRoofTopLight;
		case 36: return Tile.grape_hyacinth;
		case 37: return Tile.aloe_vera;
		case 38: return Tile.stoneRoadLeft;
		case 39: return Tile.stoneRoadRight;
		case 40: return Tile.stoneRoadTop;
		case 41: return Tile.stoneRoadBottom;
		case 42: return Tile.stoneRoadTopLeft;
		case 43: return Tile.stoneRoadTopRight;
		case 44: return Tile.stoneRoadBottomLeft;
		case 45: return Tile.stoneRoadBottomRight;
		case 46: return Tile.stoneRoadCornerTopLeft;
		case 47: return Tile.stoneRoadCornerTopRight;
		case 48: return Tile.stoneRoadCornerBottomLeft;
		case 49: return Tile.stoneRoadCornerBottomRight;
		case 50: return Tile.mtnCornerTopLeft;
		case 51: return Tile.mtnCornerTopRight;
		case 52: return Tile.mtnCornerBottomLeft;
		case 53: return Tile.mtnCornerBottomRight;
		case 54: return Tile.treeTop;
		case 55: return Tile.treeMid;
		case 56: return Tile.treeBottom;
		case 57: return Tile.fenceVertTop;
		case 58: return Tile.fenceVertMid;
		case 59: return Tile.fenceVertBottom;
		case 60: return Tile.fenceHoriz;
		default: return Tile.grass;
		}
	}
}
