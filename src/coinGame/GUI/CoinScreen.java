/**
 * Coin-toss game with win-loss count.
 * @author Natalie Williams
 * @version 1.4
 */
package coinGame.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import java.awt.Color;
import javax.swing.border.EtchedBorder;

import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class CoinScreen {
	private Random randGen = new Random();
	private int coinFace;	// Which face is facing up. 0 = Heads 1 = Tails
	private int wins = 0;	// Number of times the player won.
	private int losses = 0;	// Number of times the player lost.

	private JFrame frmCoinGame;
	private JButton btnHeads;
	private JButton btnTails;
	private JTextArea txtrHeadsOrTails;
	private JLabel lblCoin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoinScreen window = new CoinScreen();
					window.frmCoinGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CoinScreen() {
		initialize();
		eventHandler();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	// EVENT HANDLER
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Handles events.
	 */
	private void eventHandler() {
		btnHeads.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coinFace = randGen.nextInt(2);
				
				switch (coinFace) {
					case 0:
						lblCoin.setIcon(new ImageIcon(CoinScreen.class.getResource("/CoinGame/Images/Coin 1 Heads.jpg")));
						txtrHeadsOrTails.append("\nYou win!");
						++wins;
						txtrHeadsOrTails.append("\nWins = " + wins + " Losses = " + losses);
						break;
						
					case 1:
						lblCoin.setIcon(new ImageIcon(CoinScreen.class.getResource("/CoinGame/Images/Coin 1 Tails.jpg")));
						txtrHeadsOrTails.append("\nYou lose...");
						++losses;
						txtrHeadsOrTails.append("\nWins = " + wins + " Losses = " + losses);
						break;
				}
			}
		});
		
		btnTails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coinFace = randGen.nextInt(2);
				
				switch (coinFace) {
					case 0:
						lblCoin.setIcon(new ImageIcon(CoinScreen.class.getResource("/CoinGame/Images/Coin 1 Heads.jpg")));
						txtrHeadsOrTails.append("\nYou lose...");
						++losses;
						txtrHeadsOrTails.append("\nWins = " + wins + " Losses = " + losses);
						break;
						
					case 1:
						lblCoin.setIcon(new ImageIcon(CoinScreen.class.getResource("/CoinGame/Images/Coin 1 Tails.jpg")));
						txtrHeadsOrTails.append("\nYou win!");
						++wins;
						txtrHeadsOrTails.append("\nWins = " + wins + " Losses = " + losses);
						break;
				}
			}
		});
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	// INITIALIZER
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCoinGame = new JFrame();
		frmCoinGame.setIconImage(Toolkit.getDefaultToolkit().getImage(CoinScreen.class.getResource("/coinGame/Images/Coin 1 Heads.jpg")));
		frmCoinGame.setTitle("Coin Game");
		frmCoinGame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frmCoinGame.setBounds(100, 100, 935, 734);
		frmCoinGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnHeads = new JButton("Heads");
		
		btnTails = new JButton("Tails");
		
		JPanel pnlCoinView = new JPanel();
		pnlCoinView.setBackground(Color.BLACK);
		pnlCoinView.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout groupLayout = new GroupLayout(frmCoinGame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(116)
					.addComponent(btnHeads, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 386, Short.MAX_VALUE)
					.addComponent(btnTails, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(120))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnlCoinView, GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnlCoinView, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnHeads)
						.addComponent(btnTails))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		lblCoin = new JLabel("");
		lblCoin.setIcon(new ImageIcon(CoinScreen.class.getResource("/coinGame/Images/Coin 1 Heads.jpg")));
		GroupLayout gl_pnlCoinView = new GroupLayout(pnlCoinView);
		gl_pnlCoinView.setHorizontalGroup(
			gl_pnlCoinView.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlCoinView.createSequentialGroup()
					.addContainerGap(315, Short.MAX_VALUE)
					.addComponent(lblCoin, GroupLayout.PREFERRED_SIZE, 562, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_pnlCoinView.setVerticalGroup(
			gl_pnlCoinView.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCoinView.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCoin, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnlCoinView.setLayout(gl_pnlCoinView);
		
		txtrHeadsOrTails = new JTextArea();
		txtrHeadsOrTails.setText("Heads or Tails?");
		txtrHeadsOrTails.setFont(new Font("Monospaced", Font.PLAIN, 20));
		scrollPane.setViewportView(txtrHeadsOrTails);
		frmCoinGame.getContentPane().setLayout(groupLayout);
	}
}
