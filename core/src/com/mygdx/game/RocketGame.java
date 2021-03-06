//Shooting von Robert, der Rest von Paul
package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class RocketGame extends ApplicationAdapter {
SpriteBatch batch;
	
	Texture imgBackground;
	Texture imgBall;
	Texture imgStar;
	Texture imgCannon;
	
	Sprite background;
	
	Actor ball2;
	
	Star star;
	Star star2;
	Star star3;
	
	Kannone cannon;
	
	Bullets bullet;
	
	World world;
	
	//Shooting
		ArrayList<Bullets> bullets;
		Vector2 vector;
		float fireRate = 400000000;
		float lastShoot;
		
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		imgBackground = new Texture("2012-05-25 Virgo Haufen_DBE_ATWT_BN_CC_L_DONE_modified.jpg");
		imgBall = new Texture("SpaceShip Sprite.png");
		imgStar = new Texture("SpaceGem Sprite.png");
		imgCannon = new Texture("Turret Sprite.png");
		
		background = new Sprite(imgBackground);
		world = new World(new Vector2(0,0), true);
		ball2 = new Actor(world);
		star = new Star(world);
		cannon = new Kannone();
		//Array for bullets
		bullets = new ArrayList<Bullets>();
		vector = new Vector2();
		
		
		background.setPosition(
				Gdx.graphics.getWidth()/2 - background.getWidth()/2,
				Gdx.graphics.getHeight()/2 - background.getHeight()/2);
		background.setScale(0.3f);
		
		ball2.ball = new Sprite(imgBall);
		//ball2.body.setTransform(Gdx.graphics.getWidth()/2 - ball2.ball.getWidth()/2, 0, 90);
		ball2.ball.setPosition(Gdx.graphics.getWidth()/2 - ball2.ball.getWidth()/2, 0);
		
		
		star.star = new Sprite(imgStar);	
		star.star.setPosition(50,50);		
		star.star.setScale(2f);
		
		
		cannon.sprite = new Sprite(imgCannon);
		cannon.sprite.setPosition(0-cannon.sprite.getWidth()/2, Gdx.graphics.getHeight()/2-cannon.sprite.getHeight()/2);
		cannon.sprite.setOrigin(cannon.sprite.getOriginX()-(cannon.sprite.getWidth()/8), cannon.sprite.getOriginY());	
		cannon.sprite.setScale(4f);
		
	}

	@Override
	public void render () {
		
		//PoerUps
		if(Gdx.input.isKeyPressed(Keys.NUM_1)) {
			powerUp = 1;
			powerUpBegin = System.nanoTime();
		}
		else if(Gdx.input.isKeyPressed(Keys.NUM_2)) {
				fireRate = 300000000;
				powerUpBegin = System.nanoTime();
		}
		else {
			if(System.nanoTime() - powerUpBegin >= powerUpTime ) {
				powerUp = 0;
				fireRate = 400000000;
			}	
			
		}
			
		//Shooting code
		vector.set(1,0);
		vector.rotate(cannon.sprite.getRotation());
		vector.setLength(cannon.sprite.getWidth()*2);
		if(Gdx.input.isKeyPressed(Keys.SPACE)){
			switch(powerUp) {
			case 0:
				if(System.nanoTime()-lastShoot >= fireRate) {
					Bullets bullet = new Bullets((0-(cannon.sprite.getWidth()/8))+vector.x,255+vector.y);
							
					bullet.setMovingDirection(cannon.sprite.getRotation(), (5*cannon.sprite.getWidth())/8);
					bullet.sprite.setRotation(cannon.sprite.getRotation());
					bullet.update(Gdx.graphics.getDeltaTime());
					bullets.add(bullet);
					lastShoot= System.nanoTime();
				}
					break;
			case 1:
				if(System.nanoTime()-lastShoot >= fireRate) {
					Bullets bullet = new Bullets((0-(cannon.sprite.getWidth()/8))+vector.x,255+vector.y);
							
					bullet.setMovingDirection(cannon.sprite.getRotation(), (5*cannon.sprite.getWidth())/8);
					bullet.sprite.setRotation(cannon.sprite.getRotation());
					bullet.update(Gdx.graphics.getDeltaTime());
					bullets.add(bullet);
							
					Bullets bullet1 = new Bullets((0-(cannon.sprite.getWidth()/8))+vector.x,255+vector.y);
					
					bullet1.setMovingDirection(cannon.sprite.getRotation()+10, (5*cannon.sprite.getWidth())/8);
					bullet1.sprite.setRotation(cannon.sprite.getRotation()+10);
					bullet1.update(Gdx.graphics.getDeltaTime()+10);
					bullets.add(bullet1);
							
			 		Bullets bullet2 = new Bullets((0-(cannon.sprite.getWidth()/8))+vector.x,255+vector.y);
							
					bullet2.setMovingDirection(cannon.sprite.getRotation()-10, (5*cannon.sprite.getWidth())/8);
					bullet2.sprite.setRotation(cannon.sprite.getRotation()-10);
					bullet2.update(Gdx.graphics.getDeltaTime());
					bullets.add(bullet2);
					lastShoot= System.nanoTime();
					break;
			}
			}
		}
				
						
		//Update and remove bullets
		for(Bullets bullet : bullets){
			if(bullet.remove == true) {
				removeBullets.add(bullet);
			}
			else {
				bullet.update(Gdx.graphics.getDeltaTime());
				
			}
		}
		bullets.removeAll(removeBullets);
		removeBullets.clear();
		System.out.println(removeBullets);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		
		background.draw(batch);
		star.star.draw(batch);
		cannon.sprite.draw(batch);
		ball2.ball.draw(batch);	
		
		ball2.doStuff();
		star.doStuff();
		
		cannon.drehen();
		
		//render bullets
		for(Bullets bullet : bullets){
			bullet.sprite.draw(batch);
		}
		
		world.step(Gdx.graphics.getDeltaTime(), 1, 1);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		imgBackground.dispose();
		imgBall.dispose();
		imgCannon.dispose();
		imgStar.dispose();
	}
}