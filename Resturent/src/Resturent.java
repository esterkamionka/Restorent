
import java.util.*;

class Resturent{
    Scanner in=new Scanner(System.in);
   private List<Waiter> waiterList;
   private List<Chef> chefList;
   private Table[] tableArr;
   private Queue<Table> tableQueue;

    public Resturent(){
       tableArr=new Table[16];
        for (int i = 1; i < 16; i++) {
             tableArr[i]=new Table();
        }
       waiterList=new ArrayList<Waiter>();
        for (int i = 0; i < 5; i++) {
            waiterList.add(new Waiter());
        }
       chefList=new ArrayList<Chef>();
        chefList.add(new Chef());
       tableQueue=new ArrayDeque<Table>();
    }

    public Table[] getTableArr() {
        return tableArr;
    }

    public Queue<Table> getTableQueue() {
        return tableQueue;
    }

    public void addCustomerToTableList(int num){    //Adding a client to the table
        if (!tableArr[num].getReady())
          tableArr[num].addCustomerToTable();     //Choice of dishes
        else {
            System.out.println("Coose another table");
            num = in.nextInt();
            addCustomerToTableList(num);
        }
    }
    public void addTableToQueue(Table table){   //A table whose customers all chose dishes entered the queue
        tableQueue.add(table);
    }
    public void addChefToQueue(Chef c)    {
        chefList.add(c) ;
    }

    public List<Chef> getChefList() {
        return chefList;
    }
    public boolean isAllChefAvalable(){    // Are all chefs available?
        for (Chef c: chefList) {
            if (c.getNumOfOrders()!=0)
                 return false;
        }
        return true;
    }

    public Chef isChefAvalable(){     //Is there a chef available ?
        for (Chef c:chefList  )
             if (c.getNumOfOrders()==0)
                 return c;
             return null;
    }
    public Chef isAvalable(){
         for (Chef c1:chefList  )
         {
         if (c1.isReady())
             return c1;
         }
         return null;
    }
    }































