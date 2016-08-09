package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.manager.FontManager;
import com.mygdx.game.manager.ResourceManager;

/**
 * Created by braincollaboration on 30.05.2016.
 */
public class GameScreen implements Screen {

    SpriteBatch batch;
    Texture textureDroplet;
    Sprite sprite;

    BitmapFont font;

    OrthographicCamera camera;

    private float elapsedTime = 0.0f;
    private float startTime;
    private Vector2 center = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);

    @Override
    public void show() {
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        textureDroplet = ResourceManager.getInstance().getTextureByName(ResourceManager.TEXTURE_DROPLET);
        sprite = new Sprite(textureDroplet);
        font = FontManager.getInstance().generateFont();
        startTime = TimeUtils.millis();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        elapsedTime = TimeUtils.timeSinceMillis((long) startTime);
        float speed = 0.02f; // in degrees per second
        float radius = 100.0f; // the radius of the circle you'll be rotating
        float angle = elapsedTime * speed;
        batch.begin();
        font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 0, 20);
        font.draw(batch, "B", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 1.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 1.2));
        font.draw(batch, "C", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 1.4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 1.4));
        font.draw(batch, "D", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 1.6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 1.6));
        font.draw(batch, "E", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 1.8), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 1.8));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 2));
        font.draw(batch, "B", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 2.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 2.2));
        font.draw(batch, "C", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 2.4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 2.4));
        font.draw(batch, "D", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 2.6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 2.6));
        font.draw(batch, "E", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 2.8), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 2.8));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 3), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 3));
        font.draw(batch, "B", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 3.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 3.2));
        font.draw(batch, "C", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 3.4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 3.4));
        font.draw(batch, "D", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 3.6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 3.6));
        font.draw(batch, "E", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 3.8), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 3.8));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 4));
        font.draw(batch, "B", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 4.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 4.2));
        font.draw(batch, "C", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 4.4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 4.4));
        font.draw(batch, "D", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 4.6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 4.6));
        font.draw(batch, "E", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 4.8), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 4.8));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 5), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 5));
        font.draw(batch, "B", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 5.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 5.2));
        font.draw(batch, "C", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 5.4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 5.4));
        font.draw(batch, "D", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 5.6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 5.6));
        font.draw(batch, "E", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 5.8), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 5.8));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 6));
        font.draw(batch, "B", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 6.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 6.2));
        font.draw(batch, "C", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 6.4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 6.4));
        font.draw(batch, "D", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 6.6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 6.6));
        font.draw(batch, "E", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 6.8), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 6.8));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 7), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 7));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 7.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 7.2));

        radius = 130;
        angle = elapsedTime * -0.02f;

        font.draw(batch, "B", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 1.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 1.2));
        font.draw(batch, "C", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 1.4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 1.4));
        font.draw(batch, "D", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 1.6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 1.6));
        font.draw(batch, "E", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 1.8), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 1.8));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 2));
        font.draw(batch, "B", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 2.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 2.2));
        font.draw(batch, "C", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 2.4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 2.4));
        font.draw(batch, "D", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 2.6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 2.6));
        font.draw(batch, "E", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 2.8), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 2.8));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 3), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 3));
        font.draw(batch, "B", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 3.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 3.2));
        font.draw(batch, "C", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 3.4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 3.4));
        font.draw(batch, "D", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 3.6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 3.6));
        font.draw(batch, "E", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 3.8), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 3.8));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 4));
        font.draw(batch, "B", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 4.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 4.2));
        font.draw(batch, "C", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 4.4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 4.4));
        font.draw(batch, "D", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 4.6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 4.6));
        font.draw(batch, "E", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 4.8), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 4.8));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 5), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 5));
        font.draw(batch, "B", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 5.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 5.2));
        font.draw(batch, "C", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 5.4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 5.4));
        font.draw(batch, "D", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 5.6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 5.6));
        font.draw(batch, "E", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 5.8), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 5.8));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 6));
        font.draw(batch, "B", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 6.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 6.2));
        font.draw(batch, "C", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 6.4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 6.4));
        font.draw(batch, "D", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 6.6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 6.6));
        font.draw(batch, "E", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 6.8), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 6.8));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 7), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 7));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 7.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 7.2));

        radius = 160;
        angle = elapsedTime * 0.03f;

        font.draw(batch, "B", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 1.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 1.2));
        font.draw(batch, "C", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 1.4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 1.4));
        font.draw(batch, "D", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 1.6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 1.6));
        font.draw(batch, "E", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 1.8), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 1.8));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 2));
        font.draw(batch, "B", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 2.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 2.2));
        font.draw(batch, "C", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 2.4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 2.4));
        font.draw(batch, "D", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 2.6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 2.6));
        font.draw(batch, "E", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 2.8), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 2.8));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 3), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 3));
        font.draw(batch, "B", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 3.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 3.2));
        font.draw(batch, "C", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 3.4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 3.4));
        font.draw(batch, "D", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 3.6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 3.6));
        font.draw(batch, "E", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 3.8), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 3.8));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 4));
        font.draw(batch, "B", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 4.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 4.2));
        font.draw(batch, "C", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 4.4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 4.4));
        font.draw(batch, "D", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 4.6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 4.6));
        font.draw(batch, "E", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 4.8), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 4.8));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 5), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 5));
        font.draw(batch, "B", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 5.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 5.2));
        font.draw(batch, "C", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 5.4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 5.4));
        font.draw(batch, "D", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 5.6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 5.6));
        font.draw(batch, "E", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 5.8), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 5.8));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 6));
        font.draw(batch, "B", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 6.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 6.2));
        font.draw(batch, "C", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 6.4), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 6.4));
        font.draw(batch, "D", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 6.6), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 6.6));
        font.draw(batch, "E", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 6.8), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 6.8));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 7), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 7));
        font.draw(batch, "F", center.x + radius * (float) Math.cos(angle * MathUtils.degRad + 7.2), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + 7.2));

        font.draw(batch, "D", center.x, center.y);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
