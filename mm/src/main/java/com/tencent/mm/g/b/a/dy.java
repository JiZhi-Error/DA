package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class dy extends a {
    private long eBW = 0;
    private long ejW = 0;
    private long evl = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20673;
    }

    public final dy ld(long j2) {
        this.evl = j2;
        return this;
    }

    public final dy le(long j2) {
        this.ejW = j2;
        return this;
    }

    public final dy lf(long j2) {
        this.eBW = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209204);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.evl);
        stringBuffer.append(",");
        stringBuffer.append(this.ejW);
        stringBuffer.append(",");
        stringBuffer.append(this.eBW);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209204);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209205);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("type:").append(this.evl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action:").append(this.ejW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("hasReddot:").append(this.eBW);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209205);
        return stringBuffer2;
    }
}
