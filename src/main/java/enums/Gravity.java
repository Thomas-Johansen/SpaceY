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
			return "Up";
		case LEFT:
			return "Left";
		case RIGHT:
			return "Right";
		default:
			return "Down";		
		}
	}
}

