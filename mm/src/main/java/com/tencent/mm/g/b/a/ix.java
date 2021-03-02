package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ix extends a {
    public long eIW = 0;
    public long eQf = 0;
    public String eQj = "";
    public String emL = "";
    public long esI = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18258;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(110284);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.emL);
        stringBuffer.append(",");
        stringBuffer.append(this.eQf);
        stringBuffer.append(",");
        stringBuffer.append(this.esI);
        stringBuffer.append(",");
        stringBuffer.append(this.eIW);
        stringBuffer.append(",");
        stringBuffer.append(this.eQj);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(110284);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(110285);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ChatName:").append(this.emL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionID:").append(this.eQf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickType:").append(this.esI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceType:").append(this.eIW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Identifier:").append(this.eQj);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(110285);
        return stringBuffer2;
    }
}
