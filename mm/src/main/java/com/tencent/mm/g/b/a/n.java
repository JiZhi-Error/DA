package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class n extends a {
    private String ekB = "";
    public long ekC;
    public long ekD;
    public long ekE;
    private String ekF = "";
    private String ekG = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21804;
    }

    public final n hR(String str) {
        AppMethodBeat.i(226037);
        this.ekB = x("appId", str, true);
        AppMethodBeat.o(226037);
        return this;
    }

    public final n hS(String str) {
        AppMethodBeat.i(226038);
        this.ekF = x("flags", str, true);
        AppMethodBeat.o(226038);
        return this;
    }

    public final n hT(String str) {
        AppMethodBeat.i(226039);
        this.ekG = x("sessionId", str, true);
        AppMethodBeat.o(226039);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(226040);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ekB);
        stringBuffer.append(",");
        stringBuffer.append(this.ekC);
        stringBuffer.append(",");
        stringBuffer.append(this.ekD);
        stringBuffer.append(",");
        stringBuffer.append(this.ekE);
        stringBuffer.append(",");
        stringBuffer.append(this.ekF);
        stringBuffer.append(",");
        stringBuffer.append(this.ekG);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(226040);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(226041);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appId:").append(this.ekB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appType:").append(this.ekC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("aliveTime:").append(this.ekD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("reason:").append(this.ekE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("flags:").append(this.ekF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionId:").append(this.ekG);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(226041);
        return stringBuffer2;
    }
}
