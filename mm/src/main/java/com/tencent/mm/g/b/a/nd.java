package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class nd extends a {
    public String ekB = "";
    public long fgg = 0;
    public long fgh = 0;
    public long fgi = 0;
    public String fgj = "";
    public String fgk = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 14688;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(116492);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.fgg);
        stringBuffer.append(",");
        stringBuffer.append(this.fgh);
        stringBuffer.append(",");
        stringBuffer.append(this.ekB);
        stringBuffer.append(",");
        stringBuffer.append(this.fgi);
        stringBuffer.append(",");
        stringBuffer.append(this.fgj);
        stringBuffer.append(",");
        stringBuffer.append(this.fgk);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(116492);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(116493);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("actionType:").append(this.fgg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clientTimestamp:").append(this.fgh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appId:").append(this.ekB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("serviceType:").append(this.fgi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("statBuffer:").append(this.fgj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("switchId:").append(this.fgk);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(116493);
        return stringBuffer2;
    }
}
