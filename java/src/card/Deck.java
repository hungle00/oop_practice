package card;

import card.Card.Suits;
import card.Card.Values;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    static ArrayList<Card> cards = new ArrayList<Card>();

    public static void add() {
        for (Suits s : Suits.values()) {
            for (Values v : Values.values()) {
                cards.add(new Card(v, s));
            }
        }
    }

    public static void swapCards(int i, int j) {
        Card temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
    }

    /**
     * Randomly permute the cards.
     */
    public static void shuffle() {
        Random random = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swapCards(i, j);
            //Card temp = cards.get(i);
            //cards.set(i, cards.get(j));
            //cards.set(j, temp);
        }
    }

    public static void main(String args[]) {
        add();
        shuffle();
        cards.forEach(System.out::println);
        System.out.println(cards.size());
    }
}
