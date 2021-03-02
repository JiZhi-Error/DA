package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ni extends a {
    private String eBQ = "";
    public long eMl = 0;
    public long eMp = 0;
    public String enR = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15831;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(116494);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enR);
        stringBuffer.append(",");
        stringBuffer.append(this.eBQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eMp);
        stringBuffer.append(",");
        stringBuffer.append(this.eMl);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(116494);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(116495);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appid:").append(this.enR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("query:").append(this.eBQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("timecost:").append(this.eMp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("hasInitData:").append(this.eMl);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(116495);
        return stringBuffer2;
    }
}
