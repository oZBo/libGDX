package com.mygdx.game.actor;

import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;
import java.util.List;

public class CircleActor extends Actor {

    private List<TextActor> listOfChars;
    private float circleRadius;

    public CircleActor(float circleRadius, ArrayList<TextActor> listOfChars){
        this.circleRadius = circleRadius;
        this.listOfChars = listOfChars;
    }

    public void changeMovementDirection(){

    }

    public void changeMovementSpeed(){

    }

    public void setCharsMirrored(boolean isMirrored){

    }

    public void setCharsReversed(boolean isReversed){

    }

}
