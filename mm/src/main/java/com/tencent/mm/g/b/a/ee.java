package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ee extends a {
    public int eCB;
    public int eCC;
    public String ejo = "";
    public String ejr = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21611;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(241581);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ejo);
        stringBuffer.append(",");
        stringBuffer.append(this.eCB);
        stringBuffer.append(",");
        stringBuffer.append(this.eCC);
        stringBuffer.append(",");
        stringBuffer.append(this.ejr);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(241581);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(241582);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TipsId:").append(this.ejo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderSyncScene:").append(this.eCB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CmdId:").append(this.eCC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CtrlType:").append(this.ejr);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(241582);
        return stringBuffer2;
    }
}
