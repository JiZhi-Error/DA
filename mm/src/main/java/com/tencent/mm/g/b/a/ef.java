package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ef extends a {
    private long eBJ;
    private String eiB = "";
    private long ejA;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19947;
    }

    public final ef qL(String str) {
        AppMethodBeat.i(209218);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(209218);
        return this;
    }

    public final ef lI(long j2) {
        this.eBJ = j2;
        return this;
    }

    public final ef lJ(long j2) {
        this.ejA = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209219);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eBJ);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209219);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209220);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotCount:").append(this.eBJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209220);
        return stringBuffer2;
    }
}
