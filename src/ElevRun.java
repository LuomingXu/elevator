public class ElevRun extends Thread
{
    private FormMain main=null;
    ElevRun(FormMain main)
    {
        this.main=main;
        this.setName("elevator run");
    }
    public void run()
    {
        try
        {
            while (main.elevator.status == Elevator.ElevStatus.up)
            {
                for (int i=main.elevator.getFloor() - 1; i<6; i++)
                {
                    if (main.up[i] == true && i != 5)
                    {
                        main.elevUpStop(i);
                    }
                    else if(main.stop[i] == true)
                    {
                        main.elevStopStop(i);
                    }
                    else
                    {
                        main.elevNothingStop();
                        ElevRun.sleep();
                    }
                }
            }
            while (main.elevator.status == Elevator.ElevStatus.down)
            {
                for (int i=main.elevator.getFloor() - 1; i>-1;i--)
                {
                    if (main.down[i] == true && i != 0)
                    {
                        main.elevDownStop(i);
                    }
                    else if(main.stop[i] == true)
                    {
                        main.elevStopStop(i);
                    }
                    else
                    {
                        main.elevNothingStop();
                        ElevRun.sleep();
                    }
                }
            }
//            lblFloor.setText(Integer.toString(elevator.ElevMove()));
//            lblStatus.setText(elevator.getElevStatus());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

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
