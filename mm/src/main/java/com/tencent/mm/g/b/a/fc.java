package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fc extends a {
    public long eBn;
    public String eBo = "";
    public long eBr;
    public String erU = "";
    private long etn;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20493;
    }

    public final fc nf(long j2) {
        AppMethodBeat.i(241583);
        this.etn = j2;
        super.bj("EnterTimeStampMs", this.etn);
        AppMethodBeat.o(241583);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(241584);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erU);
        stringBuffer.append(",");
        stringBuffer.append(this.etn);
        stringBuffer.append(",");
        stringBuffer.append(this.eBn);
        stringBuffer.append(",");
        stringBuffer.append(this.eBr);
        stringBuffer.append(",");
        stringBuffer.append(this.eBo);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(241584);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(241585);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Sessionid:").append(this.erU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterTimeStampMs:").append(this.etn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotCtrlType:").append(this.eBn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotShowInfoType:").append(this.eBr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotTipsID:").append(this.eBo);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(241585);
        return stringBuffer2;
    }
}
