package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gg extends a {
    private long eDd;
    private long eJn;
    private long eJo;
    private String eJp = "";
    private long eJq;
    private long ejA;
    private String eoz = "";
    private String evo = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21922;
    }

    public final gg tM(String str) {
        AppMethodBeat.i(200244);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(200244);
        return this;
    }

    public final gg pX(long j2) {
        this.eJn = j2;
        return this;
    }

    public final gg tN(String str) {
        AppMethodBeat.i(200245);
        this.evo = x("ItemId", str, true);
        AppMethodBeat.o(200245);
        return this;
    }

    public final gg pY(long j2) {
        this.eDd = j2;
        return this;
    }

    public final gg pZ(long j2) {
        this.eJo = j2;
        return this;
    }

    public final gg qa(long j2) {
        this.ejA = j2;
        return this;
    }

    public final gg tO(String str) {
        AppMethodBeat.i(200246);
        this.eJp = x("ItemSubId", str, true);
        AppMethodBeat.o(200246);
        return this;
    }

    public final gg qb(long j2) {
        this.eJq = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(200247);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.eJn);
        stringBuffer.append(",");
        stringBuffer.append(this.evo);
        stringBuffer.append(",");
        stringBuffer.append(this.eDd);
        stringBuffer.append(",");
        stringBuffer.append(this.eJo);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.eJp);
        stringBuffer.append(",");
        stringBuffer.append(this.eJq);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(200247);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(200248);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemType:").append(this.eJn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemId:").append(this.evo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Position:").append(this.eDd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposeTimestamp:").append(this.eJo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemSubId:").append(this.eJp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActualExposeTimestamp:").append(this.eJq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(200248);
        return stringBuffer2;
    }
}
