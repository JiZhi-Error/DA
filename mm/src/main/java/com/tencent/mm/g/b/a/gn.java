package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gn extends a {
    public int eJR;
    private String eJS = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20551;
    }

    public final gn up(String str) {
        AppMethodBeat.i(231487);
        this.eJS = x("VoiceID", str, true);
        AppMethodBeat.o(231487);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(231488);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eJR);
        stringBuffer.append(",");
        stringBuffer.append(this.eJS);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(231488);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(231489);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Type:").append(this.eJR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VoiceID:").append(this.eJS);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(231489);
        return stringBuffer2;
    }
}
