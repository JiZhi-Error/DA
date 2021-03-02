package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ij extends a {
    private long eOE;
    private String els = "";
    private long evZ;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21182;
    }

    public final ij wh(String str) {
        AppMethodBeat.i(237192);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(237192);
        return this;
    }

    public final ij ro(long j2) {
        this.eOE = j2;
        return this;
    }

    public final ij rp(long j2) {
        this.evZ = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(237193);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.eOE);
        stringBuffer.append(",");
        stringBuffer.append(this.evZ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(237193);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(237194);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("opType:").append(this.eOE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickType:").append(this.evZ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(237194);
        return stringBuffer2;
    }
}
