/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.window_manager;

import montours_and_men.window_manager.input.Input;
import javax.swing.JPanel;

public class Display extends JPanel
{
    private Input input;
   
    public Display()
    {
        
    }
    
    public void tickInput()
    {
        input.tickInput();
    }
}
