package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bc extends a {
    private String eiB = "";
    private String eiC = "";
    private String eiD = "";
    private long eiE;
    private long eiH;
    private String eiI = "";
    private long erA;
    private String erB = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21206;
    }

    public final bc dd(long j2) {
        this.erA = j2;
        return this;
    }

    public final bc iL(String str) {
        AppMethodBeat.i(208847);
        this.erB = x("Action", str, true);
        AppMethodBeat.o(208847);
        return this;
    }

    public final bc iM(String str) {
        AppMethodBeat.i(208848);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(208848);
        return this;
    }

    public final bc iN(String str) {
        AppMethodBeat.i(208849);
        this.eiC = x("ClickTabContextid", str, true);
        AppMethodBeat.o(208849);
        return this;
    }

    public final bc iO(String str) {
        AppMethodBeat.i(208850);
        this.eiD = x("FinderContexId", str, true);
        AppMethodBeat.o(208850);
        return this;
    }

    public final bc de(long j2) {
        this.eiE = j2;
        return this;
    }

    public final bc df(long j2) {
        this.eiH = j2;
        return this;
    }

    public final bc iP(String str) {
        AppMethodBeat.i(208851);
        this.eiI = x("ActivityId", str, true);
        AppMethodBeat.o(208851);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208852);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erA);
        stringBuffer.append(",");
        stringBuffer.append(this.erB);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eiC);
        stringBuffer.append(",");
        stringBuffer.append(this.eiD);
        stringBuffer.append(",");
        stringBuffer.append(this.eiE);
        stringBuffer.append(",");
        stringBuffer.append(this.eiH);
        stringBuffer.append(",");
        stringBuffer.append(this.eiI);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208852);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208853);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("IfSelf:").append(this.erA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.erB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextid:").append(this.eiC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderContexId:").append(this.eiD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("commentScene:").append(this.eiE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EventTarget:").append(this.eiH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActivityId:").append(this.eiI);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208853);
        return stringBuffer2;
    }
}
