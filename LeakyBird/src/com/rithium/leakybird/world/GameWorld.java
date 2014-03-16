package com.rithium.leakybird.world;

import com.badlogic.gdx.Gdx;
import com.rithium.leakybird.gameobjects.Bird;

public class GameWorld {
	
	private Bird bird;
	
	public GameWorld(int gameHeight, int gameWidth) {
		//TODO: Refactor this mess
		int midY = gameHeight / 2; 
		bird = new Bird(33.0f, midY, 21, 23);
	}
	
	public void update(float delta) {
		bird.update(delta);
	}
	
	public Bird getBird() {
		return bird;
	}
}
