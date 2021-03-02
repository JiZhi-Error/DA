package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class kx extends a {
    private String eXF = "";
    public long ejA = 0;
    public long erW = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 17072;
    }

    public final kx yp(String str) {
        AppMethodBeat.i(149937);
        this.eXF = x("OrderId", str, true);
        AppMethodBeat.o(149937);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(149938);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.eXF);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(149938);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(149939);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OrderId:").append(this.eXF);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(149939);
        return stringBuffer2;
    }
}
