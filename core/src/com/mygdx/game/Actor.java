package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Actor extends Sprite{

	public Body body;
	public World world;
	
	Sprite ball;
	
	float movementSpeed = 3;
	
	
	public Actor(World world2) {
		// TODO Auto-generated constructor stub
		this.world = world2;
	}
	
	public void doStuff()
	{
		movement();
		//drehen();
		physischerKoerper();
	}

	public void movement()
	{
		
		float ballMittelX = ball.getX()+ball.getWidth()/2;
		float ballObenY = ball.getY()+ball.getHeight();
		
		if((Gdx.input.getX()) != ballMittelX+movementSpeed || Gdx.input.getX() != ballMittelX-movementSpeed)
		{
			if((Gdx.input.getX()) > ballMittelX){
				ball.translateX(movementSpeed);
			}else if((Gdx.input.getX()) < ballMittelX){
				ball.translateX(-movementSpeed);
			}
		}
		
		if(-(Gdx.input.getY()+540) != ballObenY+movementSpeed || -(Gdx.input.getY()+550) != ballObenY-movementSpeed) 
		{
			if(-(Gdx.input.getY()-540) > ballObenY){
				ball.translateY(movementSpeed);
			}else if(-(Gdx.input.getY()-540) < ballObenY){
				ball.translateY(-movementSpeed);
			}
		}
		tastenMovement();
	}
	
	public void tastenMovement() 
	{
		//Bewegung per W, A, S, D zur Korrektur 
		if (Gdx.input.isKeyPressed(Input.Keys.D))
			ball.translateX(movementSpeed);
		if (Gdx.input.isKeyPressed(Input.Keys.A))
			ball.translateX(-movementSpeed);
		if (Gdx.input.isKeyPressed(Input.Keys.W))
			ball.translateY(movementSpeed);
		if (Gdx.input.isKeyPressed(Input.Keys.S))
			ball.translateY(-movementSpeed);
		
		if (Gdx.input.isKeyPressed(Input.Keys.B))
			ball.rotate(1f);
		if (Gdx.input.isKeyPressed(Input.Keys.V))
			ball.rotate(-1f);
		
		
		//Ausgabe der koordinaten von input und objekt
		if (Gdx.input.isKeyPressed(Input.Keys.ENTER))
			System.out.println(ball.getX() + " " + ball.getY());
		if (Gdx.input.isKeyPressed(Input.Keys.K))
			System.out.println(Gdx.input.getX() + " " + -(Gdx.input.getY()));
		
		//Randbegrenzung
		if (ball.getX() <= 0)
			ball.translateX(movementSpeed);
		if (ball.getX() >= 960-ball.getWidth())
			ball.translateX(-movementSpeed);	
		if (ball.getY() <= 0)
			ball.translateY(movementSpeed);
		if (ball.getY() >= 540-ball.getHeight())
			ball.translateY(-movementSpeed);
	}
	
	public void drehen() //theoretisch ausrichtung vom sprite zur maus
	{
		Vector2 input = new Vector2();
		Vector2 actor = new Vector2();
		
		actor.set(ball.getX() - ball.getWidth()/2, ball.getY()+ball.getHeight());
		input.set(Gdx.input.getX(), -(Gdx.input.getY()-540));
		
		float rotation = input.angle(actor);
		if(rotation < 0){
			rotation +=360;}
		
		ball.setRotation(rotation);
	}
	
	public void physischerKoerper() //erstellung eines Physischen Körpers um Berührung zu registrieren
	{
		BodyDef bodyDef = new BodyDef();
		
		bodyDef.type = BodyDef.BodyType.DynamicBody; //von allen Kräften beeinflusst (Gravitation, schieben, ziehen...)
		bodyDef.position.set(getX(), getY()); //Körper an die selbe Stelle wie Textur legen
		
		body = world.createBody(bodyDef);
		
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(ball.getWidth()/2, ball.getHeight()/2);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		
		body.createFixture(fixtureDef);
		shape.dispose();
		
		
	}
	
	public void movement2()
	{
		
		float ballMittelX = body.getPosition().x+ball.getWidth()/2;
		float ballObenY = body.getPosition().y+ball.getHeight();
		
		if((Gdx.input.getX()) != ballMittelX+movementSpeed || Gdx.input.getX() != ballMittelX-movementSpeed) //Bewegung zur Maus hin
		{
			if((Gdx.input.getX()) > ballMittelX){
				body.applyForceToCenter(movementSpeed, 0, true);
			}else if((Gdx.input.getX()) < ballMittelX){
				body.applyForceToCenter(-movementSpeed, 0, true);
			}
		}
		
		if(-(Gdx.input.getY()+540) != ballObenY+movementSpeed || -(Gdx.input.getY()+550) != ballObenY-movementSpeed) //Bewegung zur Maus hin
		{
			if(-(Gdx.input.getY()-540) > ballObenY){
				body.applyForceToCenter(0,movementSpeed, true);
			}else if(-(Gdx.input.getY()-540) < ballObenY){
				body.applyForceToCenter(0, -movementSpeed, true);
			}
		}
		this.setPosition(body.getPosition().x, body.getPosition().y);
		tastenMovement();		
	}
}

