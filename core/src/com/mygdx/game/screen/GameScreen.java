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

import java.util.List;

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
    private List<Character> firstCircle;
    private List<Character> secondCircle;
    private List<Character> thirdCircle;

    @Override
    public void show() {
        firstCircle = LevelManager.getInstance().fillListOfChars(MathUtils.calcCharsNumberInCircle(40, 60));
        secondCircle = LevelManager.getInstance().fillListOfChars(MathUtils.calcCharsNumberInCircle(40, 100));
        thirdCircle = LevelManager.getInstance().fillListOfChars(MathUtils.calcCharsNumberInCircle(40, 140));
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        font = FontManager.getInstance().generateFont();
        startTime = TimeUtils.millis();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling ? GL20.GL_COVERAGE_BUFFER_BIT_NV : 0));
        elapsedTime = TimeUtils.timeSinceMillis((long) startTime);
        float speed = 0.05f;
        float radius = 60.0f;
        float angle = elapsedTime * speed;
        batch.begin();

        TextActor fps = new TextActor(font, "FPS: " + Gdx.graphics.getFramesPerSecond());
        fps.setPosition(40, 40);
        fps.draw(batch, 1f);

        LevelManager.getInstance().drawCircle(batch, firstCircle, font, radius, angle);
        angle = elapsedTime * speed;
        radius = 100f;
        LevelManager.getInstance().drawCircle(batch, secondCircle, font, radius, angle);
        angle = elapsedTime * speed;
        radius = 140f;
        LevelManager.getInstance().drawCircle(batch, thirdCircle, font, radius, angle);

        TextActor centerSymbol = new TextActor(font, "D");
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
