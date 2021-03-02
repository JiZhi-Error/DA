package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class hh extends a {
    public long eLA = 0;
    public long eLy;
    public long eLz;
    public long ejW;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18754;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(88783);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ejW);
        stringBuffer.append(",");
        stringBuffer.append(this.eLy);
        stringBuffer.append(",");
        stringBuffer.append(this.eLz);
        stringBuffer.append(",");
        stringBuffer.append(this.eLA);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(88783);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(88784);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("action:").append(this.ejW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("msgid:").append(this.eLy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("msgType:").append(this.eLz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appMsgType:").append(this.eLA);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(88784);
        return stringBuffer2;
    }
}
