package GUIGuest;

/**
 * Created by Kasia on 2017-01-10.
 */
public class Service {
    String name;
    int price;
    String description;

    public Service(String name, int price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    public String getDescription(){
        return description;
    }
}
