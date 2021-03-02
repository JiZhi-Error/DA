package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ca extends a {
    public String ekG = "";
    public String euA = "";
    public int euB;
    public int euC;
    public int euD;
    public int euE;
    private String euF = "";
    public String euG = "";
    public String euH = "";
    public int euv;
    public String euw = "";
    public long eux;
    public long euy;
    public long euz;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18260;
    }

    public final ca kI(String str) {
        AppMethodBeat.i(169249);
        this.euw = x("PName", str, true);
        AppMethodBeat.o(169249);
        return this;
    }

    public final ca kJ(String str) {
        AppMethodBeat.i(169250);
        this.ekG = x("sessionId", str, true);
        AppMethodBeat.o(169250);
        return this;
    }

    public final ca kK(String str) {
        AppMethodBeat.i(169251);
        this.euG = x("SessionPageId", str, true);
        AppMethodBeat.o(169251);
        return this;
    }

    public final ca kL(String str) {
        AppMethodBeat.i(169252);
        this.euH = x("SessionKey", str, true);
        AppMethodBeat.o(169252);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(169253);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.euv);
        stringBuffer.append(",");
        stringBuffer.append(this.euw);
        stringBuffer.append(",");
        stringBuffer.append(this.ekG);
        stringBuffer.append(",");
        stringBuffer.append(this.eux);
        stringBuffer.append(",");
        stringBuffer.append(this.euy);
        stringBuffer.append(",");
        stringBuffer.append(this.euz);
        stringBuffer.append(",");
        stringBuffer.append(this.euA);
        stringBuffer.append(",");
        stringBuffer.append(this.euB);
        stringBuffer.append(",");
        stringBuffer.append(this.euC);
        stringBuffer.append(",");
        stringBuffer.append(this.euD);
        stringBuffer.append(",");
        stringBuffer.append(this.euE);
        stringBuffer.append(",");
        stringBuffer.append(this.euF);
        stringBuffer.append(",");
        stringBuffer.append(this.euG);
        stringBuffer.append(",");
        stringBuffer.append(this.euH);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(169253);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(169254);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PID:").append(this.euv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PName:").append(this.euw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionId:").append(this.ekG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("frontTime:").append(this.eux);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("stayTotalTime:").append(this.euy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scrollTotalTime:").append(this.euz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("reportFeedList:").append(this.euA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("reportFeedCount:").append(this.euB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Seq:").append(this.euC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SubSeq:").append(this.euD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SubSeqSum:").append(this.euE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Performance:").append(this.euF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionPageId:").append(this.euG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionKey:").append(this.euH);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(169254);
        return stringBuffer2;
    }
}
