public class IskambilDeck extends Deck {
	IskambilDeck(int repeat) {
		for (int c = 0; c < repeat; c++) {
			for (int i = 10; i <= 13; i++) {
				for (int j = 0; j < 3; j++) {
					IskambilCard sc = new IskambilCard(i, j);
					addCard(sc);
				}
			}
		}
	}
}
