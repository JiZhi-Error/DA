package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lb extends a {
    public long erW = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18564;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(149943);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.erW);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(149943);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(149942);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erW);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(149942);
        return stringBuffer2;
    }
}
