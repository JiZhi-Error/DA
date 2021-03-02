package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ko extends a {
    private String eWA = "";
    public long eWB;
    public long eWq;
    public long eWr;
    public long eWs;
    public long eWt;
    public String eWu = "";
    public String eWv = "";
    public long eWw;
    private String eWx = "";
    private String eWy = "";
    private String eWz = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18094;
    }

    public final ko xW(String str) {
        AppMethodBeat.i(43450);
        this.eWx = x("AppidFrom1And5", str, true);
        AppMethodBeat.o(43450);
        return this;
    }

    public final ko xX(String str) {
        AppMethodBeat.i(43451);
        this.eWy = x("AppidFrom6And10", str, true);
        AppMethodBeat.o(43451);
        return this;
    }

    public final ko xY(String str) {
        AppMethodBeat.i(43452);
        this.eWz = x("AppidFrom11And15", str, true);
        AppMethodBeat.o(43452);
        return this;
    }

    public final ko xZ(String str) {
        AppMethodBeat.i(43453);
        this.eWA = x("AppidFrom16And20", str, true);
        AppMethodBeat.o(43453);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(43454);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWq);
        stringBuffer.append(",");
        stringBuffer.append(this.eWr);
        stringBuffer.append(",");
        stringBuffer.append(this.eWs);
        stringBuffer.append(",");
        stringBuffer.append(this.eWt);
        stringBuffer.append(",");
        stringBuffer.append(this.eWu);
        stringBuffer.append(",");
        stringBuffer.append(this.eWv);
        stringBuffer.append(",");
        stringBuffer.append(this.eWw);
        stringBuffer.append(",");
        stringBuffer.append(this.eWx);
        stringBuffer.append(",");
        stringBuffer.append(this.eWy);
        stringBuffer.append(",");
        stringBuffer.append(this.eWz);
        stringBuffer.append(",");
        stringBuffer.append(this.eWA);
        stringBuffer.append(",");
        stringBuffer.append(this.eWB);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43454);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43455);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EnterListTimeStamp:").append(this.eWq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LeaveListTimeStamp:").append(this.eWr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LeaveListType:").append(this.eWs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickAppidIndex:").append(this.eWt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickAppid:").append(this.eWu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickAppidName:").append(this.eWv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickAppidIsStar:").append(this.eWw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppidFrom1And5:").append(this.eWx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppidFrom6And10:").append(this.eWy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppidFrom11And15:").append(this.eWz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppidFrom16And20:").append(this.eWA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("openSession:").append(this.eWB);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43455);
        return stringBuffer2;
    }
}
