package com.tkb.videoplayer;

public class PlayerFacade implements PlayerInterface{
    protected  Player player;
    Update update;
    public PlayerFacade(Player player, Update update){
        this.player = player;
        this.update = update;
    }

    @Override
    public void play() {
        player.getVideoPath();
        player.getVideoSize();
        player.hasExternalStorage();
        update.update(Constants.PLAY);
    }

    @Override
    public void pause() {
        player.getVideoPath();
        update.update(Constants.PAUSE);

    }

    @Override
    public void forward() {
        player.getVideoPath();
        update.update(Constants.FORWARD);

    }

    @Override
    public void rewind() {
        player.getVideoPath();
        update.update(Constants.REWIND);
    }
}
