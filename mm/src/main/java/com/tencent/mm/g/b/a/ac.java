package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ac extends a {
    public String enA = "";
    public String enB = "";
    public int enC = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15459;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(121744);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enA);
        stringBuffer.append(",");
        stringBuffer.append(this.enB);
        stringBuffer.append(",");
        stringBuffer.append(this.enC);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(121744);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(121745);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ChatroomName:").append(this.enA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExptScore:").append(this.enB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExptFlag:").append(this.enC);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(121745);
        return stringBuffer2;
    }
}
