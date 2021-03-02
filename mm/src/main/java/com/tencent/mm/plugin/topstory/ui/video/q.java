package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.plugin.websearch.api.a.a;
import com.tencent.mm.plugin.websearch.api.a.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public final class q extends MMVideoView {
    private eiw GjH;
    private b GlS;
    String sessionId = "";

    public q(Context context, b bVar) {
        super(context);
        this.mContext = context;
        this.GlS = bVar;
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView
    public final void bgU() {
        this.jqh.jqm = 4;
        this.jqh.jqn = 2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final j di(Context context) {
        AppMethodBeat.i(126176);
        TopStoryVideoPlayTextureView topStoryVideoPlayTextureView = new TopStoryVideoPlayTextureView(context);
        topStoryVideoPlayTextureView.setOpenWithNoneSurface(true);
        topStoryVideoPlayTextureView.setNeedResetExtractor(cXc());
        topStoryVideoPlayTextureView.setIsOnlineVideoType(true);
        AppMethodBeat.o(126176);
        return topStoryVideoPlayTextureView;
    }

    private static boolean cXc() {
        boolean z = false;
        AppMethodBeat.i(126177);
        try {
            g.aAi();
            z = g.aAh().azQ().getBoolean(ar.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, false);
            AppMethodBeat.o(126177);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", e2, "check need reset error", new Object[0]);
            AppMethodBeat.o(126177);
        }
        return z;
    }

    public final void setVideoInfo(eiw eiw) {
        AppMethodBeat.i(126178);
        super.c(false, eiw.videoUrl, 0);
        this.GjH = eiw;
        this.jpT = c.bu(eiw.psI, eiw.Nip);
        this.jpU = this.GlS.fyC() + this.jpT + ".mp4";
        AppMethodBeat.o(126178);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void initView() {
        AppMethodBeat.i(126179);
        super.initView();
        AppMethodBeat.o(126179);
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView
    public final boolean uc(int i2) {
        Exception e2;
        boolean z;
        boolean z2;
        int i3;
        AppMethodBeat.i(126180);
        if (this.jpV == 3) {
            AppMethodBeat.o(126180);
            return true;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            if (i2 != 0 || this.jpX == null || !cXc()) {
                z2 = false;
            } else {
                pInt4.value = 0;
                pInt3.value = 0;
                z2 = this.jpX.b(i2 + 1, pInt3, pInt4);
            }
            int i4 = i2 + 1;
            if (z2) {
                i3 = pInt4.value;
            } else {
                i3 = i4;
            }
            if (this.jpS == null || this.jpX == null || !this.jpX.a(i2, i3, pInt, pInt2)) {
                z = false;
                AppMethodBeat.o(126180);
                return z;
            }
            z = this.jpS.isVideoDataAvailable(this.jpT, pInt.value, pInt2.value);
            if (z) {
                try {
                    this.jqc = i3;
                } catch (Exception e3) {
                    e2 = e3;
                    Log.e("MicroMsg.TopStory.TopStoryVideoView", "%s check video data error %s ", bgQ(), e2.toString());
                    AppMethodBeat.o(126180);
                    return z;
                }
            }
            AppMethodBeat.o(126180);
            return z;
        } catch (Exception e4) {
            e2 = e4;
            z = false;
            Log.e("MicroMsg.TopStory.TopStoryVideoView", "%s check video data error %s ", bgQ(), e2.toString());
            AppMethodBeat.o(126180);
            return z;
        }
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.modelvideo.b.a
    public final void i(String str, long j2, long j3) {
        AppMethodBeat.i(126181);
        if (!Util.isEqual(this.jpT, str)) {
            AppMethodBeat.o(126181);
            return;
        }
        Log.d("MicroMsg.TopStory.TopStoryVideoView", "%s download  onProgress [%d, %d]", bgQ(), Long.valueOf(j2), Long.valueOf(j3));
        if (this.jqb && this.jpW == 3) {
            ub(getCurrPosSec());
        }
        AppMethodBeat.o(126181);
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView
    public final boolean G(int i2, boolean z) {
        int blR;
        AppMethodBeat.i(164125);
        if (this.jpX != null && i2 > (blR = this.jpX.blR()) && blR > 0) {
            Log.i("MicroMsg.TopStory.TopStoryVideoView", "%s seek to reset time ori[%d] last key frame[%d]", bgQ(), Integer.valueOf(i2), Integer.valueOf(blR));
            i2 = blR;
        }
        boolean G = super.G(i2, z);
        AppMethodBeat.o(164125);
        return G;
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView
    public final boolean a(int i2, PInt pInt, PInt pInt2) {
        boolean z;
        AppMethodBeat.i(126183);
        pInt.value = Math.max(i2, this.jqc);
        if (this.jpW == 1 || this.jpW == 0) {
            if (this.jpX == null || !cXc()) {
                z = false;
            } else {
                pInt2.value = 0;
                pInt.value = 0;
                z = this.jpX.b(i2 + 1, pInt, pInt2);
            }
            if (!z) {
                pInt.value = i2;
                pInt2.value = pInt.value + 4;
            }
        } else {
            z = false;
        }
        if (this.jpW == 2) {
            if (this.jpX != null) {
                z = this.jpX.b(i2, pInt, pInt2);
                pInt2.value += 4;
            }
            if (!z) {
                pInt.value = i2 - 8;
                if (pInt.value < 0) {
                    pInt.value = 0;
                }
                pInt2.value = pInt.value + this.jqd + 8;
            }
        }
        if (this.jpW == 3 || this.jpW == 4) {
            pInt.value = this.jqc;
            pInt2.value = this.jpY + 1;
        }
        if (pInt2.value >= this.jpY + 1) {
            pInt2.value = this.jpY + 1;
        }
        if (pInt2.value < pInt.value) {
            pInt2.value = pInt.value + 2;
            AppMethodBeat.o(126183);
            return false;
        }
        Log.d("MicroMsg.TopStory.TopStoryVideoView", "%s calcDownloadRange2 range[%d, %d, %b] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", bgQ(), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(this.jpW), Integer.valueOf(this.jqc), Integer.valueOf(this.jqd), this.jpT);
        AppMethodBeat.o(126183);
        return true;
    }

    public final void aTG(String str) {
        AppMethodBeat.i(126184);
        this.sessionId = str;
        start();
        AppMethodBeat.o(126184);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void onUIDestroy() {
        AppMethodBeat.i(126185);
        super.onUIDestroy();
        this.GlS = null;
        AppMethodBeat.o(126185);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView
    public final void start() {
        AppMethodBeat.i(126186);
        super.start();
        a.pl(5);
        AppMethodBeat.o(126186);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final boolean isPlaying() {
        boolean z;
        AppMethodBeat.i(126187);
        boolean isPlaying = super.isPlaying();
        if (!isPlaying || this.jpW != 3) {
            z = false;
        } else {
            z = true;
        }
        Log.d("MicroMsg.TopStory.TopStoryVideoView", "%s result [%b] is playing[%b] playStatus[%d]", bgQ(), Boolean.valueOf(z), Boolean.valueOf(isPlaying), Integer.valueOf(this.jpW));
        AppMethodBeat.o(126187);
        return isPlaying;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final int getCurrPosMs() {
        AppMethodBeat.i(126188);
        int i2 = 0;
        if (this.qbJ != null) {
            i2 = this.qbJ.getCurrentPosition();
        }
        if (this.jpZ > 0) {
            i2 = this.jpZ * 1000;
        }
        AppMethodBeat.o(126188);
        return i2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final int getCurrPosSec() {
        AppMethodBeat.i(126189);
        int i2 = 0;
        if (this.qbJ != null) {
            i2 = Math.round((((float) this.qbJ.getCurrentPosition()) * 1.0f) / 1000.0f);
        }
        if (this.jpZ > 0) {
            i2 = this.jpZ;
        }
        AppMethodBeat.o(126189);
        return i2;
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.modelvideo.b.a
    public final void ax(String str, int i2) {
        AppMethodBeat.i(126190);
        super.ax(str, i2);
        if (!(i2 == 0 || this.pNj == null)) {
            this.pNj.c(getSessionId(), getMediaId(), "download error", i2, 0);
        }
        AppMethodBeat.o(126190);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void onError(int i2, int i3) {
        AppMethodBeat.i(126191);
        super.onError(i2, i3);
        switch (i3) {
            case -3:
                b.pl(b.vhP);
                break;
            case -2:
                try {
                    g.aAi();
                    g.aAh().azQ().set(ar.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, Boolean.TRUE);
                    if (this.qbJ instanceof TopStoryVideoPlayTextureView) {
                        ((TopStoryVideoPlayTextureView) this.qbJ).setNeedResetExtractor(true);
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", e2, "%s onError [%s]", bgQ(), e2.toString());
                }
                b.pl(b.vhO);
                AppMethodBeat.o(126191);
                return;
            case -1:
                b.pl(b.vhN);
                AppMethodBeat.o(126191);
                return;
        }
        AppMethodBeat.o(126191);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final boolean dUD() {
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final boolean efT() {
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void onUIResume() {
        AppMethodBeat.i(126192);
        Log.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIResume", bgQ());
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
        AppMethodBeat.o(126192);
    }

    @Override // com.tencent.mm.pluginsdk.ui.CommonVideoView, com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void onUIPause() {
        AppMethodBeat.i(126193);
        Log.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIPause", bgQ());
        if (this.mEw) {
            this.mEH = getCurrPosSec();
            this.mEI = isPlaying();
            this.mEO = 0;
            this.mEN = 0;
            pause();
            stopTimer();
            this.mEw = false;
            yU((long) (getReportIdkey() + 11));
        }
        AppMethodBeat.o(126193);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final String getSessionId() {
        return this.sessionId;
    }

    public final void fzD() {
        AppMethodBeat.i(126194);
        ((TopStoryVideoPlayTextureView) this.qbJ).setAlpha(0.0f);
        AppMethodBeat.o(126194);
    }

    public final void fzE() {
        AppMethodBeat.i(126195);
        ((TopStoryVideoPlayTextureView) this.qbJ).setAlpha(1.0f);
        AppMethodBeat.o(126195);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i, com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void stop() {
        AppMethodBeat.i(126196);
        super.stop();
        this.GjH = null;
        AppMethodBeat.o(126196);
    }
}
