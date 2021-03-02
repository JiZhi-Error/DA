package com.tencent.mm.plugin.n;

import android.view.Surface;

public interface c {
    long getDurationMs();

    void pause();

    boolean prepare();

    void release();

    void seek(int i2);

    void setPath(String str);

    void setSurface(Surface surface);

    void start();

    void stop();
}
