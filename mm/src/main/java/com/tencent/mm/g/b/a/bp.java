package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bp extends a {
    private String eiB = "";
    private long etn;
    private String eto = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19760;
    }

    public final bp ep(long j2) {
        AppMethodBeat.i(208898);
        this.etn = j2;
        super.bj("EnterTimeStampMs", this.etn);
        AppMethodBeat.o(208898);
        return this;
    }

    public final bp jN(String str) {
        AppMethodBeat.i(208899);
        this.eto = x("FinerUsername", str, true);
        AppMethodBeat.o(208899);
        return this;
    }

    public final bp jO(String str) {
        AppMethodBeat.i(208900);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(208900);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208901);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.etn);
        stringBuffer.append(",");
        stringBuffer.append(this.eto);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208901);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208902);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EnterTimeStampMs:").append(this.etn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinerUsername:").append(this.eto);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208902);
        return stringBuffer2;
    }
}
