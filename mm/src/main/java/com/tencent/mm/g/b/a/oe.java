package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class oe extends a {
    private String ekG = "";
    private int eql;
    private long oqb;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22344;
    }

    public final oe PE(long j2) {
        this.oqb = j2;
        return this;
    }

    public final oe GJ(String str) {
        AppMethodBeat.i(261934);
        this.ekG = x("sessionId", str, true);
        AppMethodBeat.o(261934);
        return this;
    }

    public final oe PZ(int i2) {
        this.eql = i2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(261935);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.oqb);
        stringBuffer.append(",");
        stringBuffer.append(this.ekG);
        stringBuffer.append(",");
        stringBuffer.append(this.eql);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(261935);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(261936);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("actiontime:").append(this.oqb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionId:").append(this.ekG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene:").append(this.eql);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(261936);
        return stringBuffer2;
    }
}
