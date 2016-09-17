import java.util.Vector;

public class SetCardGame extends CardGame {
	int cardCount;

	SetCardGame(int openingCardCount, int cardCount) {
		super(new SetCardDeck(cardCount), openingCardCount);
		maxOpenedCardCount = openingCardCount;
		this.cardCount = cardCount;
	}

	@Override
	public Vector<Card> getAllCard() {

		Vector<Card> all = new Vector<Card>();
		for (Card card : this.getCards()) {
			Card c;
			c = new SetCard(card);
			all.add(c);
		}
		return all;
	}

	@Override
	public boolean allCardOpened() {
		int count = 0;
		Vector<Card> v = this.getCards();
		for (int i = 0; i < v.size(); i++) {
			if (!v.get(i).matched)
				count++;
		}
		return count <= 3;
	}
}
