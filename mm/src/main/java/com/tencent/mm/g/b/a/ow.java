package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ow extends a {
    private long ejA;
    private String eoC = "";
    private String erP = "";
    private long trN;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22208;
    }

    public final ow bwX(String str) {
        AppMethodBeat.i(258302);
        this.eoC = x("SessionID", str, true);
        AppMethodBeat.o(258302);
        return this;
    }

    public final ow RA(long j2) {
        this.ejA = j2;
        return this;
    }

    public final ow bwY(String str) {
        AppMethodBeat.i(258303);
        this.erP = x("ActionResult", str, true);
        AppMethodBeat.o(258303);
        return this;
    }

    public final ow RB(long j2) {
        this.trN = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(258304);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoC);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.erP);
        stringBuffer.append(",");
        stringBuffer.append(this.trN);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(258304);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(258305);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionID:").append(this.eoC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionResult:").append(this.erP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTs:").append(this.trN);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(258305);
        return stringBuffer2;
    }
}
