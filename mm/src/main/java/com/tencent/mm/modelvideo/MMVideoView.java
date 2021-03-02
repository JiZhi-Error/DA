package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.a.k;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public class MMVideoView extends CommonVideoView implements b.a {
    private i.a jpL;
    private String jpM;
    protected b jpS;
    protected String jpT;
    public String jpU;
    protected int jpV = 0;
    protected int jpW = 0;
    protected f jpX;
    protected int jpY;
    protected int jpZ;
    private boolean jqa;
    protected boolean jqb;
    protected int jqc = 0;
    protected int jqd;
    protected boolean jqe = false;
    protected boolean jqf = false;
    private boolean jqg = false;
    protected a jqh;
    protected boolean jqi = false;
    public boolean jqj;
    private MTimerHandler jqk = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.modelvideo.MMVideoView.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            boolean z;
            AppMethodBeat.i(126786);
            if (MMVideoView.this.qbJ == null) {
                AppMethodBeat.o(126786);
                return false;
            }
            boolean isPlaying = MMVideoView.this.isPlaying();
            if (isPlaying) {
                MMVideoView.this.hideLoading();
            }
            try {
                int currentPosition = MMVideoView.this.qbJ.getCurrentPosition() / 1000;
                MMVideoView.a(MMVideoView.this, currentPosition);
                z = MMVideoView.this.ub(currentPosition);
            } catch (Exception e2) {
                Log.e(MMVideoView.this.TAG, "%s online video timer check error [%s] ", MMVideoView.d(MMVideoView.this), e2.toString());
                z = false;
            }
            Log.d(MMVideoView.this.TAG, "%s check timer[%b] isplay[%b]", MMVideoView.f(MMVideoView.this), Boolean.valueOf(z), Boolean.valueOf(isPlaying));
            if (MMVideoView.g(MMVideoView.this)) {
                if (!z || !isPlaying || !MMVideoView.h(MMVideoView.this)) {
                    AppMethodBeat.o(126786);
                    return false;
                }
                AppMethodBeat.o(126786);
                return true;
            } else if (!z || !isPlaying) {
                AppMethodBeat.o(126786);
                return false;
            } else {
                AppMethodBeat.o(126786);
                return true;
            }
        }
    }, true);

    static /* synthetic */ void a(MMVideoView mMVideoView, int i2) {
        AppMethodBeat.i(126819);
        mMVideoView.xI(i2);
        AppMethodBeat.o(126819);
    }

    static /* synthetic */ String d(MMVideoView mMVideoView) {
        AppMethodBeat.i(126820);
        String bgQ = mMVideoView.bgQ();
        AppMethodBeat.o(126820);
        return bgQ;
    }

    static /* synthetic */ String f(MMVideoView mMVideoView) {
        AppMethodBeat.i(126821);
        String bgQ = mMVideoView.bgQ();
        AppMethodBeat.o(126821);
        return bgQ;
    }

    static /* synthetic */ boolean g(MMVideoView mMVideoView) {
        AppMethodBeat.i(126822);
        boolean dUD = mMVideoView.dUD();
        AppMethodBeat.o(126822);
        return dUD;
    }

    static /* synthetic */ boolean h(MMVideoView mMVideoView) {
        AppMethodBeat.i(126823);
        boolean gop = mMVideoView.gop();
        AppMethodBeat.o(126823);
        return gop;
    }

    public static class a {
        public int jqm;
        public int jqn;

        protected a() {
        }
    }

    public MMVideoView(Context context) {
        super(context);
        AppMethodBeat.i(126787);
        AppMethodBeat.o(126787);
    }

    public MMVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(126788);
        AppMethodBeat.o(126788);
    }

    public MMVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(126789);
        AppMethodBeat.o(126789);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public void initView() {
        AppMethodBeat.i(126790);
        super.initView();
        this.TAG = "MicroMsg.MMVideoView";
        this.jpX = bgT();
        this.jqh = new a();
        bgU();
        reset();
        AppMethodBeat.o(126790);
    }

    /* access modifiers changed from: protected */
    public f bgT() {
        AppMethodBeat.i(240849);
        k kVar = new k();
        AppMethodBeat.o(240849);
        return kVar;
    }

    /* access modifiers changed from: protected */
    public void bgU() {
        this.jqh.jqm = 5;
        this.jqh.jqn = 2;
    }

    public void reset() {
        this.jpZ = -1;
        this.jqc = 0;
        this.jpY = 0;
        this.jpW = 0;
        this.jpV = 0;
        this.jqb = false;
        this.jqe = false;
        this.jqf = false;
        if (this.jqh != null) {
            this.jqd = this.jqh.jqm;
        }
    }

    public void setIOnlineVideoProxy(b bVar) {
        AppMethodBeat.i(126791);
        this.jpS = bVar;
        this.jpS.a(this);
        AppMethodBeat.o(126791);
    }

    public void setIMMDownloadFinish(i.a aVar) {
        this.jpL = aVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i
    public void c(boolean z, String str, int i2) {
        AppMethodBeat.i(126792);
        super.c(z, str, i2);
        bgR();
        AppMethodBeat.o(126792);
    }

    /* access modifiers changed from: protected */
    public void bgR() {
        AppMethodBeat.i(169101);
        if (!Util.isNullOrNil(this.url)) {
            this.jpT = "MMVideo_" + this.url.hashCode();
            this.jpU = getRootPath() + "MMVideo_" + this.url.hashCode() + ".mp4";
            s.boN(s.boZ(this.jpU));
            Log.i(this.TAG, "%s set video path [%s %s]", bgQ(), this.jpT, this.jpU);
        }
        AppMethodBeat.o(169101);
    }

    public void setRootPath(String str) {
        this.jpM = str;
    }

    private String getRootPath() {
        AppMethodBeat.i(126793);
        if (!Util.isNullOrNil(this.jpM)) {
            String str = this.jpM;
            AppMethodBeat.o(126793);
            return str;
        }
        String str2 = com.tencent.mm.loader.j.b.aKJ() + "video/";
        AppMethodBeat.o(126793);
        return str2;
    }

    /* access modifiers changed from: protected */
    public void bgV() {
        AppMethodBeat.i(126794);
        Log.printInfoStack(this.TAG, "%s prepareVideo", bgQ());
        if (this.qbJ != null) {
            this.jqe = true;
            this.qbJ.setVideoPath(this.jpU);
        }
        AppMethodBeat.o(126794);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public void onUIPause() {
        AppMethodBeat.i(126795);
        super.onUIPause();
        if (this.jqi) {
            this.jqg = true;
            stop();
        }
        AppMethodBeat.o(126795);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public void onUIResume() {
        AppMethodBeat.i(126796);
        super.onUIResume();
        Log.i(this.TAG, "%s onUIResume stopDownloadByUiPause[%b] currTimeOnUiPause[%d] isPlayOnUiPause[%b]", bgQ(), Boolean.valueOf(this.jqg), Integer.valueOf(this.mEH), Boolean.valueOf(this.mEI));
        if (this.jqg) {
            G(this.mEH, this.mEI);
            AppMethodBeat.o(126796);
        } else if (this.qbJ == null || !d.oD(24) || !(this.qbJ instanceof VideoPlayerTextureView)) {
            AppMethodBeat.o(126796);
        } else {
            ((VideoPlayerTextureView) this.qbJ).bLe();
            AppMethodBeat.o(126796);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i
    public void start() {
        AppMethodBeat.i(126797);
        Log.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d]", bgQ(), this.jpT, Integer.valueOf(this.jpY));
        if (this.qbJ != null) {
            if (Util.isNullOrNil(this.qbJ.getVideoPath())) {
                showLoading();
                this.jqi = true;
                this.jpY = 0;
                this.jpV = 1;
                if (this.jpS != null) {
                    this.jpS.p(this.jpT, this.jpU, this.url);
                    this.jpS.a(this);
                }
                fgB();
            } else {
                play();
            }
            yU((long) (getReportIdkey() + 1));
        }
        AppMethodBeat.o(126797);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i
    public void setLoop(boolean z) {
        this.jqj = z;
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.tools.j.a, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public void onCompletion() {
        AppMethodBeat.i(126798);
        if (this.jqj) {
            G(0, true);
            super.fdO();
        } else {
            super.onCompletion();
            if (!(this.jpT == null || this.jpS == null)) {
                this.jpS.he(this.jpT);
            }
            reset();
            if (this.qbJ != null) {
                this.qbJ.stop();
            }
        }
        this.jpX.release();
        AppMethodBeat.o(126798);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public void stop() {
        AppMethodBeat.i(126799);
        if (this.jpS != null) {
            this.jpS.he(this.jpT);
        }
        reset();
        super.stop();
        this.jpX.release();
        AppMethodBeat.o(126799);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public j di(Context context) {
        AppMethodBeat.i(126800);
        this.mEJ = 1;
        VideoPlayerTextureView videoPlayerTextureView = new VideoPlayerTextureView(context);
        videoPlayerTextureView.setNeedResetExtractor(true);
        AppMethodBeat.o(126800);
        return videoPlayerTextureView;
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i
    public void setScaleType(i.e eVar) {
        AppMethodBeat.i(126801);
        if (this.qbJ instanceof VideoPlayerTextureView) {
            ((VideoPlayerTextureView) this.qbJ).setScaleType(eVar);
            yU((long) (getReportIdkey() + 14));
        }
        AppMethodBeat.o(126801);
    }

    public View getInnerVideoView() {
        if (this.qbJ instanceof VideoPlayerTextureView) {
            return (View) this.qbJ;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean ub(int i2) {
        int i3;
        MMVideoView mMVideoView;
        boolean z;
        int i4;
        MMVideoView mMVideoView2;
        boolean z2;
        MMVideoView mMVideoView3;
        boolean z3 = false;
        boolean z4 = true;
        AppMethodBeat.i(126802);
        if (this.jpZ != -1) {
            i3 = this.jpZ;
        } else {
            i3 = i2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bgQ()).append(" check timer playCurrPos ").append(i2).append(" playTime ").append(i3).append(" cachePlayTime ").append(this.jqc).append(" timeDuration ").append(this.jpY).append(" playStatus ").append(this.jpW).append(" downloadStatus ").append(this.jpV).append(" cdnMediaId ").append(this.jpT).append(" isPrepareVideo[").append(this.jqe).append("], isPrepared[").append(this.ZA).append("]");
        Log.i(this.TAG, sb.toString());
        switch (this.jpV) {
            case 1:
                if (!uc(i3)) {
                    this.jqb = true;
                    if (this.jqc > 0) {
                        Log.i(this.TAG, "%s pause by load data cdnMediaId %s, playStatus %d", bgQ(), this.jpT, Integer.valueOf(this.jpW));
                        gor();
                        if (!(this.jpW == 2 || this.jpW == 4)) {
                            this.jqd += this.jqh.jqm;
                            this.jqd = Math.min(this.jqd, 60);
                            got();
                            this.jpW = 4;
                        }
                        bgW();
                    } else if (this.jpZ == -1) {
                        this.jpW = 1;
                    } else {
                        this.jpW = 2;
                    }
                    z = false;
                } else if (this.jqe) {
                    xI(i3);
                    Log.i(this.TAG, "resumeByDataGain, playStatus:%s, isPlaying:%s, pauseByLoadData:%s", Integer.valueOf(this.jpW), Boolean.valueOf(this.qbJ.isPlaying()), Boolean.valueOf(this.jqb));
                    if (this.jqb) {
                        gos();
                        gou();
                        Log.i(this.TAG, "%s resume by data gain cdnMediaId %s", bgQ(), this.jpT);
                        if (this.jpZ != -1) {
                            G(this.jpZ, this.jqa);
                            this.jpZ = -1;
                            z2 = false;
                            mMVideoView3 = this;
                        } else if (play()) {
                            z2 = false;
                            mMVideoView3 = this;
                        } else {
                            z2 = true;
                            mMVideoView3 = this;
                        }
                        mMVideoView3.jqb = z2;
                        i4 = 3;
                        mMVideoView2 = this;
                    } else {
                        if (this.jpW != 3 || !this.qbJ.isPlaying()) {
                            Log.i(this.TAG, "%s start to play video playStatus[%d]", bgQ(), Integer.valueOf(this.jpW));
                            if (play()) {
                                i4 = 3;
                                mMVideoView2 = this;
                            } else {
                                i4 = this.jpW;
                                mMVideoView2 = this;
                            }
                        }
                        z = true;
                    }
                    mMVideoView2.jpW = i4;
                    z = true;
                } else {
                    Log.i(this.TAG, "%s prepare cdnMediaId [%s]", bgQ(), this.jpT);
                    if (this.jpW == 5) {
                        this.jpW = 1;
                    }
                    bgV();
                    z = true;
                }
                xI(i3);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (a(i3, pInt, pInt2)) {
                    if (o(pInt.value, pInt2.value, false)) {
                        this.jqc = Math.max(this.jqc, pInt2.value);
                        break;
                    }
                } else {
                    Log.d(this.TAG, "%s can not calc download.", bgQ());
                }
                z4 = z;
                break;
            case 2:
                Log.w(this.TAG, "%s download error.", bgQ());
                z4 = false;
                break;
            case 3:
                if (!this.ZA) {
                    if (this.jpW == 5) {
                        this.jpW = 1;
                    }
                    bgV();
                    break;
                } else {
                    if (this.jqb) {
                        if (this.jpZ != -1) {
                            G(this.jpZ, true);
                            this.jpZ = -1;
                            mMVideoView = this;
                        } else if (play()) {
                            mMVideoView = this;
                        } else {
                            z3 = true;
                            mMVideoView = this;
                        }
                        mMVideoView.jqb = z3;
                    }
                    this.jpW = 3;
                    xI(i3);
                    break;
                }
            default:
                Log.w(this.TAG, "%s check time default.", bgQ());
                z4 = false;
                break;
        }
        AppMethodBeat.o(126802);
        return z4;
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public boolean c(double d2, boolean z) {
        AppMethodBeat.i(126803);
        boolean G = G((int) d2, z);
        AppMethodBeat.o(126803);
        return G;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean G(int i2, boolean z) {
        boolean z2;
        AppMethodBeat.i(126804);
        switch (this.jpV) {
            case 0:
                if (!asa()) {
                    if (this.mEM) {
                        this.mEK = z;
                        this.jqa = z;
                        this.mEL = i2;
                        this.jpZ = i2;
                    } else {
                        this.mEK = z;
                        if (i2 > 0) {
                            this.mEL = i2;
                        } else {
                            this.mEL = this.mEH;
                        }
                    }
                    start();
                }
                z2 = true;
                break;
            case 1:
                this.jpW = 2;
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                a(i2, pInt, pInt2);
                if (!o(pInt.value, pInt2.value, true)) {
                    this.jpZ = i2;
                    this.jqa = z;
                    this.jqb = true;
                    bgW();
                    z2 = false;
                    break;
                } else {
                    this.jpZ = -1;
                    this.jqb = false;
                    this.jqc = pInt2.value;
                    this.jpW = 3;
                    super.c((double) i2, z);
                    z2 = true;
                    break;
                }
            case 2:
                z2 = true;
                break;
            case 3:
                super.c((double) i2, z);
                z2 = true;
                break;
            default:
                z2 = true;
                break;
        }
        Log.printInfoStack(this.TAG, "%s seek video time %d, download status %d playStatus %d", bgQ(), Integer.valueOf(i2), Integer.valueOf(this.jpV), Integer.valueOf(this.jpW));
        AppMethodBeat.o(126804);
        return z2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.c, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public void fN(boolean z) {
        AppMethodBeat.i(126805);
        super.fN(z);
        hideLoading();
        AppMethodBeat.o(126805);
    }

    public boolean uc(int i2) {
        Exception e2;
        boolean z;
        AppMethodBeat.i(126806);
        if (this.jpV == 3) {
            AppMethodBeat.o(126806);
            return true;
        } else if (this.jqc - i2 > 1 || this.jqc >= this.jpY) {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            try {
                if (this.jpX.a(i2, i2 + 1, pInt, pInt2)) {
                    if (this.jpS != null) {
                        z = this.jpS.isVideoDataAvailable(this.jpT, pInt.value, pInt2.value);
                    } else {
                        z = false;
                    }
                    if (!z) {
                        try {
                            this.jqc = i2;
                        } catch (Exception e3) {
                            e2 = e3;
                            Log.e(this.TAG, "%s check video data error %s ", bgQ(), e2.toString());
                            AppMethodBeat.o(126806);
                            return z;
                        }
                    }
                } else {
                    z = false;
                }
            } catch (Exception e4) {
                e2 = e4;
                z = false;
                Log.e(this.TAG, "%s check video data error %s ", bgQ(), e2.toString());
                AppMethodBeat.o(126806);
                return z;
            }
            AppMethodBeat.o(126806);
            return z;
        } else {
            AppMethodBeat.o(126806);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(int i2, PInt pInt, PInt pInt2) {
        AppMethodBeat.i(126807);
        pInt.value = Math.max(i2, this.jqc);
        if (this.jpW == 1) {
            pInt.value = i2;
            pInt2.value = pInt.value + this.jqd;
        }
        if (this.jpW == 2) {
            pInt.value = i2 - 8;
            if (pInt.value < 0) {
                pInt.value = 0;
            }
            pInt2.value = pInt.value + this.jqd + 8;
        }
        if (this.jpW == 3 || this.jpW == 4) {
            pInt.value = this.jqc;
            pInt2.value = this.jqd + i2 + 1 + this.jqh.jqn;
        }
        if (pInt2.value >= this.jpY + 1) {
            pInt2.value = this.jpY + 1;
        }
        if (pInt2.value < pInt.value) {
            pInt2.value = pInt.value + this.jqh.jqn;
            AppMethodBeat.o(126807);
            return false;
        }
        Log.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", bgQ(), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i2), Integer.valueOf(this.jpW), Integer.valueOf(this.jqc), Integer.valueOf(this.jqd), this.jpT);
        AppMethodBeat.o(126807);
        return true;
    }

    private void bgW() {
        AppMethodBeat.i(126808);
        Log.i(this.TAG, "%s pauseByDataBlock ", bgQ());
        showLoading();
        pause();
        AppMethodBeat.o(126808);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public boolean pause() {
        AppMethodBeat.i(126809);
        boolean pause = super.pause();
        if (pause) {
            this.jqf = false;
            this.jpW = 4;
        }
        AppMethodBeat.o(126809);
        return pause;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public boolean play() {
        AppMethodBeat.i(126810);
        boolean play = super.play();
        if (play) {
            this.jpW = 3;
        }
        AppMethodBeat.o(126810);
        return play;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean o(int r12, int r13, boolean r14) {
        /*
        // Method dump skipped, instructions count: 190
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvideo.MMVideoView.o(int, int, boolean):boolean");
    }

    @Override // com.tencent.mm.modelvideo.b.a
    public final void AI(long j2) {
        AppMethodBeat.i(240850);
        Log.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s", bgQ(), Long.valueOf(j2), Integer.valueOf(this.jpY), this.jpT);
        if (this.jpY != 0) {
            Log.w(this.TAG, "moov had callback, do nothing.");
            AppMethodBeat.o(240850);
            return;
        }
        goq();
        try {
            if (this.jpX == null) {
                Log.w(this.TAG, "%s parser is null, thread is error.", bgQ());
                AppMethodBeat.o(240850);
            } else if (this.jpX.L(this.jpU, j2)) {
                this.jpY = this.jpX.blS();
                Log.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", bgQ(), Integer.valueOf(this.jpY), this.jpT);
                if (ub(0)) {
                    bgV();
                }
                if (this.jpZ == -1) {
                    this.jpW = 1;
                    AppMethodBeat.o(240850);
                    return;
                }
                this.jpW = 2;
                AppMethodBeat.o(240850);
            } else {
                Log.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", bgQ(), this.jpT);
                if (this.jpS != null) {
                    this.jpS.requestVideoData(this.jpT, 0, -1);
                }
                AppMethodBeat.o(240850);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "%s deal moov ready error [%s]", bgQ(), this.jpT);
            AppMethodBeat.o(240850);
        }
    }

    @Override // com.tencent.mm.modelvideo.b.a
    public void onDataAvailable(String str, long j2, long j3) {
        AppMethodBeat.i(126813);
        this.jqf = false;
        if (j2 <= -1 || j3 <= -1) {
            Log.w(this.TAG, "%s deal data available error offset[%d], length[%d]", bgQ(), Long.valueOf(j2), Long.valueOf(j3));
            AppMethodBeat.o(126813);
        } else if (!Util.isEqual(this.jpT, str)) {
            AppMethodBeat.o(126813);
        } else {
            try {
                this.jqc = this.jpX.dG((int) j2, (int) j3);
            } catch (Exception e2) {
                Log.e(this.TAG, "%s deal data available file pos to video time error[%s] ", bgQ(), e2.toString());
            }
            Log.i(this.TAG, "%s deal data available. offset[%d] length[%d] cachePlayTime[%d]", bgQ(), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.jqc));
            fO(true);
            AppMethodBeat.o(126813);
        }
    }

    @Override // com.tencent.mm.modelvideo.b.a
    public void i(String str, long j2, long j3) {
        AppMethodBeat.i(126814);
        if (!Util.isEqual(this.jpT, str)) {
            AppMethodBeat.o(126814);
            return;
        }
        Log.d(this.TAG, "%s download  onProgress [%d, %d]", bgQ(), Long.valueOf(j2), Long.valueOf(j3));
        AppMethodBeat.o(126814);
    }

    @Override // com.tencent.mm.modelvideo.b.a
    public void ax(String str, int i2) {
        boolean z;
        AppMethodBeat.i(126815);
        if (!Util.isEqual(this.jpT, str) || this.jpV == 3) {
            AppMethodBeat.o(126815);
            return;
        }
        Log.i(this.TAG, "%s download finish [%d]", bgQ(), Integer.valueOf(i2));
        if (i2 == 0) {
            this.jpV = 3;
        }
        if (this.jpL != null) {
            i.a aVar = this.jpL;
            String str2 = this.jpU;
            if (this.jpW > 0) {
                z = true;
            } else {
                z = false;
            }
            aVar.aO(str2, z);
        }
        fO(true);
        this.jqf = false;
        AppMethodBeat.o(126815);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public void fO(boolean z) {
        AppMethodBeat.i(126816);
        Log.d(this.TAG, "%s start timer rightNow[%b]", bgQ(), Boolean.valueOf(z));
        this.jqk.stopTimer();
        this.jqk.startTimer(10, 500);
        AppMethodBeat.o(126816);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public void stopTimer() {
        AppMethodBeat.i(126817);
        this.jqk.stopTimer();
        AppMethodBeat.o(126817);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public int getCacheTimeSec() {
        AppMethodBeat.i(126818);
        if (this.jpV == 3) {
            int videoDurationSec = getVideoDurationSec();
            AppMethodBeat.o(126818);
            return videoDurationSec;
        }
        int i2 = this.jqc;
        AppMethodBeat.o(126818);
        return i2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView, com.tencent.mm.pluginsdk.ui.tools.j.d
    public void bgX() {
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public int getReportIdkey() {
        return 100;
    }

    /* access modifiers changed from: protected */
    public void setDownloadStatus(int i2) {
        this.jpV = i2;
    }

    /* access modifiers changed from: protected */
    public void setFilepath(String str) {
        this.jpU = str;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public String getMediaId() {
        return this.jpT;
    }
}
