import java.util.Arrays;
import java.util.Stack;

public class Tower {
    Stack<Disk> tower = new Stack<>();

    public void push(Disk _disk) {
        if(_disk != null) {
            tower.push(_disk);
        }
    }

    public Disk pop() {
        return tower.pop();
    }

    public Disk peek() {
        return tower.peek();
    }

    @Override
    public String toString() {
        return Arrays.toString(tower.toArray());
    }

    public int getCount() {
        return tower.size();
    }
}
