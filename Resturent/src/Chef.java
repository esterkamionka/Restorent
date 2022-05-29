import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Chef {
    private ZonedDateTime beginTime;
    private ZonedDateTime endTime;
    private int numOfOrders;
    private Table orderOfTable;
    private int numTable;

     public Chef(){
      numOfOrders=0;
    }

    public ZonedDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(ZonedDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public int getNumOfOrders() {
        return numOfOrders;
    }

    public void setNumOfOrders(int numOfOrders) {
        this.numOfOrders = numOfOrders;
    }
    public void getOrder(Table table){
         beginTime=ZonedDateTime.now();
         endTime=ZonedDateTime.now().plusMinutes(table.getOrdersList().get(0).getPreparationTime());
         numOfOrders++;
         numTable=table.getNumOfTable();

    }
    public int sendOrder(){
        if (numOfOrders==1)
        {
            numOfOrders=0;
            beginTime=null;
            endTime=null;
            int num=numTable;
            numTable=0;
            orderOfTable=null;
            return num;
         }
        return 0;
    }

    public boolean isReady(){//בודק אם ההזמנה מוכנה והשף פנוי להזמנה נוספת
         if (numOfOrders!=0)
         if (ZonedDateTime.now().getHour()>endTime.getHour()||ZonedDateTime.now().getMinute()>endTime.getMinute())
             return true;
         return false;
    }
}
