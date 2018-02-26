package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Actor {

	
	Sprite ball;
	
	float movementSpeed = 3;
	
	
	public void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void movement2() //Koordiantensysteme verschoben 0,0 input = -350, -75 Sprite
	{
		
		float ballMittelX = ball.getX()+ball.getWidth()/2;
		float ballObenY = ball.getY()+ball.getHeight();
		
		if((Gdx.input.getX()) != ballMittelX+movementSpeed || Gdx.input.getX() != ballMittelX-movementSpeed) //Bewegung zur Maus hin
		{
			if((Gdx.input.getX()) > ballMittelX){
				ball.translateX(movementSpeed);
			}else if((Gdx.input.getX()) < ballMittelX){
				ball.translateX(-movementSpeed);
			}
		}
		
		if(-(Gdx.input.getY()+540) != ballObenY+movementSpeed || -(Gdx.input.getY()+550) != ballObenY-movementSpeed) //Bewegung zur Maus hin
		{
			if(-(Gdx.input.getY()-540) > ballObenY){
				ball.translateY(movementSpeed);
			}else if(-(Gdx.input.getY()-540) < ballObenY){
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
		
		if (Gdx.input.isKeyPressed(Input.Keys.B))
			ball.rotate(1f);
		if (Gdx.input.isKeyPressed(Input.Keys.V))
			ball.rotate(-1f);
		
		
		//Ausgabe der koordinaten von input und objekt
		if (Gdx.input.isKeyPressed(Input.Keys.ENTER))
			System.out.println(ball.getX() + " " + ball.getY());
		if (Gdx.input.isKeyPressed(Input.Keys.K))
			System.out.println(Gdx.input.getX() + " " + -(Gdx.input.getY()));
		
		//Randbegrenzung
		if (ball.getX() <= 0)
			ball.translateX(movementSpeed);
		if (ball.getX() >= 960-ball.getWidth())
			ball.translateX(-movementSpeed);	
		if (ball.getY() <= 0)
			ball.translateY(movementSpeed);
		if (ball.getY() >= 540-ball.getHeight())
			ball.translateY(-movementSpeed);
	}
	
	public void drehen()
	{
		Vector2 input = new Vector2();
		Vector2 actor = new Vector2();
		
		actor.set(ball.getX() - ball.getWidth()/2, ball.getY()+ball.getHeight());
		input.set(Gdx.input.getX(), -(Gdx.input.getY()-540));
		
		float rotation = input.angle(actor);
		if(rotation < 0){
			rotation +=360;}
		
		ball.setRotation(rotation);
	}

}

