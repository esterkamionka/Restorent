import java.sql.SQLOutput;
import java.util.*;

public class Customer<isCustomerElse> {
    Scanner in=new Scanner(System.in);
    private String name;
    private String id;
    private ArrayList<Dish> dishesList;
   private boolean isCustomerElse;

    public Customer(){
        dishesList=new ArrayList<Dish>();
        isCustomerElse=true;
    };

    public ArrayList<Dish> getDishesList() {
        return dishesList;
    }
    public boolean getCustomerElse(){
        return isCustomerElse;
    }
//Selecting dishes and adding to the list
    public void addDishes(int num) {
            switch (num) {
                case 1:{
                    dishesList.add(new Dish("fish", 4, 20));
                    break;}
                case 2:{
                    dishesList.add(new Dish("noodls", 5, 20));
                break;}
                case 3:{
                    dishesList.add(new Dish("soup", 5, 10));
                    break;}
                case 4:{
                    dishesList.add(new Dish("asado", 8, 30));
                    break;}
                case 5:{
                    dishesList.add(new Dish("chicken", 7, 25));
                    break;}
                case 6:{
                    dishesList.add(new Dish("Chicken in vegetables", 9, 25));
                    break;}
                default:
                    dishesList.add(new Dish("fish", 3, 20));
            }
        }
        //menu:
    public void chooseDish(){
                System.out.println("Select the desired dish");
                System.out.println("for fish press 1 ");
                System.out.println("for noodls press 2");
                System.out.println("for soup press 3");
                System.out.println("for asado meat press 4");
                System.out.println("for chicken press 5");
                System.out.println("for Chicken in vegetables press 6");
                System.out.println("for ice cream press 7");
                int num=in.nextInt();
                addDishes(num);
                if (ifWantMore())
                    chooseDish();
                else {
                    //If table can enter the queue
                    System.out.println("Have all the customers at the table finished ordering dishes? ");
                    System.out.println("If yes press 1' if no press to 2");
                    int num2=in.nextInt();
                    if (num2==1)
                        isCustomerElse=false;

                }

            }
            //Check if the customer wants another dish
            public boolean ifWantMore(){
                System.out.println("if you want another dish press 1 else press 2");
                int num=in.nextInt();
                if (num==1)
                    return true;
                return false;
            }


    }

