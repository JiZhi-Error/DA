package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class kn extends a {
    private long eHD;
    private String eWa = "";
    private String eWb = "";
    private long eWl;
    private String eWm = "";
    private String eWn = "";
    private long eWo;
    private long eWp;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19175;
    }

    public final kn xS(String str) {
        AppMethodBeat.i(226054);
        this.eWb = x("InstanceId", str, true);
        AppMethodBeat.o(226054);
        return this;
    }

    public final kn xT(String str) {
        AppMethodBeat.i(226055);
        this.eWa = x("Appid", str, true);
        AppMethodBeat.o(226055);
        return this;
    }

    public final kn tK(long j2) {
        this.eWl = j2;
        return this;
    }

    public final kn xU(String str) {
        AppMethodBeat.i(226056);
        this.eWm = x("EventName", str, true);
        AppMethodBeat.o(226056);
        return this;
    }

    public final kn tL(long j2) {
        this.eHD = j2;
        return this;
    }

    public final kn xV(String str) {
        AppMethodBeat.i(226057);
        this.eWn = x("Parent", str, true);
        AppMethodBeat.o(226057);
        return this;
    }

    public final kn tM(long j2) {
        this.eWo = j2;
        return this;
    }

    public final kn tN(long j2) {
        this.eWp = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(226058);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWb);
        stringBuffer.append(",");
        stringBuffer.append(this.eWa);
        stringBuffer.append(",");
        stringBuffer.append(this.eWl);
        stringBuffer.append(",");
        stringBuffer.append(this.eWm);
        stringBuffer.append(",");
        stringBuffer.append(this.eHD);
        stringBuffer.append(",");
        stringBuffer.append(this.eWn);
        stringBuffer.append(",");
        stringBuffer.append(this.eWo);
        stringBuffer.append(",");
        stringBuffer.append(this.eWp);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(226058);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(226059);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InstanceId:").append(this.eWb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Appid:").append(this.eWa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TimeStampInMs:").append(this.eWl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EventName:").append(this.eWm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EventType:").append(this.eHD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Parent:").append(this.eWn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Category:").append(this.eWo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Option:").append(this.eWp);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(226059);
        return stringBuffer2;
    }
}
