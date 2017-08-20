/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.window.rendering;

import java.awt.Graphics;
import java.awt.Image;
import montours_and_men.Start;
import montours_and_men.game.entity.Entity;
import montours_and_men.game.entity.entity_data.Transform;
import montours_and_men.utilities.Settings;

public final class ViewRenderer
{
    //Distance of the ray starting point to the projection plane
    private final double playerToProjectionDistance;
    
    public ViewRenderer()
    {
        Settings settings = Start.resources.settings;
        
        //Length of 
        playerToProjectionDistance = 
                (settings.windowDimensions.width / 2) / (settings.fieldOfView / 2);
    }
    
    public void paint(Graphics graphics)
    {
        
    }
    
    private Image resizeBasedOnDistance(Transform transform, Entity entityToResize)
    {
        return null;
    }
}
