package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class nk extends a {
    private long eCQ = 0;
    private long eDV = 0;
    private long fgB;
    public long fgC = 0;
    public long fgD = 0;
    private String fgE = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18337;
    }

    public final nk Az(String str) {
        AppMethodBeat.i(94858);
        this.fgE = x("OpenimUsername", str, true);
        AppMethodBeat.o(94858);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(94859);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.fgB);
        stringBuffer.append(",");
        stringBuffer.append(this.fgC);
        stringBuffer.append(",");
        stringBuffer.append(this.fgD);
        stringBuffer.append(",");
        stringBuffer.append(this.eDV);
        stringBuffer.append(",");
        stringBuffer.append(this.eCQ);
        stringBuffer.append(",");
        stringBuffer.append(this.fgE);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(94859);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(94860);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OpenimUin:").append(this.fgB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OptionType:").append(this.fgC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OptionResult:").append(this.fgD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Source:").append(this.eDV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickAction:").append(this.eCQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OpenimUsername:").append(this.fgE);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(94860);
        return stringBuffer2;
    }
}
