package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.manager.ResourceManager;
import com.mygdx.game.manager.ScreenManager;
import com.mygdx.game.screen.CustomScreen;

public class MyGdxGame extends Game {

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
