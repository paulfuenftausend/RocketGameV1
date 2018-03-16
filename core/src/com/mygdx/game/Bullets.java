//Klasse von Robert
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Bullets extends Sprite{
	
	Texture texture;
	
	Sprite sprite;

	Vector2 direction;
	RocketGame main;
	
	float x,y;
	
	public boolean remove = false;
	
	public Bullets(float x, float y, RocketGame main){		
		this.main = main;
		
		direction = new Vector2();

		texture = new Texture("FireShotSprite.png");	

		this.x=x;
		this.y=y;
		
		sprite = new Sprite(texture);
		sprite.setPosition(x, y);
		
	}

	public void setMovingDirection(float rotationDegrees, float length){
		direction.set(1,0);
		direction.rotate(rotationDegrees);
		direction.setLength(length);
	}
	public void update(float deltaTime){
		x += direction.x*deltaTime;
		y += direction.y*deltaTime;
		sprite.setPosition(x, y);
	}
	
}
