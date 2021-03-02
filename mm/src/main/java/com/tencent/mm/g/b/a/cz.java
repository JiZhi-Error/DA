package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class cz extends a {
    private String eiB = "";
    private long ejA;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19954;
    }

    public final cz iF(long j2) {
        this.ejA = j2;
        return this;
    }

    public final cz of(String str) {
        AppMethodBeat.i(209081);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(209081);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209082);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209082);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209083);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209083);
        return stringBuffer2;
    }
}
