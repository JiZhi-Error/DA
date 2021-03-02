package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ci extends a {
    private String eiC = "";
    private long ejW;
    private String erU = "";
    private String erV = "";
    private long erW;
    private long evr;
    private long evs;
    private long evt;
    private long evu;
    private long evv;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19998;
    }

    public final ci fT(long j2) {
        this.erW = j2;
        return this;
    }

    public final ci lL(String str) {
        AppMethodBeat.i(209003);
        this.erU = x("Sessionid", str, true);
        AppMethodBeat.o(209003);
        return this;
    }

    public final ci lM(String str) {
        AppMethodBeat.i(209004);
        this.erV = x("Contextid", str, true);
        AppMethodBeat.o(209004);
        return this;
    }

    public final ci lN(String str) {
        AppMethodBeat.i(209005);
        this.eiC = x("ClickTabContextid", str, true);
        AppMethodBeat.o(209005);
        return this;
    }

    public final ci fU(long j2) {
        this.ejW = j2;
        return this;
    }

    public final ci fV(long j2) {
        this.evr = j2;
        return this;
    }

    public final ci fW(long j2) {
        this.evs = j2;
        return this;
    }

    public final ci fX(long j2) {
        this.evt = j2;
        return this;
    }

    public final ci adf() {
        this.evv = 1;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209006);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.erU);
        stringBuffer.append(",");
        stringBuffer.append(this.erV);
        stringBuffer.append(",");
        stringBuffer.append(this.eiC);
        stringBuffer.append(",");
        stringBuffer.append(this.ejW);
        stringBuffer.append(",");
        stringBuffer.append(this.evr);
        stringBuffer.append(",");
        stringBuffer.append(this.evs);
        stringBuffer.append(",");
        stringBuffer.append(this.evt);
        stringBuffer.append(",");
        stringBuffer.append(this.evu);
        stringBuffer.append(",");
        stringBuffer.append(this.evv);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209006);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209007);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Sessionid:").append(this.erU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Contextid:").append(this.erV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextid:").append(this.eiC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action:").append(this.ejW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionTimeStamp:").append(this.evr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("messageType:").append(this.evs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("feedIndex:").append(this.evt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isfloat:").append(this.evu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("innerVersion:").append(this.evv);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209007);
        return stringBuffer2;
    }
}
