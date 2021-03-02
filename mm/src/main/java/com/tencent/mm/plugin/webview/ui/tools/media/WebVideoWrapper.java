package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class WebVideoWrapper extends RelativeLayout implements d.a, i, i.b, i.c {
    private i Eho;
    private boolean bzP;
    private Context mContext;
    private int mwI;
    private i.b pNj;
    private d pNk;
    private String url;

    public WebVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebVideoWrapper(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(82068);
        this.mContext = context;
        this.pNk = new d();
        if (this.Eho == null) {
            CommonVideoView commonVideoView = new CommonVideoView(this.mContext);
            commonVideoView.setReporter(this);
            commonVideoView.setIMMVideoViewCallback(this);
            yU(200);
            this.Eho = commonVideoView;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        addView((View) this.Eho, layoutParams);
        AppMethodBeat.o(82068);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void c(boolean z, String str, int i2) {
        AppMethodBeat.i(82069);
        this.mwI = i2;
        this.bzP = z;
        this.url = str;
        if (this.Eho != null) {
            this.Eho.c(this.bzP, this.url, this.mwI);
        }
        AppMethodBeat.o(82069);
    }

    public void setIMMVideoViewCallback(i.b bVar) {
        this.pNj = bVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setVideoFooterView(h hVar) {
        AppMethodBeat.i(82070);
        if (this.Eho != null) {
            this.Eho.setVideoFooterView(hVar);
        }
        AppMethodBeat.o(82070);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void dFl() {
        AppMethodBeat.i(82071);
        if (this.Eho != null) {
            this.Eho.dFl();
        }
        AppMethodBeat.o(82071);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getPlayerType() {
        AppMethodBeat.i(82072);
        if (this.Eho != null) {
            int playerType = this.Eho.getPlayerType();
            AppMethodBeat.o(82072);
            return playerType;
        }
        AppMethodBeat.o(82072);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean p(double d2) {
        AppMethodBeat.i(82073);
        if (this.Eho != null) {
            boolean p = this.Eho.p(d2);
            AppMethodBeat.o(82073);
            return p;
        }
        AppMethodBeat.o(82073);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean c(double d2, boolean z) {
        AppMethodBeat.i(82074);
        if (this.Eho != null) {
            boolean c2 = this.Eho.c(d2, z);
            AppMethodBeat.o(82074);
            return c2;
        }
        AppMethodBeat.o(82074);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.i(82075);
        if (this.Eho != null) {
            this.Eho.setIsShowBasicControls(z);
        }
        AppMethodBeat.o(82075);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setFullDirection(int i2) {
        AppMethodBeat.i(82076);
        if (this.Eho != null) {
            this.Eho.setFullDirection(i2);
        }
        AppMethodBeat.o(82076);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getVideoDurationSec() {
        AppMethodBeat.i(82077);
        if (this.Eho != null) {
            int videoDurationSec = this.Eho.getVideoDurationSec();
            AppMethodBeat.o(82077);
            return videoDurationSec;
        }
        int i2 = this.mwI;
        AppMethodBeat.o(82077);
        return i2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getCurrPosMs() {
        AppMethodBeat.i(82078);
        if (this.Eho != null) {
            int currPosMs = this.Eho.getCurrPosMs();
            AppMethodBeat.o(82078);
            return currPosMs;
        }
        AppMethodBeat.o(82078);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getCurrPosSec() {
        AppMethodBeat.i(82079);
        if (this.Eho != null) {
            int currPosSec = this.Eho.getCurrPosSec();
            AppMethodBeat.o(82079);
            return currPosSec;
        }
        AppMethodBeat.o(82079);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getCacheTimeSec() {
        AppMethodBeat.i(82080);
        if (this.Eho != null) {
            int cacheTimeSec = this.Eho.getCacheTimeSec();
            AppMethodBeat.o(82080);
            return cacheTimeSec;
        }
        AppMethodBeat.o(82080);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean isPlaying() {
        AppMethodBeat.i(82081);
        if (this.Eho != null) {
            boolean isPlaying = this.Eho.isPlaying();
            AppMethodBeat.o(82081);
            return isPlaying;
        }
        AppMethodBeat.o(82081);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean isLive() {
        AppMethodBeat.i(82082);
        if (this.Eho != null) {
            boolean isLive = this.Eho.isLive();
            AppMethodBeat.o(82082);
            return isLive;
        }
        AppMethodBeat.o(82082);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setCover(Bitmap bitmap) {
        AppMethodBeat.i(82083);
        if (this.Eho != null) {
            this.Eho.setCover(bitmap);
        }
        AppMethodBeat.o(82083);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void start() {
        AppMethodBeat.i(82084);
        if (this.Eho != null) {
            this.Eho.start();
            setKeepScreenOn(true);
            this.pNk.a(this);
        }
        AppMethodBeat.o(82084);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void stop() {
        AppMethodBeat.i(82085);
        if (this.Eho != null) {
            this.Eho.stop();
            this.pNk.fp(false);
            setKeepScreenOn(false);
        }
        AppMethodBeat.o(82085);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean pause() {
        AppMethodBeat.i(82086);
        if (this.Eho != null) {
            setKeepScreenOn(false);
            this.pNk.fp(false);
            boolean pause = this.Eho.pause();
            AppMethodBeat.o(82086);
            return pause;
        }
        AppMethodBeat.o(82086);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setMute(boolean z) {
        AppMethodBeat.i(82087);
        if (this.Eho != null) {
            this.Eho.setMute(z);
        }
        AppMethodBeat.o(82087);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void onUIResume() {
        AppMethodBeat.i(82088);
        if (this.Eho != null) {
            this.Eho.onUIResume();
        }
        AppMethodBeat.o(82088);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void onUIPause() {
        AppMethodBeat.i(82089);
        if (this.Eho != null) {
            this.Eho.onUIPause();
        }
        this.pNk.fp(false);
        setKeepScreenOn(false);
        AppMethodBeat.o(82089);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void onUIDestroy() {
        AppMethodBeat.i(82090);
        if (this.Eho != null) {
            this.Eho.onUIDestroy();
        }
        this.pNk.fp(false);
        setKeepScreenOn(false);
        AppMethodBeat.o(82090);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setScaleType(i.e eVar) {
        AppMethodBeat.i(82091);
        if (this.Eho != null) {
            this.Eho.setScaleType(eVar);
        }
        AppMethodBeat.o(82091);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean aO(float f2) {
        AppMethodBeat.i(82092);
        if (f2 <= 0.0f) {
            AppMethodBeat.o(82092);
            return false;
        } else if (this.Eho != null) {
            boolean aO = this.Eho.aO(f2);
            AppMethodBeat.o(82092);
            return aO;
        } else {
            AppMethodBeat.o(82092);
            return false;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setLoop(boolean z) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setLoopCompletionCallback(i.d dVar) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void c(String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(82093);
        Log.w("MicroMsg.WebVideoWrapper", "%d onError[%s %d, %d]", Integer.valueOf(hashCode()), str3, Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.pNj != null) {
            this.pNj.c(str, str2, str3, i2, i3);
        }
        AppMethodBeat.o(82093);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dH(String str, String str2) {
        AppMethodBeat.i(82094);
        Log.i("MicroMsg.WebVideoWrapper", "%d onPrepared", Integer.valueOf(hashCode()));
        if (this.pNj != null) {
            this.pNj.dH(str, str2);
        }
        AppMethodBeat.o(82094);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dI(String str, String str2) {
        AppMethodBeat.i(82095);
        Log.i("MicroMsg.WebVideoWrapper", "%d onVideoEnded", Integer.valueOf(hashCode()));
        if (this.pNj != null) {
            this.pNj.dI(str, str2);
        }
        AppMethodBeat.o(82095);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void d(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(82096);
        Log.i("MicroMsg.WebVideoWrapper", "%d onGetVideoSize[%d %d]", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.pNj != null) {
            this.pNj.d(str, str2, i2, i3);
        }
        AppMethodBeat.o(82096);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dJ(String str, String str2) {
        AppMethodBeat.i(82097);
        Log.d("MicroMsg.WebVideoWrapper", "%d onVideoPause", Integer.valueOf(hashCode()));
        setKeepScreenOn(false);
        this.pNk.fp(false);
        if (this.pNj != null) {
            this.pNj.dJ(str, str2);
        }
        AppMethodBeat.o(82097);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dK(String str, String str2) {
        AppMethodBeat.i(82098);
        Log.d("MicroMsg.WebVideoWrapper", "%d onVideoPlay", Integer.valueOf(hashCode()));
        setKeepScreenOn(true);
        this.pNk.a(this);
        if (this.pNj != null) {
            this.pNj.dK(str, str2);
        }
        AppMethodBeat.o(82098);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dL(String str, String str2) {
        AppMethodBeat.i(82099);
        if (this.pNj != null) {
            this.pNj.dL(str, str2);
        }
        AppMethodBeat.o(82099);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dM(String str, String str2) {
        AppMethodBeat.i(82100);
        if (this.pNj != null) {
            this.pNj.dM(str, str2);
        }
        AppMethodBeat.o(82100);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void fo(String str, String str2) {
    }

    public void setKeepScreenOn(boolean z) {
        AppMethodBeat.i(82101);
        Log.d("MicroMsg.WebVideoWrapper", "set keep screen on[%b] stack[%s]", Boolean.valueOf(z), Util.getStack());
        super.setKeepScreenOn(z);
        AppMethodBeat.o(82101);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.c
    public final void yU(long j2) {
        AppMethodBeat.i(82102);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(600, j2, 1, false);
        AppMethodBeat.o(82102);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.c
    public final void DX(String str) {
        AppMethodBeat.i(82103);
        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(14349, str);
        AppMethodBeat.o(82103);
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTw() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTx() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTy() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTz() {
    }
}
