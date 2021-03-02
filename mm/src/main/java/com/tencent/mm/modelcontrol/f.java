package com.tencent.mm.modelcontrol;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class f {
    protected int audioBitrate;
    protected String iST;
    protected int iSU;
    protected int iSV;
    protected boolean iSW;
    protected g[] iSX;
    protected int iiH;

    /* access modifiers changed from: protected */
    public final void a(String str, String str2, String str3, String str4, String str5, String str6) {
        boolean z;
        AppMethodBeat.i(126774);
        this.iST = str;
        this.audioBitrate = Util.getInt(str2, 0);
        this.audioBitrate = this.audioBitrate == 0 ? 64000 : this.audioBitrate * 1000;
        this.iiH = Util.getInt(str3, 10);
        this.iSU = Util.getInt(str4, 2);
        this.iSV = Util.getInt(str5, 1);
        if (Util.getInt(str6, 0) > 0) {
            z = true;
        } else {
            z = false;
        }
        this.iSW = z;
        AppMethodBeat.o(126774);
    }

    /* access modifiers changed from: protected */
    public final boolean bbo() {
        AppMethodBeat.i(126775);
        if (Util.isNullOrNil(this.iST)) {
            AppMethodBeat.o(126775);
            return true;
        }
        boolean Of = b.Of(this.iST);
        AppMethodBeat.o(126775);
        return Of;
    }

    /* access modifiers changed from: protected */
    public final VideoTransPara bbp() {
        AppMethodBeat.i(126776);
        VideoTransPara videoTransPara = null;
        if (this.iSX != null) {
            g[] gVarArr = this.iSX;
            for (g gVar : gVarArr) {
                if (gVar != null && gVar.iSY <= 0 && gVar.iSZ >= 0) {
                    videoTransPara = new VideoTransPara();
                    videoTransPara.width = gVar.iTa;
                    videoTransPara.height = gVar.iTb;
                    videoTransPara.fps = gVar.iTc;
                    videoTransPara.videoBitrate = gVar.iTd;
                    videoTransPara.iiH = this.iiH;
                    videoTransPara.audioBitrate = this.audioBitrate;
                    videoTransPara.iSU = this.iSU;
                    videoTransPara.iSV = this.iSV;
                }
            }
        }
        AppMethodBeat.o(126776);
        return videoTransPara;
    }

    /* access modifiers changed from: protected */
    public final VideoTransPara bbq() {
        double d2 = 1.0d;
        AppMethodBeat.i(184645);
        VideoTransPara bbp = bbp();
        if (bbp == null) {
            AppMethodBeat.o(184645);
            return null;
        }
        if (bbp.fps <= 0) {
            bbp.iiH = 1;
        } else {
            double d3 = ((double) bbp.iiH) / ((double) bbp.fps);
            if (d3 >= 1.0d) {
                d2 = d3;
            }
            bbp.iiH = (int) Math.ceil(d2);
        }
        AppMethodBeat.o(184645);
        return bbp;
    }

    public final String toString() {
        AppMethodBeat.i(126777);
        String str = "[ busyTime " + this.iST + " audioBitrate " + this.audioBitrate + " iFrame " + this.iiH + " profileIndex " + this.iSU + " presetIndex " + this.iSV + " isStepBr " + this.iSW + " ]";
        AppMethodBeat.o(126777);
        return str;
    }
}
