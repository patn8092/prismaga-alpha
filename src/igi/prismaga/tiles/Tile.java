package igi.prismaga.tiles;

import igi.prismaga.gfx.ImageManager;
import igi.prismaga.gfx.SpriteSheet;
import igi.prismaga.main.Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	protected static ImageManager im = Game.getImageManager();
	protected BufferedImage img;
	public boolean isSolid = false;
	protected byte id;
	
	public static Tile grass = new Tile(im.grassTile, false),
					   brick = new Tile(im.brickTile, true),
					   
					   water = new AnimatedTile(new SpriteSheet(Game.imageLoader.load("/gfx/tile/watertile.png")), false, 1000),
					   lava = new AnimatedTile(new SpriteSheet(Game.imageLoader.load("/gfx/tile/lavatile.png")), false, 1000),
					   bridgeTop = new Tile(im.bridgeTopTile, false),
					   bridgeBottom = new Tile(im.bridgeBottomTile, false),
					   
					   ice = new Tile(im.iceTile, false),
					   solidIce = new Tile(im.solidIceTile, true),
					   sand = new Tile(im.sandTile, false),
					   
					   stoneRoad = new Tile(im.stoneRoadTile, false),
					   
					   stoneRoadLeft = new Tile(im.stoneRoadTileLeft, false),
					   stoneRoadRight = new Tile(im.stoneRoadTileRight, false),
					   stoneRoadTop = new Tile(im.stoneRoadTileTop, false),
					   stoneRoadBottom = new Tile(im.stoneRoadTileBottom, false),
					   stoneRoadTopLeft = new Tile(im.stoneRoadTileTopLeft, false),
					   stoneRoadTopRight = new Tile(im.stoneRoadTileTopRight, false),
					   stoneRoadBottomLeft = new Tile(im.stoneRoadTileBottomLeft, false),
					   stoneRoadBottomRight = new Tile(im.stoneRoadTileBottomRight, false),
					   stoneRoadCornerTopLeft = new Tile(im.stoneRoadTileTopLeftCorner, false),
					   stoneRoadCornerTopRight = new Tile(im.stoneRoadTileTopRightCorner, false),
					   stoneRoadCornerBottomLeft = new Tile(im.stoneRoadTileBottomLeftCorner, false),
					   stoneRoadCornerBottomRight = new Tile(im.stoneRoadTileBottomRightCorner, false),
					   
					   flower = new Tile(im.roses, false),
					   mushroom_brown = new Tile(im.brownMushroom, false),
					   mushroom_red = new Tile(im.redMushroom, false),
					   grape_hyacinth = new Tile(im.grape_hyacinth, false),
					   aloe_vera = new Tile(im.aloe_vera, false),
					   
					   stair = new Tile(im.stairTile, false),
					   stair2 = new Tile(im.stairTile2, false),
					   
					   caveFloor = new Tile(im.caveFloor, false),
					   caveTopLeft = new Tile(im.caveTileTopLeft, true),
					   caveTopRight = new Tile(im.caveTileTopRight, true),
					   caveBottomLeft = new Tile(im.caveTileBottomLeft, true),
					   caveBottomRight = new Tile(im.caveTileBottomRight, true),
					   caveTop = new Tile(im.caveTileTop, true),
					   caveBottom = new Tile(im.caveTileBottom, true),
					   caveLeft = new Tile(im.caveTileLeft, true),
					   caveRight = new Tile(im.caveTileRight, true),
					   caveEntrance = new Tile(im.caveTileEntrance, false),
					   
					   mtnTopLeft = new Tile(im.mtnTileTopLeft, true),
					   mtnTopRight = new Tile(im.mtnTileTopRight, true),
					   mtnBottomLeft = new Tile(im.mtnTileBottomLeft, true),
					   mtnBottomRight = new Tile(im.mtnTileBottomRight, true),
					   mtnTop = new Tile(im.mtnTileTop, true),
					   mtnBottom = new Tile(im.mtnTileBottom, true),
					   mtnLeft = new Tile(im.mtnTileLeft, true),
					   mtnRight = new Tile(im.mtnTileRight, true),
					   mtnEntrance = new Tile(im.mtnTileEntrance, false),
					   mtnCornerTopLeft = new Tile(im.mtnTileCornerTopLeft, true),
					   mtnCornerTopRight = new Tile(im.mtnTileCornerTopRight, true),
					   mtnCornerBottomLeft = new Tile(im.mtnTileCornerBottomLeft, true),
					   mtnCornerBottomRight = new Tile(im.mtnTileCornerBottomRight, true),
					   
					   houseSidingLeft = new Tile(im.houseSidingLeft, true),
					   houseSidingLeftBottom = new Tile(im.houseSidingLeftBottom, true),
					   houseSidingRight = new Tile(im.houseSidingRight, true),
					   houseSidingRightBottom = new Tile(im.houseSidingRightBottom, true),
					   houseSidingMiddle = new Tile(im.houseSidingMiddle, true),
					   houseSidingMiddleBottom = new Tile(im.houseSidingMiddleBottom, true),
					   houseWindow = new Tile(im.houseWindow, true),
					   houseDoor = new Tile(im.houseDoor, true),
					   houseRoofBottom = new Tile(im.houseRoofBottom, true),
					   houseRoofTop = new Tile(im.houseRoofTop, true),
					   houseRoofMiddle = new Tile(im.houseRoofMiddle, true),
					   houseRoofTopLight = new Tile(im.houseRoofTopLight, true),
					   
					   fenceVertTop = new Tile(im.fenceVerticalTop, true),
					   fenceVertMid = new Tile(im.fenceVerticalMiddle, true),
					   fenceVertBottom = new Tile(im.fenceVerticalBottom, true),
					   fenceHoriz = new Tile(im.fenceHorizontal, true),
					   
					   treeTop = new Tile(im.treeTop, true),
					   treeMid = new Tile(im.treeMid, true),
					   treeBottom = new Tile(im.treeBottom, true)
							
					   ;
	
	
	public Tile(BufferedImage img, boolean isSolid) {
		this.isSolid = isSolid;
		this.img = img;
	}
	
	public void tick() {}
	
	public void render(Graphics g,int x,int y) {
		g.drawImage(img, x, y, img.getWidth() * Game.SCALE, img.getHeight() * Game.SCALE, null);
	}
	
	public boolean isSolid() {
		return isSolid;
	}
	
	public byte getID() {
		return id;
	}
}
