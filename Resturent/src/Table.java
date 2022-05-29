import java.util.*;
import java.util.stream.Collector;

import static java.util.Comparator.comparingInt;

public class Table {
    private List<Customer> customerList;
    private List<Dish> ordersList;
    private static int cnt;
    private int numOfTable;
    private int totalCost;
    private  boolean isReady;


    static {
        cnt = 0;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }
    public boolean getReady(){
        return isReady;
    }

    public int getNumOfTable() {
        return numOfTable;
    }

    public List<Dish> getOrdersList() {
        return ordersList;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public Table() {
        cnt++;
        numOfTable = cnt;
        customerList = new ArrayList<Customer>();
        ordersList = new ArrayList<Dish>();
        isReady=false;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void addCustomerToTable() {
        this.customerList.add(new Customer());//Adding a client to the table
        customerList.get(customerList.size() - 1).chooseDish();//Select dishes for the customer
        isReady();
    }

    public void addOrderToTable() {
        for (Customer c : customerList) {
            ordersList.addAll(c.getDishesList());
        }
        ordersList.sort(Comparator.comparing(Dish::getPreparationTime).reversed());//Sort the list by preparation time
        for (Dish d:ordersList) {
            totalCost+=d.getCost();
        }
    }

    public boolean isReady() {
        for (int i = 0; i < customerList.size(); i++)
            if (!customerList.get(i).getCustomerElse()) {
                {
                    isReady = true;
                    addOrderToTable();
                    return true;
                }
            }
        return false;
    }
        public void clearTable(){
        customerList.clear();
        ordersList.clear();
    }



    }


