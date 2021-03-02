package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class kv extends a {
    public long eXx = 0;
    public long esA = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 17573;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(91241);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.esA);
        stringBuffer.append(",");
        stringBuffer.append(this.eXx);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(91241);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(91242);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("clickScene:").append(this.esA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("switchWay:").append(this.eXx);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(91242);
        return stringBuffer2;
    }
}
