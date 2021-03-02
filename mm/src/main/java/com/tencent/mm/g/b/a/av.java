package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class av extends a {
    public long eqk;
    public String eqv = "";
    public long eqw;
    public String eqx = "";
    public long eqy;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22251;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(210794);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eqv);
        stringBuffer.append(",");
        stringBuffer.append(this.eqk);
        stringBuffer.append(",");
        stringBuffer.append(this.eqw);
        stringBuffer.append(",");
        stringBuffer.append(this.eqx);
        stringBuffer.append(",");
        stringBuffer.append(this.eqy);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(210794);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(210795);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Query:").append(this.eqv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterTime:").append(this.eqk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StayTime:").append(this.eqw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("InitUrl:").append(this.eqx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PageCnt:").append(this.eqy);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(210795);
        return stringBuffer2;
    }
}
