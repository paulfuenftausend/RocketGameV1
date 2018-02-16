package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Actor {

	
	Sprite ball;
	
	float movementSpeed = 3;
	
	
	public void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void movement2() //Koordiantensysteme verschoben 0,0 input = -350, -75 Sprite
	{
		
		float ballMittelX = ball.getX()+ball.getWidth()/50;
		float ballObenY = ball.getY()+ball.getHeight()/25;
		
		if((Gdx.input.getX()-350) != ballMittelX) //Bewegung zur Maus hin
		{
			if((Gdx.input.getX()-350) > ballMittelX){
				ball.translateX(movementSpeed);
			}else if((Gdx.input.getX()-350) < ballMittelX){
				ball.translateX(-movementSpeed);
			}
		}
		
		if(-1*(Gdx.input.getY()-75) != ballObenY) //Bewegung zur Maus hin
		{
			if(-(Gdx.input.getY()+75) > ballObenY){
				ball.translateY(movementSpeed);
			}else if(-(Gdx.input.getY()+75) < ballObenY){
				ball.translateY(-movementSpeed);
			}
		}
		tastenMovement();
	}
	
	public void tastenMovement() 
	{
		//Bewegung per W, A, S, D zur Korrektur 
		if (Gdx.input.isKeyPressed(Input.Keys.D))
			ball.translateX(movementSpeed);
		if (Gdx.input.isKeyPressed(Input.Keys.A))
			ball.translateX(-movementSpeed);
		if (Gdx.input.isKeyPressed(Input.Keys.W))
			ball.translateY(movementSpeed);
		if (Gdx.input.isKeyPressed(Input.Keys.S))
			ball.translateY(-movementSpeed);
		
		//Ausgabe der koordinaten von input und objekt
		if (Gdx.input.isKeyPressed(Input.Keys.ENTER))
			System.out.println(ball.getX() + " " + ball.getY());
		if (Gdx.input.isKeyPressed(Input.Keys.K))
			System.out.println(Gdx.input.getX() + " " + -(Gdx.input.getY()));
		
		//Randbegrenzung
		if (ball.getX() <= -350)
			ball.translateX(movementSpeed);
		if (ball.getX() >= 575)
			ball.translateX(-movementSpeed);	
		if (ball.getY() <= -620)
			ball.translateY(movementSpeed);
		if (ball.getY() >= -130)
			ball.translateY(-movementSpeed);
	}

}

