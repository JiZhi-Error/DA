package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tavkit.component.TAVExporter;

public final class p {
    public int gIP = 2;
    public int ilT = -1;
    public VideoTransPara irT;
    public boolean isQ = false;
    public int kyq = -1;
    public boolean roc = true;
    public int videoBitrate;
    public int zuJ = 1;
    public int zuK = -1;
    public boolean zuL = false;
    public boolean zuM = true;
    public boolean zuN = false;
    h.c zuO;
    public boolean zuv = false;

    public static p a(int i2, VideoTransPara videoTransPara) {
        p p;
        AppMethodBeat.i(89447);
        switch (i2) {
            case 1:
                p = e(videoTransPara);
                break;
            case 2:
                p = f(videoTransPara);
                break;
            case 3:
                p = g(videoTransPara);
                break;
            case 4:
                p = h(videoTransPara);
                break;
            case 5:
                p = i(videoTransPara);
                break;
            case 6:
                p = j(videoTransPara);
                break;
            case 7:
                p = k(videoTransPara);
                break;
            case 8:
                p = l(videoTransPara);
                break;
            case 9:
                p = m(videoTransPara);
                break;
            case 10:
                p = n(videoTransPara);
                break;
            case 11:
                p = o(videoTransPara);
                break;
            case 12:
                p = p(videoTransPara);
                break;
            default:
                AppMethodBeat.o(89447);
                return null;
        }
        if (p != null) {
            p.zuK = i2;
        }
        AppMethodBeat.o(89447);
        return p;
    }

    private static p e(VideoTransPara videoTransPara) {
        AppMethodBeat.i(89448);
        Log.i("MicroMsg.RecoderParameter", "setToPresetConfig1");
        p pVar = new p(2, videoTransPara);
        pVar.zuL = false;
        AppMethodBeat.o(89448);
        return pVar;
    }

    private static p f(VideoTransPara videoTransPara) {
        AppMethodBeat.i(89449);
        Log.i("MicroMsg.RecoderParameter", "setToPresetConfig2");
        p pVar = new p(2, videoTransPara);
        pVar.zuL = false;
        p ejO = pVar.ejP().ejO();
        AppMethodBeat.o(89449);
        return ejO;
    }

    private static p g(VideoTransPara videoTransPara) {
        AppMethodBeat.i(89450);
        Log.i("MicroMsg.RecoderParameter", "setToPresetConfig3");
        p pVar = new p(1, videoTransPara);
        pVar.zuL = false;
        AppMethodBeat.o(89450);
        return pVar;
    }

    private static p h(VideoTransPara videoTransPara) {
        AppMethodBeat.i(89451);
        Log.i("MicroMsg.RecoderParameter", "setToPresetConfig4");
        p pVar = new p(1, videoTransPara);
        pVar.zuL = false;
        p ejO = pVar.ejP().ejO();
        AppMethodBeat.o(89451);
        return ejO;
    }

    private static p i(VideoTransPara videoTransPara) {
        AppMethodBeat.i(89452);
        Log.i("MicroMsg.RecoderParameter", "setToPresetConfig5");
        p pVar = new p(2, videoTransPara);
        pVar.zuL = true;
        pVar.isQ = false;
        p ejO = pVar.ejO();
        AppMethodBeat.o(89452);
        return ejO;
    }

    private static p j(VideoTransPara videoTransPara) {
        AppMethodBeat.i(89453);
        Log.i("MicroMsg.RecoderParameter", "setToPresetConfig6");
        p pVar = new p(1, videoTransPara);
        pVar.zuL = true;
        p ejO = pVar.ejO();
        AppMethodBeat.o(89453);
        return ejO;
    }

    private static p k(VideoTransPara videoTransPara) {
        AppMethodBeat.i(89454);
        Log.i("MicroMsg.RecoderParameter", "setToPresetConfig7");
        p pVar = new p(2, videoTransPara);
        pVar.zuL = true;
        p ejQ = pVar.ejQ();
        ejQ.isQ = false;
        AppMethodBeat.o(89454);
        return ejQ;
    }

    private static p l(VideoTransPara videoTransPara) {
        AppMethodBeat.i(89455);
        Log.i("MicroMsg.RecoderParameter", "setToPresetConfig8");
        p pVar = new p(2, videoTransPara);
        pVar.zuL = true;
        p ejQ = pVar.ejQ();
        ejQ.isQ = true;
        AppMethodBeat.o(89455);
        return ejQ;
    }

    private static p m(VideoTransPara videoTransPara) {
        AppMethodBeat.i(89456);
        p pVar = new p(1, videoTransPara);
        pVar.zuL = true;
        p ejQ = pVar.ejQ();
        ejQ.isQ = false;
        AppMethodBeat.o(89456);
        return ejQ;
    }

    private static p n(VideoTransPara videoTransPara) {
        AppMethodBeat.i(89457);
        Log.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
        p pVar = new p(1, videoTransPara);
        pVar.zuL = true;
        p ejQ = pVar.ejQ();
        ejQ.isQ = true;
        AppMethodBeat.o(89457);
        return ejQ;
    }

    public p() {
    }

    private static p o(VideoTransPara videoTransPara) {
        AppMethodBeat.i(89458);
        Log.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
        p pVar = new p(2, videoTransPara);
        pVar.zuL = true;
        p ejQ = pVar.ejQ();
        ejQ.isQ = false;
        p ejP = ejQ.ejP();
        AppMethodBeat.o(89458);
        return ejP;
    }

    private static p p(VideoTransPara videoTransPara) {
        AppMethodBeat.i(89459);
        Log.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
        p pVar = new p(2, videoTransPara);
        pVar.zuL = true;
        p ejR = pVar.ejR();
        ejR.isQ = false;
        p ejP = ejR.ejP();
        AppMethodBeat.o(89459);
        return ejP;
    }

    private p(int i2, VideoTransPara videoTransPara) {
        this.irT = videoTransPara;
        this.gIP = i2;
        this.videoBitrate = videoTransPara.videoBitrate;
        this.ilT = videoTransPara.width;
    }

    public final p ejO() {
        this.ilT = TAVExporter.VIDEO_EXPORT_WIDTH;
        if (this.kyq > 0 && this.ilT > this.kyq) {
            this.ilT = this.kyq;
        }
        return this;
    }

    public final p ejP() {
        this.videoBitrate = this.irT.videoBitrate * 2;
        this.zuN = true;
        return this;
    }

    public final p ejQ() {
        this.ilT = this.irT.width * 2;
        if (this.kyq > 0 && this.ilT > this.kyq) {
            this.ilT = this.kyq;
        }
        return this;
    }

    private p ejR() {
        this.ilT = 1080;
        if (this.kyq > 0 && this.ilT > this.kyq) {
            this.ilT = this.kyq;
        }
        return this;
    }

    public final boolean ejS() {
        return this.irT.width < this.ilT;
    }

    public final String toString() {
        AppMethodBeat.i(89460);
        String format = String.format("mediatype %s videoBitrate : %s isEnableLandscapeMode %s needRotateEachFrame %s isNeedRealtimeScale %s resolutionLimit %s videoParams %s", Integer.valueOf(this.gIP), Integer.valueOf(this.videoBitrate), Boolean.valueOf(this.zuv), Boolean.valueOf(this.isQ), Boolean.valueOf(this.zuL), Integer.valueOf(this.ilT), this.irT);
        AppMethodBeat.o(89460);
        return format;
    }
}
