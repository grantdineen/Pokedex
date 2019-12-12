package com.example.gdineen.pokedex.Managers;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import com.example.gdineen.pokedex.Constants.Music;

import java.util.Random;

public class SoundManager {
    private Context ctx;
    private static SoundManager soundManager;
    private MediaPlayer mediaPlayerMusic;
    private MediaPlayer mediaPlayerSFX;


    public static SoundManager getInstance(Context ctx){
        if(soundManager == null)
            soundManager = new SoundManager(ctx);
        return soundManager;
    }

    private SoundManager(Context ctx){
        this.ctx = ctx;
        prepareRandomSong();
        prepareClickSFX();
    }

    public void playMusic(){
        if(mediaPlayerMusic != null && !mediaPlayerMusic.isPlaying())
            mediaPlayerMusic.start();
    }

    public void stopMusic(){
        if(mediaPlayerMusic != null && mediaPlayerMusic.isPlaying())
            mediaPlayerMusic.pause();
    }

    private void prepareRandomSong(){
        try{
            Random random = new Random();
            String randomSong = Music.MusicFiles.get(random.nextInt(Music.MusicFiles.size()));

            mediaPlayerMusic = new MediaPlayer();
            AssetFileDescriptor descriptor = ctx.getAssets().openFd(randomSong);
            mediaPlayerMusic.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();

            mediaPlayerMusic.prepare();
            mediaPlayerMusic.setVolume(1f, 1f);
            mediaPlayerMusic.setLooping(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void prepareClickSFX(){
        try{
            mediaPlayerSFX = new MediaPlayer();
            AssetFileDescriptor descriptor = ctx.getAssets().openFd(Music.ClickSoundEffect);
            mediaPlayerSFX.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();

            mediaPlayerSFX.prepare();
            mediaPlayerSFX.setVolume(1f, 1f);
            mediaPlayerSFX.setLooping(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void playClickSoundEffect(){
        mediaPlayerSFX.start();
    }
}
