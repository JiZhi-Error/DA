package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class f extends a {
    public String ejs = "";
    public String ejt = "";
    public String eju = "";
    public long ejv;
    public long ejw;
    public long ejx;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21948;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(238845);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ejs);
        stringBuffer.append(",");
        stringBuffer.append(this.ejt);
        stringBuffer.append(",");
        stringBuffer.append(this.eju);
        stringBuffer.append(",");
        stringBuffer.append(this.ejv);
        stringBuffer.append(",");
        stringBuffer.append(this.ejw);
        stringBuffer.append(",");
        stringBuffer.append(this.ejx);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(238845);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(238846);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("lastSessionId:").append(this.ejs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("currSessionId:").append(this.ejt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("nextSessionId:").append(this.eju);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("currSessionEnterMs:").append(this.ejv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("currSessionQuitMs:").append(this.ejw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("currSessionStayTime:").append(this.ejx);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(238846);
        return stringBuffer2;
    }
}
