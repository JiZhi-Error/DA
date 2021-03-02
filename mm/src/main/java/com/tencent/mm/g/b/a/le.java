package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class le extends a {
    public long eXG = 0;
    private String eXM = "";
    public long eXN = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16016;
    }

    public final le yr(String str) {
        AppMethodBeat.i(91247);
        this.eXM = x("TransferUserName", str, true);
        AppMethodBeat.o(91247);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(91248);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eXG);
        stringBuffer.append(",");
        stringBuffer.append(this.eXM);
        stringBuffer.append(",");
        stringBuffer.append(this.eXN);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(91248);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(91249);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ReportScene:").append(this.eXG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TransferUserName:").append(this.eXM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TransferAmount:").append(this.eXN);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(91249);
        return stringBuffer2;
    }
}
