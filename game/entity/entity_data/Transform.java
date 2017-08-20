/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package montours_and_men.game.entity.entity_data;

public final class Transform
{ 
    private final Vector2D location;
    //This is in degrees
    private double rotation = 0;
    
    public Transform(double x, double y, double rotation)
    {
        location = new Vector2D(x, y);

        this.rotation = rotation;
    }

    public Vector2D getLocation()
    {
        return location;
    }
     
    public double getRotation()
    {
        return rotation;
    }
    
    public void set(Transform transform)
    {
        location.set
        (
            transform.getLocation().getX(),
            transform.getLocation().getY()
        );
        
        rotation = transform.rotation;
    }
    
    public void rotate(double rotate)
    {
        double newRotation = rotation + rotate;
        
        //Makes sure rotation wraps properly
        rotation = checkRotation(newRotation);
    }
    
    //Everytime transform is rotated,
    //It should be checked to make it wrap properly 
    private double checkRotation(double rotationAmmount)
    {
        //If it is over 360 degrees, subtract 360 degress
        //Then recursively check it again
        if(rotationAmmount >= 360)
        {
            rotationAmmount -= 360;
            rotationAmmount = checkRotation(rotationAmmount);
        }
        //If it is under 0 degrees, it wraps around to 360
        //The wrapped rotation will be 360 subtracted by the absolute value of the rotation
        //Then recursively checks it again
        else if(rotationAmmount < 0)
        {
            rotationAmmount = 360 - Math.abs(rotationAmmount);
            rotationAmmount = checkRotation(rotationAmmount);
        }
        
        return rotationAmmount;
    }
}
