package gameLogic;

import com.badlogic.gdx.graphics.OrthographicCamera;

import Objects.Player;
import inf112.skeleton.app.PlatformGame;

public class CameraHandler  {
	private float xAxis;
	private float yAxis;
	
	public CameraHandler(Player player){
		xAxis = player.getX();
		yAxis = player.getY(); //+ 200 / PlatformGame.PPM;
	}
	
	
	public OrthographicCamera Update(OrthographicCamera camera, Player player, GravityHandler gravity) {
		
		//Rotation
		switch (gravity.playerGravity) {
		case DOWN:
			camera.up.set(0,1,0);
			break;
		case UP:
			camera.up.set(0,1,0);
			camera.rotate(180);
			break;
		case LEFT:
			camera.up.set(0,1,0);
			camera.rotate(90);
			break;
		case RIGHT:
			camera.up.set(0,1,0);
			camera.rotate(270);
			break;
		}
		
		
		//Position
		switch (gravity.playerGravity) {
		case DOWN:
		case UP:
			camera.position.x = player.getX();
			while(player.getY() > yAxis + (100 / PlatformGame.PPM)){
				yAxis += (1 / PlatformGame.PPM);
			}
			while(player.getY() < yAxis - (100 / PlatformGame.PPM)) {
				yAxis -= (1 / PlatformGame.PPM);
			}
			camera.position.y = yAxis;
			
			break;
		case LEFT:
		case RIGHT:
			while(player.getX() > xAxis + (100 / PlatformGame.PPM)){
				xAxis += (1 / PlatformGame.PPM);
			}
			while(player.getX() < xAxis - (100 / PlatformGame.PPM)) {
				xAxis -= (1 / PlatformGame.PPM);
			}
			camera.position.x = xAxis;
			camera.position.y = player.getY();
			break;
		}
		return camera;
	}
	
}
