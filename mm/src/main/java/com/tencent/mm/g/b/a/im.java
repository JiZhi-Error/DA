package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class im extends a {
    private long eOD = 0;
    private String eiB = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15988;
    }

    public final im wj(String str) {
        AppMethodBeat.i(94836);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(94836);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(94838);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eOD);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(94838);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(94839);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTimeStampMs:").append(this.eOD);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(94839);
        return stringBuffer2;
    }

    public final im ahi() {
        AppMethodBeat.i(94837);
        this.eOD = Util.nowMilliSecond();
        super.bj("ClickTimeStampMs", this.eOD);
        AppMethodBeat.o(94837);
        return this;
    }
}
