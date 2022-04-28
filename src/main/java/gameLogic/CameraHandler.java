package gameLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

import Objects.Player;
import SpaceY.PlatformGame;
import enums.Gravity;

public class CameraHandler  {
	private float xAxis;
	private float yAxis;
	
	public CameraHandler(Player player){
		xAxis = player.getX();
		yAxis = player.getY(); //+ 200 / PlatformGame.PPM;
	}
	
	
	public OrthographicCamera Update(OrthographicCamera camera, Player player, GravityHandler gravity) {
		Gravity switchGrav; 
		if (gravity.playerToggle) switchGrav = gravity.playerGravity; else switchGrav = gravity.worldGravity;
		//Rotation
		switch (switchGrav) {
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
	
	//Multiplayer camera
	public OrthographicCamera Update(OrthographicCamera camera, Player player, Player player2, GravityHandler gravity) {
		camera.position.x = (player.getX() + player2.getX()) / 2;
		camera.position.y = (player.getY() + player2.getY()) / 2;
		
		float playerDistanceX = (Math.abs(player.getX()- player2.getX()));
		float playerDistanceY = (Math.abs(player.getY()- player2.getY()));
		//double playerDistance = Math.sqrt(Math.pow(player.getX()- player2.getX(),2) + Math.pow(player.getY()- player2.getY(),2));
		if (playerDistanceY > (300 / PlatformGame.PPM)) {
			camera.zoom =  (playerDistanceY / (300 / PlatformGame.PPM));
		} else if (playerDistanceX > (400 / PlatformGame.PPM)){
			camera.zoom =  (playerDistanceX / (400 / PlatformGame.PPM));
		} else camera.zoom = 1;
		if (camera.zoom > 5) camera.zoom = (float) 5; 
		return camera;	
	}
	
}
