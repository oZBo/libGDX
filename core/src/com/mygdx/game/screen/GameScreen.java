package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.actor.TextActor;
import com.mygdx.game.manager.FontManager;
import com.mygdx.game.manager.LevelManager;
import com.mygdx.game.utils.MathUtils;

/**
 * Created by braincollaboration on 30.05.2016.
 */
public class GameScreen implements Screen {

    SpriteBatch batch;

    BitmapFont font;

    OrthographicCamera camera;

    private float elapsedTime = 0.0f;
    private float startTime;
    private Vector2 center = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);

    @Override
    public void show() {
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        font = FontManager.getInstance().generateFont();
        startTime = TimeUtils.millis();
        LevelManager.getInstance().addCircle(MathUtils.calcCharsNumberInCircle(40, 60), 60, 0.05f, font);
        LevelManager.getInstance().addCircle(MathUtils.calcCharsNumberInCircle(40, 100), 100, 0.05f, font);
        LevelManager.getInstance().getCircleByIndex(1).setClockwiseRotation(false);
        LevelManager.getInstance().addCircle(MathUtils.calcCharsNumberInCircle(40, 140), 140, 0.05f, font);
        LevelManager.getInstance().addCircle(MathUtils.calcCharsNumberInCircle(40, 180), 180, 0.05f, font);
        LevelManager.getInstance().getCircleByIndex(3).setClockwiseRotation(false);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling ? GL20.GL_COVERAGE_BUFFER_BIT_NV : 0));
        elapsedTime = TimeUtils.timeSinceMillis((long) startTime);
        batch.begin();

        TextActor fps = new TextActor(font, "FPS: " + Gdx.graphics.getFramesPerSecond());
        fps.setPosition(40, 40);
        fps.draw(batch, 1f);

        LevelManager.getInstance().drawCircles(batch, elapsedTime);

        TextActor centerSymbol = new TextActor(font, "4");
        centerSymbol.setPosition(center.x, center.y);
        centerSymbol.setOrigin(centerSymbol.getWidth(), centerSymbol.getHeight());
        centerSymbol.draw(batch, 1f);
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
