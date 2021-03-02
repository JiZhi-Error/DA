package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class kz extends a {
    public long eEH = 0;
    public long eXI = 0;
    public long eXJ = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15661;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(149940);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eEH);
        stringBuffer.append(",");
        stringBuffer.append(this.eXI);
        stringBuffer.append(",");
        stringBuffer.append(this.eXJ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(149940);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(149941);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ClickScene:").append(this.eEH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ReportValue:").append(this.eXI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EntryScene:").append(this.eXJ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(149941);
        return stringBuffer2;
    }
}
