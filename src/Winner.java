import java.util.HashMap;

public class Winner {

	public static String prepareWinnerCombo(int winCombination, char turn) {
		StringBuilder combo = new StringBuilder();
		for (int i = 1; i <= winCombination; i++) {
			combo.append(turn);

		}
		return combo.toString();
	}

	public static boolean checkIfGameEnds(int winCombination, int columnSize, int rowSize, char turn, int row,
			int column, HashMap<Integer, HashMap<Integer, Character>> colToRowMap,
			HashMap<Integer, HashMap<Integer, Character>> rowToColMap) {

		// winCombination
		String winningCombination = prepareWinnerCombo(winCombination, turn);

		// checkHorizontal
		StringBuilder rowOutput = new StringBuilder();
		HashMap<Integer, Character> rowValueMap = colToRowMap.get(column);
		for (int i = 1; i <= columnSize; i++) {
			if (rowValueMap.get(i) != null) {
				rowOutput.append(rowValueMap.get(i));
			} else {
				rowOutput.append('~');
			}

		}

		if (rowOutput.toString().contains(winningCombination)) {
			System.out.println("Found Match in column");
			return true;
		}

		// checkVertical
		StringBuilder colOutput = new StringBuilder();
		HashMap<Integer, Character> colValueMap = rowToColMap.get(row);
		for (int i = 1; i <= rowSize; i++) {
			if (colValueMap.get(i) != null) {
				colOutput.append(colValueMap.get(i));
			} else {
				colOutput.append('~');
			}

		}
		if (colOutput.toString().contains(winningCombination)) {
			System.out.println("Found Match in row");
			return true;
		}

		return false;
	}
}
