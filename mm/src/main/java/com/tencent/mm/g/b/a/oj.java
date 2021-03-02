package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class oj extends a {
    private long eLz;
    private long fgg;
    private String oqU = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20849;
    }

    public final oj aFb() {
        this.eLz = 5;
        return this;
    }

    public final oj PL(long j2) {
        this.fgg = j2;
        return this;
    }

    public final oj atL(String str) {
        AppMethodBeat.i(259300);
        this.oqU = x("msgId", str, true);
        AppMethodBeat.o(259300);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(259301);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eLz);
        stringBuffer.append(",");
        stringBuffer.append(this.fgg);
        stringBuffer.append(",");
        stringBuffer.append(this.oqU);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(259301);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(259302);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("msgType:").append(this.eLz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionType:").append(this.fgg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("msgId:").append(this.oqU);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(259302);
        return stringBuffer2;
    }
}
