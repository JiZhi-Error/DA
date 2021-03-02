package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ax extends a {
    public int eqL = -1;
    public int eqM = -1;
    public int eqN = -1;
    private String eqO = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21597;
    }

    public final ax iC(String str) {
        AppMethodBeat.i(186347);
        this.eqO = x("ErrorMsg", str, true);
        AppMethodBeat.o(186347);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(186348);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eqL);
        stringBuffer.append(",");
        stringBuffer.append(this.eqM);
        stringBuffer.append(",");
        stringBuffer.append(this.eqN);
        stringBuffer.append(",");
        stringBuffer.append(this.eqO);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(186348);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(186349);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EventType:").append(this.eqL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FaceType:").append(this.eqM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ErrorCode:").append(this.eqN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ErrorMsg:").append(this.eqO);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(186349);
        return stringBuffer2;
    }
}
