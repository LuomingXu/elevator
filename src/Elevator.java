import java.awt.datatransfer.FlavorListener;

public class Elevator
{
    Elevator(){}
    Elevator(ElevStatus status, int maxFloor)
    {
        this.status=status;
        this.maxFloor=maxFloor;
    }

    public int maxFloor = 6;//最大楼层
    public int floor = 1;//楼层
    public ElevStatus status = ElevStatus.stop;//电梯状态
    public enum ElevStatus
    {
        up,down,stop,open//上升,下降,静止,开门
    }

    public int getFloor()
    {
        return floor;
    }
    public String getElevStatus()
    {
        switch (status)
        {
            case up: return "up";
            case down: return "down";
            case stop: return "stop";
            case open: return "open";
            default: return null;
        }
    }

    public int ElevMove()
    {
        if (floor == maxFloor)
            status=ElevStatus.down;
        if (floor == 1)
            status=ElevStatus.up;

        switch (status)
        {
            case up: ++floor;break;
            case down:--floor;break;
            default: return floor;
        }

        return floor;
    }
}
