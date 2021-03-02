package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gk extends a {
    private String eJA = "";
    private long eJB;
    private String eJC = "";
    private long eJD;
    private long eJE;
    private long eJF;
    private long eJG;
    private long eJH;
    private long eJI;
    private long eJJ;
    private String eJK = "";
    private String eJu = "";
    private String eJv = "";
    private String eJw = "";
    private String eJx = "";
    private String eJy = "";
    private String eJz = "";
    private long enl;
    private String eoz = "";
    private long erW;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22223;
    }

    public final gk tW(String str) {
        AppMethodBeat.i(256692);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(256692);
        return this;
    }

    public final gk tX(String str) {
        AppMethodBeat.i(256693);
        this.eJu = x("SongName", str, true);
        AppMethodBeat.o(256693);
        return this;
    }

    public final gk tY(String str) {
        AppMethodBeat.i(256694);
        this.eJv = x("WebUrl", str, true);
        AppMethodBeat.o(256694);
        return this;
    }

    public final gk tZ(String str) {
        AppMethodBeat.i(256695);
        this.eJw = x("DataUrl", str, true);
        AppMethodBeat.o(256695);
        return this;
    }

    public final gk ua(String str) {
        AppMethodBeat.i(256696);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(256696);
        return this;
    }

    public final gk qn(long j2) {
        this.erW = j2;
        return this;
    }

    public final gk ub(String str) {
        AppMethodBeat.i(256697);
        this.eJy = x("FromSourceId", str, true);
        AppMethodBeat.o(256697);
        return this;
    }

    public final gk uc(String str) {
        AppMethodBeat.i(256698);
        this.eJz = x("MvObjectId", str, true);
        AppMethodBeat.o(256698);
        return this;
    }

    public final gk ud(String str) {
        AppMethodBeat.i(256699);
        this.eJA = x("MvNonceId", str, true);
        AppMethodBeat.o(256699);
        return this;
    }

    public final gk qo(long j2) {
        this.eJB = j2;
        return this;
    }

    public final gk ue(String str) {
        AppMethodBeat.i(256700);
        this.eJC = x("SongId", str, true);
        AppMethodBeat.o(256700);
        return this;
    }

    public final gk Qf(long j2) {
        this.enl = j2;
        return this;
    }

    public final gk Qg(long j2) {
        this.eJD = j2;
        return this;
    }

    public final gk Qh(long j2) {
        this.eJE = j2;
        return this;
    }

    public final gk Qi(long j2) {
        this.eJF = j2;
        return this;
    }

    public final gk Qj(long j2) {
        this.eJG = j2;
        return this;
    }

    public final gk Qk(long j2) {
        this.eJH = j2;
        return this;
    }

    public final gk Ql(long j2) {
        this.eJI = j2;
        return this;
    }

    public final gk bvO(String str) {
        AppMethodBeat.i(259116);
        this.eJK = x("Singer", str, true);
        AppMethodBeat.o(259116);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(256701);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.eJu);
        stringBuffer.append(",");
        stringBuffer.append(this.eJv);
        stringBuffer.append(",");
        stringBuffer.append(this.eJw);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.eJy);
        stringBuffer.append(",");
        stringBuffer.append(this.eJz);
        stringBuffer.append(",");
        stringBuffer.append(this.eJA);
        stringBuffer.append(",");
        stringBuffer.append(this.eJB);
        stringBuffer.append(",");
        stringBuffer.append(this.eJC);
        stringBuffer.append(",");
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.eJD);
        stringBuffer.append(",");
        stringBuffer.append(this.eJE);
        stringBuffer.append(",");
        stringBuffer.append(this.eJF);
        stringBuffer.append(",");
        stringBuffer.append(this.eJG);
        stringBuffer.append(",");
        stringBuffer.append(this.eJH);
        stringBuffer.append(",");
        stringBuffer.append(this.eJI);
        stringBuffer.append(",");
        stringBuffer.append(this.eJJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eJK);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(256701);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(256702);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SongName:").append(this.eJu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WebUrl:").append(this.eJv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DataUrl:").append(this.eJw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FromSourceId:").append(this.eJy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MvObjectId:").append(this.eJz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MvNonceId:").append(this.eJA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasLyric:").append(this.eJB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SongId:").append(this.eJC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PCU:").append(this.eJD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FCU:").append(this.eJE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MCU:").append(this.eJF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsCreate:").append(this.eJG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayDuration:").append(this.eJH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsCommentArea:").append(this.eJI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExpoCommentNum:").append(this.eJJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Singer:").append(this.eJK);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(256702);
        return stringBuffer2;
    }
}
