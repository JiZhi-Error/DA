package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class kl extends a {
    private String eWa = "";
    private String eWb = "";
    private long eWc = 0;
    private long eWd = 0;
    private long eWe = 0;
    private long eWf = 0;
    private long eWg = 0;
    private long eWh = 0;
    private long eWi = 0;
    private long eWj = 0;
    private String ejm = "";
    private String etW = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20579;
    }

    public final kl xK(String str) {
        AppMethodBeat.i(226042);
        this.eWa = x("Appid", str, true);
        AppMethodBeat.o(226042);
        return this;
    }

    public final kl xL(String str) {
        AppMethodBeat.i(226043);
        this.etW = x("Username", str, true);
        AppMethodBeat.o(226043);
        return this;
    }

    public final kl xM(String str) {
        AppMethodBeat.i(226044);
        this.eWb = x("InstanceId", str, true);
        AppMethodBeat.o(226044);
        return this;
    }

    public final kl tC(long j2) {
        this.eWc = j2;
        return this;
    }

    public final kl tD(long j2) {
        this.eWd = j2;
        return this;
    }

    public final kl tE(long j2) {
        this.eWe = j2;
        return this;
    }

    public final kl tF(long j2) {
        this.eWf = j2;
        return this;
    }

    public final kl tG(long j2) {
        this.eWg = j2;
        return this;
    }

    public final kl tH(long j2) {
        this.eWh = j2;
        return this;
    }

    public final kl xN(String str) {
        AppMethodBeat.i(226045);
        this.ejm = x("NetType", str, true);
        AppMethodBeat.o(226045);
        return this;
    }

    public final kl tI(long j2) {
        this.eWi = j2;
        return this;
    }

    public final kl tJ(long j2) {
        this.eWj = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(226046);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWa);
        stringBuffer.append(",");
        stringBuffer.append(this.etW);
        stringBuffer.append(",");
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eWc);
        stringBuffer.append(",");
        stringBuffer.append(this.eWd);
        stringBuffer.append(",");
        stringBuffer.append(this.eWe);
        stringBuffer.append(",");
        stringBuffer.append(this.eWf);
        stringBuffer.append(",");
        stringBuffer.append(this.eWg);
        stringBuffer.append(",");
        stringBuffer.append(this.eWh);
        stringBuffer.append(",");
        stringBuffer.append(this.ejm);
        stringBuffer.append(",");
        stringBuffer.append(this.eWi);
        stringBuffer.append(",");
        stringBuffer.append(this.eWj);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(226046);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(226047);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Appid:").append(this.eWa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Username:").append(this.etW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OpenScene:").append(this.eWc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TargetAppVersion:").append(this.eWd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LocalAppVersion:").append(this.eWe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UpdateResult:").append(this.eWf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UpdateCostTimeInMs:").append(this.eWg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FallbackWaitTimeInMs:").append(this.eWh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetType:").append(this.ejm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsWeakNet:").append(this.eWi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FallbackScene:").append(this.eWj);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(226047);
        return stringBuffer2;
    }
}
