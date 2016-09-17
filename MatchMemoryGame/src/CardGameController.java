import java.awt.event.*;
import java.io.IOException;
import java.util.*;

import javax.swing.*;

public class CardGameController implements ActionListener {
	static boolean debug = true;
	CardGame model;
	// CardGameView view;
	Scanner sc;
	Card lastSelectedCard;

	CardGameWindowsView viewGui;

	CardGameController(char opc) {
		if (opc == 'a')
			model = new IskambilCardGame(2, 9*2);
		else
			model = new SetCardGame(2, 27);

		// view = new CardGameView(this);
		viewGui = new CardGameWindowsView(this);
		viewGui.setVisible(true);
		updateView();
		sc = new Scanner(System.in);
	}

	public void updateView()  {
		Vector<Card> list = model.getAllCard();
		// view.updateGUI(list, model.score, model.tryCount);
		viewGui.updateGUI(list, model.score, model.tryCount,
				model.allCardOpened(), lastSelectedCard);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();

		if (btn == viewGui.btnRestart) {
			// model.restart();
			model = new IskambilCardGame(2, 10);
			updateView();
			return;
		}
		int index = viewGui.buttons.indexOf(btn);
		Vector<Card> vc = new Vector<Card>();
		lastSelectedCard = model.chooseCard(index, vc);
		updateView();

	}

	public int getInput() {
		int index;
		if (debug) {
			index = new Random().nextInt(model.getCards().size());
			System.out.println(index);
		} else
			index = sc.nextInt();
		return index;
	}

	public static void main(String[] args) {

		System.out.println("For game Iskambil press a\n"
				+ "For game SetCard press b");
		char opc;
		if (!debug) {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			opc = sc.nextLine().charAt(0);
		} else {
			opc = 'b';
		}
		CardGameController cgc = new CardGameController(opc);

		System.out.println(opc);
		/*
		 * while (!cgc.model.allCardOpened()) { int index = cgc.getInput();
		 * cgc.model.chooseCard(index); cgc.updateView(); }
		 */
	}
}
