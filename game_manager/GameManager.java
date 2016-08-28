

package montours_and_men.game_manager;

import java.util.ArrayList;
import montours_and_men.entity.Entity;
import java.util.List;

public class GameManager {
    
    public List<Entity> entities = new ArrayList<Entity>();
    public Entity player = new Entity();
    
    public boolean frozen = false;
    
    public Map map = new Map(20, 20);
    
    public GameManager(){
        entities.add(player);
        entities.add(new Entity());
    }
    
    public void tick(){
        
    }
    
}
