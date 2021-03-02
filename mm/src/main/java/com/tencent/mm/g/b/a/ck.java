package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ck extends a {
    private String elt = "";
    private String evU = "";
    private String evV = "";
    private String evW = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21140;
    }

    public final ck mb(String str) {
        AppMethodBeat.i(209016);
        this.elt = x("contextid", str, true);
        AppMethodBeat.o(209016);
        return this;
    }

    public final ck mc(String str) {
        AppMethodBeat.i(209017);
        this.evU = x("ReportExtraInfo", str, true);
        AppMethodBeat.o(209017);
        return this;
    }

    public final ck md(String str) {
        AppMethodBeat.i(209018);
        this.evV = x("EnterSourceFeedid", str, true);
        AppMethodBeat.o(209018);
        return this;
    }

    public final ck me(String str) {
        AppMethodBeat.i(209019);
        this.evW = x("EnterSourceUsername", str, true);
        AppMethodBeat.o(209019);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209020);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.elt);
        stringBuffer.append(",");
        stringBuffer.append(this.evU);
        stringBuffer.append(",");
        stringBuffer.append(this.evV);
        stringBuffer.append(",");
        stringBuffer.append(this.evW);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209020);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209021);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("contextid:").append(this.elt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ReportExtraInfo:").append(this.evU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterSourceFeedid:").append(this.evV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterSourceUsername:").append(this.evW);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209021);
        return stringBuffer2;
    }
}
