package com.rithium.leakybird;

import com.badlogic.gdx.Game;
import com.rithium.leakybird.loader.AssetLoader;
import com.rithium.leakybird.screen.GameScreen;

public class LeakyBirdGame extends Game {	
	@Override
	public void create() {		
		AssetLoader.load();
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
}
