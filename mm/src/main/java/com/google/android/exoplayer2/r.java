package com.google.android.exoplayer2;

import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.source.n;

public interface r extends f.b {
    void a(t tVar, Format[] formatArr, n nVar, long j2, boolean z, long j3);

    void a(Format[] formatArr, n nVar, long j2);

    void disable();

    void e(long j2, long j3);

    int getState();

    int getTrackType();

    boolean isReady();

    s sW();

    i sX();

    n sY();

    boolean sZ();

    void setIndex(int i2);

    void start();

    void stop();

    boolean tB();

    void ta();

    boolean tb();

    void tc();

    void u(long j2);
}
