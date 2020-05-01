package model;
public class Card implements Comparable<Card>{
    private String suit;
    private int rank;

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }
    public Card() {
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return  rank + suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }



    @Override
    public int compareTo(Card o) {
        return this.getRank()-o.getRank();
    }
}