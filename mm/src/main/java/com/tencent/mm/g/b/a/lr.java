package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class lr extends a {
    private String eWa = "";
    public long eZp = 0;
    public long eZr = 0;
    public long eZs = 0;
    public long eZt = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15402;
    }

    public final lr yZ(String str) {
        AppMethodBeat.i(43480);
        this.eWa = x("Appid", str, true);
        AppMethodBeat.o(43480);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(43481);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eZr);
        stringBuffer.append(",");
        stringBuffer.append(this.eWa);
        stringBuffer.append(",");
        stringBuffer.append(this.eZs);
        stringBuffer.append(",");
        stringBuffer.append(this.eZt);
        stringBuffer.append(",");
        stringBuffer.append(this.eZp);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43481);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43482);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DeleteReason:").append(this.eZr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Appid:").append(this.eWa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DebugType:").append(this.eZs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DeleteCount:").append(this.eZt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AbtestStatus:").append(this.eZp);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43482);
        return stringBuffer2;
    }
}
