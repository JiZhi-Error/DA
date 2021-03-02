package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class my extends a {
    private long eJb;
    private String eJx = "";
    private long eYW;
    private String eoK = "";
    private long erW;
    private long fac;
    private long fad;
    private long fae;
    private int ffH;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18866;
    }

    public final my Ag(String str) {
        AppMethodBeat.i(43724);
        this.eoK = x("UserName", str, true);
        AppMethodBeat.o(43724);
        return this;
    }

    public final my Ah(String str) {
        AppMethodBeat.i(43725);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(43725);
        return this;
    }

    public final my xo(long j2) {
        this.eYW = j2;
        return this;
    }

    public final my xp(long j2) {
        AppMethodBeat.i(43726);
        this.fac = j2;
        super.bi("CostTimeMs", this.fac);
        AppMethodBeat.o(43726);
        return this;
    }

    public final my xq(long j2) {
        this.erW = j2;
        return this;
    }

    public final my xr(long j2) {
        AppMethodBeat.i(43727);
        this.fad = j2;
        super.bj("StartTimeStampMs", this.fad);
        AppMethodBeat.o(43727);
        return this;
    }

    public final my xs(long j2) {
        AppMethodBeat.i(43728);
        this.fae = j2;
        super.bj("EndTimeStampMs", this.fae);
        AppMethodBeat.o(43728);
        return this;
    }

    public final my mK(int i2) {
        this.ffH = i2;
        return this;
    }

    public final my xt(long j2) {
        this.eJb = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(43729);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoK);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eYW);
        stringBuffer.append(",");
        stringBuffer.append(this.fac);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.fad);
        stringBuffer.append(",");
        stringBuffer.append(this.fae);
        stringBuffer.append(",");
        stringBuffer.append(this.ffH);
        stringBuffer.append(",");
        stringBuffer.append(this.eJb);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43729);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43730);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("UserName:").append(this.eoK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppType:").append(this.eYW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CostTimeMs:").append(this.fac);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StartTimeStampMs:").append(this.fad);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EndTimeStampMs:").append(this.fae);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Ret:").append(this.ffH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetworkType:").append(this.eJb);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43730);
        return stringBuffer2;
    }
}
