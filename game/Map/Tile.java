/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montours_and_men.game.Map;

import montours_and_men.game.entity.entity_data.Vector2D;

public class Tile
{
    private TileType tileType;
    
    private final int x;
    private final int y;
    
    protected Tile(int x, int y, TileType tileType)
    {
        this.tileType = tileType;
        
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }

    public void setTileType(TileType tileType)
    {
        this.tileType = tileType;
    }
    
    public enum TileType
    {
        EMPTY, WALL;
    }
}

