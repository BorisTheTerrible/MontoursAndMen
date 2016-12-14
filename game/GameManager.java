

package montours_and_men.game;

import java.util.ArrayList;
import montours_and_men.game.entity.Entity;
import java.util.List;
import montours_and_men.game.entity.Player;

public class GameManager
{
    //Player is not added to entities list
    public List<Entity> entities = new ArrayList<Entity>();
    public Player player = new Player();
    
    public boolean frozen = false;
    
    public Map map = new Map(20, 20);
    
    public GameManager()
    {
        
    }
    
    public void tick()
    {
        
    }
    
}
