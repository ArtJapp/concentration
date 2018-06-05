package mrth.legion.concentration1;
import java.util.*;

public class GameEngine {
    public HashMap<String, Card> cards;

    private int inRow = 4;
    private int rows = 3;
    GameEngine(int size)
    {
        cards = new HashMap<>();
        List<Integer> temp_list = new ArrayList<>();
        for (int i =0; i < size; i++){
            temp_list.add(i/2 + 1);
        }
        Collections.shuffle(temp_list);
        for (int i = 1; i <= size; i++)
        {
            Integer a = (i-1)/inRow + 1;
            Integer b = (i-1)%inRow + 1;
            String m = ""+a;
            m += ""+b;
            cards.put(m, new Card(temp_list.get(i - 1)));
        }
    }

    boolean fire(String id1, String id2)
    {
        Card a = this.cards.get(id1);
        Card b = this.cards.get(id2);
        return a.compare(b);
    }

}
