package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;



public class Kannone {
	
	Sprite sprite;

	public void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
		/*setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(),sprite.getHeight());
		sprite.setPosition(0-sprite.getWidth()/2, 400-(sprite.getHeight()/2));
		sprite.setOrigin(sprite.getOriginX()-(sprite.getWidth()/8), sprite.getOriginY());*/
		
	/*	this.addListener(new InputListener() {
			@Override
			public boolean keyDown(InputEvent event, int keycode) {*/
		public void drehen()
		{
				if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
					if(sprite.getRotation()<77f) {
						sprite.rotate(2f);
					}
				}
				
				if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
					if(sprite.getRotation()>-77f) {
						sprite.rotate(-2f);
					}	
				}
				if (Gdx.input.isKeyPressed(Input.Keys.I))
					System.out.println(sprite.getX() + " " + sprite.getY());
				
				/*if (sprite.getX() <= -350)
					sprite.translateX(5);
				if (sprite.getX() >= 575)
					sprite.translateX(-5);	
				if (sprite.getY() <= -620)
					sprite.translateY(5);
				if (sprite.getY() >= -130)
					sprite.translateY(-5);     */
				
			}
		}		

	

	
	
	/*public void draw(Batch batch, float alpha) {
		sprite.draw(batch);
	}
	
	public void act(float delta) {
		super.act(delta);
	}*/
	


