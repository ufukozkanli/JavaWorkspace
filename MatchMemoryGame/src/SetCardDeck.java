public class SetCardDeck extends Deck {
	SetCardDeck(int repeat) {
		for (int c = 0; c < repeat; c++) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						for (int m = 0; m < 3; m++) {
							SetCard sc = new SetCard(i, j, k, m);
							addCard(sc);
						}
					}
				}
			}
		}
	}
}
