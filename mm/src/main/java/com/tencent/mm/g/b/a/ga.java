package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ga extends a {
    public long eHz;
    public long eIq;
    public long eIr = 0;
    public long ejA;
    public long erW;
    public long erY = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18712;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(19864);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.eIq);
        stringBuffer.append(",");
        stringBuffer.append(this.eHz);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.eIr);
        stringBuffer.append(",");
        stringBuffer.append(this.erY);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(19864);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(19865);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SelfSendMsg:").append(this.eIq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MsgId:").append(this.eHz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CopyLen:").append(this.eIr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Type:").append(this.erY);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(19865);
        return stringBuffer2;
    }
}
