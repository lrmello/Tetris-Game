import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TetrisBoard extends JPanel implements ActionListener {

	private final int BOARD_WIDTH = 10;
	private final int BOARD_HEIGHT = 22;
	private final int SQUARE_SIZE = 30;

	private Timer timer;
	private boolean isFallingFinished = false;
	private boolean isPaused = false;
	private int curX = 0;
	private int curY = 0;


	private final int ROWS = 20;
	private final int COLS = 10;
	private final int CELL_SIZE = 30;
	private final Color[][] board = new Color[ROWS][COLS];
	private final TetrisController controller;

	public TetrisBoard(){
		setPreferredSize(new Dimension(COLS * CELL_SIZE,ROWS *CELL_SIZE));
		setBackground(Color.BLACK);
		setFocusable(true);

		timer = new Timer(400,this);
		timer.start();

		controller = new TetrisController();
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(isFallingFinished){
			isFallingFinished = false;
			newPiece();
		}else{
			moveDown();
		}
	}

	private void moveDown(){
		if(!tryMove(curX, curY -1)){
			pieceDropped();
		}
	}

	private void newPiece(){
		curX = BOARD_WIDTH / 2;
		curY = BOARD_HEIGHT - 1;
	}

	private boolean tryMove(int newX, int newY){
		return true;
	}

	private void pieceDropped(){
		isFallingFinished = true;
		newPiece();
	}

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		drawBoard(g);
		drawPiece(g);
	}

	private void drawBoard(Graphics g){
		for(int r = 0; r < ROWS;r++){
			for(int c = 0; c < COLS; c++){
				drawCell(g,r,c,board[r][c]);
			}
		}
	}

	private void drawPiece(Graphics g){
		TetrisPiece currentPiece = controller.getCurrentPiece();
		int currentX = controller.getCurrentX();
		int currentY = controller.getCurrentY();

		if(currentPiece != null){
			int [][] shape = currentPiece.getShape();
			Color color = currentPiece.getColor();

			for (int r = 0; r < shape.length; r++){
				for(int c =0; c < shape[0].length;c++){
					if(shape[r][c] == 1){
						int x = (currentX + c) * CELL_SIZE;
						int y = (currentY + r) * CELL_SIZE;
						drawCell(g,y,x,color);
					}
				}
			}
		}

	}

	private void drawCell(Graphics g, int r, int c, Color color){
		if (color != null){
			g.setColor(color);
			g.fillRect(c * CELL_SIZE, r*CELL_SIZE,CELL_SIZE,CELL_SIZE);
			g.setColor(color.darker());
			g.drawRect(c * CELL_SIZE, r * CELL_SIZE,CELL_SIZE,CELL_SIZE);

		}
	}
}
