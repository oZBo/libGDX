package com.mygdx.game.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.actor.TextActor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by braincollaboration on 09/08/2016.
 */
public class LevelManager {

    private static LevelManager instance;
    private static Vector2 center = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);

    public static LevelManager getInstance() {
        if (instance == null) {
            instance = new LevelManager();
        }
        return instance;
    }

    private LevelManager() {

    }

    public List<Character> fillListOfChars(int numberOfSymbols) {
        List<Character> listOfSymbols = new ArrayList<Character>();
        for (int i = 0; i < numberOfSymbols; i++) {
            listOfSymbols.add(rndChar());
        }
        return listOfSymbols;
    }

    public void generateCircle(SpriteBatch batch, List<Character> symbolList, BitmapFont font, float radius, float angle) {

        for (int i = 0; i < symbolList.size(); i++) {
            TextActor symbol = new TextActor(font, "" + symbolList.get(i));
            symbol.setPosition(center.x + radius * (float) Math.cos(angle * MathUtils.degRad + i), center.y + radius * (float) Math.sin(angle * MathUtils.degRad + (float) i));
            symbol.setRotation(angle * MathUtils.degRad);
            symbol.draw(batch, 1f);
        }
    }

    private static char rndChar() {
        Random r = new Random();
        String alphabet = "QWERTYUIOPASDFGHJKLZXCVBNM";
        return alphabet.charAt(r.nextInt(alphabet.length()));
    }

}
