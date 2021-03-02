package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lf extends a {
    public long ejA = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18278;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(149950);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Action:").append(this.ejA);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(149950);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(149949);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ejA);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(149949);
        return stringBuffer2;
    }
}
