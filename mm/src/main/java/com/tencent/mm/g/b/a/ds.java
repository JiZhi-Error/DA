package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ds extends a {
    private long eBj;
    private long eBk;
    private String eBl = "";
    private long eBm;
    private String ejo = "";
    private long eyO;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20223;
    }

    public final ds kw(long j2) {
        this.eBj = j2;
        return this;
    }

    public final ds pG(String str) {
        AppMethodBeat.i(209167);
        this.ejo = x("TipsId", str, true);
        AppMethodBeat.o(209167);
        return this;
    }

    public final ds kx(long j2) {
        this.eBk = j2;
        return this;
    }

    public final ds ky(long j2) {
        this.eyO = j2;
        return this;
    }

    public final ds pH(String str) {
        AppMethodBeat.i(209168);
        this.eBl = x("RevokeId", str, true);
        AppMethodBeat.o(209168);
        return this;
    }

    public final ds kz(long j2) {
        this.eBm = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209169);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eBj);
        stringBuffer.append(",");
        stringBuffer.append(this.ejo);
        stringBuffer.append(",");
        stringBuffer.append(this.eBk);
        stringBuffer.append(",");
        stringBuffer.append(this.eyO);
        stringBuffer.append(",");
        stringBuffer.append(this.eBl);
        stringBuffer.append(",");
        stringBuffer.append(this.eBm);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209169);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209170);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CtrType:").append(this.eBj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TipsId:").append(this.ejo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RecallTime:").append(this.eBk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TabType:").append(this.eyO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RevokeId:").append(this.eBl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RevokeStatus:").append(this.eBm);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209170);
        return stringBuffer2;
    }
}
