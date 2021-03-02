package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ag extends a {
    public int enW;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18884;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(63296);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActionType:").append(this.enW);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(63296);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(63295);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enW);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(63295);
        return stringBuffer2;
    }
}
