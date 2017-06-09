package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.manager.ResourceManager;
import com.mygdx.game.manager.ScreenManager;
import com.mygdx.game.screen.CustomScreen;

public class MyGdxGame extends Game {

    public static final float SCREEN_WIDTH = 960f;
    public static final float SCREEN_HEIGHT = 1280f;
    public static float VIEWPORT_LEFT;
    public static float VIEWPORT_RIGHT;

    @Override
    public void create() {
        ScreenManager.getInstance().init(this);
        ScreenManager.getInstance().show(CustomScreen.LOAD_SCREEN);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
        ResourceManager.getInstance().dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);

        float aspectRatio = (float) width / height;
        float viewportWidth = SCREEN_HEIGHT * aspectRatio;

        VIEWPORT_LEFT = (SCREEN_WIDTH - viewportWidth) / 2;
        VIEWPORT_RIGHT = VIEWPORT_LEFT + viewportWidth;
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }
}
