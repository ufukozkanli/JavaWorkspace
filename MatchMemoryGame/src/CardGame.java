import java.util.Vector;

public abstract class CardGame {

	private Vector<Card> vc;
	private Vector<Card> chosenCards;
	int maxOpenedCardCount, score;
	public int tryCount;

	CardGame(Deck d, int cardCount) {
		vc = new Vector<Card>();
		chosenCards = new Vector<Card>();
		Card draw;
		while ((draw = d.drawRandomCard()) != null) {
			vc.add(draw);
			if (vc.size() == cardCount)
				break;
		}
	}

	public abstract boolean allCardOpened();

	public Vector<Card> getCards() {
		return vc;
	}

	public Card chooseCard(int index, Vector<Card> selcard) {
		if (!allCardOpened()) {

			if (index > vc.size() || index < 0) {
				System.out.println("Index out of range");
				return null;
			}
			Card c = vc.get(index);
			c.chosen = true;
			if (chosenCards.contains(c)) {
				System.out.println("Already chosen again?");
				c.chosen = false;
				chosenCards.remove(c);

				return null;
			} else if (c.matched) {
				System.out.println("Already matched again?");
				return null;
			} else
				chosenCards.add(c);
			checkMatch();
			return c;
		}

		return null;

	}

	public void checkMatch() {
		if (chosenCards.size() == maxOpenedCardCount) {
			tryCount++;
			int matchCount = chosenCards.firstElement().match(chosenCards);
			if (matchCount > 1) {
				for (Card card : chosenCards) {
					card.matched = true;
				}
				score += maxOpenedCardCount;
			} else {
				for (Card card : chosenCards) {
					card.chosen = false;
				}
				score -= 1;
			}
			chosenCards.clear();
		}
	}

	public abstract Vector<Card> getAllCard();

}
