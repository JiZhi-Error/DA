package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gz extends a {
    public String eLk = "";
    public int eLl;
    public int enq;
    public String etW = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19963;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(231494);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enq);
        stringBuffer.append(",");
        stringBuffer.append(this.etW);
        stringBuffer.append(",");
        stringBuffer.append(this.eLk);
        stringBuffer.append(",");
        stringBuffer.append(this.eLl);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(231494);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(231495);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.enq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Username:").append(this.etW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChatUsername:").append(this.eLk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MessageCount:").append(this.eLl);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(231495);
        return stringBuffer2;
    }
}
