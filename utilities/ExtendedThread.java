package montours_and_men.utilities;


public abstract class ExtendedThread implements Runnable
{
    public final Thread thread;
    
    private volatile static boolean shouldStop = false;
    private volatile long sleepLength = 10L;
   
    public ExtendedThread()
    {
        thread = new Thread(this, "Default");
    }

    public void start()
    {
        thread.start();
    }

    public static void stop()
    {
        shouldStop = true;
    }
    
    abstract protected void tick();
    abstract protected void exitCleanup();

    protected void setSleepLength(long sleepLength)
    {
        this.sleepLength = sleepLength;
    }
    
    
    //Theoretically should not use thread, should be replaced by ScheduledExecutorService
    @Override
    public void run()
    {
        while (!shouldStop)
        {
            tick();
                
            try
            {
                Thread.sleep(sleepLength);//1000 miliseconds equals 1 second
            } 
            catch (Exception exception)
            {
                SystemManager.consolePrintStack(exception);
            }
        }
        
        exitCleanup();
        System.exit(0);
    }
}
