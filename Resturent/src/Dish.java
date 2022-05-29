import org.jetbrains.annotations.NotNull;

public class Dish {
    public String name;
    private int preparationTime;
    private int cost;

    public Dish(String name,int preparationTime,int cost){
        this.name=name;
        this.preparationTime=preparationTime;
        this.cost=cost;
    }
    public Dish(@NotNull Dish d) {
        this.cost=d.cost;
        this.name=d.name;
        this.preparationTime=d.preparationTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
        }
   }

