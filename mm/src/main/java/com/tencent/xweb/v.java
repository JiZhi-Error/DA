package com.tencent.xweb;

public interface v {
    void bLx();

    void onVideoEnded();

    void onVideoEnterFullscreen(boolean z, long j2, double d2, double d3, boolean z2, boolean z3, double d4, double d5, double[] dArr);

    void onVideoError(int i2, String str);

    void onVideoExitFullscreen();

    void onVideoPause();

    void onVideoPlay();

    void onVideoPlaying();

    void onVideoSeeked();

    void onVideoSeeking();

    void onVideoSizeUpdate(double d2, double d3);

    void onVideoTimeUpdate(double d2, double d3, double[] dArr);

    void onVideoWaiting();

    boolean xJ(int i2);
}
