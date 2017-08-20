/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montours_and_men.game.Map;

import java.util.Random;
import montours_and_men.game.Map.Tile.TileType;
import montours_and_men.game.entity.entity_data.Vector2D;

public class Map
{
    private final Tile tileMap[][];

    public Map(int mapSizeX, int mapSizeY)
    {
        tileMap = new Tile[mapSizeX][mapSizeY];
        
        Random random = new Random(System.nanoTime());
        
        for(int x = 0; x < mapSizeY; x++)
        {
            for(int y = 0 ; y < mapSizeX; y++)
            {
                if(random.nextInt(2) == 0)
                {
                    tileMap[x][y] = new Tile(x, y, TileType.WALL);
                }
                else
                {
                    tileMap[x][y] = new Tile(x, y, TileType.EMPTY);
                }
            }
        }
    }
    
    public Tile getTileAt(int x, int y)
    {
        return tileMap[x][y];
    }
    
    public Tile getOccupiedTile(Vector2D location)
    {
        return getTileAt((int)location.getX(), (int)location.getY());
    }
}
