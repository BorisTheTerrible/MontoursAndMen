/*
 *  All Rights Reserved by Johnathan Schemenaur
 */

package montours_and_men.window_manager.input;

import java.util.ArrayList;

public final class InputList
{
    protected volatile boolean hasMouseFocus = true;
    
    protected final ArrayList<Character> keyTyped;
    protected final ArrayList<Character> keyPressed;
    protected final ArrayList<Character> keyReleased;
    protected final ArrayList<Integer> mouseClicked;
    protected final ArrayList<Integer> mousePressed;
    protected final ArrayList<Integer> mouseReleased;
    
    protected InputList()
    {
        keyTyped = new ArrayList();
        keyPressed = new ArrayList();
        keyReleased = new ArrayList();
        mouseClicked = new ArrayList();
        mousePressed = new ArrayList();
        mouseReleased = new ArrayList();
    }
    
    protected InputList(InputList inputList)
    {
        this.keyTyped = inputList.keyTyped;
        this.keyPressed = inputList.keyPressed;
        this.keyReleased = inputList.keyReleased;
        this.mouseClicked = inputList.mouseClicked;
        this.mousePressed = inputList.mousePressed;
        this.mouseReleased = inputList.mouseReleased;
    }
    
    public boolean keyWasTyped(char character)
    {
        return keyTyped.contains(character);
    }
    
    public boolean keyWasPressed(char character)
    {
        return keyPressed.contains(character);
    }
    
    public boolean keyWasReleased(char character)
    {
        return keyReleased.contains(character);
    }
    
    public boolean mouseWasClicked(int mouseButton)
    {
        return mouseClicked.contains(mouseButton);
    }
    
    public boolean mouseWasPressed(int mouseButton)
    {
        return mousePressed.contains(mouseButton);
    }
    
    public boolean mouseWasReleased(int mouseButton)
    {
        return mouseReleased.contains(mouseButton);
    }
    
    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append(keyTyped.toString());
        stringBuilder.append(keyPressed.toString());
        stringBuilder.append(keyReleased.toString());
        stringBuilder.append(mouseClicked.toString());
        stringBuilder.append(mousePressed.toString());
        stringBuilder.append(mouseReleased.toString());
        
        return stringBuilder.toString();
    }
}
