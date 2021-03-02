package com.tencent.mm.plugin.luckymoney.story;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public class EnvelopeStoryVideoView extends MMVideoView {
    public static final String ROOT_PATH = (b.aKJ() + "hbstoryvideo/");
    private boolean UXN;
    private boolean dLQ;
    private String sessionId;
    boolean zaZ;
    private boolean zba = false;
    public a zbb;

    public interface a {
        void a(EnvelopeStoryVideoView envelopeStoryVideoView);
    }

    static {
        AppMethodBeat.i(174376);
        AppMethodBeat.o(174376);
    }

    public EnvelopeStoryVideoView(Context context) {
        super(context);
        AppMethodBeat.i(163671);
        init();
        AppMethodBeat.o(163671);
    }

    public EnvelopeStoryVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(163672);
        init();
        AppMethodBeat.o(163672);
    }

    public EnvelopeStoryVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(163673);
        init();
        AppMethodBeat.o(163673);
    }

    private void init() {
        AppMethodBeat.i(163674);
        if (this.mEB != null) {
            this.mEB.setVisibility(8);
        }
        setRootPath(ROOT_PATH);
        s.bpc(ROOT_PATH);
        setLoop(true);
        AppMethodBeat.o(163674);
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public void setMute(boolean z) {
        AppMethodBeat.i(163675);
        super.setMute(z);
        this.zaZ = z;
        AppMethodBeat.o(163675);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView
    public final void c(boolean z, String str, int i2) {
        AppMethodBeat.i(163676);
        super.c(z, str, i2);
        if (this.UXN) {
            this.jpU = str;
        }
        AppMethodBeat.o(163676);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public String getSessionId() {
        return this.sessionId;
    }

    public void setLocal(boolean z) {
        this.dLQ = z;
    }

    public void setLocalPreDownloadVideo(boolean z) {
        this.UXN = z;
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.tools.j.a, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void onCompletion() {
        AppMethodBeat.i(174373);
        this.zba = true;
        if (this.jqj && this.zbb != null) {
            this.zbb.a(this);
        }
        super.onCompletion();
        AppMethodBeat.o(174373);
    }

    public int getRealPlayDurationSec() {
        AppMethodBeat.i(174374);
        if (this.zba) {
            int videoDurationSec = getVideoDurationSec();
            AppMethodBeat.o(174374);
            return videoDurationSec;
        }
        int currPosSec = getCurrPosSec();
        AppMethodBeat.o(174374);
        return currPosSec;
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView
    public final void start() {
        AppMethodBeat.i(163677);
        Log.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d] isLocal[%s]", bgQ(), this.jpT, Integer.valueOf(this.jpY), Boolean.valueOf(this.dLQ));
        if (this.qbJ != null) {
            if (!Util.isNullOrNil(this.qbJ.getVideoPath())) {
                play();
            } else if (this.dLQ || this.UXN) {
                bgV();
                this.jpV = 3;
                AppMethodBeat.o(163677);
                return;
            } else {
                showLoading();
                this.jqi = true;
                this.jpY = 0;
                this.jpV = 1;
                if (this.jpS != null) {
                    this.jpS.p(this.jpT, this.jpU, this.url);
                    this.jpS.a(this);
                }
                fgB();
            }
            yU((long) (getReportIdkey() + 1));
        }
        AppMethodBeat.o(163677);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void onUIResume() {
        AppMethodBeat.i(163678);
        if (!this.mEw) {
            this.mEw = true;
            if (this.qbJ != null) {
                if (this.mEI) {
                    play();
                } else {
                    ((VideoPlayerTextureView) this.qbJ).bLe();
                }
            }
            yU((long) (getReportIdkey() + 10));
        }
        AppMethodBeat.o(163678);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void onUIPause() {
        AppMethodBeat.i(163679);
        Log.i(this.TAG, "%s onUIPause", bgQ());
        if (this.mEw) {
            this.mEH = getCurrPosSec();
            this.mEI = true;
            this.mEO = 0;
            this.mEN = 0;
            pause();
            stopTimer();
            this.mEw = false;
            yU((long) (getReportIdkey() + 11));
        }
        AppMethodBeat.o(163679);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final boolean efT() {
        return false;
    }

    public final boolean YY() {
        AppMethodBeat.i(174375);
        if (this.qbJ instanceof VideoPlayerTextureView) {
            boolean YY = ((VideoPlayerTextureView) this.qbJ).YY();
            AppMethodBeat.o(174375);
            return YY;
        }
        Log.e(this.TAG, "videoview not VideoPlayerTextureView");
        if (this.jpW == 4) {
            AppMethodBeat.o(174375);
            return true;
        }
        AppMethodBeat.o(174375);
        return false;
    }
}
