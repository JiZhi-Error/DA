package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ia extends a {
    public long eMJ;
    public int eMK;
    public int eML;
    public int eMM;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18617;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(19866);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eMJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eMK);
        stringBuffer.append(",");
        stringBuffer.append(this.eML);
        stringBuffer.append(",");
        stringBuffer.append(this.eMM);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(19866);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(19867);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("msgId:").append(this.eMJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("selectLen:").append(this.eMK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("totalLen:").append(this.eML);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clipLen:").append(this.eMM);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(19867);
        return stringBuffer2;
    }
}
