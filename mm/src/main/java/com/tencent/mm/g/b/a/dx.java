package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class dx extends a {
    private long ejA;
    private long erY;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19952;
    }

    public final dx lb(long j2) {
        this.erY = j2;
        return this;
    }

    public final dx lc(long j2) {
        this.ejA = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209202);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erY);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209202);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209203);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Type:").append(this.erY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209203);
        return stringBuffer2;
    }
}
