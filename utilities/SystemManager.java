package montours_and_men.utilities;

public class SystemManager
{
    private long tickCount = 0l;
    private static long lastTimeMillis;
    
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
    
    public static void consolePrintStack(Exception e)
    {
        consolePrintError(e.getLocalizedMessage());
        
        for(StackTraceElement element : e.getStackTrace())
        {
            consolePrintError(element.toString());
        }
    }
    
    public static synchronized long getDeltaTime()
    {
        return (System.currentTimeMillis() - lastTimeMillis);
    }
    
    public synchronized void tick()
    {       
        tickCount++;
        
        if((System.currentTimeMillis() - lastTimeMillis) >= 1000)
        {
            consolePrint(((Long)tickCount).toString());
            tickCount = 0l;
            lastTimeMillis = System.currentTimeMillis();
        }
    }
    
}
