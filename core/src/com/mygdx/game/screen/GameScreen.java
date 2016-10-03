package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.actor.TextActor;
import com.mygdx.game.manager.FontManager;
import com.mygdx.game.manager.LevelManager;

/**
 * Created by braincollaboration on 30.05.2016.
 */
public class GameScreen implements Screen {

    SpriteBatch batch;

    BitmapFont font;

    OrthographicCamera camera;

    private float elapsedTime = 0.0f;
    private float startTime;

    @Override
    public void show() {
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        font = FontManager.getInstance().generateFont();
        startTime = TimeUtils.millis();
        LevelManager.getInstance().addCircle(60, 0.05f, font);
        LevelManager.getInstance().addCircle(100, 0.05f, font);
        LevelManager.getInstance().getCircleByIndex(1).setClockwiseRotation(false);
        LevelManager.getInstance().addCircle(140, 0.05f, font);
        LevelManager.getInstance().addCircle(180, 0.05f, font);
        LevelManager.getInstance().getCircleByIndex(3).setClockwiseRotation(false);
        LevelManager.getInstance().generateCenterSymbol(font);
        LevelManager.getInstance().generateAnswerTextActors(font);

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
        LevelManager.getInstance().drawLevel(batch);

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
