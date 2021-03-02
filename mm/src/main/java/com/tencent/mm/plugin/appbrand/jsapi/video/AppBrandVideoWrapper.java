package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.HttpURLConnection;
import java.net.URL;

public class AppBrandVideoWrapper extends RelativeLayout implements e, e.c {
    private static f mwD;
    private boolean bzP;
    private a cEM;
    private boolean dLQ;
    private boolean isb;
    private Context mContext;
    private e mwC;
    private f mwE;
    private e.b mwF;
    private e.h mwG;
    private float mwH;
    private int mwI;
    private boolean mwJ;
    protected int mwp;
    private e.c mwz;
    private String url;

    public static void setVideoViewFactory(f fVar) {
        AppMethodBeat.i(234614);
        Log.i("MicroMsg.Video.AppBrandVideoWrapper", "setVideoViewFactory, videoViewFactory: " + fVar.getName());
        mwD = fVar;
        AppMethodBeat.o(234614);
    }

    public AppBrandVideoWrapper(Context context) {
        this(context, null);
    }

    public AppBrandVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppBrandVideoWrapper(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(46921);
        this.mwE = null;
        this.mwG = e.h.CONTAIN;
        this.isb = false;
        this.mwH = -1.0f;
        this.mwp = 0;
        this.mwJ = true;
        this.mContext = context;
        this.cEM = new a();
        this.mwE = mwD;
        AppMethodBeat.o(46921);
    }

    public void setMyVideoViewFactory(f fVar) {
        AppMethodBeat.i(234615);
        Log.i("MicroMsg.Video.AppBrandVideoWrapper", "setMyVideoViewFactory, videoViewFactory: " + fVar.getName());
        this.mwE = fVar;
        AppMethodBeat.o(234615);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public View getView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void c(boolean z, String str, int i2) {
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(46922);
        this.mwI = i2;
        this.bzP = z;
        PString pString = new PString();
        pString.value = str;
        if (Util.isNullOrNil(pString.value) || pString.value.indexOf("file://") != 0) {
            z2 = false;
        } else {
            pString.value = pString.value.substring(7);
            z2 = true;
        }
        this.dLQ = z2;
        this.url = pString.value;
        if (this.mwC == null) {
            f fVar = this.mwE;
            if (fVar == null) {
                fVar = mwD;
            }
            Log.i("MicroMsg.Video.AppBrandVideoWrapper", "setVideoPath, videoViewFactory: " + fVar.getName());
            this.mwC = fVar.dU(this.mContext);
            this.mwC.setVideoSource(this.mwp);
            this.mwC.setIMMVideoViewCallback(this);
        } else {
            this.mwC.stop();
            z3 = false;
        }
        setScaleType(this.mwG);
        aO(this.mwH);
        setMute(this.isb);
        if (z3) {
            setVideoFooterView(this.mwF);
            addView(this.mwC.getView(), new RelativeLayout.LayoutParams(-1, -1));
        }
        this.mwC.c(this.bzP, this.url, this.mwI);
        h.RTc.aX(new com.tencent.f.i.h() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(234613);
                AppBrandVideoWrapper.a(AppBrandVideoWrapper.this);
                AppMethodBeat.o(234613);
            }

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "AppBrandVideo_checkVideoUrl";
            }
        });
        AppMethodBeat.o(46922);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void bIW() {
        AppMethodBeat.i(234616);
        Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%s preload video url %s", Integer.valueOf(hashCode()), this.url);
        if (!Util.isNullOrNil(this.url)) {
            this.mwC.bIW();
        }
        AppMethodBeat.o(234616);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public void setVideoSource(int i2) {
        this.mwp = i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public void setIMMVideoViewCallback(e.c cVar) {
        this.mwz = cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public void setVideoFooterView(e.b bVar) {
        AppMethodBeat.i(234617);
        this.mwF = bVar;
        if (this.mwC != null) {
            this.mwC.setVideoFooterView(this.mwF);
        }
        AppMethodBeat.o(234617);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public int getPlayerType() {
        AppMethodBeat.i(46927);
        if (this.mwC != null) {
            int playerType = this.mwC.getPlayerType();
            AppMethodBeat.o(46927);
            return playerType;
        }
        AppMethodBeat.o(46927);
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean p(double d2) {
        AppMethodBeat.i(46928);
        if (this.mwC != null) {
            boolean p = this.mwC.p(d2);
            AppMethodBeat.o(46928);
            return p;
        }
        AppMethodBeat.o(46928);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean c(double d2, boolean z) {
        AppMethodBeat.i(46929);
        if (this.mwC != null) {
            boolean c2 = this.mwC.c(d2, z);
            AppMethodBeat.o(46929);
            return c2;
        }
        AppMethodBeat.o(46929);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.i(46930);
        if (this.mwC != null) {
            this.mwC.setIsShowBasicControls(z);
        }
        AppMethodBeat.o(46930);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public void setFullDirection(int i2) {
        AppMethodBeat.i(46931);
        if (this.mwC != null) {
            this.mwC.setFullDirection(i2);
        }
        AppMethodBeat.o(46931);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public int getVideoDurationSec() {
        AppMethodBeat.i(46932);
        if (this.mwC != null) {
            int videoDurationSec = this.mwC.getVideoDurationSec();
            AppMethodBeat.o(46932);
            return videoDurationSec;
        }
        int i2 = this.mwI;
        AppMethodBeat.o(46932);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public int getCurrPosMs() {
        AppMethodBeat.i(46933);
        if (this.mwC != null) {
            int currPosMs = this.mwC.getCurrPosMs();
            AppMethodBeat.o(46933);
            return currPosMs;
        }
        AppMethodBeat.o(46933);
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public int getCurrPosSec() {
        AppMethodBeat.i(46934);
        if (this.mwC != null) {
            int currPosSec = this.mwC.getCurrPosSec();
            AppMethodBeat.o(46934);
            return currPosSec;
        }
        AppMethodBeat.o(46934);
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public int getCacheTimeSec() {
        AppMethodBeat.i(46935);
        if (this.mwC != null) {
            int cacheTimeSec = this.mwC.getCacheTimeSec();
            AppMethodBeat.o(46935);
            return cacheTimeSec;
        }
        AppMethodBeat.o(46935);
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean isPlaying() {
        AppMethodBeat.i(46936);
        if (this.mwC != null) {
            boolean isPlaying = this.mwC.isPlaying();
            AppMethodBeat.o(46936);
            return isPlaying;
        }
        AppMethodBeat.o(46936);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean isLive() {
        AppMethodBeat.i(46937);
        if (this.mwC != null) {
            boolean isLive = this.mwC.isLive();
            AppMethodBeat.o(46937);
            return isLive;
        }
        AppMethodBeat.o(46937);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public void setCover(Bitmap bitmap) {
        AppMethodBeat.i(46938);
        if (this.mwC != null) {
            this.mwC.setCover(bitmap);
        }
        AppMethodBeat.o(46938);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void start() {
        AppMethodBeat.i(46939);
        if (this.mwC != null) {
            this.mwC.start();
            setKeepScreenOn(true);
            if (this.mwJ) {
                this.cEM.bJI();
            }
        }
        AppMethodBeat.o(46939);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void stop() {
        AppMethodBeat.i(46940);
        if (this.mwC != null) {
            this.mwC.stop();
            if (this.mwJ) {
                this.cEM.bJJ();
            }
            setKeepScreenOn(false);
        }
        AppMethodBeat.o(46940);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean pause() {
        AppMethodBeat.i(46941);
        if (this.mwC != null) {
            setKeepScreenOn(false);
            if (this.mwJ) {
                this.cEM.bJJ();
            }
            boolean pause = this.mwC.pause();
            AppMethodBeat.o(46941);
            return pause;
        }
        AppMethodBeat.o(46941);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public void setMute(boolean z) {
        AppMethodBeat.i(46942);
        this.isb = z;
        if (this.mwC != null) {
            this.mwC.setMute(this.isb);
        }
        AppMethodBeat.o(46942);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void onUIResume() {
        AppMethodBeat.i(46943);
        if (this.mwC != null) {
            this.mwC.onUIResume();
        }
        AppMethodBeat.o(46943);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void onUIPause() {
        AppMethodBeat.i(46944);
        if (this.mwC != null) {
            this.mwC.onUIPause();
        }
        if (this.mwJ) {
            this.cEM.bJJ();
        }
        setKeepScreenOn(false);
        AppMethodBeat.o(46944);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void onUIDestroy() {
        AppMethodBeat.i(46945);
        if (this.mwC != null) {
            this.mwC.onUIDestroy();
        }
        if (this.mwJ) {
            this.cEM.bJJ();
        }
        setKeepScreenOn(false);
        AppMethodBeat.o(46945);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public void setScaleType(e.h hVar) {
        AppMethodBeat.i(46946);
        this.mwG = hVar;
        if (this.mwC != null) {
            this.mwC.setScaleType(this.mwG);
        }
        AppMethodBeat.o(46946);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean aO(float f2) {
        AppMethodBeat.i(46947);
        if (f2 <= 0.0f) {
            AppMethodBeat.o(46947);
            return false;
        }
        this.mwH = f2;
        if (this.mwC != null) {
            boolean aO = this.mwC.aO(this.mwH);
            AppMethodBeat.o(46947);
            return aO;
        }
        AppMethodBeat.o(46947);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void c(String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(46949);
        Log.w("MicroMsg.Video.AppBrandVideoWrapper", "%d onError[%s %d, %d]", Integer.valueOf(hashCode()), str3, Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.mwz != null) {
            this.mwz.c(str, str2, str3, i2, i3);
        }
        AppMethodBeat.o(46949);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void dH(String str, String str2) {
        AppMethodBeat.i(46950);
        Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onPrepared", Integer.valueOf(hashCode()));
        if (this.mwz != null) {
            this.mwz.dH(str, str2);
        }
        AppMethodBeat.o(46950);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void dI(String str, String str2) {
        AppMethodBeat.i(46951);
        Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoEnded", Integer.valueOf(hashCode()));
        if (this.mwz != null) {
            this.mwz.dI(str, str2);
        }
        AppMethodBeat.o(46951);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void d(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(46952);
        Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.mwz != null) {
            this.mwz.d(str, str2, i2, i3);
        }
        AppMethodBeat.o(46952);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void dJ(String str, String str2) {
        AppMethodBeat.i(46953);
        Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoPause", Integer.valueOf(hashCode()));
        setKeepScreenOn(false);
        if (this.mwJ) {
            this.cEM.bJJ();
        }
        if (this.mwz != null) {
            this.mwz.dJ(str, str2);
        }
        AppMethodBeat.o(46953);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void dK(String str, String str2) {
        AppMethodBeat.i(46954);
        Log.i("MicroMsg.Video.AppBrandVideoWrapper", "%d onVideoPlay", Integer.valueOf(hashCode()));
        setKeepScreenOn(true);
        if (this.mwJ) {
            this.cEM.bJI();
        }
        if (this.mwz != null) {
            this.mwz.dK(str, str2);
        }
        AppMethodBeat.o(46954);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void dL(String str, String str2) {
        AppMethodBeat.i(46955);
        if (this.mwz != null) {
            this.mwz.dL(str, str2);
        }
        AppMethodBeat.o(46955);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c
    public final void dM(String str, String str2) {
        AppMethodBeat.i(46956);
        if (this.mwz != null) {
            this.mwz.dM(str, str2);
        }
        AppMethodBeat.o(46956);
    }

    public void setKeepScreenOn(boolean z) {
        AppMethodBeat.i(46957);
        Log.d("MicroMsg.Video.AppBrandVideoWrapper", "set keep screen on:%s", Boolean.valueOf(z));
        super.setKeepScreenOn(z);
        AppMethodBeat.o(46957);
    }

    public TextureView getTexture() {
        AppMethodBeat.i(234618);
        if (this.mwC == null || !(this.mwC.getView() instanceof com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.e)) {
            AppMethodBeat.o(234618);
            return null;
        }
        TextureView videoTexture = ((com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.e) this.mwC.getView()).getVideoTexture();
        AppMethodBeat.o(234618);
        return videoTexture;
    }

    public void setFocusAudio(boolean z) {
        this.mwJ = z;
    }

    static /* synthetic */ void a(AppBrandVideoWrapper appBrandVideoWrapper) {
        AppMethodBeat.i(46960);
        if (!Util.isNullOrNil(appBrandVideoWrapper.url) && appBrandVideoWrapper.url.startsWith("http")) {
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(appBrandVideoWrapper.url).openConnection();
                httpURLConnection2.connect();
                int responseCode = httpURLConnection2.getResponseCode();
                Log.i("MicroMsg.Video.AppBrandVideoWrapper", "check video url http ret code: %s", Integer.valueOf(responseCode));
                if (responseCode >= 400 && appBrandVideoWrapper.mwz != null) {
                    appBrandVideoWrapper.mwz.c("", "", "http error", -1, responseCode);
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                    AppMethodBeat.o(46960);
                    return;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Video.AppBrandVideoWrapper", e2, "check video url error: %s", e2.getMessage());
                if (0 != 0) {
                    httpURLConnection.disconnect();
                    AppMethodBeat.o(46960);
                    return;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    httpURLConnection.disconnect();
                }
                AppMethodBeat.o(46960);
                throw th;
            }
        }
        AppMethodBeat.o(46960);
    }
}
