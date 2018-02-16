package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Cannon {
	
	Sprite sprite; //testibesti

public Cannon() {
		
		setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(),sprite.getHeight());
		sprite.setPosition(0-sprite.getWidth()/2, 400-(sprite.getHeight()/2));
		sprite.setOrigin(sprite.getOriginX()-(sprite.getWidth()/8), sprite.getOriginY());
		
		this.addListener(new InputListener() {
			@Override
			public boolean keyDown(InputEvent event, int keycode) {
				if(Gdx.input.isKeyPressed(Input.Keys.W)) {
					if(sprite.getRotation()<77f) {
						sprite.rotate(2f);
					}	
				}
				if(Gdx.input.isKeyPressed(Input.Keys.S)) {
					if(sprite.getRotation()>-77f) {
						sprite.rotate(-2f);
					}	
				}
				//if(Gdx.input.isKeyPressed((Input.Keys.SPACE)){
					
				//}
						
				return super.keyDown(event, keycode);
				
			}
		});		

	}

	
	
	@Override
	public void draw(Batch batch, float alpha) {
		sprite.draw(batch);
	}
	
	public void act(float delta) {
		super.act(delta);
	}

}
