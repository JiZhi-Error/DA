package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class nw extends a {
    public int eRI;
    public int eki;
    public long exh;
    public String fiF = "";
    public String fiG = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19822;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(186337);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.exh);
        stringBuffer.append(",");
        stringBuffer.append(this.fiF);
        stringBuffer.append(",");
        stringBuffer.append(this.fiG);
        stringBuffer.append(",");
        stringBuffer.append(this.eki);
        stringBuffer.append(",");
        stringBuffer.append(this.eRI);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(186337);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(186338);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.exh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RegisterMobile:").append(this.fiF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DeviceID:").append(this.fiG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.eki);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Result:").append(this.eRI);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(186338);
        return stringBuffer2;
    }
}
