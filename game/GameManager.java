

package montours_and_men.game;

import montours_and_men.game.Map.Map;
import java.util.ArrayList;
import montours_and_men.game.entity.Entity;
import java.util.List;
import java.util.Queue;
import montours_and_men.game.entity.Player;

public class GameManager
{
    //Player is not added to entities list
    private List<Entity> entities = new ArrayList<Entity>();
    private Player player;
    
    //True is the game is frozen or paused
    private boolean isFrozen = false;
    
    private Map map;
    
    /*
      Since this game is only online, GameManager is only instantiated when
      a connection has been established with a server.
      Information is sent from the server and used to create a new GameManager.
    */
    
    public GameManager()
    {
        
    }
    
    public void tick()
    {
        
    }

    public List<Entity> getEntities()
    {
        return entities;
    }
    
    public Player getPlayer()
    {
        return player;
    }

    public Map getMap()
    {
        return map;
    }

    public void setIsFrozen(boolean isFrozen)
    {
        this.isFrozen = isFrozen;
    }
    
    public boolean getIsFrozen()
    {
        return isFrozen;
    }
}
