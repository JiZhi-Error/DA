package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class es extends a {
    public long eEr = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18526;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(63300);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("reportScene:").append(this.eEr);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(63300);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(63299);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eEr);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(63299);
        return stringBuffer2;
    }
}
