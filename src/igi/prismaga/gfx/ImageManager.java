package igi.prismaga.gfx;

import igi.prismaga.main.Game;

import java.awt.image.BufferedImage;

public class ImageManager {
	
	public SpriteSheet tiles;
	
	public BufferedImage 
		grassTile,  //grass
		roses, //roses
		brownMushroom, //brown mushroom
		redMushroom, //red mushroom
		grape_hyacinth, //grape hyacinth
		aloe_vera, //aloe vera
		brickTile,
		waterTile,
		lavaTile,
		bridgeTopTile,
		bridgeBottomTile,
		iceTile,
		solidIceTile,
		sandTile,
		
		stoneRoadTile,
		stoneRoadTileLeft,
		stoneRoadTileRight,
		stoneRoadTileTop,
		stoneRoadTileBottom,
		stoneRoadTileTopLeft,
		stoneRoadTileTopRight,
		stoneRoadTileBottomLeft,
		stoneRoadTileBottomRight,
		stoneRoadTileTopLeftCorner,
		stoneRoadTileTopRightCorner,
		stoneRoadTileBottomLeftCorner,
		stoneRoadTileBottomRightCorner,
		
		stairTile, //mountains
		stairTile2,
		caveFloor,
		caveTileTopLeft,
		caveTileTopRight,
		caveTileBottomLeft,
		caveTileBottomRight,
		caveTileEntrance,
		caveTileLeft,
		caveTileRight,
		caveTileBottom,
		caveTileTop,
		
		mtnTileTopLeft,
		mtnTileBottomLeft,
		mtnTileTopRight,
		mtnTileBottomRight,
		mtnTileEntrance,
		mtnTileTop,
		mtnTileBottom,
		mtnTileLeft,
		mtnTileRight, 
		mtnTileCornerTopLeft,
		mtnTileCornerTopRight,
		mtnTileCornerBottomLeft,
		mtnTileCornerBottomRight,
		
		houseSidingLeft, //housing
		houseSidingRight,
		houseSidingMiddle,
		houseSidingLeftBottom,
		houseSidingRightBottom,
		houseSidingMiddleBottom,
		houseDoor,
		houseWindow,
		houseRoofTop,
		houseRoofTopLight,
		houseRoofBottom,
		houseRoofMiddle,
		sign,
		fenceVerticalTop,
		fenceVerticalMiddle,
		fenceVerticalBottom,
		fenceHorizontal,
		
		treeTop,
		treeBottom,
		treeMid
		
		;
	
	public ImageManager() {
		tiles = Game.tiles;
		
		//generic outside tiles
		grassTile = tiles.crop(1, 0, Game.TILESIZE, Game.TILESIZE);
		roses = tiles.crop(2, 1, Game.TILESIZE, Game.TILESIZE);
		brownMushroom = tiles.crop(4, 2, Game.TILESIZE, Game.TILESIZE);
		redMushroom = tiles.crop(5, 2, Game.TILESIZE, Game.TILESIZE);
		brickTile = tiles.crop(2, 0, Game.TILESIZE, Game.TILESIZE);
		waterTile = tiles.crop(3, 0, Game.TILESIZE, Game.TILESIZE);
		lavaTile = tiles.crop(4, 0, Game.TILESIZE, Game.TILESIZE);
		bridgeTopTile = tiles.crop(1, 2, Game.TILESIZE, Game.TILESIZE);
		bridgeBottomTile = tiles.crop(2,2, Game.TILESIZE, Game.TILESIZE);
		iceTile = tiles.crop(5, 1, Game.TILESIZE, Game.TILESIZE);
		solidIceTile = tiles.crop(1, 1, Game.TILESIZE, Game.TILESIZE);
		sandTile = tiles.crop(3, 2, Game.TILESIZE, Game.TILESIZE);
		grape_hyacinth = tiles.crop(6, 2, Game.TILESIZE, Game.TILESIZE);
		aloe_vera = tiles.crop(7, 2, Game.TILESIZE, Game.TILESIZE);
		
		stoneRoadTile = tiles.crop(7, 1, Game.TILESIZE, Game.TILESIZE);
		stoneRoadTileLeft = tiles.crop(8, 1, Game.TILESIZE, Game.TILESIZE);
		stoneRoadTileRight = tiles.crop(10, 1, Game.TILESIZE, Game.TILESIZE);
		stoneRoadTileTop = tiles.crop(9, 0, Game.TILESIZE, Game.TILESIZE);
		stoneRoadTileBottom = tiles.crop(9, 2, Game.TILESIZE, Game.TILESIZE);
		stoneRoadTileTopLeft = tiles.crop(8, 0, Game.TILESIZE, Game.TILESIZE);
		stoneRoadTileTopRight = tiles.crop(10, 0, Game.TILESIZE, Game.TILESIZE);
		stoneRoadTileBottomLeft = tiles.crop(8, 2, Game.TILESIZE, Game.TILESIZE);
		stoneRoadTileBottomRight = tiles.crop(10, 2, Game.TILESIZE, Game.TILESIZE);
		stoneRoadTileTopLeftCorner = tiles.crop(8, 3, Game.TILESIZE, Game.TILESIZE);
		stoneRoadTileTopRightCorner = tiles.crop(9, 3, Game.TILESIZE, Game.TILESIZE);
		stoneRoadTileBottomLeftCorner = tiles.crop(8, 4, Game.TILESIZE, Game.TILESIZE);
		stoneRoadTileBottomRightCorner = tiles.crop(9, 4, Game.TILESIZE, Game.TILESIZE);
	
		stairTile = tiles.crop(0, 3, Game.TILESIZE, Game.TILESIZE);
		stairTile2 = tiles.crop(1, 3, Game.TILESIZE, Game.TILESIZE);
		
		//cave
		caveFloor = tiles.crop(3, 4, Game.TILESIZE, Game.TILESIZE);
		caveTileTopLeft = tiles.crop(2, 3, Game.TILESIZE, Game.TILESIZE);
		caveTileTopRight = tiles.crop(4, 3, Game.TILESIZE, Game.TILESIZE);
		caveTileBottomLeft = tiles.crop(2, 5, Game.TILESIZE, Game.TILESIZE);
		caveTileBottomRight = tiles.crop(4, 5, Game.TILESIZE, Game.TILESIZE);
		caveTileEntrance = tiles.crop(0, 4, Game.TILESIZE, Game.TILESIZE);
		caveTileLeft = tiles.crop(2, 4, Game.TILESIZE, Game.TILESIZE);
		caveTileRight = tiles.crop(4, 4, Game.TILESIZE, Game.TILESIZE);
		caveTileBottom = tiles.crop(3, 5, Game.TILESIZE, Game.TILESIZE);
		caveTileTop = tiles.crop(3, 3, Game.TILESIZE, Game.TILESIZE);
		
		//mountain
		mtnTileTopLeft = tiles.crop(5, 3, Game.TILESIZE, Game.TILESIZE);
		mtnTileBottomLeft = tiles.crop(5, 5, Game.TILESIZE, Game.TILESIZE);
		mtnTileTopRight = tiles.crop(7, 3, Game.TILESIZE, Game.TILESIZE);
		mtnTileBottomRight = tiles.crop(7, 5, Game.TILESIZE, Game.TILESIZE);
		mtnTileEntrance = tiles.crop(1, 4, Game.TILESIZE, Game.TILESIZE);
		mtnTileTop = tiles.crop(6, 3, Game.TILESIZE, Game.TILESIZE);
		mtnTileBottom = tiles.crop(6, 5, Game.TILESIZE, Game.TILESIZE);
		mtnTileLeft = tiles.crop(5, 4, Game.TILESIZE, Game.TILESIZE);
		mtnTileRight = tiles.crop(7, 4, Game.TILESIZE, Game.TILESIZE);
		mtnTileCornerTopLeft = tiles.crop(11, 0,Game.TILESIZE, Game.TILESIZE);
		mtnTileCornerTopRight = tiles.crop(12, 0,Game.TILESIZE, Game.TILESIZE);
		mtnTileCornerBottomLeft = tiles.crop(11, 1,Game.TILESIZE, Game.TILESIZE);
		mtnTileCornerBottomRight = tiles.crop(12, 1,Game.TILESIZE, Game.TILESIZE);
		
		//house
		houseSidingLeft = tiles.crop(3, 6, Game.TILESIZE, Game.TILESIZE);
		houseSidingRight = tiles.crop(5, 6, Game.TILESIZE, Game.TILESIZE);
		houseSidingMiddle = tiles.crop(4, 6, Game.TILESIZE, Game.TILESIZE);
		houseSidingLeftBottom = tiles.crop(6, 6, Game.TILESIZE, Game.TILESIZE);
		houseSidingRightBottom = tiles.crop(7, 6, Game.TILESIZE, Game.TILESIZE);
		houseSidingMiddleBottom = tiles.crop(0, 7, Game.TILESIZE, Game.TILESIZE);
		houseDoor = tiles.crop(1, 7, Game.TILESIZE, Game.TILESIZE);
		houseWindow = tiles.crop(2, 7, Game.TILESIZE, Game.TILESIZE);
		houseRoofTop = tiles.crop(0, 6, Game.TILESIZE, Game.TILESIZE);
		houseRoofTopLight = tiles.crop(0, 5, Game.TILESIZE, Game.TILESIZE);
		houseRoofBottom = tiles.crop(2, 6, Game.TILESIZE, Game.TILESIZE);
		houseRoofMiddle = tiles.crop(1, 6, Game.TILESIZE, Game.TILESIZE);
		sign = tiles.crop(0, 1, Game.TILESIZE, Game.TILESIZE);
		fenceVerticalTop = tiles.crop(3, 7, Game.TILESIZE, Game.TILESIZE);
		fenceVerticalMiddle = tiles.crop(4, 7, Game.TILESIZE, Game.TILESIZE);
		fenceVerticalBottom = tiles.crop(5, 7, Game.TILESIZE, Game.TILESIZE);
		fenceHorizontal = tiles.crop(1, 5, Game.TILESIZE, Game.TILESIZE);
		
		treeTop = tiles.crop(6, 0, Game.TILESIZE, Game.TILESIZE);
		treeBottom = tiles.crop(6, 1, Game.TILESIZE, Game.TILESIZE);
		treeMid = tiles.crop(5, 0, Game.TILESIZE, Game.TILESIZE);
		
	}
}
