package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public final class a extends com.tencent.mm.plugin.report.a {
    private String eiB = "";
    private String eiC = "";
    private String eiD = "";
    private long eiE;
    private long eiF;
    private String eiG = "";
    private long eiH;
    private String eiI = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21851;
    }

    public final a hA(String str) {
        AppMethodBeat.i(208814);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(208814);
        return this;
    }

    public final a hB(String str) {
        AppMethodBeat.i(208815);
        this.eiC = x("ClickTabContextid", str, true);
        AppMethodBeat.o(208815);
        return this;
    }

    public final a hC(String str) {
        AppMethodBeat.i(208816);
        this.eiD = x("FinderContexId", str, true);
        AppMethodBeat.o(208816);
        return this;
    }

    public final a bD(long j2) {
        this.eiE = j2;
        return this;
    }

    public final a bE(long j2) {
        this.eiF = j2;
        return this;
    }

    public final a hD(String str) {
        AppMethodBeat.i(208817);
        this.eiG = x("EventTime", str, true);
        AppMethodBeat.o(208817);
        return this;
    }

    public final a abU() {
        this.eiH = 1;
        return this;
    }

    public final a hE(String str) {
        AppMethodBeat.i(208818);
        this.eiI = x("ActivityId", str, true);
        AppMethodBeat.o(208818);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208819);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eiC);
        stringBuffer.append(",");
        stringBuffer.append(this.eiD);
        stringBuffer.append(",");
        stringBuffer.append(this.eiE);
        stringBuffer.append(",");
        stringBuffer.append(this.eiF);
        stringBuffer.append(",");
        stringBuffer.append(this.eiG);
        stringBuffer.append(",");
        stringBuffer.append(this.eiH);
        stringBuffer.append(",");
        stringBuffer.append(this.eiI);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208819);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208820);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextid:").append(this.eiC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderContexId:").append(this.eiD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("commentScene:").append(this.eiE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EventCode:").append(this.eiF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EventTime:").append(this.eiG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EventTarget:").append(this.eiH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActivityId:").append(this.eiI);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208820);
        return stringBuffer2;
    }
}
