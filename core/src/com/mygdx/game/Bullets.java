package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bullets {
	
	public static Texture texture;
	
	Sprite sprite;

	Vector2 direction;
	
	float x,y;
	
	public boolean remove = false;
	
	public Bullets(float x, float y) {		
		direction = new Vector2();

		texture = new Texture("C:\\Users\\Robert\\Documents\\Schule\\Inf\\FireShotSprite.png");	

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
