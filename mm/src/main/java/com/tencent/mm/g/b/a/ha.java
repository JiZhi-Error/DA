package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ha extends a {
    private String eiB = "";
    private int eki;
    private int enq;
    private int eqN;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20379;
    }

    public final ha uP(String str) {
        AppMethodBeat.i(206896);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(206896);
        return this;
    }

    public final ha lo(int i2) {
        this.eki = i2;
        return this;
    }

    public final ha lp(int i2) {
        this.eqN = i2;
        return this;
    }

    public final ha agT() {
        this.enq = 3;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(206897);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eki);
        stringBuffer.append(",");
        stringBuffer.append(this.eqN);
        stringBuffer.append(",");
        stringBuffer.append(this.enq);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(206897);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(206898);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.eki);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ErrorCode:").append(this.eqN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.enq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(206898);
        return stringBuffer2;
    }
}
