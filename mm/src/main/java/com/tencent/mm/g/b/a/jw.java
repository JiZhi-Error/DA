package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jw extends a {
    public long eSN = 0;
    public String eSO = "";
    public String eSP = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15493;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(19868);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eSN);
        stringBuffer.append(",");
        stringBuffer.append(this.eSO);
        stringBuffer.append(",");
        stringBuffer.append(this.eSP);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(19868);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(19869);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("LogType:").append(this.eSN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WechatLanguage:").append(this.eSO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("InputLanguage:").append(this.eSP);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(19869);
        return stringBuffer2;
    }
}
