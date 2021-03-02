package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ne extends a {
    public long eXG = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19540;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(223496);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ReportScene:").append(this.eXG);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(223496);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(223495);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eXG);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(223495);
        return stringBuffer2;
    }
}
