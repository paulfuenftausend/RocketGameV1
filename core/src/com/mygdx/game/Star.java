package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Star {
	
	Sprite star;

	float movementSpeed = 2;
	public void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void tastenMovement() 
	{
		//Bewegung per W, A, S, D zur Korrektur 
		if (Gdx.input.isKeyPressed(Input.Keys.D))
			star.translateX(movementSpeed);
		if (Gdx.input.isKeyPressed(Input.Keys.A))
			star.translateX(-movementSpeed);
		if (Gdx.input.isKeyPressed(Input.Keys.W))
			star.translateY(movementSpeed);
		if (Gdx.input.isKeyPressed(Input.Keys.S))
			star.translateY(-movementSpeed);
		
		//Ausgabe der koordinaten von input und objekt
		if (Gdx.input.isKeyPressed(Input.Keys.I))
			System.out.println(star.getX() + " " + star.getY());
		if (Gdx.input.isKeyPressed(Input.Keys.O))
			star.setPosition((float) ((float)Math.random()*-(Gdx.graphics.getWidth()*0.55)), (float) ((float)Math.random()*-Gdx.graphics.getHeight()*0.75));
		
		//Randbegrenzung
		if (star.getX() <= 0)
			star.translateX(movementSpeed);
		if (star.getX() >= 940)
			star.translateX(-movementSpeed);	
		if (star.getY() <= 0)
			star.translateY(movementSpeed);
		if (star.getY() >= 540-star.getHeight())
			star.translateY(-movementSpeed);
	}

}
