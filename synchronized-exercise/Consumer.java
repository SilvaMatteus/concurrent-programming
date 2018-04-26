import java.util.ArrayList;
import java.util.List;

public class Consumer implements Runnable {

    private final Data data;

    public Consumer(Data data) {
        this.data = data;
    }
    public List<Integer> history = new ArrayList<Integer>();

    public void printHistory(){
        System.out.println("Consume history:" + history.toString());
    }

    @Override
    public void run() {
        while (true) {
            if (data.peek() != -1) {
                int foo = data.pop();
                history.add(foo);
            }
        }
    }
}