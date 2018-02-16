package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		imgBackground = new Texture("2012-05-25 Virgo Haufen_DBE_ATWT_BN_CC_L_DONE_modified.jpg");
		imgBall = new Texture("rocket-147466_1280.png");
		imgStar = new Texture("Gold_Star.svg.png");
		imgCannon = new Texture("Angreifer.png");
		
		background = new Sprite(imgBackground);
		ball2 = new Actor();
		star = new Star();
		star2 = new Star();
		star3 = new Star();
		cannon = new Kannone();
		
		background.setPosition(
				Gdx.graphics.getWidth()/2 - background.getWidth()/2,
				Gdx.graphics.getHeight()/2 - background.getHeight()/2);
		background.setScale(0.3f);
		ball2.ball = new Sprite(imgBall);
		ball2.ball.setPosition(Gdx.graphics.getWidth()/2 - ball2.ball.getWidth()/2,
				-600);
		ball2.ball.setScale(0.05f);
		
		star.star = new Sprite(imgStar);
		star2.star = new Sprite(imgStar);
		star3.star = new Sprite(imgStar);
		
		star.star.setPosition((float) ((float)Math.random()*-(Gdx.graphics.getWidth()*0.5)), (float) ((float)Math.random()*-Gdx.graphics.getHeight()*0.6));
		star2.star.setPosition((float) ((float)Math.random()*-Gdx.graphics.getWidth()*0.5), (float) ((float)Math.random()*-Gdx.graphics.getHeight()*0.5));
		star3.star.setPosition((float) ((float)Math.random()*-Gdx.graphics.getWidth()*0.5), (float) ((float)Math.random()*-Gdx.graphics.getHeight()*0.5));
		
		star.star.setScale(0.05f);
		star2.star.setScale(0.05f);
		star3.star.setScale(0.05f);
		
	}

	@Override
	public void render () {
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.draw(batch);
		star.star.draw(batch);
		star2.star.draw(batch);
		star3.star.draw(batch);
		ball2.ball.draw(batch);	
		cannon.sprite.draw(batch);
		ball2.movement2();
		star.tastenMovement();
		star2.tastenMovement();
		star3.tastenMovement();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		imgBackground.dispose();
		imgBall.dispose();
	}
}