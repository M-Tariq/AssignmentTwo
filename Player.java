package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Player extends Thread{
    //List list = Collections.synchronizedList(new ArrayList());
private List<Card> deck=Collections.synchronizedList((List<Card>) new ArrayList<Card>());
private ArrayList<Card> pickedCard;

    public ArrayList<Card> getPickedCard() {
        return pickedCard;
    }

    @Override
    public String toString() {
        return "Deck{" + "deck=" + deck + '}';
    }

    public Player(String[] suit, int[] rank ) {
        pickedCard=new ArrayList<>();
        for (int i=0; i<suit.length; i++){
            for(int j=0; j<rank.length; j++){
                Card card=new Card(suit[i], rank[j]);
                deck.add(card);
            }
        }
    }

    public int size() {
        return deck.size();
    }

    public void shuffle() {
      Collections.shuffle(deck);
    }

    public int getRandom(){
        Random random=new Random();
        return random.nextInt(deck.size());
    }

    @Override
    public void run() {
        synchronized (deck) {
            Card card=deck.get(getRandom());
            deck.remove(card);
           pickedCard.add(card);
           // System.out.print(card+",");
        }
    }
    public void addCardList(ArrayList<Card> cards){
        deck.addAll(cards);
    }
}
