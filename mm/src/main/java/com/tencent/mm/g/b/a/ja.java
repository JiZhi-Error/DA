package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ja extends a {
    public long eQf = 0;
    public String eQj = "";
    public long eQs = 0;
    public long eQt = 0;
    public String emL = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19964;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(194416);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.emL);
        stringBuffer.append(",");
        stringBuffer.append(this.eQf);
        stringBuffer.append(",");
        stringBuffer.append(this.eQj);
        stringBuffer.append(",");
        stringBuffer.append(this.eQs);
        stringBuffer.append(",");
        stringBuffer.append(this.eQt);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(194416);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(194417);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ChatName:").append(this.emL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionID:").append(this.eQf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Identifier:").append(this.eQj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DisplayCount:").append(this.eQs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HideCount:").append(this.eQt);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(194417);
        return stringBuffer2;
    }
}
