public class Elevator
{
    Elevator(){}
    Elevator(int maxFloor)
    {
        this.maxFloor=maxFloor;
    }

    public int maxFloor = 6;//最大楼层
    public int floor = 1;//楼层
    public ElevStatus status = ElevStatus.stop;//电梯状态
    public enum ElevStatus
    {
        up,down,stop//上升,下降,静止
    }

    public int ElevUp() throws Exception
    {
        if ((++floor) > maxFloor)
            throw new Exception("Beyond maximum floor !");
        else
            return ++floor;
    }
    public int ElevUp(int upFloor) throws Exception
    {
        if ((floor+upFloor) > maxFloor)
            throw new Exception("Beyond maximum floor !");
        else
            return floor+upFloor;
    }

    public int ElevDown() throws Exception
    {
        if ((--floor) < 1)
            throw new Exception("Beyond minimum floor !");
        else
            return --floor;
    }
    public int ElevDown(int downFloor) throws Exception
    {
        if ((floor-downFloor) < 1)
            throw new Exception("Beyond minimum floor !");
        else
            return floor-downFloor;
    }
}
