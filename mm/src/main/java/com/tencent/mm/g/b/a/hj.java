package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class hj extends a {
    public long eLK = 0;
    public long eLL = 0;
    public long eLM = 0;
    public String eLN = "";
    public long eLO = 0;
    public long eLP = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15166;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(223491);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eLK);
        stringBuffer.append(",");
        stringBuffer.append(this.eLL);
        stringBuffer.append(",");
        stringBuffer.append(this.eLM);
        stringBuffer.append(",");
        stringBuffer.append(this.eLN);
        stringBuffer.append(",");
        stringBuffer.append(this.eLO);
        stringBuffer.append(",");
        stringBuffer.append(this.eLP);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(223491);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(223492);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ResType:").append(this.eLK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ResSubType:").append(this.eLL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ResVersion:").append(this.eLM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Network:").append(this.eLN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ReportId:").append(this.eLO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ReportKey:").append(this.eLP);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(223492);
        return stringBuffer2;
    }
}
