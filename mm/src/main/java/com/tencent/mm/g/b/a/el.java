package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class el extends a {
    private String eCL = "";
    private long eCM = 0;
    private String eCN = "";
    private long eCO = 0;
    private String eCP = "";
    private String eiB = "";
    private long enH = 0;
    private String erH = "";
    private String esZ = "";
    private String eta = "";
    private long ezg = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19943;
    }

    public final el re(String str) {
        AppMethodBeat.i(220209);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(220209);
        return this;
    }

    public final String getSessionId() {
        return this.eiB;
    }

    public final el rf(String str) {
        AppMethodBeat.i(220210);
        this.eCL = x("PageName", str, true);
        AppMethodBeat.o(220210);
        return this;
    }

    public final String afB() {
        return this.eCL;
    }

    public final el ma(long j2) {
        AppMethodBeat.i(220211);
        this.enH = j2;
        super.bi("StayTimeMs", this.enH);
        AppMethodBeat.o(220211);
        return this;
    }

    public final long afo() {
        return this.enH;
    }

    public final el mb(long j2) {
        AppMethodBeat.i(220212);
        this.ezg = j2;
        super.bi("EnterTimeMs", this.ezg);
        AppMethodBeat.o(220212);
        return this;
    }

    public final long afC() {
        return this.ezg;
    }

    public final el mc(long j2) {
        AppMethodBeat.i(220213);
        this.eCM = j2;
        super.bi("ExitTimeMs", this.eCM);
        AppMethodBeat.o(220213);
        return this;
    }

    public final long afD() {
        return this.eCM;
    }

    public final el rg(String str) {
        AppMethodBeat.i(220214);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(220214);
        return this;
    }

    public final String ack() {
        return this.erH;
    }

    public final el rh(String str) {
        AppMethodBeat.i(220215);
        this.eCN = x("Sid", str, true);
        AppMethodBeat.o(220215);
        return this;
    }

    public final String afE() {
        return this.eCN;
    }

    public final el md(long j2) {
        this.eCO = j2;
        return this;
    }

    public final long afF() {
        return this.eCO;
    }

    public final el ri(String str) {
        AppMethodBeat.i(220216);
        this.eCP = x("FinderContextID", str, true);
        AppMethodBeat.o(220216);
        return this;
    }

    public final String afG() {
        return this.eCP;
    }

    public final el rj(String str) {
        AppMethodBeat.i(220217);
        this.esZ = x("ExtraInfo", str, true);
        AppMethodBeat.o(220217);
        return this;
    }

    public final String getExtraInfo() {
        return this.esZ;
    }

    public final el rk(String str) {
        AppMethodBeat.i(220218);
        this.eta = x("enterSourceInfo", str, true);
        AppMethodBeat.o(220218);
        return this;
    }

    public final String afH() {
        return this.eta;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(220219);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eCL);
        stringBuffer.append(",");
        stringBuffer.append(this.enH);
        stringBuffer.append(",");
        stringBuffer.append(this.ezg);
        stringBuffer.append(",");
        stringBuffer.append(this.eCM);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.eCN);
        stringBuffer.append(",");
        stringBuffer.append(this.eCO);
        stringBuffer.append(",");
        stringBuffer.append(this.eCP);
        stringBuffer.append(",");
        stringBuffer.append(this.esZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eta);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(220219);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(220220);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PageName:").append(this.eCL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StayTimeMs:").append(this.enH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterTimeMs:").append(this.ezg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExitTimeMs:").append(this.eCM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Sid:").append(this.eCN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("reportType:").append(this.eCO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderContextID:").append(this.eCP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExtraInfo:").append(this.esZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("enterSourceInfo:").append(this.eta);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(220220);
        return stringBuffer2;
    }
}
