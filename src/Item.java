public class Item {
    String name;
    int weight;

    public Item(String name, int weight){
        this.name = name;
        this.weight = weight;
    }
    public String toString(){
        return this.name + " = " + weight;
    }
}
