package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.modelvideo.AdLandingMMVideoView;
import com.tencent.mm.modelvideo.FullScreenMMVideoView;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.p.p;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;

public class AdLandingVideoWrapper extends RelativeLayout implements d.a, i, i.a, i.b, i.c {
    private i.e BOo;
    private i Eho;
    private a Ehp;
    public MTimerHandler Ehq;
    private boolean bzP;
    private boolean dLQ;
    private boolean isb;
    private Context mContext;
    private float mwH;
    private int mwI;
    private boolean onr;
    private h pNf;
    private i.b pNj;
    private d pNk;
    private String url;

    public interface a {
        void xv(int i2);
    }

    public AdLandingVideoWrapper(Context context) {
        this(context, null);
    }

    public AdLandingVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdLandingVideoWrapper(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(96831);
        this.BOo = i.e.CONTAIN;
        this.isb = false;
        this.mwH = -1.0f;
        this.onr = false;
        this.Ehq = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(96830);
                if (AdLandingVideoWrapper.this.Eho == null || AdLandingVideoWrapper.this.Ehp == null) {
                    AppMethodBeat.o(96830);
                    return false;
                }
                if (AdLandingVideoWrapper.this.Ehp != null && AdLandingVideoWrapper.this.Eho.isPlaying()) {
                    AdLandingVideoWrapper.this.Ehp.xv(AdLandingVideoWrapper.this.Eho.getCurrPosSec());
                }
                AppMethodBeat.o(96830);
                return true;
            }
        }, true);
        this.mContext = context;
        this.pNk = new d();
        AppMethodBeat.o(96831);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x006e  */
    @Override // com.tencent.mm.pluginsdk.ui.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(boolean r9, java.lang.String r10, int r11) {
        /*
        // Method dump skipped, instructions count: 459
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper.c(boolean, java.lang.String, int):void");
    }

    private i dUF() {
        AppMethodBeat.i(96833);
        CommonVideoView commonVideoView = new CommonVideoView(this.mContext);
        commonVideoView.setReporter(this);
        commonVideoView.setIMMVideoViewCallback(this);
        AppMethodBeat.o(96833);
        return commonVideoView;
    }

    private i dUG() {
        AppMethodBeat.i(96834);
        AdLandingMMVideoView adLandingMMVideoView = new AdLandingMMVideoView(this.mContext);
        adLandingMMVideoView.setReporter(this);
        adLandingMMVideoView.setIMMVideoViewCallback(this);
        adLandingMMVideoView.setIMMDownloadFinish(this);
        String few = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.few();
        FilePathGenerator.checkMkdir(few);
        adLandingMMVideoView.setRootPath(few);
        adLandingMMVideoView.setIOnlineVideoProxy(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a());
        AppMethodBeat.o(96834);
        return adLandingMMVideoView;
    }

    private i fdP() {
        AppMethodBeat.i(203118);
        try {
            FullScreenMMVideoView fullScreenMMVideoView = new FullScreenMMVideoView(this.mContext);
            fullScreenMMVideoView.setReporter(this);
            fullScreenMMVideoView.setIMMVideoViewCallback(this);
            fullScreenMMVideoView.setIMMDownloadFinish(this);
            String few = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.few();
            FilePathGenerator.checkMkdir(few);
            fullScreenMMVideoView.setRootPath(few);
            fullScreenMMVideoView.setIOnlineVideoProxy(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a());
            AppMethodBeat.o(203118);
            return fullScreenMMVideoView;
        } catch (Throwable th) {
            Log.e("MicroMsg.AdLandingVideoWrapper", th.toString());
            FullScreenMMVideoView fullScreenMMVideoView2 = new FullScreenMMVideoView(this.mContext);
            AppMethodBeat.o(203118);
            return fullScreenMMVideoView2;
        }
    }

    public void setFullScreen(boolean z) {
        this.onr = z;
    }

    private boolean dUI() {
        if (this.bzP || this.dLQ) {
            return true;
        }
        return false;
    }

    public void setIMMVideoViewCallback(i.b bVar) {
        this.pNj = bVar;
    }

    public void setVideoPlayCallback(a aVar) {
        this.Ehp = aVar;
    }

    public final void fdQ() {
        AppMethodBeat.i(96835);
        this.Ehq.stopTimer();
        this.Ehq.startTimer(1000);
        AppMethodBeat.o(96835);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setVideoFooterView(h hVar) {
        AppMethodBeat.i(96836);
        this.pNf = hVar;
        if (this.Eho != null) {
            this.Eho.setVideoFooterView(this.pNf);
        }
        AppMethodBeat.o(96836);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void dFl() {
        AppMethodBeat.i(96837);
        if (this.Eho != null) {
            this.Eho.dFl();
        }
        AppMethodBeat.o(96837);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getPlayerType() {
        AppMethodBeat.i(96838);
        if (this.Eho != null) {
            int playerType = this.Eho.getPlayerType();
            AppMethodBeat.o(96838);
            return playerType;
        }
        AppMethodBeat.o(96838);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean p(double d2) {
        AppMethodBeat.i(96839);
        if (this.Eho != null) {
            boolean p = this.Eho.p(d2);
            AppMethodBeat.o(96839);
            return p;
        }
        AppMethodBeat.o(96839);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean c(double d2, boolean z) {
        AppMethodBeat.i(96840);
        if (this.Eho != null) {
            boolean c2 = this.Eho.c(d2, z);
            AppMethodBeat.o(96840);
            return c2;
        }
        AppMethodBeat.o(96840);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.i(96841);
        if (this.Eho != null) {
            this.Eho.setIsShowBasicControls(z);
        }
        AppMethodBeat.o(96841);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setFullDirection(int i2) {
        AppMethodBeat.i(96842);
        if (this.Eho != null) {
            this.Eho.setFullDirection(i2);
        }
        AppMethodBeat.o(96842);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getVideoDurationSec() {
        AppMethodBeat.i(96843);
        if (this.Eho != null) {
            int videoDurationSec = this.Eho.getVideoDurationSec();
            AppMethodBeat.o(96843);
            return videoDurationSec;
        }
        int i2 = this.mwI;
        AppMethodBeat.o(96843);
        return i2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getCurrPosMs() {
        AppMethodBeat.i(96844);
        if (this.Eho != null) {
            int currPosMs = this.Eho.getCurrPosMs();
            AppMethodBeat.o(96844);
            return currPosMs;
        }
        AppMethodBeat.o(96844);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getCurrPosSec() {
        AppMethodBeat.i(96845);
        if (this.Eho != null) {
            int currPosSec = this.Eho.getCurrPosSec();
            AppMethodBeat.o(96845);
            return currPosSec;
        }
        AppMethodBeat.o(96845);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public int getCacheTimeSec() {
        AppMethodBeat.i(96846);
        if (this.Eho != null) {
            int cacheTimeSec = this.Eho.getCacheTimeSec();
            AppMethodBeat.o(96846);
            return cacheTimeSec;
        }
        AppMethodBeat.o(96846);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean isPlaying() {
        AppMethodBeat.i(96847);
        if (this.Eho != null) {
            boolean isPlaying = this.Eho.isPlaying();
            AppMethodBeat.o(96847);
            return isPlaying;
        }
        AppMethodBeat.o(96847);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean isLive() {
        AppMethodBeat.i(96848);
        if (this.Eho != null) {
            boolean isLive = this.Eho.isLive();
            AppMethodBeat.o(96848);
            return isLive;
        }
        AppMethodBeat.o(96848);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setCover(Bitmap bitmap) {
        AppMethodBeat.i(96849);
        if (this.Eho != null) {
            this.Eho.setCover(bitmap);
        }
        AppMethodBeat.o(96849);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void start() {
        AppMethodBeat.i(96850);
        if (this.Eho != null) {
            this.Eho.start();
            setKeepScreenOn(true);
            this.pNk.a(this);
        }
        AppMethodBeat.o(96850);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void stop() {
        AppMethodBeat.i(96851);
        if (this.Eho != null) {
            this.Eho.stop();
            this.pNk.fp(false);
            setKeepScreenOn(false);
        }
        AppMethodBeat.o(96851);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean pause() {
        AppMethodBeat.i(96852);
        if (this.Eho != null) {
            setKeepScreenOn(false);
            this.pNk.fp(false);
            boolean pause = this.Eho.pause();
            AppMethodBeat.o(96852);
            return pause;
        }
        AppMethodBeat.o(96852);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setMute(boolean z) {
        AppMethodBeat.i(96853);
        this.isb = z;
        if (this.Eho != null) {
            this.Eho.setMute(this.isb);
        }
        AppMethodBeat.o(96853);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void onUIResume() {
        AppMethodBeat.i(96854);
        if (this.Eho != null) {
            this.Eho.onUIResume();
        }
        AppMethodBeat.o(96854);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void onUIPause() {
        AppMethodBeat.i(96855);
        if (this.Eho != null) {
            this.Eho.onUIPause();
        }
        this.pNk.fp(false);
        setKeepScreenOn(false);
        AppMethodBeat.o(96855);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final void onUIDestroy() {
        AppMethodBeat.i(96856);
        if (this.Eho != null) {
            this.Eho.onUIDestroy();
        }
        this.pNk.fp(false);
        setKeepScreenOn(false);
        AppMethodBeat.o(96856);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setScaleType(i.e eVar) {
        AppMethodBeat.i(96857);
        this.BOo = eVar;
        if (this.Eho != null) {
            this.Eho.setScaleType(this.BOo);
        }
        AppMethodBeat.o(96857);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean aO(float f2) {
        AppMethodBeat.i(96858);
        if (f2 <= 0.0f) {
            AppMethodBeat.o(96858);
            return false;
        }
        this.mwH = f2;
        if (this.Eho != null) {
            boolean aO = this.Eho.aO(this.mwH);
            AppMethodBeat.o(96858);
            return aO;
        }
        AppMethodBeat.o(96858);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setLoop(boolean z) {
        AppMethodBeat.i(203119);
        try {
            if (this.Eho != null) {
                this.Eho.setLoop(z);
            }
            AppMethodBeat.o(203119);
        } catch (Throwable th) {
            Log.e("MicroMsg.AdLandingVideoWrapper", th.toString());
            AppMethodBeat.o(203119);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setLoopCompletionCallback(i.d dVar) {
        AppMethodBeat.i(203120);
        try {
            if (this.Eho != null) {
                this.Eho.setLoopCompletionCallback(dVar);
            }
            AppMethodBeat.o(203120);
        } catch (Throwable th) {
            Log.e("MicroMsg.AdLandingVideoWrapper", th.toString());
            AppMethodBeat.o(203120);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.a
    public final void aO(String str, boolean z) {
        AppMethodBeat.i(96859);
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", Integer.valueOf(hashCode()), str, Boolean.valueOf(z));
        AppMethodBeat.o(96859);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void c(String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(96860);
        Log.w("MicroMsg.AdLandingVideoWrapper", "%d onError[%s %d, %d]", Integer.valueOf(hashCode()), str3, Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.pNj != null) {
            this.pNj.c(str, str2, str3, i2, i3);
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(p.CTRL_INDEX, 36);
        AppMethodBeat.o(96860);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dH(String str, String str2) {
        AppMethodBeat.i(96861);
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d onPrepared", Integer.valueOf(hashCode()));
        if (this.pNj != null) {
            this.pNj.dH(str, str2);
        }
        AppMethodBeat.o(96861);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dI(String str, String str2) {
        AppMethodBeat.i(96862);
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d onVideoEnded", Integer.valueOf(hashCode()));
        if (this.pNj != null) {
            this.pNj.dI(str, str2);
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(p.CTRL_INDEX, 35);
        AppMethodBeat.o(96862);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void d(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(96863);
        Log.i("MicroMsg.AdLandingVideoWrapper", "%d onGetVideoSize[%d %d]", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.pNj != null) {
            this.pNj.d(str, str2, i2, i3);
        }
        AppMethodBeat.o(96863);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dJ(String str, String str2) {
        AppMethodBeat.i(96864);
        Log.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPause", Integer.valueOf(hashCode()));
        setKeepScreenOn(false);
        this.pNk.fp(false);
        if (this.pNj != null) {
            this.pNj.dJ(str, str2);
        }
        AppMethodBeat.o(96864);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dK(String str, String str2) {
        AppMethodBeat.i(96865);
        Log.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPlay", Integer.valueOf(hashCode()));
        setKeepScreenOn(true);
        this.pNk.a(this);
        if (this.pNj != null) {
            this.pNj.dK(str, str2);
        }
        AppMethodBeat.o(96865);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dL(String str, String str2) {
        AppMethodBeat.i(96866);
        if (this.pNj != null) {
            this.pNj.dL(str, str2);
        }
        AppMethodBeat.o(96866);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dM(String str, String str2) {
        AppMethodBeat.i(96867);
        if (this.pNj != null) {
            this.pNj.dM(str, str2);
        }
        AppMethodBeat.o(96867);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void fo(String str, String str2) {
    }

    public void setKeepScreenOn(boolean z) {
        AppMethodBeat.i(96868);
        Log.d("MicroMsg.AdLandingVideoWrapper", "set keep screen on[%b] stack[%s]", Boolean.valueOf(z), Util.getStack());
        super.setKeepScreenOn(z);
        AppMethodBeat.o(96868);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.c
    public final void yU(long j2) {
        AppMethodBeat.i(96869);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(600, j2, 1, false);
        AppMethodBeat.o(96869);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.c
    public final void DX(String str) {
        AppMethodBeat.i(96870);
        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(14349, str);
        AppMethodBeat.o(96870);
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

    public View getInnerVideoView() {
        AppMethodBeat.i(176282);
        if (this.Eho instanceof AdLandingMMVideoView) {
            View innerVideoView = ((AdLandingMMVideoView) this.Eho).getInnerVideoView();
            AppMethodBeat.o(176282);
            return innerVideoView;
        } else if (this.Eho instanceof MMVideoView) {
            View innerVideoView2 = ((MMVideoView) this.Eho).getInnerVideoView();
            AppMethodBeat.o(176282);
            return innerVideoView2;
        } else {
            AppMethodBeat.o(176282);
            return null;
        }
    }

    public void setNeedPause(boolean z) {
        AppMethodBeat.i(203121);
        if (this.Eho instanceof AdLandingMMVideoView) {
            ((AdLandingMMVideoView) this.Eho).setNeedPause(z);
        }
        AppMethodBeat.o(203121);
    }
}
