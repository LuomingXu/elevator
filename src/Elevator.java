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
        up,down,stop,open//上升,下降,静止
    }

    public int getFloor()
    {
        return floor;
    }
    public String getElevStatus()
    {
        if (status == ElevStatus.stop)
            return "stop";
        else if(status == ElevStatus.up)
            return "up";
        else if(status == ElevStatus.down)
            return "down";

        return "stop";
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

//    public int ElevUp() throws Exception
//    {
//        if ((++floor) > maxFloor)
//            throw new Exception("Beyond maximum floor !");
//        else
//            return ++floor;
//    }
//    public int ElevUp(int upFloor) throws Exception
//    {
//        if ((floor+upFloor) > maxFloor)
//            throw new Exception("Beyond maximum floor !");
//        else
//            return floor+upFloor;
//    }
//
//    public int ElevDown() throws Exception
//    {
//        if ((--floor) < 1)
//            throw new Exception("Beyond minimum floor !");
//        else
//            return --floor;
//    }
//    public int ElevDown(int downFloor) throws Exception
//    {
//        if ((floor-downFloor) < 1)
//            throw new Exception("Beyond minimum floor !");
//        else
//            return floor-downFloor;
//    }
}
