/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.window_manager;

import java.awt.Color;
import java.awt.Graphics;
import montours_and_men.window_manager.input.Input;
import javax.swing.JPanel;
import montours_and_men.Start;
import montours_and_men.utilities.SystemManager;
import montours_and_men.utilities.ThreadPlus;
import montours_and_men.window_manager.rendering.Renderer;

public class Display extends JPanel
{
    private final Renderer renderer;
    
    public final Input input;
   
    public Display()
    {
        renderer = new Renderer();
        input = new Input();
    }
    
    public void tickInput()
    {
        input.tickInput();
        
        if(Input.getLastInputList().keyWasTyped('a'))
        {
           Start.stop();
        }
    }
    
    @Override
    public void paint(Graphics graphics)
    {
        renderer.paint(graphics);
    }
}
