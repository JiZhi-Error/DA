package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hd extends a {
    public long eEH = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16871;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(149923);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ClickScene:").append(this.eEH);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(149923);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(149922);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eEH);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(149922);
        return stringBuffer2;
    }
}
