package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ak extends a {
    private long ejW;
    private long eoB;
    private String eoC = "";
    private String eoD = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21831;
    }

    public final ak cb(long j2) {
        this.eoB = j2;
        return this;
    }

    public final ak cc(long j2) {
        this.ejW = j2;
        return this;
    }

    public final ak iq(String str) {
        AppMethodBeat.i(231471);
        this.eoC = x("SessionID", str, true);
        AppMethodBeat.o(231471);
        return this;
    }

    public final ak ir(String str) {
        AppMethodBeat.i(231472);
        this.eoD = x("ContextID", str, true);
        AppMethodBeat.o(231472);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(231473);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoB);
        stringBuffer.append(",");
        stringBuffer.append(this.ejW);
        stringBuffer.append(",");
        stringBuffer.append(this.eoC);
        stringBuffer.append(",");
        stringBuffer.append(this.eoD);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(231473);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(231474);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActionTimestamp:").append(this.eoB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action:").append(this.ejW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionID:").append(this.eoC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextID:").append(this.eoD);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(231474);
        return stringBuffer2;
    }
}
