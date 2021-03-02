package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class er extends a {
    public long eEp = 0;
    public long eEq = 0;
    public String eqv = "";
    public long erW = 0;
    public long esI = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 12639;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(184550);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eqv);
        stringBuffer.append(",");
        stringBuffer.append(this.eEp);
        stringBuffer.append(",");
        stringBuffer.append(this.esI);
        stringBuffer.append(",");
        stringBuffer.append(this.eEq);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(184550);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(184551);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Query:").append(this.eqv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasWebSearchEntryShown:").append(this.eEp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickType:").append(this.esI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Style:").append(this.eEq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(184551);
        return stringBuffer2;
    }
}
