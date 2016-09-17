import java.util.Vector;

public abstract class Card {

	// protected String contents;
	protected Vector<Integer> contents;
	protected boolean chosen;
	protected boolean matched;

	Card() {
		contents = new Vector<Integer>();
	}

	public boolean match(Card c) {
		if (contents.size() != c.contents.size())
			return false;
		boolean eqCnt = true;

		for (int i = 0; i < contents.size(); i++) {
			if (!contents.get(i).equals(c.contents.get(i))) {
				eqCnt = false;
				break;
			}
		}
		// System.out.println("eq="+eqCnt);
		return eqCnt;
	}

	int match(Vector<Card> set) {
		Vector<Card> vc = new Vector<Card>();
		vc.addAll(set);
		vc.add(this);

		int mtc = 0;
		for (int i = 0; i < vc.size(); i++) {
			for (int j = i + 1; j < vc.size(); j++) {
				if (vc.get(i) == vc.get(j))
					continue;
				if (vc.get(i).match(vc.get(j))) {
					mtc += 1;
				}
			}
		}
		return mtc;
	}

	public boolean IsChoosen() {
		return chosen;
	}

	public boolean IsMatched() {
		return matched;
	}

	public String toString() {
		return "-";
	}
}
