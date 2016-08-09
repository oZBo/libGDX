package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.actor.TextActor;
import com.mygdx.game.manager.FontManager;
import com.mygdx.game.manager.LevelManager;
import com.mygdx.game.manager.ResourceManager;

import java.util.List;

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
    private List<Character> firstCircle;
    private List<Character> secondCircle;
    private List<Character> thirdCircle;

    @Override
    public void show() {
        firstCircle = LevelManager.getInstance().fillListOfChars(10);
        secondCircle = LevelManager.getInstance().fillListOfChars(15);
        thirdCircle = LevelManager.getInstance().fillListOfChars(20);
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
        float speed = 0.05f;
        float radius = 60.0f;
        float angle = elapsedTime * speed;
        batch.begin();

        TextActor fps = new TextActor(font, "FPS: " + Gdx.graphics.getFramesPerSecond());
        fps.setPosition(40, 40);
        fps.draw(batch, 1f);

        LevelManager.getInstance().generateCircle(batch, firstCircle, font, radius, angle);
        angle = elapsedTime * -speed;
        radius = 100f;
        LevelManager.getInstance().generateCircle(batch, secondCircle, font, radius, angle);
        angle = elapsedTime * speed;
        radius = 140f;
        LevelManager.getInstance().generateCircle(batch, thirdCircle, font, radius, angle);

        TextActor centerSymbol = new TextActor(font, "D");
        centerSymbol.setPosition(center.x, center.y);
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
