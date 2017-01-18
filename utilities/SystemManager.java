package montours_and_men.utilities;

public class SystemManager
{
    //Used to count the number of ticks per second
    private int tickCount = 0;
    //Used to determine the time since the last SystemManager tick
    private static long lastTimeMillis;
    //Used to determine if a second has passed
    //Used to count number of ticks per second
    //Set to current time millis once 1000 millis has passed.
    private static long lastSecondTimeMillis;
    
    public SystemManager()
    {
        lastTimeMillis = System.currentTimeMillis();
    }
    
    public static void consolePrint(Object... objects)
    {
        StringBuilder stringBuilder = new StringBuilder();
        
        for(Object object : objects)
        {
            stringBuilder.append(object.toString());
        }
        
        System.out.println(stringBuilder);//Normal console print
    }
    
    public static void consolePrintError(String message)
    {
        System.err.println(message);//Error console print
    }
    
    public static void consolePrintStack(Exception exception)
    {
        consolePrintError(exception.getLocalizedMessage());
        
        for(StackTraceElement element : exception.getStackTrace())
        {
            consolePrintError(element.toString());
        }
    }
    
    //Time since last SystemManager tick
    public static synchronized long getDeltaTime()
    {
        return (System.currentTimeMillis() - lastTimeMillis);
    }
    
    public synchronized void tick()
    {       
        tickCount++;
        
        //Adds elapsed time since last tick
        lastSecondTimeMillis += System.currentTimeMillis() - lastTimeMillis;
        
        //If the elapsed time is longer than a second
        if(lastSecondTimeMillis >= 1000)
        {
            consolePrint(tickCount);
            tickCount = 0;
            lastSecondTimeMillis = 0;
        }
        
        lastTimeMillis = System.currentTimeMillis();
    }
}
