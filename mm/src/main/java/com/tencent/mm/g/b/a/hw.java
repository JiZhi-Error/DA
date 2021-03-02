package com.tencent.mm.g.b.a;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class hw extends a {
    private String eBQ = "";
    public long eMC = 0;
    private String eMD = "";
    private String eME = "";
    private String ekG = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15960;
    }

    public final hw vB(String str) {
        AppMethodBeat.i(116486);
        this.eBQ = x(SearchIntents.EXTRA_QUERY, str, true);
        AppMethodBeat.o(116486);
        return this;
    }

    public final hw vC(String str) {
        AppMethodBeat.i(116487);
        this.ekG = x("sessionId", str, true);
        AppMethodBeat.o(116487);
        return this;
    }

    public final hw vD(String str) {
        AppMethodBeat.i(116488);
        this.eMD = x("appidBefore", str, true);
        AppMethodBeat.o(116488);
        return this;
    }

    public final hw vE(String str) {
        AppMethodBeat.i(116489);
        this.eME = x("appidAfter", str, true);
        AppMethodBeat.o(116489);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(116490);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eBQ);
        stringBuffer.append(",");
        stringBuffer.append(this.ekG);
        stringBuffer.append(",");
        stringBuffer.append(this.eMC);
        stringBuffer.append(",");
        stringBuffer.append(this.eMD);
        stringBuffer.append(",");
        stringBuffer.append(this.eME);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(116490);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(116491);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("query:").append(this.eBQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionId:").append(this.ekG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isChange:").append(this.eMC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appidBefore:").append(this.eMD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appidAfter:").append(this.eME);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(116491);
        return stringBuffer2;
    }
}
