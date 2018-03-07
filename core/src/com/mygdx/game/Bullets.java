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
	public void Shoot(){
		//Shooting code
				main.vector.set(1,0);
				main.vector.rotate(main.cannon.sprite.getRotation());
				main.vector.setLength(main.cannon.sprite.getWidth()*2);
				if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
					if(System.nanoTime()-main.lastShoot >= main.fireRate) {
						Bullets bullet = new Bullets((0-(main.cannon.sprite.getWidth()/8))+main.vector.x,255+main.vector.y, main);
							
						setMovingDirection(main.cannon.sprite.getRotation(), (5*main.cannon.sprite.getWidth())/8);
						sprite.setRotation(main.cannon.sprite.getRotation());
						update(Gdx.graphics.getDeltaTime());
						main.bullets.add(bullet);
						main.lastShoot = System.nanoTime();
					}
				}
						
				//Update bullets
				for(Bullets bullet : main.bullets){
					bullet.update(Gdx.graphics.getDeltaTime());
				}
	}
}
