/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.window.rendering;

import montours_and_men.Start;
import montours_and_men.game.GameManager;
import montours_and_men.game.Map.Tile;
import montours_and_men.game.entity.entity_data.Transform;
import montours_and_men.game.entity.entity_data.Vector2D;

public final class Raycast
{
    private final GameManager gameManager = Start.getGameManager();
    
    private final boolean didHit = false;
    private final double hitDistance = 0;
    private final double hitX = 0;
    private final double hitY = 0;
    
    public Raycast(Transform startTransform, double distanceToCheck)
    {
        Vector2D startLocation = startTransform.getLocation();
        
        Tile startTile = gameManager.getMap().getOccupiedTile(startTransform.getLocation());
        
        //Check y axis intersections, which are horizontal wall faces
        //If the rotation = 180 or 0, then no need to check y intersections
        //Because it will never intersect a horizontal wall face
        if(startTransform.getRotation() < 180)
        {
            //The intial distance test is different from the following checks
            //The first distance check is the distance from the inside of the occupied tile
            //to the edge of it
            double yDistanceToNextWall = (startTile.getY() + 1) - startLocation.getY();
            
            //Loops through and checks each y wall intersection,
            //until it hits a solid wall
            for(int y = startTile.getY(); ; y++)
            {
                /*
                    To obtain the current x-tile we need to check for walls,
                    we need to get the x-component of the ray that has been
                    traversed already to the intial start x-value.
                */
                double xRayComponent = yDistanceToNextWall / Math.tan(startTransform.getRotation());
                
                /*
                    If the rotation is less than 90, we add it to the currentX location.
                    If it is larger, we subtract it from the currentX location.
                */
                double xDistanceToNextWall;
                
                if(startTransform.getRotation() < 90)
                {
                    xDistanceToNextWall = startLocation.getX() + xRayComponent;
                }
                else
                {
                    xDistanceToNextWall = startLocation.getX() - xRayComponent;
                }
                
                /*
                    We make a vector with the new l
                */
                Vector2D locationToCheck = new Vector2D(xDistanceToNextWall, startTile.getX());
                
                //Get 
                Tile tileToCheck = gameManager.getMap().getOccupiedTile(locationToCheck);
                
                if(gameManager.getMap().getTileAt(startTransform.getLocation().getX(), y))
            }
        }
        else if(startTransform.getRotation() > 180)
        {
            
        }
        
        //Check x axis intersections, which are vertical wall faces
        //If the rotation = 90 or 270, then no need to check x intersections
        //Because it will never intersect a vetical wall face
        if(startTransform.getRotation() < 90 || startTransform.getRotation() > 270)
        {
            
        }
        else if(startTransform.getRotation() > 90 && startTransform.getRotation() < 270)
        {
            
        }
        
    }
}
    