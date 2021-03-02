package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ge extends a {
    private String eIR = "";
    private long eIS;
    private long eIT;
    private long eIU;
    private long eIV;
    private long eIW;
    private String eIX = "";
    private long eIY;
    private long eIZ;
    private long eJa;
    private long eJb;
    private String eJc = "";
    private String eJd = "";
    private String eJe = "";
    private int eJf = -1;
    private long ejA;
    private String ezR = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20741;
    }

    public final ge tH(String str) {
        AppMethodBeat.i(190434);
        this.ezR = x("EditId", str, true);
        AppMethodBeat.o(190434);
        return this;
    }

    public final ge tI(String str) {
        AppMethodBeat.i(190435);
        this.eIR = x("JsonInfo", str, true);
        AppMethodBeat.o(190435);
        return this;
    }

    public final ge pP(long j2) {
        this.eIS = j2;
        return this;
    }

    public final ge pQ(long j2) {
        this.eIT = j2;
        return this;
    }

    public final ge pR(long j2) {
        this.eIU = j2;
        return this;
    }

    public final ge pS(long j2) {
        this.eIV = j2;
        return this;
    }

    public final ge pT(long j2) {
        this.ejA = j2;
        return this;
    }

    public final ge pU(long j2) {
        this.eIW = j2;
        return this;
    }

    public final ge pV(long j2) {
        this.eJa = j2;
        return this;
    }

    public final ge pW(long j2) {
        this.eJb = j2;
        return this;
    }

    public final ge tJ(String str) {
        AppMethodBeat.i(190436);
        this.eJc = x("SeekTimeStr", str, true);
        AppMethodBeat.o(190436);
        return this;
    }

    public final String agM() {
        return this.eJc;
    }

    public final ge tK(String str) {
        AppMethodBeat.i(190437);
        this.eJd = x("UpdateCompositionTimeStr", str, true);
        AppMethodBeat.o(190437);
        return this;
    }

    public final ge tL(String str) {
        AppMethodBeat.i(190438);
        this.eJe = x("VideoGOPStr", str, true);
        AppMethodBeat.o(190438);
        return this;
    }

    public final ge ln(int i2) {
        this.eJf = i2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(190439);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ezR);
        stringBuffer.append(",");
        stringBuffer.append(this.eIR);
        stringBuffer.append(",");
        stringBuffer.append(this.eIS);
        stringBuffer.append(",");
        stringBuffer.append(this.eIT);
        stringBuffer.append(",");
        stringBuffer.append(this.eIU);
        stringBuffer.append(",");
        stringBuffer.append(this.eIV);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.eIW);
        stringBuffer.append(",");
        stringBuffer.append(this.eIX);
        stringBuffer.append(",");
        stringBuffer.append(this.eIY);
        stringBuffer.append(",");
        stringBuffer.append(this.eIZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eJa);
        stringBuffer.append(",");
        stringBuffer.append(this.eJb);
        stringBuffer.append(",");
        stringBuffer.append(this.eJc);
        stringBuffer.append(",");
        stringBuffer.append(this.eJd);
        stringBuffer.append(",");
        stringBuffer.append(this.eJe);
        stringBuffer.append(",");
        stringBuffer.append(this.eJf);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(190439);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(190440);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EditId:").append(this.ezR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("JsonInfo:").append(this.eIR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoCount:").append(this.eIS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ImageCount:").append(this.eIT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EditItemCount:").append(this.eIU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AudioCount:").append(this.eIV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceType:").append(this.eIW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TemplateId:").append(this.eIX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TemplateResourceReady:").append(this.eIY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DownloadTemplateTimeMs:").append(this.eIZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsEnableImageEnhancement:").append(this.eJa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetworkType:").append(this.eJb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SeekTimeStr:").append(this.eJc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UpdateCompositionTimeStr:").append(this.eJd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoGOPStr:").append(this.eJe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SendType:").append(this.eJf);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(190440);
        return stringBuffer2;
    }
}
