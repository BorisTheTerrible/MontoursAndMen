/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montours_and_men.game.entity;

import java.awt.Image;
import montours_and_men.game.entity.entity_data.SpriteController;
import montours_and_men.game.entity.entity_data.Transform;

public class Entity
{
    //id and transform are always provided by the server
    protected final String id;
    protected Transform transform;
    protected SpriteController spriteController;
    
    protected final int entityType;
    
    public Entity(int entityType, String id, Transform transform)
    {
        this.entityType = entityType;
        this.id = id;
        this.transform = transform;
    }
    
    public String getID()
    {
        return id;
    }
    
    public Transform getTransform()
    {
        return transform;
    }
}
