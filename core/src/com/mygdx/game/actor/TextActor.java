package com.mygdx.game.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TextActor extends Actor {

    private Matrix4 matrix = new Matrix4();
    private BitmapFontCache bitmapFontCache;
    private GlyphLayout textBounds;

    public TextActor(BitmapFont bitmapFont, String text) {
        bitmapFontCache = new BitmapFontCache(bitmapFont);
        textBounds = bitmapFontCache.setText(text, 0, 0);
    }

    public GlyphLayout getTextBounds() {
        return textBounds;
    }

    @Override
    public void setColor(float r, float g, float b, float a) {
        super.setColor(r, g, b, a);
    }

    public void setPosition(float x, float y) {
        this.setX(x);
        this.setY(y);
    }

    public void setScale(float x, float y) {
        this.setScaleX(x);
        this.setScaleY(y);
    }

    public void setOrigin(float x, float y) {
        this.setOriginX(x);
        this.setOriginY(y);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        bitmapFontCache.setColor(getColor().r, getColor().g, getColor().b, getColor().a * parentAlpha);
        matrix.idt();
        matrix.translate(getX() + getOriginX(), getY() + getOriginY(), 0);
        matrix.rotate(0, 0, 1, getRotation());
        matrix.scale(getScaleX(), getScaleY(), 1);
        matrix.translate(-getOriginX(), -getOriginY(), 0);
        batch.setTransformMatrix(matrix);
        bitmapFontCache.draw(batch);
        super.draw(batch, parentAlpha);
    }
}
