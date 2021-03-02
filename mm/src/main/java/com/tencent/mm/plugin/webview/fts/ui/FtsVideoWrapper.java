package com.tencent.mm.plugin.webview.fts.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class FtsVideoWrapper extends RelativeLayout implements d.a, i, i.a, i.b, i.c {
    private i.e BOo;
    private i Eho;
    private boolean bzP;
    private boolean dLQ;
    private boolean isb;
    private Context mContext;
    private float mwH;
    private int mwI;
    private h pNf;
    private i.b pNj;
    private d pNk;
    private String url;

    public FtsVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FtsVideoWrapper(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(77989);
        this.BOo = i.e.CONTAIN;
        this.isb = false;
        this.mwH = -1.0f;
        this.mContext = context;
        this.pNk = new d();
        AppMethodBeat.o(77989);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void c(boolean z, String str, int i2) {
        boolean z2;
        AppMethodBeat.i(77990);
        this.mwI = i2;
        this.bzP = z;
        PString pString = new PString();
        pString.value = str;
        Util.isNullOrNil(pString.value);
        this.dLQ = false;
        this.url = pString.value;
        if (this.Eho == null) {
            Log.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", Integer.valueOf(hashCode()));
            this.Eho = dUF();
            z2 = true;
        } else if (this.Eho instanceof MMVideoView) {
            this.Eho.stop();
            this.Eho.dFl();
            removeView((View) this.Eho);
            Log.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", Integer.valueOf(hashCode()));
            this.Eho = dUF();
            z2 = true;
        } else {
            Log.i("MicroMsg.AppBrandVideoWrapper", "%d use last common video view !", Integer.valueOf(hashCode()));
            this.Eho.stop();
            z2 = false;
        }
        setScaleType(this.BOo);
        aO(this.mwH);
        setMute(this.isb);
        if (z2) {
            setVideoFooterView(this.pNf);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            addView((View) this.Eho, layoutParams);
        }
        this.Eho.c(this.bzP, this.url, this.mwI);
        AppMethodBeat.o(77990);
    }

    private i dUF() {
        AppMethodBeat.i(77991);
        CommonVideoView commonVideoView = new CommonVideoView(this.mContext);
        commonVideoView.setReporter(this);
        commonVideoView.setIMMVideoViewCallback(this);
        AppMethodBeat.o(77991);
        return commonVideoView;
    }

    public void setIMMVideoViewCallback(i.b bVar) {
        this.pNj = bVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setVideoFooterView(h hVar) {
        AppMethodBeat.i(77992);
        this.pNf = hVar;
        if (this.Eho != null) {
            this.Eho.setVideoFooterView(this.pNf);
        }
        AppMethodBeat.o(77992);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void dFl() {
        AppMethodBeat.i(77993);
        if (this.Eho != null) {
            this.Eho.dFl();
        }
        AppMethodBeat.o(77993);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getPlayerType() {
        AppMethodBeat.i(77994);
        if (this.Eho != null) {
            int playerType = this.Eho.getPlayerType();
            AppMethodBeat.o(77994);
            return playerType;
        }
        AppMethodBeat.o(77994);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean p(double d2) {
        AppMethodBeat.i(77995);
        if (this.Eho != null) {
            boolean p = this.Eho.p(d2);
            AppMethodBeat.o(77995);
            return p;
        }
        AppMethodBeat.o(77995);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean c(double d2, boolean z) {
        AppMethodBeat.i(77996);
        if (this.Eho != null) {
            boolean c2 = this.Eho.c(d2, z);
            AppMethodBeat.o(77996);
            return c2;
        }
        AppMethodBeat.o(77996);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.i(77997);
        if (this.Eho != null) {
            this.Eho.setIsShowBasicControls(z);
        }
        AppMethodBeat.o(77997);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setFullDirection(int i2) {
        AppMethodBeat.i(77998);
        if (this.Eho != null) {
            this.Eho.setFullDirection(i2);
        }
        AppMethodBeat.o(77998);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getVideoDurationSec() {
        AppMethodBeat.i(77999);
        if (this.Eho != null) {
            int videoDurationSec = this.Eho.getVideoDurationSec();
            AppMethodBeat.o(77999);
            return videoDurationSec;
        }
        int i2 = this.mwI;
        AppMethodBeat.o(77999);
        return i2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getCurrPosMs() {
        AppMethodBeat.i(78000);
        if (this.Eho != null) {
            int currPosMs = this.Eho.getCurrPosMs();
            AppMethodBeat.o(78000);
            return currPosMs;
        }
        AppMethodBeat.o(78000);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getCurrPosSec() {
        AppMethodBeat.i(78001);
        if (this.Eho != null) {
            int currPosSec = this.Eho.getCurrPosSec();
            AppMethodBeat.o(78001);
            return currPosSec;
        }
        AppMethodBeat.o(78001);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getCacheTimeSec() {
        AppMethodBeat.i(78002);
        if (this.Eho != null) {
            int cacheTimeSec = this.Eho.getCacheTimeSec();
            AppMethodBeat.o(78002);
            return cacheTimeSec;
        }
        AppMethodBeat.o(78002);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean isPlaying() {
        AppMethodBeat.i(78003);
        if (this.Eho != null) {
            boolean isPlaying = this.Eho.isPlaying();
            AppMethodBeat.o(78003);
            return isPlaying;
        }
        AppMethodBeat.o(78003);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean isLive() {
        AppMethodBeat.i(78004);
        if (this.Eho != null) {
            boolean isLive = this.Eho.isLive();
            AppMethodBeat.o(78004);
            return isLive;
        }
        AppMethodBeat.o(78004);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setCover(Bitmap bitmap) {
        AppMethodBeat.i(78005);
        if (this.Eho != null) {
            this.Eho.setCover(bitmap);
        }
        AppMethodBeat.o(78005);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void start() {
        AppMethodBeat.i(78006);
        if (this.Eho != null) {
            this.Eho.start();
            setKeepScreenOn(true);
            this.pNk.a(this);
        }
        AppMethodBeat.o(78006);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void stop() {
        AppMethodBeat.i(78007);
        if (this.Eho != null) {
            this.Eho.stop();
            this.pNk.fp(false);
            setKeepScreenOn(false);
        }
        AppMethodBeat.o(78007);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean pause() {
        AppMethodBeat.i(78008);
        if (this.Eho != null) {
            setKeepScreenOn(false);
            this.pNk.fp(false);
            boolean pause = this.Eho.pause();
            AppMethodBeat.o(78008);
            return pause;
        }
        AppMethodBeat.o(78008);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setMute(boolean z) {
        AppMethodBeat.i(78009);
        this.isb = z;
        if (this.Eho != null) {
            this.Eho.setMute(this.isb);
        }
        AppMethodBeat.o(78009);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void onUIResume() {
        AppMethodBeat.i(78010);
        if (this.Eho != null) {
            this.Eho.onUIResume();
        }
        AppMethodBeat.o(78010);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void onUIPause() {
        AppMethodBeat.i(78011);
        if (this.Eho != null) {
            this.Eho.onUIPause();
        }
        this.pNk.fp(false);
        setKeepScreenOn(false);
        AppMethodBeat.o(78011);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void onUIDestroy() {
        AppMethodBeat.i(78012);
        if (this.Eho != null) {
            this.Eho.onUIDestroy();
        }
        this.pNk.fp(false);
        setKeepScreenOn(false);
        AppMethodBeat.o(78012);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setScaleType(i.e eVar) {
        AppMethodBeat.i(78013);
        this.BOo = eVar;
        if (this.Eho != null) {
            this.Eho.setScaleType(this.BOo);
        }
        AppMethodBeat.o(78013);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean aO(float f2) {
        AppMethodBeat.i(78014);
        if (f2 <= 0.0f) {
            AppMethodBeat.o(78014);
            return false;
        }
        this.mwH = f2;
        if (this.Eho != null) {
            boolean aO = this.Eho.aO(this.mwH);
            AppMethodBeat.o(78014);
            return aO;
        }
        AppMethodBeat.o(78014);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setLoop(boolean z) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setLoopCompletionCallback(i.d dVar) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.a
    public final void aO(String str, boolean z) {
        boolean z2;
        AppMethodBeat.i(78015);
        Log.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", Integer.valueOf(hashCode()), str, Boolean.valueOf(z));
        if (z) {
            AppMethodBeat.o(78015);
            return;
        }
        if (this.Eho instanceof MMVideoView) {
            this.Eho.stop();
            this.Eho.dFl();
            removeView((View) this.Eho);
            Log.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use common video view !", Integer.valueOf(hashCode()));
            this.Eho = dUF();
            z2 = true;
        } else {
            z2 = false;
        }
        setScaleType(this.BOo);
        aO(this.mwH);
        setMute(this.isb);
        if (z2) {
            setVideoFooterView(this.pNf);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            addView((View) this.Eho, layoutParams);
            this.Eho.c(this.bzP, this.url, this.mwI);
            this.Eho.start();
        }
        AppMethodBeat.o(78015);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void c(String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(78016);
        Log.w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", Integer.valueOf(hashCode()), str3, Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.pNj != null) {
            this.pNj.c(str, str2, str3, i2, i3);
        }
        AppMethodBeat.o(78016);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dH(String str, String str2) {
        AppMethodBeat.i(78017);
        Log.i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", Integer.valueOf(hashCode()));
        if (this.pNj != null) {
            this.pNj.dH(str, str2);
        }
        AppMethodBeat.o(78017);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dI(String str, String str2) {
        AppMethodBeat.i(78018);
        Log.i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", Integer.valueOf(hashCode()));
        if (this.pNj != null) {
            this.pNj.dI(str, str2);
        }
        AppMethodBeat.o(78018);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void d(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(78019);
        Log.i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.pNj != null) {
            this.pNj.d(str, str2, i2, i3);
        }
        AppMethodBeat.o(78019);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dJ(String str, String str2) {
        AppMethodBeat.i(78020);
        Log.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", Integer.valueOf(hashCode()));
        setKeepScreenOn(false);
        this.pNk.fp(false);
        if (this.pNj != null) {
            this.pNj.dJ(str, str2);
        }
        AppMethodBeat.o(78020);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dK(String str, String str2) {
        AppMethodBeat.i(78021);
        Log.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", Integer.valueOf(hashCode()));
        setKeepScreenOn(true);
        this.pNk.a(this);
        if (this.pNj != null) {
            this.pNj.dK(str, str2);
        }
        AppMethodBeat.o(78021);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dL(String str, String str2) {
        AppMethodBeat.i(78022);
        if (this.pNj != null) {
            this.pNj.dL(str, str2);
        }
        AppMethodBeat.o(78022);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dM(String str, String str2) {
        AppMethodBeat.i(78023);
        if (this.pNj != null) {
            this.pNj.dM(str, str2);
        }
        AppMethodBeat.o(78023);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void fo(String str, String str2) {
    }

    public void setKeepScreenOn(boolean z) {
        AppMethodBeat.i(78024);
        Log.d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", Boolean.valueOf(z), Util.getStack());
        super.setKeepScreenOn(z);
        AppMethodBeat.o(78024);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.c
    public final void yU(long j2) {
        AppMethodBeat.i(78025);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(600, j2, 1, false);
        AppMethodBeat.o(78025);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.c
    public final void DX(String str) {
        AppMethodBeat.i(78026);
        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(14349, str);
        AppMethodBeat.o(78026);
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
