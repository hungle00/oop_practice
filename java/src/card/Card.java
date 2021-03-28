package card;

import java.util.Arrays;
import java.util.stream.Stream;

public class Card implements Comparable<Card> {

    public enum Suits {
        SPADES,
        CLUBS,
        DIAMONDS,
        HEARTS
    }
    
    public enum Values {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE, 
    }
    
    private Suits suit;
    private Values value;
    
    public Card(final Values value, final Suits suit) {
        this.value = value;
        this.suit = suit;
    }
    
    public Values getValue() {
        return value;
    }
    
    public Suits getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "Card [value=" + getValue() + ", suit=" + getSuit() + "]";
    }

    @Override
    public int compareTo(Card other) {
        if(this.getValue().compareTo(other.getValue()) == 0) {
            return this.getSuit().compareTo(other.getSuit());
        }
        return this.getValue().compareTo(other.getValue());
    }

    public static void main(String[] args) {
        Card[] cards = {
            new Card(Values.JACK, Suits.CLUBS),
            new Card(Values.ACE, Suits.CLUBS),
            new Card(Values.ACE, Suits.DIAMONDS),
            new Card(Values.NINE, Suits.SPADES),
            new Card(Values.JACK, Suits.HEARTS)
        };
        Arrays.sort(cards);
        Stream.of(cards).forEach(System.out::println);
    }
}