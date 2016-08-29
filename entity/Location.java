/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montours_and_men.entity;

import montours_and_men.Start;

public class Location {

    private int x;
    private int y;

    public Location() {
        x = 0;
        y = 0;
    }
    
    public Location(int y, int x){
        this.y = y;
        this.x = x;  
    }

    public void move(int addY, int addX) {
        y += addY;
        x += addX;

        checkY:
        if (y > 1000) {
            y = 1000;
            break checkY;
        } else if (y < 0) {
            y = 0;
        }

        checkX:
        if (x > 1000) {
            x = 1000;
            break checkX;
        } else if (x < 0) {
            x = 0;
        }

    }
    
    public int getRelativeY(){
        int height = Start.resources.settings.windowDimensions.height;
        return y*(height/1000);
    } 
    
    public int getRelativeX(){
        int width = Start.resources.settings.windowDimensions.width;
        return x*(width/1000);
    }
}
