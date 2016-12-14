/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montours_and_men.game.entity.entity_data;

import montours_and_men.network.packets.LocationPacket;

public final class Transform {
    
    //It should be noted that rotation is based off of a circle
    //As such, facing the positive x is rotation 0, negative x is rotation 180, etc...
    
    private double x = 0;
    private double y = 0;
    
    //This is in degrees
    private double rotation = 0;

    public Transform()
    {
        
    }
    
    public Transform(double x, double y)
    {
        this.x = x; 
        this.y = y;
    }
    
    public Transform(double x, double y, double rotation)
    {
        this.x = x; 
        this.y = y;

        this.rotation = rotation;
    }

    public void moveTo(int moveToX, int moveToY)
    {
        x = moveToX;
        y = moveToY;
    }
    
    public void move(int movementX, int movementY)
    {
        x += movementX;
        y += movementY;
    }
    
    public double getX()
    {
        return x;
    }
    
    public double getY()
    {
        return y;
    }
   
    //Explicity stated in degrees for clearity
    public void rotateInDegrees(double rotateX)
    {
        rotation = rotation + rotateX;
        
        //Makes sure rotation warps properly
        rotation = checkRotationInDegrees(rotation);
    }
    
    //Everytime transform is rotated,
    //It should be checked to make it warps properly
    
    
    private double checkRotationInDegrees(double rotationAmmount)
    {
        if(rotationAmmount >= 360)
        {
            rotationAmmount -= 360;
            rotationAmmount = checkRotationInDegrees(rotationAmmount);
        }
        else if(rotationAmmount < 0)
        {
            rotationAmmount = 360 - Math.abs(rotationAmmount);
            rotationAmmount = checkRotationInDegrees(rotationAmmount);
        }
        
        return rotationAmmount;
    }
    
    //Explicity stated in degrees for clearity
    public double getRotationInDegrees()
    {
        return rotation;
    }
}
