package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nf extends a {
    public long eXG = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 17875;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(149952);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ReportScene:").append(this.eXG);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(149952);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(149951);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eXG);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(149951);
        return stringBuffer2;
    }
}
