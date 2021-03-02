package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class am extends a {
    public long eoH;
    public long eoI;
    public long eoJ = 0;
    public String eoK = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20134;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(224146);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoH);
        stringBuffer.append(",");
        stringBuffer.append(this.eoI);
        stringBuffer.append(",");
        stringBuffer.append(this.eoJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eoK);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(224146);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(224147);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ClickMethod:").append(this.eoH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UnreadNum:").append(this.eoI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("JumpToChatType:").append(this.eoJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UserName:").append(this.eoK);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(224147);
        return stringBuffer2;
    }
}
