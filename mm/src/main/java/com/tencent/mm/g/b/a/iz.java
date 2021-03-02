package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class iz extends a {
    public long eQf = 0;
    private String eQj = "";
    public long eQr = 0;
    private String emL = "";
    public long etp = 0;
    public long ewL = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18256;
    }

    public final iz wA(String str) {
        AppMethodBeat.i(110291);
        this.emL = x("ChatName", str, true);
        AppMethodBeat.o(110291);
        return this;
    }

    public final iz wB(String str) {
        AppMethodBeat.i(110292);
        this.eQj = x("Identifier", str, true);
        AppMethodBeat.o(110292);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(110293);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.emL);
        stringBuffer.append(",");
        stringBuffer.append(this.eQf);
        stringBuffer.append(",");
        stringBuffer.append(this.etp);
        stringBuffer.append(",");
        stringBuffer.append(this.ewL);
        stringBuffer.append(",");
        stringBuffer.append(this.eQr);
        stringBuffer.append(",");
        stringBuffer.append(this.eQj);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(110293);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(110294);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ChatName:").append(this.emL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionID:").append(this.eQf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterScene:").append(this.etp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExitType:").append(this.ewL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OperateType:").append(this.eQr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Identifier:").append(this.eQj);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(110294);
        return stringBuffer2;
    }
}
