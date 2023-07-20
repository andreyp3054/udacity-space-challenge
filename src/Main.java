import java.io.FileNotFoundException;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        Simulation simulate = new Simulation();
        simulate.loadU1(simulate.loadItems());
    }
}