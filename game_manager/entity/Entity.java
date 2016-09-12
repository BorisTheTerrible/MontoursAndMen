/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montours_and_men.game_manager.entity;

import java.awt.Image;
import montours_and_men.game_manager.entity.entity_data.Transform;
import java.util.UUID;

public class Entity
{
    private final UUID ID = UUID.randomUUID();
    private final Transform transform = new Transform();
    private Image sprite;
    
    public Entity()
    {
        
    }
    
    public UUID getID()
    {
        return ID;
    }
    
    public Transform getTransform()
    {
        return transform;
    }
    
    
    
}
