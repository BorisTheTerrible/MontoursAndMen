/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montours_and_men.game_manager;

public class Map
{
    Tile tileMap[][];
    
    public int mapSizeY;
    public int mapSizeX;

    public Map(int mapSizeY, int mapSizeX)
    {
        tileMap = new Tile[this.mapSizeY = mapSizeY][this.mapSizeX = mapSizeX];
        
        for(int y=0; y<=mapSizeY - 1; y++)
        {
            for(int x=0; x<=mapSizeX - 1; x++)
            {
                tileMap[y][x] = Tile.GRASS;
            }
        }
    }
}
