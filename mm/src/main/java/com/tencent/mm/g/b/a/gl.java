package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gl extends a {
    private String eBx = "";
    private String eCL = "";
    private long eCM;
    private String eCN = "";
    private long eCO;
    private long enH;
    private String eoC = "";
    private String eoD = "";
    private long ezg;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21835;
    }

    public final gl uf(String str) {
        AppMethodBeat.i(209282);
        this.eoC = x("SessionID", str, true);
        AppMethodBeat.o(209282);
        return this;
    }

    public final gl ug(String str) {
        AppMethodBeat.i(209283);
        this.eCL = x("PageName", str, true);
        AppMethodBeat.o(209283);
        return this;
    }

    public final gl qp(long j2) {
        AppMethodBeat.i(209284);
        this.enH = j2;
        super.bi("StayTimeMs", this.enH);
        AppMethodBeat.o(209284);
        return this;
    }

    public final gl qq(long j2) {
        AppMethodBeat.i(209285);
        this.ezg = j2;
        super.bi("EnterTimeMs", this.ezg);
        AppMethodBeat.o(209285);
        return this;
    }

    public final gl qr(long j2) {
        AppMethodBeat.i(209286);
        this.eCM = j2;
        super.bi("ExitTimeMs", this.eCM);
        AppMethodBeat.o(209286);
        return this;
    }

    public final gl uh(String str) {
        AppMethodBeat.i(209287);
        this.eBx = x("ClickTabContextID", str, true);
        AppMethodBeat.o(209287);
        return this;
    }

    public final gl ui(String str) {
        AppMethodBeat.i(209288);
        this.eCN = x("Sid", str, true);
        AppMethodBeat.o(209288);
        return this;
    }

    public final gl qs(long j2) {
        this.eCO = j2;
        return this;
    }

    public final gl uj(String str) {
        AppMethodBeat.i(209289);
        this.eoD = x("ContextID", str, true);
        AppMethodBeat.o(209289);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209290);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoC);
        stringBuffer.append(",");
        stringBuffer.append(this.eCL);
        stringBuffer.append(",");
        stringBuffer.append(this.enH);
        stringBuffer.append(",");
        stringBuffer.append(this.ezg);
        stringBuffer.append(",");
        stringBuffer.append(this.eCM);
        stringBuffer.append(",");
        stringBuffer.append(this.eBx);
        stringBuffer.append(",");
        stringBuffer.append(this.eCN);
        stringBuffer.append(",");
        stringBuffer.append(this.eCO);
        stringBuffer.append(",");
        stringBuffer.append(this.eoD);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209290);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209291);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionID:").append(this.eoC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PageName:").append(this.eCL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StayTimeMs:").append(this.enH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterTimeMs:").append(this.ezg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExitTimeMs:").append(this.eCM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextID:").append(this.eBx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Sid:").append(this.eCN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("reportType:").append(this.eCO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextID:").append(this.eoD);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209291);
        return stringBuffer2;
    }
}
