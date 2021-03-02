package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class kw extends a {
    public String eXA = "";
    public String eXB = "";
    public String eXC = "";
    public String eXD = "";
    public String eXE = "";
    public long eXy = 0;
    public long eXz = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16310;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(91243);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eXy);
        stringBuffer.append(",");
        stringBuffer.append(this.eXz);
        stringBuffer.append(",");
        stringBuffer.append(this.eXA);
        stringBuffer.append(",");
        stringBuffer.append(this.eXB);
        stringBuffer.append(",");
        stringBuffer.append(this.eXC);
        stringBuffer.append(",");
        stringBuffer.append(this.eXD);
        stringBuffer.append(",");
        stringBuffer.append(this.eXE);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(91243);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(91244);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PayType:").append(this.eXy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CallbackType:").append(this.eXz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceH5Url:").append(this.eXA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceAppUsername:").append(this.eXB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceAppPath:").append(this.eXC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TargetAppUsername:").append(this.eXD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TargetAppPath:").append(this.eXE);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(91244);
        return stringBuffer2;
    }
}
