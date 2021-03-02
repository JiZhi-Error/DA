package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class CommonVideoView extends AbstractVideoView {
    protected boolean bzP;
    private boolean jqj = false;
    protected int mwI;
    protected int mwp = 0;
    protected String url;

    public CommonVideoView(Context context) {
        super(context);
    }

    public CommonVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CommonVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public void initView() {
        AppMethodBeat.i(133991);
        super.initView();
        this.TAG = "MicroMsg.CommonVideoView";
        AppMethodBeat.o(133991);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void c(boolean z, String str, int i2) {
        AppMethodBeat.i(133992);
        Log.i(this.TAG, "%s set video path isLive [%b] url [%s] durationSec [%d]", bgQ(), Boolean.valueOf(z), str, Integer.valueOf(i2));
        this.bzP = z;
        this.url = str;
        this.mwI = i2;
        bep(str);
        AppMethodBeat.o(133992);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public j di(Context context) {
        AppMethodBeat.i(133993);
        this.mEJ = 0;
        VideoTextureView videoTextureView = new VideoTextureView(context);
        AppMethodBeat.o(133993);
        return videoTextureView;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void start() {
        AppMethodBeat.i(133994);
        if (this.qbJ != null) {
            Log.i(this.TAG, "%s start path [%s] [%s]", bgQ(), this.qbJ.getVideoPath(), Util.getStack());
            if (Util.isNullOrNil(this.qbJ.getVideoPath())) {
                this.qbJ.setVideoPath(this.url);
                showLoading();
                fgB();
            } else {
                play();
            }
            yU((long) (getReportIdkey() + 1));
        }
        AppMethodBeat.o(133994);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setScaleType(i.e eVar) {
        AppMethodBeat.i(133995);
        if (this.qbJ instanceof VideoTextureView) {
            ((VideoTextureView) this.qbJ).setScaleType(eVar);
            yU((long) (getReportIdkey() + 14));
        }
        AppMethodBeat.o(133995);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public final boolean aO(float f2) {
        AppMethodBeat.i(133996);
        Log.i(this.TAG, "%s set play rate [%f]", bgQ(), Float.valueOf(f2));
        if (this.qbJ instanceof VideoTextureView) {
            yU((long) (getReportIdkey() + 13));
            boolean aO = ((VideoTextureView) this.qbJ).aO(f2);
            AppMethodBeat.o(133996);
            return aO;
        }
        AppMethodBeat.o(133996);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public int getVideoDurationSec() {
        AppMethodBeat.i(133997);
        if (this.mwI <= 0) {
            int videoDurationSec = super.getVideoDurationSec();
            AppMethodBeat.o(133997);
            return videoDurationSec;
        }
        int i2 = this.mwI;
        AppMethodBeat.o(133997);
        return i2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public int getCacheTimeSec() {
        AppMethodBeat.i(133998);
        try {
            if (this.qbJ instanceof VideoTextureView) {
                int downloadPercent = (int) (((((float) ((VideoTextureView) this.qbJ).getDownloadPercent()) * 1.0f) / 100.0f) * ((float) super.getVideoDurationSec()));
                AppMethodBeat.o(133998);
                return downloadPercent;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "%s get cache time sec error", bgQ());
        }
        AppMethodBeat.o(133998);
        return 0;
    }

    public final int goG() {
        this.mwp = 0;
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public int getVideoSource() {
        return this.mwp;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void hideLoading() {
        AppMethodBeat.i(133999);
        super.hideLoading();
        AppMethodBeat.o(133999);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public boolean c(double d2, boolean z) {
        AppMethodBeat.i(134000);
        if (isLive()) {
            Log.w(this.TAG, "%s it is live, don't seek ", bgQ());
            AppMethodBeat.o(134000);
            return false;
        }
        boolean c2 = super.c(d2, z);
        AppMethodBeat.o(134000);
        return c2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public void onUIResume() {
        AppMethodBeat.i(134001);
        super.onUIResume();
        if (this.qbJ != null && (this.qbJ instanceof VideoTextureView)) {
            if (this.mEI) {
                play();
                AppMethodBeat.o(134001);
                return;
            }
            ((VideoTextureView) this.qbJ).bLe();
        }
        AppMethodBeat.o(134001);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public void onUIPause() {
        AppMethodBeat.i(134002);
        super.onUIPause();
        AppMethodBeat.o(134002);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.b
    public final void ep(int i2, int i3) {
        AppMethodBeat.i(134003);
        Log.d(this.TAG, "%s onInfo [%d %d]", bgQ(), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 701) {
            showLoading();
            got();
            gor();
            yU((long) (getReportIdkey() + 40));
            AppMethodBeat.o(134003);
            return;
        }
        if (i2 == 702) {
            super.hideLoading();
            gos();
            gou();
        }
        AppMethodBeat.o(134003);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public void onCompletion() {
        AppMethodBeat.i(134004);
        if (isLive()) {
            Log.i(this.TAG, "%s it is live video, do not completion", bgQ());
            stop();
            start();
            AppMethodBeat.o(134004);
            return;
        }
        super.onCompletion();
        if (this.jqj) {
            c(0.0d, true);
        }
        AppMethodBeat.o(134004);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public void setLoop(boolean z) {
        this.jqj = z;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void fdO() {
        AppMethodBeat.i(208751);
        super.fdO();
        AppMethodBeat.o(208751);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i
    public boolean isLive() {
        boolean z;
        AppMethodBeat.i(134005);
        boolean asa = asa();
        int duration = this.qbJ != null ? this.qbJ.getDuration() : 0;
        if (this.bzP) {
            z = true;
        } else if (!asa || duration > 0) {
            z = false;
        } else {
            z = true;
        }
        Log.d(this.TAG, "%s is live video result [%b] isPrepared[%b] durationMs[%d] isLive[%b]", bgQ(), Boolean.valueOf(z), Boolean.valueOf(asa()), Integer.valueOf(duration), Boolean.valueOf(this.bzP));
        AppMethodBeat.o(134005);
        return z;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public int getReportIdkey() {
        return 0;
    }
}
