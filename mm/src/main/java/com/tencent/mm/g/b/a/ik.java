package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ik extends a {
    private long eOF;
    private String els = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21183;
    }

    public final ik wi(String str) {
        AppMethodBeat.i(237195);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(237195);
        return this;
    }

    public final ik rq(long j2) {
        this.eOF = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(237196);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.eOF);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(237196);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(237197);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("exposeType:").append(this.eOF);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(237197);
        return stringBuffer2;
    }
}
