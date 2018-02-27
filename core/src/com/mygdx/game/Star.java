package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Star extends Sprite{
	
	Sprite star;
	
	World world;
	Body body;

	float movementSpeed = 2;
	public Star(World world2) {
		// TODO Auto-generated constructor stub
		this.world = world2;
	}
	
	public void doStuff()
	{
		tastenMovement();
		physischerKoerper();
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
	
	public void physischerKoerper()
	{
		BodyDef bodyDef = new BodyDef();
		
		bodyDef.type = BodyDef.BodyType.DynamicBody; //von allen Kräften beeinflusst (Gravitation, schieben, ziehen...)
		bodyDef.position.set(getX(), getY()); //Körper an die selbe Stelle wie Textur legen
		
		body = world.createBody(bodyDef);
		
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(star.getWidth()/2, star.getHeight()/2);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		
		body.createFixture(fixtureDef);
		shape.dispose();
	}

}
