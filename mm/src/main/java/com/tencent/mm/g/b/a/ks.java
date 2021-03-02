package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ks extends a {
    public long eXj = 0;
    public long elF = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 13071;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(223493);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.elF);
        stringBuffer.append(",");
        stringBuffer.append(this.eXj);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(223493);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(223494);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OpType:").append(this.elF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Success:").append(this.eXj);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(223494);
        return stringBuffer2;
    }
}
