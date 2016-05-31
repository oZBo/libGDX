package com.mygdx.game.screen;

import com.badlogic.gdx.Screen;
import com.mygdx.game.manager.ResourceManager;
import com.mygdx.game.manager.ScreenManager;

/**
 * Created by braincollaboration on 30.05.2016.
 */
public class LoadScreen implements Screen {

    @Override
    public void show() {
        ResourceManager.getInstance().loadResources();
    }

    @Override
    public void render(float delta) {
        if(ResourceManager.getInstance().update()){
            ScreenManager.getInstance().show(CustomScreen.GAME_SCREEN);
        }
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
