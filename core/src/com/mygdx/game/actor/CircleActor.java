package com.mygdx.game.actor;

import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;
import java.util.List;

public class CircleActor extends Actor {

    private List<TextActor> listOfChars;
    private float circleRadius;
    private float circleSpeed;
    private boolean isClockwiseRotation = true;
    private boolean isSymbolsMirrored = true;

    public CircleActor(float circleRadius, ArrayList<TextActor> listOfChars){
        this.circleRadius = circleRadius;
        this.listOfChars = listOfChars;
    }

    public List<TextActor> getListOfChars() {
        return listOfChars;
    }

    public float getCircleRadius() {
        return circleRadius;
    }

    public void setCircleRadius(float circleRadius) {
        this.circleRadius = circleRadius;
    }

    public float getCircleSpeed() {
        return circleSpeed;
    }

    public void setCircleSpeed(float circleSpeed) {
        this.circleSpeed = circleSpeed;
    }

    public boolean isClockwiseRotation() {
        return isClockwiseRotation;
    }

    public void setClockwiseRotation(boolean clockwiseRotation) {
        isClockwiseRotation = clockwiseRotation;
    }

    public boolean isSymbolsMirrored() {
        return isSymbolsMirrored;
    }

    public void setSymbolsMirrored(boolean symbolsMirrored) {
        isSymbolsMirrored = symbolsMirrored;
    }
}
