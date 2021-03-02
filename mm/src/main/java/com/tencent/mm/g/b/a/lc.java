package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class lc extends a {
    private String eXK = "";
    public long eXL = 0;
    public long ejA = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18262;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(149944);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.eXK);
        stringBuffer.append(",");
        stringBuffer.append(this.eXL);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(149944);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(149945);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ReqKey:").append(this.eXK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterSettingScene:").append(this.eXL);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(149945);
        return stringBuffer2;
    }
}
