import java.util.Random;
import java.util.Vector;

public class Deck {
	Vector<Card> cards;

	Deck()
	{
		cards=new Vector<Card>();
	}
	
	protected void addCard(Card c) {
		cards.add(c);
	}

	public Card drawRandomCard() {
		if(cards.size()==0)
			return null;
		int rand = new Random().nextInt(cards.size());
		Card draw = cards.get(rand);
		cards.remove(draw);
		return draw;
	}
}
