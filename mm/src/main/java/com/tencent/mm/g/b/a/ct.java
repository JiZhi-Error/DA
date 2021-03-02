package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ct extends a {
    private String eiB = "";
    private long enl;
    private String erP = "";
    private long etR;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21919;
    }

    public final ct hO(long j2) {
        this.enl = j2;
        return this;
    }

    public final long acL() {
        return this.enl;
    }

    public final ct nu(String str) {
        AppMethodBeat.i(220154);
        this.erP = x("ActionResult", str, true);
        AppMethodBeat.o(220154);
        return this;
    }

    public final String acu() {
        return this.erP;
    }

    public final ct hP(long j2) {
        AppMethodBeat.i(220155);
        this.etR = j2;
        super.bi("ActionTimeMs", this.etR);
        AppMethodBeat.o(220155);
        return this;
    }

    public final long acK() {
        return this.etR;
    }

    public final ct nv(String str) {
        AppMethodBeat.i(220156);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(220156);
        return this;
    }

    public final String getSessionId() {
        return this.eiB;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(220157);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.erP);
        stringBuffer.append(",");
        stringBuffer.append(this.etR);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(220157);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(220158);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionResult:").append(this.erP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTimeMs:").append(this.etR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(220158);
        return stringBuffer2;
    }
}
