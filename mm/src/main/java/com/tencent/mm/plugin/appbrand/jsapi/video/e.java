package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface e {

    public interface a {
        void KD();

        void a(f fVar);

        void bGL();

        void bIZ();

        void bJA();

        void bJB();

        void bJC();

        boolean bJD();

        boolean bJt();

        void bJu();

        void bJv();

        boolean bJw();

        boolean bJx();

        boolean bJy();

        void bJz();

        void hide();

        void onDestroy();

        void seek(int i2);

        void setDanmakuBtnOnClickListener(g gVar);

        void setDanmakuBtnOpen(boolean z);

        void setExitFullScreenBtnOnClickListener(View.OnClickListener onClickListener);

        void setFullScreenBtnOnClickListener(View.OnClickListener onClickListener);

        void setIplaySeekCallback(d dVar);

        void setIsPlay(boolean z);

        void setMuteBtnOnClickListener(View.OnClickListener onClickListener);

        void setMuteBtnState(boolean z);

        void setOnPlayButtonClickListener(View.OnClickListener onClickListener);

        void setOnUpdateProgressLenListener(AbstractC0717e eVar);

        void setPlayBtnInCenterPosition(boolean z);

        void setShowControlProgress(boolean z);

        void setShowDanmakuBtn(boolean z);

        void setShowFullScreenBtn(boolean z);

        void setShowMuteBtn(boolean z);

        void setShowPlayBtn(boolean z);

        void setShowProgress(boolean z);

        void setStatePorter(i iVar);

        void setTitle(String str);
    }

    public interface b {
        int getVideoTotalTime();

        void hP(boolean z);

        void setVideoTotalTime(int i2);

        void xv(int i2);
    }

    public interface c {
        void c(String str, String str2, String str3, int i2, int i3);

        void d(String str, String str2, int i2, int i3);

        void dH(String str, String str2);

        void dI(String str, String str2);

        void dJ(String str, String str2);

        void dK(String str, String str2);

        void dL(String str, String str2);

        void dM(String str, String str2);
    }

    public interface d {
        void aJq();

        void rk(int i2);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.e$e  reason: collision with other inner class name */
    public interface AbstractC0717e {
        void onProgressChanged(int i2, int i3);
    }

    public interface f {
        void onVisibilityChanged(boolean z);
    }

    public interface g {
        void hO(boolean z);
    }

    public interface i {
        int bJh();

        int bJi();
    }

    boolean aO(float f2);

    void bIW();

    void c(boolean z, String str, int i2);

    boolean c(double d2, boolean z);

    int getCacheTimeSec();

    int getCurrPosMs();

    int getCurrPosSec();

    int getPlayerType();

    int getVideoDurationSec();

    View getView();

    boolean isLive();

    boolean isPlaying();

    void onUIDestroy();

    void onUIPause();

    void onUIResume();

    boolean p(double d2);

    boolean pause();

    void setCover(Bitmap bitmap);

    void setFullDirection(int i2);

    void setIMMVideoViewCallback(c cVar);

    void setIsShowBasicControls(boolean z);

    void setMute(boolean z);

    void setScaleType(h hVar);

    void setVideoFooterView(b bVar);

    void setVideoSource(int i2);

    void start();

    void stop();

    public enum h {
        DEFAULT,
        FILL,
        CONTAIN,
        COVER;

        public static h valueOf(String str) {
            AppMethodBeat.i(137805);
            h hVar = (h) Enum.valueOf(h.class, str);
            AppMethodBeat.o(137805);
            return hVar;
        }

        static {
            AppMethodBeat.i(137806);
            AppMethodBeat.o(137806);
        }
    }
}
