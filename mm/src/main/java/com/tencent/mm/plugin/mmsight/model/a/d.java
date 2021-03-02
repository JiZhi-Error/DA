package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.plugin.mmsight.model.g;

public interface d {

    public interface a {
        void bqP();
    }

    public interface b {
    }

    void E(Runnable runnable);

    void HA(String str);

    void HB(String str);

    void M(int i2, int i3, int i4);

    void a(a aVar);

    String aQK();

    float aQL();

    long aQM();

    c aQN();

    int aQO();

    Point aQP();

    int aQQ();

    boolean aQR();

    c.a aQS();

    void aQT();

    String aQn();

    void av(float f2);

    int b(int i2, boolean z, int i3);

    void cancel();

    void clear();

    void fk(boolean z);

    String getFileName();

    String getFilePath();

    g getFrameDataCallback();

    String getMd5();

    boolean isLandscape();

    void pause();

    boolean rC(int i2);

    void rD(int i2);

    void reset();

    void s(int i2, int i3, int i4, int i5);

    void setFilePath(String str);

    void setMirror(boolean z);

    void setMute(boolean z);

    public enum c {
        WaitStart,
        Start,
        PrepareStop,
        WaitStop,
        Stop,
        WaitSend,
        Sent,
        Error,
        Initialized,
        Pause;

        public static c valueOf(String str) {
            AppMethodBeat.i(148824);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(148824);
            return cVar;
        }

        static {
            AppMethodBeat.i(148825);
            AppMethodBeat.o(148825);
        }
    }
}
