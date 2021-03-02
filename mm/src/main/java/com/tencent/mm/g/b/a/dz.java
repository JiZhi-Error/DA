package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class dz extends a {
    public String eBX = "";
    private String eoj = "";
    public String epf = "";
    public long esJ;
    public long evg;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21181;
    }

    public final dz ql(String str) {
        AppMethodBeat.i(201825);
        this.eoj = x("Feedid", str, true);
        AppMethodBeat.o(201825);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(201826);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.evg);
        stringBuffer.append(",");
        stringBuffer.append(this.eoj);
        stringBuffer.append(",");
        stringBuffer.append(this.epf);
        stringBuffer.append(",");
        stringBuffer.append(this.esJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eBX);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(201826);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(201827);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ForwardType:").append(this.evg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Feedid:").append(this.eoj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Publishid:").append(this.epf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Outcome:").append(this.esJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MonmentSessionId:").append(this.eBX);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(201827);
        return stringBuffer2;
    }
}
