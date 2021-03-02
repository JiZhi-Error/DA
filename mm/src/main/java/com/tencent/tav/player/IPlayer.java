package com.tencent.tav.player;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public interface IPlayer {

    public interface PlayerListener {
        void onPositionChanged(CMTime cMTime);

        void onStatusChanged(PlayerStatus playerStatus);
    }

    PlayerStatus currentStatus();

    CMTime duration();

    boolean isPlaying();

    void pause();

    void play();

    CMTime position();

    void release();

    void release(Runnable runnable);

    void seekToTime(CMTime cMTime, Callback callback);

    void setLoop(boolean z);

    void setOnCompositionUpdateListener(OnCompositionUpdateListener onCompositionUpdateListener);

    void setPlayRange(CMTimeRange cMTimeRange);

    void setPlayerListener(PlayerListener playerListener);

    void setVolume(float f2);

    void stop();

    void update(PlayerItem playerItem, CMTime cMTime);

    void updateAudioClipsProperties();

    void updateAudioVolumeProperties();

    int videoHeight();

    int videoWidth();

    void waitForRelease(long j2);

    public enum PlayerStatus {
        IDLE,
        READY,
        PLAYING,
        STOPPED,
        PAUSED,
        FINISHED,
        ERROR,
        REPLAY;

        public static PlayerStatus valueOf(String str) {
            AppMethodBeat.i(218547);
            PlayerStatus playerStatus = (PlayerStatus) Enum.valueOf(PlayerStatus.class, str);
            AppMethodBeat.o(218547);
            return playerStatus;
        }

        static {
            AppMethodBeat.i(218548);
            AppMethodBeat.o(218548);
        }
    }
}
