package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ht extends a {
    private String eBX = "";
    public long eMr;
    public long eMs = -1;
    public long eMt = -1;
    public String epf = "";
    public long erY;
    public long esJ;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21746;
    }

    public final ht vw(String str) {
        AppMethodBeat.i(201828);
        this.eBX = x("MonmentSessionId", str, true);
        AppMethodBeat.o(201828);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(201829);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erY);
        stringBuffer.append(",");
        stringBuffer.append(this.epf);
        stringBuffer.append(",");
        stringBuffer.append(this.esJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eBX);
        stringBuffer.append(",");
        stringBuffer.append(this.eMr);
        stringBuffer.append(",");
        stringBuffer.append(this.eMs);
        stringBuffer.append(",");
        stringBuffer.append(this.eMt);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(201829);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(201830);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Type:").append(this.erY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Publishid:").append(this.epf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Outcome:").append(this.esJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MonmentSessionId:").append(this.eBX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("templateType:").append(this.eMr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsThumbExit:").append(this.eMs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsThumbBlack:").append(this.eMt);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(201830);
        return stringBuffer2;
    }
}
