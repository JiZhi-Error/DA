package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ld extends a {
    private String eXK = "";
    public long erW = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18263;
    }

    public final ld yq(String str) {
        AppMethodBeat.i(149946);
        this.eXK = x("ReqKey", str, true);
        AppMethodBeat.o(149946);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(149947);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.eXK);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(149947);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(149948);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ReqKey:").append(this.eXK);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(149948);
        return stringBuffer2;
    }
}
