package com.rithium.leakybird.gameobjects;

import com.badlogic.gdx.math.Vector2;

public class Bird {
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;
	
	private float rotation;
	private int width;
	private int height;
	
	public Bird(float x, float y, int width, int height) {
		this.width = width;
		this.height = height;
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0, 460);
	}

	public void update(float delta) {
		velocity.add(acceleration.cpy().scl(delta));
		
		if(velocity.y > 200) 
			velocity.y = 200;
		
		position.add(velocity.cpy().scl(delta));
	}
	
	public void onClick() {
			velocity.y = -140;
	}
	
	public float getX() {
		return position.x;
	}
	
	public float getY() {
		return position.y;
	}
	
	public float getWidth() {
		return width;
	}
	
	public float getHeight() {
		return height;
	}
	
	public float getRotation() {
		return rotation;
	}	
	
	public float getVelocityX() {
		return velocity.x;
	}
	
	public float getVelocityY() {
		return velocity.y;
	}
	
	public boolean isAscending() {
		return velocity.y < 90 ? true : false;
	}
	
	public boolean isDescending() {
		return velocity.y > 90 ? true : false;
	}
	
	public boolean shouldntFlap() {
		return velocity.y > 70 ? true: false;
	}
}
