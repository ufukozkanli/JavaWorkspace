import java.util.Vector;

public class SetCard extends Card {

	SetCard(int rank, int suit, int shaded, int shape) {
		this.contents.add(rank);
		this.contents.add(suit);
		this.contents.add(shaded);
		this.contents.add(rank);
	}

	public SetCard(Card c) {
		chosen = c.chosen;
		matched = c.matched;
		contents = new Vector<Integer>();
		contents.addAll(c.contents);
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < contents.size(); i++) {
			s += contents.get(i);
		}
		return s;
	}
	public boolean match(Card a,Card b,Card c ) {
		 if (!((a.contents.get(0) == b.contents.get(0)) && (b.contents.get(0) == c.contents.get(0)) ||
	                (a.contents.get(0) != b.contents.get(0)) && (a.contents.get(0) != c.contents.get(0)) && (b.contents.get(0) != c.contents.get(0)))) {
	            return false;
	        }
	        if (!((a.contents.get(1) == b.contents.get(1)) && (b.contents.get(1) == c.contents.get(1)) ||
	                (a.contents.get(1) != b.contents.get(1)) && (a.contents.get(1) != c.contents.get(1)) && (b.contents.get(1) != c.contents.get(1)))) {
	            return false;
	        }
	        if (!((a.contents.get(2) == b.contents.get(2)) && (b.contents.get(2) == c.contents.get(2)) ||
	                (a.contents.get(2) != b.contents.get(2)) && (a.contents.get(2) != c.contents.get(2)) && (b.contents.get(2) != c.contents.get(2)))) {
	            return false;
	        }
	        if (!((a.contents.get(3) == b.contents.get(3)) && (b.contents.get(3) == c.contents.get(3)) ||
	                (a.contents.get(3) != b.contents.get(3)) && (a.contents.get(3) != c.contents.get(3)) && (b.contents.get(3) != c.contents.get(3)))) {
	            return false;
	        }
	        return true;
	}
}
