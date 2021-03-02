package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ev extends a {
    public String eEA = "";
    public long eEv;
    public long eEw = 0;
    public long eEx = 0;
    public long eEy = 0;
    public String eEz = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19451;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(194514);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eEv);
        stringBuffer.append(",");
        stringBuffer.append(this.eEw);
        stringBuffer.append(",");
        stringBuffer.append(this.eEx);
        stringBuffer.append(",");
        stringBuffer.append(this.eEy);
        stringBuffer.append(",");
        stringBuffer.append(this.eEz);
        stringBuffer.append(",");
        stringBuffer.append(this.eEA);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(194514);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(194515);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RecomdSuccess:").append(this.eEv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RecomdFail:").append(this.eEw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("otherSuccess:").append(this.eEx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("otherFail:").append(this.eEy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sucRoomList:").append(this.eEz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ticketId:").append(this.eEA);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(194515);
        return stringBuffer2;
    }
}
