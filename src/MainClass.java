import java.util.HashMap;
import java.util.Scanner;

public class MainClass {

	public static HashMap<Integer, HashMap<Integer, Character>> rowToColMap = new HashMap<>();
	public static HashMap<Integer, HashMap<Integer, Character>> colToRowMap = new HashMap<>();

	public static int rowSize = 5;
	public static int colSize = 5;
	public static int winCombination = 3;
	public static int totalCount = rowSize * colSize;

	public static void main(String args[]) {
		int play = 1;
		int moves = 0;
		char turn = 'b';
		Scanner scan = new Scanner(System.in);

		while (moves < totalCount && play == 1) {
			turn = Turn.getNextTurn(turn);
			System.out.println("Now it is turn of =" + turn);

			System.out.println("Enter the column number.");
			int column = Integer.parseInt(scan.nextLine());

			if (!Board.isColNumberValid(column, colSize)) {
				System.out.println("Column number = " + column + "  is invalid. Try again");
				turn = Turn.getNextTurn(turn);
				continue;
			}

			if (Board.isBoardColumnFull(colToRowMap, column, rowSize)) {
				System.out.println("Column number = " + column + "  is full. Try again");
				turn = Turn.getNextTurn(turn);
				continue;
			}

			int row = Board.addBallToBoard(rowSize, turn, column, colToRowMap, rowToColMap);

			System.out.println("Ball added at row=" + row + " col=" + column);

			if (Winner.checkIfGameEnds(winCombination, colSize, rowSize, turn, row, column, colToRowMap, rowToColMap)) {

				Board.displayBoardOutput(colSize, rowSize, rowToColMap);

				System.out.println(turn + " is the winner. Game ends");

				return;
			}

			Board.displayBoardOutput(colSize, rowSize, rowToColMap);

			System.out.println("Do you want to continue(1 for yes)");
			play = Integer.parseInt(scan.nextLine());
			++moves;
		}

		scan.close();

	}
}
