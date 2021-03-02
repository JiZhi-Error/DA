package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ka extends a {
    public long eTd = 0;
    public long ejA = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16996;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(155377);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eTd);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(155377);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(155378);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ThirdAppType:").append(this.eTd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(155378);
        return stringBuffer2;
    }
}
