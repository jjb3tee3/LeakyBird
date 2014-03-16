package com.rithium.leakybird.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.rithium.handlers.InputHandler;
import com.rithium.leakybird.world.GameRenderer;
import com.rithium.leakybird.world.GameWorld;

public class GameScreen implements Screen {

	private GameWorld world;
	private GameRenderer renderer;
	
	private int runTime = 0;
	
	public GameScreen() {
		int gameWidth = 136;
		int gameHeight = Gdx.graphics.getHeight() / (Gdx.graphics.getWidth() / gameWidth);
		
		world = new GameWorld(
					gameWidth,
					gameHeight
				);
		
		renderer = new GameRenderer(world, gameHeight, gameHeight/2);
		
		Gdx.input.setInputProcessor(new InputHandler(world.getBird()));
		
		System.out.println("GameScreen attached.");
	}
	
	@Override
	public void render(float delta) {
		runTime += delta;
		world.update(delta);
		renderer.render(runTime);
	}

	@Override
	public void resize(int width, int height) {
		System.out.println("GameScreen resizing.");
		
	}

	@Override
	public void show() {
		System.out.println("GameScreen shown.");
		
	}

	@Override
	public void hide() {
		System.out.println("GameScreen hidden.");
		
	}

	@Override
	public void pause() {
		System.out.println("GameScreen paused.");
		
	}

	@Override
	public void resume() {
		System.out.println("GameScreen resumed.");
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
