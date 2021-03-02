package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class kq extends a {
    private long eJb = 0;
    private long eLO = 0;
    private long eSS = 0;
    private String eWa = "";
    private long eXc = 0;
    private long eXd = 0;
    private long eXe = 0;
    private long eXf = 0;
    private String eXg = "";
    private String etW = "";
    private long ezt = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16636;
    }

    public final kq ya(String str) {
        AppMethodBeat.i(226060);
        this.etW = x("Username", str, true);
        AppMethodBeat.o(226060);
        return this;
    }

    public final kq yb(String str) {
        AppMethodBeat.i(226061);
        this.eWa = x("Appid", str, true);
        AppMethodBeat.o(226061);
        return this;
    }

    public final kq tO(long j2) {
        this.eXc = j2;
        return this;
    }

    public final kq aiw() {
        this.eXd = 0;
        return this;
    }

    public final kq tP(long j2) {
        this.eJb = j2;
        return this;
    }

    public final kq tQ(long j2) {
        this.eSS = j2;
        return this;
    }

    public final kq tR(long j2) {
        this.ezt = j2;
        return this;
    }

    public final kq tS(long j2) {
        this.eXe = j2;
        return this;
    }

    public final kq tT(long j2) {
        this.eLO = j2;
        return this;
    }

    public final kq tU(long j2) {
        this.eXf = j2;
        return this;
    }

    public final kq yc(String str) {
        AppMethodBeat.i(226062);
        this.eXg = x("PackageKey", str, true);
        AppMethodBeat.o(226062);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(43458);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.etW);
        stringBuffer.append(",");
        stringBuffer.append(this.eWa);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        stringBuffer.append(this.eXd);
        stringBuffer.append(",");
        stringBuffer.append(this.eJb);
        stringBuffer.append(",");
        stringBuffer.append(this.eSS);
        stringBuffer.append(",");
        stringBuffer.append(this.ezt);
        stringBuffer.append(",");
        stringBuffer.append(this.eXe);
        stringBuffer.append(",");
        stringBuffer.append(this.eLO);
        stringBuffer.append(",");
        stringBuffer.append(this.eXf);
        stringBuffer.append(",");
        stringBuffer.append(this.eXg);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43458);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43459);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Username:").append(this.etW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Appid:").append(this.eWa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsEncrypt:").append(this.eXd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetworkType:").append(this.eJb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsSuccess:").append(this.eSS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RetryCount:").append(this.ezt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CmdSequence:").append(this.eXe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ReportId:").append(this.eLO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PackageType:").append(this.eXf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PackageKey:").append(this.eXg);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43459);
        return stringBuffer2;
    }
}
