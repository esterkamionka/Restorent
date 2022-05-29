import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Resturent res = new Resturent();
        int num, num2, num3;
        String name;

        System.out.println("Wellcome to the restaurant system");
        do {
            System.out.println("If you are a waiter press 1");
            System.out.println("If you are a customer press 2");
            System.out.println("To exit press 0");
            num = in.nextInt();
            switch (num) {
                case 1: {
                    while (res.getTableQueue().size()>0 ||res.getTableQueue().size()>0&& res.isChefAvalable() != null ||res.isAvalable() != null) {
                        //If there is an order ready
                        if (res.isAvalable() != null) {
                            num3 = res.isAvalable().sendOrder();
                            System.out.println("the total cost for table number " + num3 + " is "
                                    + res.getTableArr()[num3].getTotalCost());
                            res.getTableArr()[num3].clearTable();
                        }
                        //If the queue is not empty
                        if (!res.getTableQueue().isEmpty()) {
                            //If there is a chef available
                            if (res.isChefAvalable() != null)
                                res.isChefAvalable().getOrder(res.getTableQueue().poll());
                            if(res.isAvalable()!=null)
                                res.isAvalable().getOrder(res.getTableQueue().poll());
                        }
                    }
                    if (res.getTableQueue().size()==0&&res.isAllChefAvalable())
                        System.out.println("No pending orders or ready-made dishes to return to the table");
                    break;
                }
                case 2: {
                    System.out.println("Choose a table you want to sit at(from 1 to 15)");
                    num2 = in.nextInt();
                    res.addCustomerToTableList(num2);
                    res.addTableToQueue(res.getTableArr()[num2]);

break;
                }
            }
        }
        while (num != 0);
    }
}
