
public class Turn {

	public static char getNextTurn(char currentTurn) {
		
		switch (currentTurn) {
		case 'a':
			return 'b';

		case 'b':
			return 'a';

		default:
			return currentTurn;
		}
	}
}
