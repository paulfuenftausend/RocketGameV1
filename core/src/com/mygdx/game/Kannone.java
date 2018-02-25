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
				
				
			}
		}
