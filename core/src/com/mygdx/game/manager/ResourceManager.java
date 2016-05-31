package com.mygdx.game.manager;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by braincollaboration on 30.05.2016.
 */
public class ResourceManager extends AssetManager {

    public static final String TEXTURE_BUCKET = "data/bucket.png";
    public static final String TEXTURE_DROPLET = "data/droplet.png";

    public static final String SOUND_WATERDROP = "data/waterdrop.wav";

    public static final String MUSIC_RAIN = "data/rain.mp3";

    private static ResourceManager instance;

    public static ResourceManager getInstance(){
        if(null == instance){
            instance = new ResourceManager();
        }
        return instance;
    }

    public void loadResources(){
        load(TEXTURE_BUCKET, Texture.class);
        load(TEXTURE_DROPLET, Texture.class);
        load(SOUND_WATERDROP, Sound.class);
        load(MUSIC_RAIN, Music.class);
    }

    public Texture getTextureByName(String textureName){
        return get(textureName, Texture.class);
    }

    public Sound getSoundByName(String textureName){
        return get(textureName, Sound.class);
    }

    public Music getMusicByName(String textureName){
        return get(textureName, Music.class);
    }

}
