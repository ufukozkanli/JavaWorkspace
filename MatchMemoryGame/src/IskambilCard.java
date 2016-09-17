import java.util.Vector;

public class IskambilCard extends Card {

	IskambilCard(int rank, int suit) {

		contents.add(rank);
		contents.add(suit);
	}

	public IskambilCard(Card c) {
		chosen = c.chosen;
		matched = c.matched;
		contents = new Vector<Integer>();
		contents.addAll(c.contents);
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < contents.size(); i++) {
			s += contents.get(i) + "-";
		}
		return s;// String.format("IskambilCard:%s",s);
	}
}
