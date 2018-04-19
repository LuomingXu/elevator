import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormMain extends JFrame
{
    //region 控件定义
    private JButton btnDown6;
    private JButton btnUp5;
    private JButton btnDown5;
    private JButton btnUp4;
    private JButton btnDown4;
    private JButton btnUp3;
    private JButton btnDown3;
    private JButton btnDown2;
    private JButton btnUp2;
    private JButton btnUp1;
    private JLabel lblFloor;
    public JPanel mainPanel;
    private JButton btnStart;
    private JButton btnStop6;
    private JButton btnStop5;
    private JButton btnStop4;
    private JButton btnStop3;
    private JButton btnStop2;
    private JButton btnStop1;
    private JLabel lblStatus;
    //endregion

    private Elevator elevator=new Elevator(Elevator.ElevStatus.up,6);

    private boolean down6=false;
    private boolean up5=false;private boolean down5=false;
    private boolean up4=false;private boolean down4=false;
    private boolean up3=false;private boolean down3=false;
    private boolean up2=false;private boolean down2=false;
    private boolean up1=false;
    private boolean stop1=false;private boolean stop2=false;
    private boolean stop3=false;private boolean stop4=false;
    private boolean stop5=false;private boolean stop6=false;

    private boolean[] up=new boolean[6];//0-4
    private boolean[] down=new boolean[6];//1-5
    private boolean[] stop=new boolean[6];//0-5

    FormMain()
    {
        InitializeComponent();
        ListenerDown();
        ListenerUp();
        ListenerStop();
        InitArray();

        btnStart.addActionListener(e ->
                {
                    Run();
                }
        );

    }

    private void InitializeComponent()
    {
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    private void Run()
    {
        try
        {
            while (elevator.status == Elevator.ElevStatus.up)
            {
                for (int i=elevator.getFloor() - 1; i<6; i++)
                {
                    if (up[i] == true && i != 5)
                    {
                        elevUpStop(i);
                    }
                    else if(stop[i] == true)
                    {
                        elevStopStop(i);
                    }
                    else
                    {
                        elevNothingStop();
                        Thread.sleep(1000);
                    }
                }
            }
            while (elevator.status == Elevator.ElevStatus.down)
            {
                for (int i=elevator.getFloor() - 1; i>-1;i--)
                {
                    if (down[i] == true && i != 0)
                    {
                        elevDownStop(i);
                    }
                    else if(stop[i] == true)
                    {
                        elevStopStop(i);
                    }
                    else
                    {
                        elevNothingStop();
                        Thread.sleep(1000);
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

    private void elevUpStop(int i)
    {
        try
        {
            elevator.status= Elevator.ElevStatus.open;setLblStatus();setLblFloor();
            Thread.sleep(1000);
            elevator.status= Elevator.ElevStatus.up;setLblStatus();setLblFloor();
            elevator.ElevMove();
            switch (i)
            {
                case 0:up[0]=false;btnUp1.setForeground(Color.BLACK);
                    stop[0]=false;btnStop1.setForeground(Color.BLACK);
                    break;
                case 1:up[1]=false;btnUp2.setForeground(Color.BLACK);
                    stop[1]=false;btnStop2.setForeground(Color.BLACK);
                    break;
                case 2:up[2]=false;btnUp3.setForeground(Color.BLACK);
                    stop[2]=false;btnStop3.setForeground(Color.BLACK);
                    break;
                case 3:up[3]=false;btnUp4.setForeground(Color.BLACK);
                    stop[3]=false;btnStop4.setForeground(Color.BLACK);
                    break;
                case 4:up[4]=false;btnUp5.setForeground(Color.BLACK);
                    stop[4]=false;btnStop5.setForeground(Color.BLACK);
                    break;
                default:
                    break;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void elevDownStop(int i)
    {
        try
        {
            elevator.status= Elevator.ElevStatus.open;setLblStatus();setLblFloor();
            Thread.sleep(1000);
            elevator.status= Elevator.ElevStatus.down;setLblStatus();setLblFloor();
            elevator.ElevMove();
            switch (i)
            {
                case 1:up[1]=false;btnDown2.setForeground(Color.BLACK);
                    stop[1]=false;btnStop2.setForeground(Color.BLACK);
                    break;
                case 2:up[2]=false;btnDown3.setForeground(Color.BLACK);
                    stop[2]=false;btnStop3.setForeground(Color.BLACK);
                    break;
                case 3:up[3]=false;btnDown4.setForeground(Color.BLACK);
                    stop[3]=false;btnStop4.setForeground(Color.BLACK);
                    break;
                case 4:up[4]=false;btnDown5.setForeground(Color.BLACK);
                    stop[4]=false;btnStop5.setForeground(Color.BLACK);
                    break;
                case 5:up[5]=false;btnDown6.setForeground(Color.BLACK);
                    stop[5]=false;btnStop6.setForeground(Color.BLACK);
                    break;
                default:
                    break;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void elevStopStop(int i)
    {
        try
        {
            Elevator.ElevStatus temp=elevator.status;
            elevator.status= Elevator.ElevStatus.open;setLblStatus();setLblFloor();
            Thread.sleep(1000);
            elevator.status=temp;
            switch (i)
            {
                case 0:
                    stop[0]=false;btnStop1.setForeground(Color.BLACK);
                    break;
                case 1:
                    stop[1]=false;btnStop2.setForeground(Color.BLACK);
                    break;
                case 2:
                    stop[2]=false;btnStop3.setForeground(Color.BLACK);
                    break;
                case 3:
                    stop[3]=false;btnStop4.setForeground(Color.BLACK);
                    break;
                case 4:
                    stop[4]=false;btnStop5.setForeground(Color.BLACK);
                    break;
                case 5:
                    stop[5]=false;btnStop6.setForeground(Color.BLACK);
                    break;
                default:
                    break;
            }
        }
        catch(Exception e)
        {
            System.out.println("error: " + e);
        }
    }
    private void elevNothingStop()
    {
        elevator.ElevMove();
        setLblFloor();
        setLblStatus();
    }

    private void setLblStatus()
    {
        lblStatus.setText(elevator.getElevStatus());
    }
    private void setLblFloor()
    {
        lblFloor.setText(Integer.toString(elevator.getFloor()));
    }

    private void InitArray()
    {
        for (int i=0;i<6;i++)
        {
            up[i]=false;
            down[i]=false;
            stop[i]=false;
        }
    }

    private void ListenerDown()
    {
        btnDown6.addActionListener(e ->
        {
            down[5]=true;
            btnDown6.setForeground(Color.RED);
        });
        btnDown5.addActionListener(e ->
        {
            down[4]=true;
            btnDown5.setForeground(Color.RED);
        });
        btnDown4.addActionListener(e ->
        {
            down[3]=true;
            btnDown4.setForeground(Color.RED);
        });
        btnDown3.addActionListener(e ->
        {
            down[2]=true;
            btnDown3.setForeground(Color.RED);
        });
        btnDown2.addActionListener(e ->
        {
            down[1]=true;
            btnDown2.setForeground(Color.RED);
        });
    }

    private void ListenerUp()
    {
        btnUp1.addActionListener(e ->
        {
            up[0]=true;
            btnUp1.setForeground(Color.RED);
        });
        btnUp2.addActionListener(e ->
        {
            up[1]=true;
            btnUp2.setForeground(Color.RED);
        });
        btnUp3.addActionListener(e ->
        {
            up[2]=true;
            btnUp3.setForeground(Color.RED);
        });
        btnUp4.addActionListener(e ->
        {
            up[3]=true;
            btnUp4.setForeground(Color.RED);
        });
        btnUp5.addActionListener(e ->
        {
            up[4]=true;
            btnUp5.setForeground(Color.RED);
        });
    }

    private void ListenerStop()
    {
        btnStop6.addActionListener(e ->
        {
            stop[5]=true;
            btnStop6.setForeground(Color.RED);
        });
        btnStop5.addActionListener(e ->
        {
            stop[4]=true;
            btnStop5.setForeground(Color.RED);
        });
        btnStop4.addActionListener(e ->
        {
            stop[3]=true;
            btnStop4.setForeground(Color.RED);
        });
        btnStop3.addActionListener(e ->
        {
            stop[2]=true;
            btnStop3.setForeground(Color.RED);
        });
        btnStop2.addActionListener(e ->
        {
            stop[1]=true;
            btnStop2.setForeground(Color.RED);
        });
        btnStop1.addActionListener(e ->
        {
            stop[0]=true;
            btnStop1.setForeground(Color.RED);
        });
    }

//    private boolean JudgeTxtBoxIsLegal()
//    {
//        try
//        {
//            int floor1=Integer.parseInt(txtToFloor1.getText());
//            int floor2=Integer.parseInt(txtToFloor2.getText());
//            int floor3=Integer.parseInt(txtToFloor3.getText());
//            int floor4=Integer.parseInt(txtToFloor4.getText());
//            int floor5=Integer.parseInt(txtToFloor5.getText());
//            int floor6=Integer.parseInt(txtToFloor6.getText());
//
//            if (floor1 < 2 || floor1 > 6)
//                return false;
//            if (floor2 < 1 || floor2 > 6 || floor2 == 2)
//                return false;
//            if (floor3 < 1 || floor3 > 6 || floor3 == 3)
//                return false;
//            if (floor4 < 1 || floor4 > 6 || floor4 == 4)
//                return false;
//            if (floor5 < 1 || floor5 > 6 || floor5 == 5)
//                return false;
//            if (floor6 < 1 || floor6 > 5)
//                return false;
//
//            return true;
//        }
//        catch(Exception e)
//        {
//
//        }
//        finally
//        {
//            return false;
//        }
//    }
}
