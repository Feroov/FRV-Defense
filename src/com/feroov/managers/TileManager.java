package com.feroov.managers;

import com.feroov.helpmethods.LoadSave;
import com.feroov.objects.Tile;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TileManager
{
    public Tile
            // Grass related
            GRASS, GRASS_TREE, GRASS_BIGTREE, GRASS_FLOWER,
            // Road related
            ROAD_X, ROAD_Y, ROAD_UPRIGHT, ROAD_LEFTDOWN, ROAD_LEFTUP, ROAD_DOWNRIGHT,
            // Water related
            WATER, DEEPWATER, WATER_NW, WATER_SE, WATER_NE, WATER_SW, WATER_TOP, WATER_LEFT, WATER_RIGHT, WATER_DOWN,
            // Sand related
            SAND, SAND_CACTUS, SAND_SE, SAND_SW, SAND_NW, SAND_NE, SAND_LEFT, SAND_DOWN, SAND_RIGHT, SAND_UP,
            // Corner stuff
            CORNER_BOTTOMRIGHT, CORNER_BOTTOMLEFT, CORNER_TOPRIGHT, CORNER_TOPLEFT;

    public BufferedImage atlas;
    public ArrayList<Tile> tiles = new ArrayList<>();

    public TileManager()
    {
        loadAtlas();
        createTiles();
    }

    private void createTiles()
    {
        int id = 0;
        // Grass
        tiles.add(GRASS = new Tile(getSprite(7,2), id++, "Grass")); /* 0 */
        tiles.add(GRASS_TREE = new Tile(getSprite(6,2), id++, "Grass with Trees")); /* 1 */
        tiles.add(GRASS_BIGTREE = new Tile(getSprite(4,2), id++, "Grass with big Tree")); /* 2 */
        tiles.add(GRASS_FLOWER = new Tile(getSprite(5,2), id++, "Grass with Flower")); /* 3 */

        // Water
        tiles.add(WATER = new Tile(getSprite(4,1), id++, "Water")); /* 4 */
        tiles.add(DEEPWATER = new Tile(getSprite(3,1), id++, "Deep Water")); /* 5 */
       /* tiles.add(WATER_NW = new Tile(getSprite(0,0), id++, "Water NW"));
        tiles.add(WATER_SE = new Tile(getSprite(1,0), id++, "Water SE"));
        tiles.add(WATER_TOP = new Tile(getSprite(2,0), id++, "Water TOP"));
        tiles.add(WATER_DOWN = new Tile(getSprite(3,0), id++, "Water DOWN"));
        tiles.add(WATER_NE = new Tile(getSprite(4,0), id++, "Water NE"));
        tiles.add(WATER_RIGHT = new Tile(getSprite(0,1), id++, "Water RIGHT"));
        tiles.add(WATER_SW = new Tile(getSprite(1,1), id++, "Water SW"));
        tiles.add(WATER_LEFT = new Tile(getSprite(2,1), id++, "Water LEFT"));

        // Roads
        tiles.add(ROAD_X = new Tile(getSprite(7,1), id++, "Road Horizontal"));
        tiles.add(ROAD_Y = new Tile(getSprite(7,0), id++, "Road Vertical"));
        tiles.add(ROAD_UPRIGHT = new Tile(getSprite(8,0), id++, "Road UPRIGHT"));
        tiles.add(ROAD_LEFTDOWN = new Tile(getSprite(9,0), id++, "Road LEFTDOWN"));
        tiles.add(ROAD_LEFTUP = new Tile(getSprite(8,1), id++, "Road LEFTUP"));
        tiles.add(ROAD_DOWNRIGHT = new Tile(getSprite(9,1), id++, "Road DOWNRIGHT"));

        // Sand
        tiles.add(SAND = new Tile(getSprite(0,4), id++, "Grass"));
        tiles.add(SAND_CACTUS = new Tile(getSprite(1,4), id++, "Grass"));
        tiles.add(SAND_SE = new Tile(getSprite(0,2), id++, "Grass"));
        tiles.add(SAND_SW = new Tile(getSprite(1,2), id++, "Grass"));
        tiles.add(SAND_NW = new Tile(getSprite(2,2), id++, "Grass"));
        tiles.add(SAND_NE = new Tile(getSprite(3,2), id++, "Grass"));
        tiles.add(SAND_LEFT = new Tile(getSprite(0,3), id++, "Grass"));
        tiles.add(SAND_DOWN = new Tile(getSprite(1,3), id++, "Grass"));
        tiles.add(SAND_RIGHT = new Tile(getSprite(2,3), id++, "Grass"));
        tiles.add(SAND_UP = new Tile(getSprite(3,3), id++, "Grass"));

        // Corner stuff
        tiles.add(CORNER_BOTTOMRIGHT = new Tile(getSprite(5,0), id++, "Corner BOTTOMRIGHT"));
        tiles.add(CORNER_BOTTOMLEFT = new Tile(getSprite(6,0), id++, "Corner BOTTOMLEFT"));
        tiles.add(CORNER_TOPRIGHT = new Tile(getSprite(5,1), id++, "Corner TOPRIGHT"));
        tiles.add(CORNER_TOPLEFT = new Tile(getSprite(6,1), id++, "Corner TOPLEFT"));

        */
    }

    private void loadAtlas() { atlas = LoadSave.getSpriteAtlas();}

    public Tile getTile(int id) { return tiles.get(id);}

    public BufferedImage getSprite(int id)
    {
        return tiles.get(id).getSprite();
    }

    private BufferedImage getSprite(int xCord, int yCord)
    {
        return atlas.getSubimage(xCord * 32,yCord * 32,32,32);
    }
}
