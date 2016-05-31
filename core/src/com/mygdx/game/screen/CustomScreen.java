package com.mygdx.game.screen;

/**
 * Created by braincollaboration on 30.05.2016.
 */
public enum CustomScreen {

    LOAD_SCREEN {
        @Override
        public com.badlogic.gdx.Screen getScreenInstance() {
            return new LoadScreen();
        }
    },

    MAIN_MENU {
        @Override
        public com.badlogic.gdx.Screen getScreenInstance() {
            return new MenuScreen();
        }
    },

    GAME_SCREEN {
        @Override
        public com.badlogic.gdx.Screen getScreenInstance() {
            return new GameScreen();
        }
    };

    public abstract com.badlogic.gdx.Screen getScreenInstance();

}
