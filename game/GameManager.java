

package montours_and_men.game;

import java.util.ArrayList;
import montours_and_men.game.entity.Entity;
import java.util.List;
import java.util.Queue;
import montours_and_men.game.entity.Player;

public class GameManager
{
    //Player is not added to entities list
    public List<Entity> entities = new ArrayList<Entity>();
    public Player player;
    
    //Queue receivedMessages = new Queue();
    
    //True is the game is frozen or paused
    public boolean frozen = false;
    
    public Map map;
    
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
    
}
