package enums;

public enum Gravity {
	DOWN,
	UP,
	LEFT,
	RIGHT;
	
	public static String convertGravity(Gravity gravity) {
		switch(gravity) {
		case DOWN:
			return "Down";
		case UP:
			return "UP";
		case LEFT:
			return "LEFT";
		case RIGHT:
			return "RIGHT";
		default:
			return "Down";		
		}
	}
}

