package com.tkb.videoplayer;

public class Player implements PlayerFunction{
    @Override
    public boolean hasExternalStorage() {
        return false;
    }

    @Override
    public String getVideoPath() {
        return null;
    }

    @Override
    public int getVideoSize() {
        return 0;
    }
}
