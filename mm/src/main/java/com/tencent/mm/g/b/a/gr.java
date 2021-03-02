package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gr extends a {
    public long eCt = 0;
    public long eKL = 0;
    public long eKM = 0;
    private String euc = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15850;
    }

    public final gr ut(String str) {
        AppMethodBeat.i(149915);
        this.euc = x("sessionID", str, true);
        AppMethodBeat.o(149915);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(149916);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.euc);
        stringBuffer.append(",");
        stringBuffer.append(this.eCt);
        stringBuffer.append(",");
        stringBuffer.append(this.eKL);
        stringBuffer.append(",");
        stringBuffer.append(this.eKM);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(149916);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(149917);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sessionID:").append(this.euc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionCode:").append(this.eCt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionCodeResult:").append(this.eKL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickAddContact:").append(this.eKM);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(149917);
        return stringBuffer2;
    }
}
