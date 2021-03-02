package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gb extends a {
    public long eIs;
    public long eIt;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21626;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(231485);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eIs);
        stringBuffer.append(",");
        stringBuffer.append(this.eIt);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(231485);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(231486);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OperationObject:").append(this.eIs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OperationType:").append(this.eIt);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(231486);
        return stringBuffer2;
    }
}
