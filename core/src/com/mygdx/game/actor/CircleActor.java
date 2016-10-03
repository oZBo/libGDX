package com.mygdx.game.actor;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.List;

public class CircleActor extends Actor {

    private List<TextActor> textElementsList;
    private float radius;
    private boolean isClockwiseRotation = true;
    private boolean isSymbolsMirrored = true;
    private float rotationSpeed;
    private Circle selfCircle;

    public CircleActor(Vector2 position, float circleRadius, float speed, List<TextActor> listOfChars){
        this.radius = circleRadius;
        this.textElementsList = listOfChars;
        this.rotationSpeed = speed;
        this.selfCircle = new Circle(position, circleRadius+30);
    }

    public List<TextActor> getCircleSymbolsList() {
        return textElementsList;
    }

    public float getRotationSpeed() {
        if(isClockwiseRotation()) {
            return rotationSpeed;
        }else{
            return rotationSpeed * -1;
        }
    }

    public Circle getSelfCircle() {
        return selfCircle;
    }

    public void setRotationSpeed(float rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
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

    public TextActor getSymbolByIndex(int position){
        return textElementsList.get(position);
    }
}
