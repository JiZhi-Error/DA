package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class hc extends a {
    private long eBF;
    private long eBn;
    private String eBo = "";
    private String eBp = "";
    private long eBr;
    private String eBu = "";
    private long eLr;
    private long eLs;
    private String eLt = "";
    private String eLu = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20951;
    }

    public final hc qI(long j2) {
        this.eBn = j2;
        return this;
    }

    public final hc qJ(long j2) {
        this.eBr = j2;
        return this;
    }

    public final hc qK(long j2) {
        this.eLr = j2;
        return this;
    }

    public final hc uQ(String str) {
        AppMethodBeat.i(209307);
        this.eBo = x("RedDotTipsID", str, true);
        AppMethodBeat.o(209307);
        return this;
    }

    public final hc uR(String str) {
        AppMethodBeat.i(209308);
        this.eBp = x("RedDotShowInfoPath", str, true);
        AppMethodBeat.o(209308);
        return this;
    }

    public final hc qL(long j2) {
        this.eLs = j2;
        return this;
    }

    public final hc uS(String str) {
        AppMethodBeat.i(209309);
        this.eLt = x("WhiteListReddotList", str, true);
        AppMethodBeat.o(209309);
        return this;
    }

    public final hc uT(String str) {
        AppMethodBeat.i(209310);
        this.eLu = x("OverwriteRedDotTipsID", str, true);
        AppMethodBeat.o(209310);
        return this;
    }

    public final hc qM(long j2) {
        this.eBF = j2;
        return this;
    }

    public final hc uU(String str) {
        AppMethodBeat.i(209311);
        this.eBu = x("RedDotShowInfoExt", str, true);
        AppMethodBeat.o(209311);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209312);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eBn);
        stringBuffer.append(",");
        stringBuffer.append(this.eBr);
        stringBuffer.append(",");
        stringBuffer.append(this.eLr);
        stringBuffer.append(",");
        stringBuffer.append(this.eBo);
        stringBuffer.append(",");
        stringBuffer.append(this.eBp);
        stringBuffer.append(",");
        stringBuffer.append(this.eLs);
        stringBuffer.append(",");
        stringBuffer.append(this.eLt);
        stringBuffer.append(",");
        stringBuffer.append(this.eLu);
        stringBuffer.append(",");
        stringBuffer.append(this.eBF);
        stringBuffer.append(",");
        stringBuffer.append(this.eBu);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209312);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209313);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RedDotCtrlType:").append(this.eBn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotShowInfoType:").append(this.eBr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RevokeState:").append(this.eLr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotTipsID:").append(this.eBo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotShowInfoPath:").append(this.eBp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RevokeType:").append(this.eLs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WhiteListReddotList:").append(this.eLt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OverwriteRedDotTipsID:").append(this.eLu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotactiontimestamp:").append(this.eBF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDotShowInfoExt:").append(this.eBu);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209313);
        return stringBuffer2;
    }
}
