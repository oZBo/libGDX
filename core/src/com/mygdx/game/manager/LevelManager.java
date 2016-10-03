package com.mygdx.game.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.actor.CircleActor;
import com.mygdx.game.actor.TextActor;
import com.mygdx.game.utils.MathUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.badlogic.gdx.math.MathUtils.random;
import static com.mygdx.game.utils.MathUtils.calcXPosInCircle;
import static com.mygdx.game.utils.MathUtils.calcYPosInCircle;

/**
 * Created by braincollaboration on 09/08/2016.
 */
public class LevelManager {

    private final static String LEVEL_SYMBOLS = "1234567890";

    private static LevelManager instance;
    private static float screenWidth = Gdx.graphics.getWidth();
    private static float screenHeight = Gdx.graphics.getHeight();
    private static Vector2 center = new Vector2(screenWidth / 2, screenHeight / 2);
    private static List<CircleActor> listOfCircles = new ArrayList<CircleActor>();
    private static List<TextActor> listOfAnswers = new ArrayList<TextActor>();
    private static TextActor centerSymbol;

    public static LevelManager getInstance() {
        if (instance == null) {
            instance = new LevelManager();
        }
        return instance;
    }

    private LevelManager() {

    }

    public void generateCenterSymbol(BitmapFont font) {
        centerSymbol = new TextActor(font, getRandomChar());
        centerSymbol.setPosition(center.x, center.y);
        centerSymbol.setOrigin(centerSymbol.getWidth(), centerSymbol.getHeight());
    }

    public void addCircle(int numberOfSymbols, float radius, float speed, BitmapFont font) {
        List<TextActor> listOfSymbols = new ArrayList<TextActor>();
        for (int i = 0; i < numberOfSymbols; i++) {
            TextActor symbol = new TextActor(font, "" + getRandomChar());
            listOfSymbols.add(symbol);
        }
        listOfCircles.add(new CircleActor(center, radius, speed, listOfSymbols));
    }

    public void drawLevel(SpriteBatch batch) {
        centerSymbol.draw(batch, 1f);
        drawAnswerTextActors(batch);
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

    public int getCorrectAnswer() {
        int correctAnswer = 0;
        for (CircleActor circle : listOfCircles) {
            for (TextActor symbol : circle.getCircleSymbolsList()) {
                if (centerSymbol.getSymbol().equals(symbol.getSymbol())) {
                    correctAnswer++;
                }
            }
        }
        return correctAnswer;
    }

    public void generateAnswerTextActors(BitmapFont font) {
        for (int i = 0; i < 30; i++) {
            TextActor answerSymbol = new TextActor(font, getRandomChar());
            answerSymbol.setPosition(random(screenWidth), random(screenHeight));
            for(TextActor textActor : listOfAnswers) {
                while (Intersector.overlaps(listOfCircles.get(listOfCircles.size() - 1).getSelfCircle(), answerSymbol.getSelfRectangle()) ||
                        Intersector.overlaps(answerSymbol.getSelfRectangle(), textActor.getSelfRectangle())) {
                    answerSymbol.setPosition(random(screenWidth), random(screenHeight));
                }
            }
            listOfAnswers.add(answerSymbol);
        }
    }

    private void drawAnswerTextActors(SpriteBatch batch) {
        for (TextActor textActor : listOfAnswers) {
            textActor.draw(batch, 1f);
        }
    }

    private static String getRandomChar() {
        Random r = new Random();
        return String.valueOf(LEVEL_SYMBOLS.charAt(r.nextInt(LEVEL_SYMBOLS.length())));
    }

    public void setMovementDirection(CircleActor circle, boolean isClockwise) {
        if (isClockwise) {
            circle.setClockwiseRotation(true);
        } else {
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
