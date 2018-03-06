package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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
	
	World world;
	
	
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