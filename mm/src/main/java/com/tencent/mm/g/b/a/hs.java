package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class hs extends a {
    private long eMo = 0;
    private long eMp = 0;
    private long eMq = 0;
    private long ejW = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15005;
    }

    public final hs qS(long j2) {
        this.eMo = j2;
        return this;
    }

    public final hs qT(long j2) {
        this.ejW = j2;
        return this;
    }

    public final hs qU(long j2) {
        this.eMp = j2;
        return this;
    }

    public final hs qV(long j2) {
        this.eMq = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(210796);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eMo);
        stringBuffer.append(",");
        stringBuffer.append(this.ejW);
        stringBuffer.append(",");
        stringBuffer.append(this.eMp);
        stringBuffer.append(",");
        stringBuffer.append(this.eMq);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(210796);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(210797);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("biz:").append(this.eMo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action:").append(this.ejW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("timecost:").append(this.eMp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isUseSysWebview:").append(this.eMq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(210797);
        return stringBuffer2;
    }
}
