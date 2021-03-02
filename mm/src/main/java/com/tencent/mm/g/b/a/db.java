package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class db extends a {
    private String eiB = "";
    private long erY;
    private String euI = "";
    private long eyM;
    private long eyN;
    private long eyO;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19946;
    }

    public final db oi(String str) {
        AppMethodBeat.i(209084);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(209084);
        return this;
    }

    public final db iH(long j2) {
        this.erY = j2;
        return this;
    }

    public final db iI(long j2) {
        this.eyM = j2;
        return this;
    }

    public final db iJ(long j2) {
        this.eyN = j2;
        return this;
    }

    public final db oj(String str) {
        AppMethodBeat.i(209085);
        this.euI = x("feedid", str, true);
        AppMethodBeat.o(209085);
        return this;
    }

    public final db iK(long j2) {
        this.eyO = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209086);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.erY);
        stringBuffer.append(",");
        stringBuffer.append(this.eyM);
        stringBuffer.append(",");
        stringBuffer.append(this.eyN);
        stringBuffer.append(",");
        stringBuffer.append(this.euI);
        stringBuffer.append(",");
        stringBuffer.append(this.eyO);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209086);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209087);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Type:").append(this.erY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsOverlap:").append(this.eyM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OverlapCount:").append(this.eyN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("feedid:").append(this.euI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TabType:").append(this.eyO);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209087);
        return stringBuffer2;
    }
}
