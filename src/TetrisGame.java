import javax.swing.*;

public class TetrisGame extends JFrame {

	public TetrisGame(){
		setTitle("Tetris");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLocationRelativeTo(null);
		setResizable(false);

		TetrisBoard board = new TetrisBoard();
		add(board);

		setVisible(true);


	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			new TetrisGame().setVisible(true);
		});
	}

}
