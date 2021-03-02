package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class g extends a {
    public long ejA = 0;
    public String ejB = "";
    public long ejy;
    public String ejz = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19574;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(185997);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ejy);
        stringBuffer.append(",");
        stringBuffer.append(this.ejz);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.ejB);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(185997);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(185998);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Requestcode:").append(this.ejy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ProcessName:").append(this.ejz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Stack:").append(this.ejB);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(185998);
        return stringBuffer2;
    }
}
