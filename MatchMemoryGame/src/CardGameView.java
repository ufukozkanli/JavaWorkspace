import java.util.Vector;

public class CardGameView {

	CardGameController cont;

	CardGameView(CardGameController cont) {
		this.cont = cont;
	}

	public void updateGUI(Vector<Card> cards, int score, int tryCount) {
		System.out.println(String
				.format("Score:%d in %d Try:", score, tryCount));
		for (Card card : cards) {
			if (card.matched)
				System.out.print(card);
			else if (card.chosen)
				System.out.print("?");
			else
				System.out.print("*");
			System.out.print(" ");
		}
		System.out.println();
	}
}
