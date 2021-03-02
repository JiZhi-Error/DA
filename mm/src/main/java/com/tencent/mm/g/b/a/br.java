package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class br extends a {
    private long etA;
    private String etB = "";
    private String etz = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20889;
    }

    public final br jX(String str) {
        AppMethodBeat.i(241577);
        this.etz = x("InnerVersion", str, true);
        AppMethodBeat.o(241577);
        return this;
    }

    public final br ew(long j2) {
        this.etA = j2;
        return this;
    }

    public final br jY(String str) {
        AppMethodBeat.i(241578);
        this.etB = x("exceptionValue", str, true);
        AppMethodBeat.o(241578);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(241579);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.etz);
        stringBuffer.append(",");
        stringBuffer.append(this.etA);
        stringBuffer.append(",");
        stringBuffer.append(this.etB);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(241579);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(241580);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InnerVersion:").append(this.etz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("exceptionType:").append(this.etA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("exceptionValue:").append(this.etB);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(241580);
        return stringBuffer2;
    }
}
