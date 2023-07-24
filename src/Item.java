
public record Item(String name, int weight) implements Comparable<Item> {

    @Override
    public int compareTo(Item anotherItem) {
        return Integer.compare(this.weight, anotherItem.weight);
    }
}