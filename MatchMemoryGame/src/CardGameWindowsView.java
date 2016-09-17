import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class CardGameWindowsView extends JFrame {
	CardGameController cont;
	Vector<JButton> buttons;
	JLabel lblNewLabel;
	JButton btnRestart;
	private JPanel contentPane;

	int rowElc = 4;

	public void updateGUI(Vector<Card> cards, int score, int tryCount,
			boolean isFinished, Card lastSelectedCard) {
		btnRestart.setVisible(false);
		if (buttons.size() == 0) {
			for (int i = 0; i < cards.size(); i++) {
				JButton btn = new JButton("*");
				btn.addActionListener(cont);
				btn.setBounds((i % rowElc) * 90, 90 * (i / rowElc), 80, 80);
				btn.setBackground(Color.gray);
				Image image;
				try {
					image = ImageIO.read(new File("C:/Users/Ufuk/Desktop/3_Clubs.bmp"));
					ImageIcon icon = new ImageIcon(image);					
					btn.setIcon(icon);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(getClass().getResource("/resources/remapped.bmp"));
				
				buttons.add(btn);
				contentPane.add(btn);
			}

		} else {
			for (int i = 0; i < cards.size(); i++) {
				Card c = cards.get(i);
				JButton b = buttons.get(i);

				if (c.matched || c.chosen) {
					String s = c.toString();
					String[] ct = s.split("-");

					if (Integer.parseInt(ct[1]) == 0)
						b.setBackground(Color.RED);
					else if (Integer.parseInt(ct[1]) == 1)
						b.setBackground(Color.GREEN);
					else if (Integer.parseInt(ct[1]) == 2)
						b.setBackground(Color.BLUE);

					if (Integer.parseInt(ct[0]) == 1)
						b.setText("A");
					else if (Integer.parseInt(ct[0]) == 11)
						b.setText("J");
					else if (Integer.parseInt(ct[0]) == 12)
						b.setText("K");
					else if (Integer.parseInt(ct[0]) == 13)
						b.setText("Q");
					else
						b.setText(ct[0]);

				} else {
					b.setBackground(Color.GRAY);
					b.setText("*");
				}

			}
		}
		lblNewLabel.setText(String.format("Score:%d, Try:%d L %s", score,
				tryCount, lastSelectedCard));
		if (isFinished) {
			btnRestart.setVisible(true);
		}
		this.repaint();
	}

	/**
	 * Create the frame.
	 */
	public CardGameWindowsView(CardGameController cont) {
		this.cont = cont;
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(421, 11, 177, 248);
		contentPane.add(lblNewLabel);

		btnRestart = new JButton("Restart");
		btnRestart.setVisible(false);
		btnRestart.setMnemonic('R');
		btnRestart.setBounds(471, 281, 127, 116);
		btnRestart.addActionListener(cont);
		contentPane.add(btnRestart);

		buttons = new Vector<JButton>();
	}
}
