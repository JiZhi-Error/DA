package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fa extends a {
    public long eEP;
    public long eEQ;
    public long eER;
    public long eES;
    public long eET;
    public String emL = "";
    public long etp = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21169;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(231475);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.etp);
        stringBuffer.append(",");
        stringBuffer.append(this.emL);
        stringBuffer.append(",");
        stringBuffer.append(this.eEP);
        stringBuffer.append(",");
        stringBuffer.append(this.eEQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eER);
        stringBuffer.append(",");
        stringBuffer.append(this.eES);
        stringBuffer.append(",");
        stringBuffer.append(this.eET);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(231475);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(231476);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EnterScene:").append(this.etp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChatName:").append(this.emL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterTimeStamp:").append(this.eEP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExitTimeStamp:").append(this.eEQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterChatType:").append(this.eER);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExitChatType:").append(this.eES);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExitHiddenStatus:").append(this.eET);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(231476);
        return stringBuffer2;
    }
}
