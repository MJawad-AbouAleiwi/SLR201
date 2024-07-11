import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        List<Fork> forks = new ArrayList<>();

        for(int i=0; i<5; ++i) 
        {
            forks.add(new Fork());
        }

        for(int j=0; j<5; ++j) {
            Fork left = forks.get(j);
            Fork right = forks.get((j+1)%5);
            // to break the deadlock that may occur, we need to break up the circular wait;
            // so the last philosopher will acquire the right instead of the first.
            if(j==5-1) {
                new Philosopher(j+1, right, left);
            } else {
                new Philosopher(j+1, left, right);
            }
        }

    }
}
