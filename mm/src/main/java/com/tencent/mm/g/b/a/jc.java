package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jc extends a {
    public long eLn;
    public long eQu;
    public long ejA;
    public long emN;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21321;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(231496);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.emN);
        stringBuffer.append(",");
        stringBuffer.append(this.eLn);
        stringBuffer.append(",");
        stringBuffer.append(this.eQu);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(231496);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(231497);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MsgSvrId:").append(this.emN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MsgType:").append(this.eLn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BanType:").append(this.eQu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(231497);
        return stringBuffer2;
    }
}
