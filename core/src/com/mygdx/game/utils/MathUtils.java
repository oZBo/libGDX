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

    public static float calcOffsetForEachSymbol(float charWidth, float circleRadius){
        return 2 * PI * circleRadius / charWidth;
    }

    public static float calcXPosInCircle(float angle, float circleRadius, float elementOffset){
        return circleRadius * (float) Math.cos((angle + elementOffset) * degRad);
    }

    public static float calcYPosInCircle(float angle, float circleRadius, float elementOffset){
        return circleRadius * (float) Math.sin((angle + elementOffset) * degRad);
    }
}
