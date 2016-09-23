package com.mygdx.game.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.actor.CircleActor;
import com.mygdx.game.actor.TextActor;
import com.mygdx.game.utils.MathUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.mygdx.game.utils.MathUtils.calcXPosInCircle;
import static com.mygdx.game.utils.MathUtils.calcYPosInCircle;

/**
 * Created by braincollaboration on 09/08/2016.
 */
public class LevelManager {

    private static LevelManager instance;
    private static Vector2 center = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
    private static List<CircleActor> listOfCircles = new ArrayList<CircleActor>();

    public static LevelManager getInstance() {
        if (instance == null) {
            instance = new LevelManager();
        }
        return instance;
    }

    private LevelManager() {

    }

    public void addCircle(int numberOfSymbols, float radius, float speed, BitmapFont font) {
        List<TextActor> listOfSymbols = new ArrayList<TextActor>();
        for (int i = 0; i < numberOfSymbols; i++) {
            TextActor symbol = new TextActor(font, "" + rndChar());
            listOfSymbols.add(symbol);
        }
        listOfCircles.add(new CircleActor(radius, speed, listOfSymbols));
    }

    public void drawCircles(SpriteBatch batch, float elapsedTime) {
        for (CircleActor circle : listOfCircles) {
            float circleRadius = circle.getRadius();
            float circleSpeed = circle.getRotationSpeed();
            float angle = elapsedTime * circleSpeed;
            for (int i = 0; i < circle.getCircleSymbolsList().size(); i++) {
                TextActor symbol = circle.getSymbolByIndex(i);
                float offset = 360 / MathUtils.calcOffsetForEachSymbol(40, circleRadius);
                offset = offset * i;
                symbol.setPosition(center.x + calcXPosInCircle(angle, circleRadius, offset), center.y + calcYPosInCircle(angle, circleRadius, offset));
                symbol.setRotation(angle + offset + 90);
                symbol.draw(batch, 0.05f);
            }
        }
    }

    private static char rndChar() {
        Random r = new Random();
        String alphabet = "1324567890";
        return alphabet.charAt(r.nextInt(alphabet.length()));
    }

    public void setMovementDirection(CircleActor circle, boolean isClockwise) {
        if(isClockwise){
            circle.setClockwiseRotation(true);
        }else{
            circle.setClockwiseRotation(false);
        }
    }

    public void setMovementSpeed(CircleActor circle, float speed) {

    }

    public void setCharsMirrored(CircleActor circle, boolean isMirrored) {

    }

    public void setCharsReversed(CircleActor circle, boolean isReversed) {

    }

    public CircleActor getCircleByIndex(int index) {
        return listOfCircles.get(index);
    }

}
