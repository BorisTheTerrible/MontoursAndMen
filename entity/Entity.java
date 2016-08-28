/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montours_and_men.entity;

import java.util.UUID;

public class Entity {
    
    private final UUID ID = UUID.randomUUID();
    
    public Location location = new Location();
    
    public Entity(){
        
    }
    
    public UUID getID(){
        return ID;
    }
    
    
    
}
