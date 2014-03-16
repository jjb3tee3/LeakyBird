package com.rithium.leakybird.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class Button implements Drawable {
	private Vector2 position;
	private Vector2 size;
	
	private TextureRegion buttonUp;
	private TextureRegion buttonDown;
	
	private Rectangle bounds;
	
	private boolean pressed;
	
	public Button(float x, float y, float w, float h,
						TextureRegion upTexture, TextureRegion downTexture) {
		this.position = new Vector2(x, y);
		this.size = new Vector2(w, h);
		
		this.buttonUp = upTexture;
		this.buttonDown = downTexture;
		
		this.bounds = new Rectangle(x, y, w, h);
	}
	
	@Override
	public void draw(SpriteBatch batch, float x, float y, float width,
			float height) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isClicked(int sX, int sY) {
		return bounds.contains(sX, sY);
	}
	
	public boolean isPressed() {
		return pressed;
	}

	@Override
	public float getLeftWidth() {
		return bounds.x;
	}

	@Override
	public void setLeftWidth(float leftWidth) {
		bounds.x = leftWidth;
	}

	@Override
	public float getRightWidth() {
		return bounds.width;
	}

	@Override
	public void setRightWidth(float rightWidth) {
		bounds.width = rightWidth;
	}

	@Override
	public float getTopHeight() {
		return bounds.y;
	}

	@Override
	public void setTopHeight(float topHeight) {
		bounds.y = topHeight;
	}

	@Override
	public float getBottomHeight() {
		return bounds.height;
	}

	@Override
	public void setBottomHeight(float bottomHeight) {
		bounds.height = bottomHeight;		
	}

	@Override
	public float getMinWidth() {
		return bounds.width;
	}

	@Override
	public void setMinWidth(float minWidth) {
		bounds.width = minWidth;
	}

	@Override
	public float getMinHeight() {
		return bounds.height;
	}

	@Override
	public void setMinHeight(float minHeight) {
		bounds.height = minHeight;
	}
}
