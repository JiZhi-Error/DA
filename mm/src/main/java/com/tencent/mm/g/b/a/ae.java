package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ae extends a {
    public String enK = "";
    public long enL;
    public long enM = 0;
    public long enN = 0;
    public long enO = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19437;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(184762);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enK);
        stringBuffer.append(",");
        stringBuffer.append(this.enL);
        stringBuffer.append(",");
        stringBuffer.append(this.enM);
        stringBuffer.append(",");
        stringBuffer.append(this.enN);
        stringBuffer.append(",");
        stringBuffer.append(this.enO);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(184762);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(184763);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("roomusrname:").append(this.enK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("exitType:").append(this.enL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("role:").append(this.enM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("topBefore:").append(this.enN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("topAfter:").append(this.enO);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(184763);
        return stringBuffer2;
    }
}
