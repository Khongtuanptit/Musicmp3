package com.example.basicmusic;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.List;

import phucdv.android.musichelper.Song;

public class MusicPalybackService extends Service {

    MusicController mMusicController;


    @Override
    public void onCreate() {
        mMusicController = new MusicController(this);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MusicServiceBinder();
    }


    public class MusicServiceBinder extends Binder{
        public MusicPalybackService getService(){
            return MusicPalybackService.this;
        }
    }

    public void setData(List<Song> song){
        mMusicController.setData(song);
    }

    public void playSongAt(int index){
        mMusicController.playSongAt(index);
    }


    public void play(){
        mMusicController.start();
    }

    public void pause(){
        mMusicController.pause();
    }

    public void next(){
        mMusicController.playNext();
    }

    public void prev(){
        mMusicController.playPrev();
    }
}
