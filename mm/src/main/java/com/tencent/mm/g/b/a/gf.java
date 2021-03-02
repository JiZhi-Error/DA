package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gf extends a {
    public String eJg = "";
    public long eJh = 0;
    public long eJi = 2;
    public long eJj = 0;
    public String eJk = "";
    public long eJl;
    public String eJm = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20559;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(187891);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eJg);
        stringBuffer.append(",");
        stringBuffer.append(this.eJh);
        stringBuffer.append(",");
        stringBuffer.append(this.eJi);
        stringBuffer.append(",");
        stringBuffer.append(this.eJj);
        stringBuffer.append(",");
        stringBuffer.append(this.eJk);
        stringBuffer.append(",");
        stringBuffer.append(this.eJl);
        stringBuffer.append(",");
        stringBuffer.append(this.eJm);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(187891);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(187892);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("HasConfirmed:").append(this.eJg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Oper:").append(this.eJh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasSideNote:").append(this.eJi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinalShareCount:").append(this.eJj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinalShareCountByType:").append(this.eJk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ForwardScene:").append(this.eJl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ToUsername:").append(this.eJm);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(187892);
        return stringBuffer2;
    }
}
