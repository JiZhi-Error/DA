package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bx extends a {
    private String eiC = "";
    private String erU = "";
    private long ery;
    private long erz;
    private String esZ = "";
    private long euk;
    private long eul;
    private long eum;
    private long eun;
    private long euo;
    private long eup;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20713;
    }

    public final bx kz(String str) {
        AppMethodBeat.i(208932);
        this.erU = x("Sessionid", str, true);
        AppMethodBeat.o(208932);
        return this;
    }

    public final bx kA(String str) {
        AppMethodBeat.i(208933);
        this.eiC = x("ClickTabContextid", str, true);
        AppMethodBeat.o(208933);
        return this;
    }

    public final bx eT(long j2) {
        this.ery = j2;
        return this;
    }

    public final bx eU(long j2) {
        this.euk = j2;
        return this;
    }

    public final bx eV(long j2) {
        this.eul = j2;
        return this;
    }

    public final bx eW(long j2) {
        this.eum = j2;
        return this;
    }

    public final bx eX(long j2) {
        this.eun = j2;
        return this;
    }

    public final bx kB(String str) {
        AppMethodBeat.i(208934);
        this.esZ = x("ExtraInfo", str, true);
        AppMethodBeat.o(208934);
        return this;
    }

    public final bx eY(long j2) {
        this.erz = j2;
        return this;
    }

    public final bx eZ(long j2) {
        this.euo = j2;
        return this;
    }

    public final bx fa(long j2) {
        this.eup = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208935);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erU);
        stringBuffer.append(",");
        stringBuffer.append(this.eiC);
        stringBuffer.append(",");
        stringBuffer.append(this.ery);
        stringBuffer.append(",");
        stringBuffer.append(this.euk);
        stringBuffer.append(",");
        stringBuffer.append(this.eul);
        stringBuffer.append(",");
        stringBuffer.append(this.eum);
        stringBuffer.append(",");
        stringBuffer.append(this.eun);
        stringBuffer.append(",");
        stringBuffer.append(this.esZ);
        stringBuffer.append(",");
        stringBuffer.append(this.erz);
        stringBuffer.append(",");
        stringBuffer.append(this.euo);
        stringBuffer.append(",");
        stringBuffer.append(this.eup);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208935);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208936);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Sessionid:").append(this.erU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextid:").append(this.eiC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentScene:").append(this.ery);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CgiType:").append(this.euk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LoadingTime:").append(this.eul);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StartCgiTimestamp:").append(this.eum);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("status:").append(this.eun);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExtraInfo:").append(this.esZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("InnerVersion:").append(this.erz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("pullType:").append(this.euo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EndCgiTimestamp:").append(this.eup);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208936);
        return stringBuffer2;
    }
}
