package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ns extends a {
    public int eqm = 0;
    private String fir = "";
    private String fit = "";
    private String fiu = "";
    public int fiv;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19376;
    }

    public final ns AQ(String str) {
        AppMethodBeat.i(184121);
        this.fir = x("oldaccountusername", str, true);
        AppMethodBeat.o(184121);
        return this;
    }

    public final ns AR(String str) {
        AppMethodBeat.i(184122);
        this.fit = x("newaccountusername", str, true);
        AppMethodBeat.o(184122);
        return this;
    }

    public final ns AS(String str) {
        AppMethodBeat.i(184123);
        this.fiu = x("friendusername", str, true);
        AppMethodBeat.o(184123);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(184124);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eqm);
        stringBuffer.append(",");
        stringBuffer.append(this.fir);
        stringBuffer.append(",");
        stringBuffer.append(this.fit);
        stringBuffer.append(",");
        stringBuffer.append(this.fiu);
        stringBuffer.append(",");
        stringBuffer.append(this.fiv);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(184124);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(184125);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("action:").append(this.eqm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("oldaccountusername:").append(this.fir);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("newaccountusername:").append(this.fit);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("friendusername:").append(this.fiu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("errortype:").append(this.fiv);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(184125);
        return stringBuffer2;
    }
}
