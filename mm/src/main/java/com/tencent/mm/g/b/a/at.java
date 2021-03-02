package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class at extends a {
    public int enW = 0;
    public int eqq = 0;
    public int eqr = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19988;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(220079);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eqq);
        stringBuffer.append(",");
        stringBuffer.append(this.eqr);
        stringBuffer.append(",");
        stringBuffer.append(this.enW);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(220079);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(220080);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ExptAppId:").append(this.eqq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExptSeq:").append(this.eqr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionType:").append(this.enW);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(220080);
        return stringBuffer2;
    }
}
