package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ew extends a {
    public long eEB;
    public long eEC = 0;
    public long eED = 0;
    public long eEE = 0;
    private String eEF = "";
    public long eEG;
    public long ewL;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19450;
    }

    public final ew rT(String str) {
        AppMethodBeat.i(194516);
        this.eEF = x("TicketId", str, true);
        AppMethodBeat.o(194516);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(194517);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eEB);
        stringBuffer.append(",");
        stringBuffer.append(this.eEC);
        stringBuffer.append(",");
        stringBuffer.append(this.eED);
        stringBuffer.append(",");
        stringBuffer.append(this.eEE);
        stringBuffer.append(",");
        stringBuffer.append(this.ewL);
        stringBuffer.append(",");
        stringBuffer.append(this.eEF);
        stringBuffer.append(",");
        stringBuffer.append(this.eEG);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(194517);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(194518);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RecomdCount:").append(this.eEB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickMore:").append(this.eEC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RecomdSelect:").append(this.eED);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OtherSelect:").append(this.eEE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExitType:").append(this.ewL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TicketId:").append(this.eEF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OtherCount:").append(this.eEG);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(194518);
        return stringBuffer2;
    }
}
