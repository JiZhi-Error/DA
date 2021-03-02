package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class km extends a {
    private String eWa = "";
    private String eWb = "";
    public long eWc = 0;
    public long eWd = 0;
    public long eWe = 0;
    public long eWi = 0;
    public long eWj = 0;
    public long eWk = 0;
    private String ejm = "";
    private String etW = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20572;
    }

    public final km xO(String str) {
        AppMethodBeat.i(226048);
        this.eWa = x("Appid", str, true);
        AppMethodBeat.o(226048);
        return this;
    }

    public final String getAppid() {
        return this.eWa;
    }

    public final km xP(String str) {
        AppMethodBeat.i(226049);
        this.etW = x("Username", str, true);
        AppMethodBeat.o(226049);
        return this;
    }

    public final String getUsername() {
        return this.etW;
    }

    public final long aip() {
        return this.eWc;
    }

    public final long aiq() {
        return this.eWd;
    }

    public final long air() {
        return this.eWe;
    }

    public final long ais() {
        return this.eWk;
    }

    public final km xQ(String str) {
        AppMethodBeat.i(226050);
        this.ejm = x("NetType", str, true);
        AppMethodBeat.o(226050);
        return this;
    }

    public final String ait() {
        return this.ejm;
    }

    public final long aiu() {
        return this.eWi;
    }

    public final km xR(String str) {
        AppMethodBeat.i(226051);
        this.eWb = x("InstanceId", str, true);
        AppMethodBeat.o(226051);
        return this;
    }

    public final String aiv() {
        return this.eWb;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(226052);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWa);
        stringBuffer.append(",");
        stringBuffer.append(this.etW);
        stringBuffer.append(",");
        stringBuffer.append(this.eWc);
        stringBuffer.append(",");
        stringBuffer.append(this.eWd);
        stringBuffer.append(",");
        stringBuffer.append(this.eWe);
        stringBuffer.append(",");
        stringBuffer.append(this.eWj);
        stringBuffer.append(",");
        stringBuffer.append(this.eWk);
        stringBuffer.append(",");
        stringBuffer.append(this.ejm);
        stringBuffer.append(",");
        stringBuffer.append(this.eWi);
        stringBuffer.append(",");
        stringBuffer.append(this.eWb);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(226052);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(226053);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Appid:").append(this.eWa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Username:").append(this.etW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OpenScene:").append(this.eWc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TargetAppVersion:").append(this.eWd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LocalAppVersion:").append(this.eWe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FallbackScene:").append(this.eWj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WaitTimeInMs:").append(this.eWk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetType:").append(this.ejm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsWeakNet:").append(this.eWi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("InstanceId:").append(this.eWb);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(226053);
        return stringBuffer2;
    }
}
