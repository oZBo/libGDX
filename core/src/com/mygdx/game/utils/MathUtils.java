package com.mygdx.game.utils;

import static com.badlogic.gdx.math.MathUtils.*;

/**
 * Created by braincollaboration on 31/08/2016.
 */
public class MathUtils {

    /**
     * @param charWidth width of the symbol with spacebar.
     * @param circleRadius radius of the circle.
     * @return number of symbols that fill in circle radius.
     */
    public static int calcCharsNumberInCircle(float charWidth, float circleRadius){
        float charsNumber = 2 * PI * circleRadius;
        return Math.round(charsNumber / charWidth);
    }

}
