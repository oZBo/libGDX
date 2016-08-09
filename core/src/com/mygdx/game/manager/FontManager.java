package com.mygdx.game.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class FontManager {

    public static final String FONT_PATH = "data/main_font.ttf";

    private final static float DEFAULT_BORDER_WIDTH = 3f;
    private final static int DEFAULT_TEXT_SIZE = 25;

    private static FontManager instance;
    private static FreeTypeFontGenerator fontGenerator;
    private static FreeTypeFontGenerator.FreeTypeFontParameter fontParameter;

    public static FontManager getInstance(){
        if(null == instance){
            instance = new FontManager();
        }
        return instance;
    }

    private FontManager() {
        fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        configureFontParams();
    }

    public FreeTypeFontGenerator.FreeTypeFontParameter getFontParams(){
        return fontParameter;
    }

    /**
     * Generate default BitmapFont from default font.ttf file
     * @return BitmapFont
     */
    public BitmapFont generateFont(){
        fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal(FONT_PATH));
        BitmapFont bitmapFont = fontGenerator.generateFont(getFontParams());
        fontGenerator.dispose();
        return bitmapFont;
    }

    /**
     * @param fontPath path to the font.ttf file
     * @return BitmapFont generated from .ttf file
     */
    public BitmapFont generateFont(String fontPath){
        fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal(fontPath));
        BitmapFont bitmapFont = fontGenerator.generateFont(getFontParams());
        fontGenerator.dispose();
        return bitmapFont;
    }

    public void configureFontParams(){
        getFontParams().borderWidth = DEFAULT_BORDER_WIDTH;
        getFontParams().borderColor = Color.CORAL;
        getFontParams().size = DEFAULT_TEXT_SIZE;
    }
}
