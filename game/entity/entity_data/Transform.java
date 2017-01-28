/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montours_and_men.game.entity.entity_data;

public final class Transform
{ 
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

    public double getX()
    {
        return x;
    }
    
    public double getY()
    {
        return y;
    }
     
    public double getRotationInDegrees()
    {
        return rotation;
    }
    
    public void set(Transform transform)
    {
        x = transform.x;
        y = transform.y;
        
        rotation = transform.rotation;
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
    
    public void rotateInDegrees(double rotateX)
    {
        double newRotation = rotation + rotateX;
        
        //Makes sure rotation warps properly
        rotation = checkRotationInDegrees(newRotation);
    }
    
    //Everytime transform is rotated,
    //It should be checked to make it wrap properly 
    private double checkRotationInDegrees(double rotationAmmount)
    {
        //If it is over 360 degrees, subtract 360 degress
        //Then recursively check it again
        if(rotationAmmount >= 360)
        {
            rotationAmmount -= 360;
            rotationAmmount = checkRotationInDegrees(rotationAmmount);
        }
        //If it is under 0 degrees, it wraps around to 360
        //The wrapped rotation will be 360 subtracted by the absolute value of the rotation
        //Then recursively checks it again
        else if(rotationAmmount < 0)
        {
            rotationAmmount = 360 - Math.abs(rotationAmmount);
            rotationAmmount = checkRotationInDegrees(rotationAmmount);
        }
        
        return rotationAmmount;
    }
}
