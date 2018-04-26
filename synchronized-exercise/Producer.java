import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Producer implements Runnable {

    private Data data;

    public Producer(Data data) {
        this.data = data;
    }
    public List<Integer> history = new ArrayList<Integer>();

    public void printHistory(){
        System.out.println("Produce history:" + history.toString());
    }

    @Override
    public void run() {
        while (true) {
            while (data.peek() != -1) {
                try {
                    Thread.sleep(new Random().nextInt(101));

                } catch (InterruptedException e) { }
            }
            int value = new Random().nextInt(11);
            this.data.put(value);
            history.add(value);
        }
    }
}
