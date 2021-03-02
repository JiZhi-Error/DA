package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class da extends a {
    private String eiB = "";
    private long ejA;
    private String etW = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19431;
    }

    public final da og(String str) {
        AppMethodBeat.i(184161);
        this.etW = x("Username", str, true);
        AppMethodBeat.o(184161);
        return this;
    }

    public final da iG(long j2) {
        this.ejA = j2;
        return this;
    }

    public final da oh(String str) {
        AppMethodBeat.i(184162);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(184162);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(184163);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.etW);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(184163);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(184164);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Username:").append(this.etW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(184164);
        return stringBuffer2;
    }
}
