package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hf extends a {
    public long eEH = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16867;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(149927);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ClickScene:").append(this.eEH);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(149927);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(149926);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eEH);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(149926);
        return stringBuffer2;
    }
}