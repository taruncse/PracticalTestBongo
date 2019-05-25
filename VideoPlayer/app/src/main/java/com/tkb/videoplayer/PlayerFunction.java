package com.tkb.videoplayer;

public interface PlayerFunction {
    boolean hasExternalStorage();
    String getVideoPath();
    int getVideoSize();
}
