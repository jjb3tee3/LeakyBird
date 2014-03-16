package com.rithium.leakybird.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.rithium.leakybird.gameobjects.Bird;
import com.rithium.leakybird.loader.AssetLoader;

public class GameRenderer {
	private GameWorld world;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	
	// Debug stuff
	private BitmapFont font;
	
	private SpriteBatch batcher;
	
	private int midPointY;
	private int gameHeight;
	
	public GameRenderer(GameWorld world, int gameHeight, int midPointY) {
		this.world = world;
		this.cam = new OrthographicCamera();
		this.batcher = new SpriteBatch();
		this.shapeRenderer = new ShapeRenderer();
		this.font = new BitmapFont(true);
		
		this.gameHeight = gameHeight;
		this.midPointY = midPointY;
		
		cam.setToOrtho(true, 136, 204);
		
		batcher.setProjectionMatrix(cam.combined);
		shapeRenderer.setProjectionMatrix(cam.combined);
		
		font.setColor(Color.WHITE);
	}
	
	public void render(float runTime) {
		Bird bird = world.getBird();
		// Fill the entire screen with black, to prevent potential flickering.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        // Begin ShapeRenderer
        shapeRenderer.begin(ShapeType.Filled);
        
        // Draw Background color
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 136, midPointY + 66);

        // Draw Grass
        shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 66, 136, 11);

        // Draw Dirt
        shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 77, 136, 52);
        
        // End ShapeRenderer
        shapeRenderer.end();

        // Begin SpriteBatch
        batcher.begin();
        // Disable transparency 
        // This is good for performance when drawing images that do not require
        // transparency.
        batcher.disableBlending();
        
        batcher.draw(AssetLoader.bg, 0, midPointY + 23, 136, 43);

        // The bird needs transparency, so we enable that again.
        batcher.enableBlending();
        
        // Draw bird at its coordinates. Retrieve the Animation object from AssetLoader
        // Pass in the runTime variable to get the current frame.
        batcher.draw(AssetLoader.birdAnimation.getKeyFrame(runTime),
                bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());
        
        
        String text = "Velocity - x: "+bird.getVelocityX()+" y: "+bird.getVelocityY();
        String text2;
        
        if(bird.isAscending())
        	text2 = "Ascending";
        else
        	text2 = "Descending";
        
        font.setScale(.6f);
        font.draw(batcher, text, 1, 0);
        font.draw(batcher, text2, 1, 10);
        // End SpriteBatch
        batcher.end();
	}
}
