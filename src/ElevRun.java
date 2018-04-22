public class ElevRun extends Thread
{
    public static void sleep()
    {
        try
        {
            System.out.println(Thread.currentThread().getName()+"  Sleep 1s");
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
