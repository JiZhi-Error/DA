package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class by extends a {
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
        return 20672;
    }

    public final by kC(String str) {
        AppMethodBeat.i(208937);
        this.erU = x("Sessionid", str, true);
        AppMethodBeat.o(208937);
        return this;
    }

    public final String acA() {
        return this.erU;
    }

    public final by kD(String str) {
        AppMethodBeat.i(208938);
        this.eiC = x("ClickTabContextid", str, true);
        AppMethodBeat.o(208938);
        return this;
    }

    public final String acM() {
        return this.eiC;
    }

    public final by fb(long j2) {
        this.ery = j2;
        return this;
    }

    public final long acN() {
        return this.ery;
    }

    public final by fc(long j2) {
        this.euk = j2;
        return this;
    }

    public final long acO() {
        return this.euk;
    }

    public final by fd(long j2) {
        this.eul = j2;
        return this;
    }

    public final long acP() {
        return this.eul;
    }

    public final by fe(long j2) {
        this.eum = j2;
        return this;
    }

    public final long acQ() {
        return this.eum;
    }

    public final by ff(long j2) {
        this.eun = j2;
        return this;
    }

    public final long acR() {
        return this.eun;
    }

    public final by kE(String str) {
        AppMethodBeat.i(208939);
        this.esZ = x("ExtraInfo", str, true);
        AppMethodBeat.o(208939);
        return this;
    }

    public final String getExtraInfo() {
        return this.esZ;
    }

    public final by acS() {
        this.erz = 10;
        return this;
    }

    public final long acT() {
        return this.erz;
    }

    public final by fg(long j2) {
        this.euo = j2;
        return this;
    }

    public final long acU() {
        return this.euo;
    }

    public final by fh(long j2) {
        this.eup = j2;
        return this;
    }

    public final long acV() {
        return this.eup;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208940);
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
        AppMethodBeat.o(208940);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208941);
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
        AppMethodBeat.o(208941);
        return stringBuffer2;
    }
}
