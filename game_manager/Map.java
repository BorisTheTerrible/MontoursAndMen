/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montours_and_men.game_manager;

import montours_and_men.game_manager.entity.entity_data.Transform;

public class Map
{
    private final Tile tileMap[][];

    public Map(int mapSizeX, int mapSizeY)
    {
        tileMap = new Tile[mapSizeX][mapSizeY];
        
        for(int x = 0; x < mapSizeY; x++)
        {
            for(int y = 0 ; y < mapSizeX; y++)
            {
                tileMap[x][y] = Tile.EMPTY;
            }
        }
    }
    
    public Tile getTileAt(int x, int y)
    {
        return tileMap[x][y];
    }
    
    public Tile getCurrentOccupiedTile(Transform transform)
    {
        int x = getWholeAxisEquivalent(transform.getX());
        int y = getWholeAxisEquivalent(transform.getY());
        
        return tileMap[x][y];
    }
    
    //If the player is inside of a tile, then it returns that tile's location
    //If the players is magically at a perfect tile boundary,
    //it will return the higher bounded tile's location
    private int getWholeAxisEquivalent(double axis)
    {
        int tileValue;
        
        int convertedAxis = (int)axis;
        
        if()
        
            if(axis > convertedAxis)
            {
                tileValue = convertedAxis + 1;
            }
            else
            {
                tileValue = (int)axis;
            }
        
        return tileValue;
    }
}
