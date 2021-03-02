package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class oa extends a {
    public String fiO = "";
    public String fiP = "";
    public String fiQ = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16358;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(76373);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.fiO);
        stringBuffer.append(",");
        stringBuffer.append(this.fiP);
        stringBuffer.append(",");
        stringBuffer.append(this.fiQ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(76373);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(76374);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("WidgetAppid:").append(this.fiO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SrcAppid:").append(this.fiP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DrawData:").append(this.fiQ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(76374);
        return stringBuffer2;
    }
}
