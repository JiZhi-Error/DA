package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class cb extends a {
    private String eiC = "";
    private long ejW;
    private String erU = "";
    private String erV = "";
    private String euI = "";
    private long euJ;
    private long euK;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20353;
    }

    public final cb kM(String str) {
        AppMethodBeat.i(208947);
        this.euI = x("feedid", str, true);
        AppMethodBeat.o(208947);
        return this;
    }

    public final cb fm(long j2) {
        this.euJ = j2;
        return this;
    }

    public final cb fn(long j2) {
        this.euK = j2;
        return this;
    }

    public final cb fo(long j2) {
        this.ejW = j2;
        return this;
    }

    public final cb kN(String str) {
        AppMethodBeat.i(208948);
        this.erU = x("Sessionid", str, true);
        AppMethodBeat.o(208948);
        return this;
    }

    public final cb kO(String str) {
        AppMethodBeat.i(208949);
        this.erV = x("Contextid", str, true);
        AppMethodBeat.o(208949);
        return this;
    }

    public final cb kP(String str) {
        AppMethodBeat.i(208950);
        this.eiC = x("ClickTabContextid", str, true);
        AppMethodBeat.o(208950);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208951);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.euI);
        stringBuffer.append(",");
        stringBuffer.append(this.euJ);
        stringBuffer.append(",");
        stringBuffer.append(this.euK);
        stringBuffer.append(",");
        stringBuffer.append(this.ejW);
        stringBuffer.append(",");
        stringBuffer.append(this.erU);
        stringBuffer.append(",");
        stringBuffer.append(this.erV);
        stringBuffer.append(",");
        stringBuffer.append(this.eiC);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208951);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208952);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("feedid:").append(this.euI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("mediaType:").append(this.euJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("commentscene:").append(this.euK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action:").append(this.ejW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Sessionid:").append(this.erU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Contextid:").append(this.erV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextid:").append(this.eiC);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208952);
        return stringBuffer2;
    }
}
