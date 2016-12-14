/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.window.rendering;

import montours_and_men.Start;
import montours_and_men.game.GameManager;
import montours_and_men.game.Tile;
import montours_and_men.game.entity.entity_data.Transform;

public final class Raycast
{
    private final double locationX;
    private final double locationY;
    private final double rotation;
    
    private final GameManager gameManager = Start.getGameManager();
    
    private final double length;
    
    public Raycast(Transform transform, double rotationToAdd)
    {
        Tile occupiedTile = gameManager.map.getCurrentOccupiedTile(transform);
        
        locationX = transform.getX();
        locationY = transform.getY();
        rotation = transform.getRotationInDegrees() + rotationToAdd;
        
        //Check y axis intersections, which are horizontal wall faces
        //If the rotation = 180 or 0, then no need to check y intersections
        //Because it will never intersect a horizontal wall face
        if(rotation < 180)
        {
            
        }
        else if(rotation > 180)
        {
            
        }
        
        //Check x axis intersections, which are vertical wall faces
        //If the rotation = 90 or 270, then no need to check x intersections
        //Because it will never intersect a vetical wall face
        if(rotation < 90 || rotation > 270)
        {
            
        }
        else if(rotation > 90 && rotation < 270)
        {
            
        }
        
        length = 0;
    }
}
    