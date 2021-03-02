package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface i {

    public interface a {
        void aO(String str, boolean z);
    }

    public interface b {
        void c(String str, String str2, String str3, int i2, int i3);

        void d(String str, String str2, int i2, int i3);

        void dH(String str, String str2);

        void dI(String str, String str2);

        void dJ(String str, String str2);

        void dK(String str, String str2);

        void dL(String str, String str2);

        void dM(String str, String str2);

        void fo(String str, String str2);
    }

    public interface c {
        void DX(String str);

        void yU(long j2);
    }

    public interface d {
        void fdO();
    }

    boolean aO(float f2);

    void c(boolean z, String str, int i2);

    boolean c(double d2, boolean z);

    void dFl();

    int getCacheTimeSec();

    int getCurrPosMs();

    int getCurrPosSec();

    int getPlayerType();

    int getVideoDurationSec();

    boolean isLive();

    boolean isPlaying();

    void onUIDestroy();

    void onUIPause();

    void onUIResume();

    boolean p(double d2);

    boolean pause();

    void setCover(Bitmap bitmap);

    void setFullDirection(int i2);

    void setIsShowBasicControls(boolean z);

    void setLoop(boolean z);

    void setLoopCompletionCallback(d dVar);

    void setMute(boolean z);

    void setScaleType(e eVar);

    void setVideoFooterView(h hVar);

    void start();

    void stop();

    public enum e {
        DEFAULT,
        FILL,
        CONTAIN,
        COVER,
        CROP;

        public static e valueOf(String str) {
            AppMethodBeat.i(134007);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(134007);
            return eVar;
        }

        static {
            AppMethodBeat.i(134008);
            AppMethodBeat.o(134008);
        }
    }
}
