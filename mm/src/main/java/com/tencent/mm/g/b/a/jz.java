package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jz extends a {
    private long eSQ;
    private long eSR;
    private long eSS;
    private String eSZ = "";
    private long eTb;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20203;
    }

    public final jz td(long j2) {
        this.eSQ = j2;
        return this;
    }

    public final jz te(long j2) {
        this.eSR = j2;
        return this;
    }

    public final jz tf(long j2) {
        this.eSS = j2;
        return this;
    }

    public final jz tg(long j2) {
        this.eTb = j2;
        return this;
    }

    public final jz xj(String str) {
        AppMethodBeat.i(199749);
        this.eSZ = x("WordVersion", str, true);
        AppMethodBeat.o(199749);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(199750);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eSQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eSR);
        stringBuffer.append(",");
        stringBuffer.append(this.eSS);
        stringBuffer.append(",");
        stringBuffer.append(this.eTb);
        stringBuffer.append(",");
        stringBuffer.append(this.eSZ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(199750);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(199751);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PullStartTimeStamp:").append(this.eSQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PullEndTimeStamp:").append(this.eSR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsSuccess:").append(this.eSS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WordSize:").append(this.eTb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WordVersion:").append(this.eSZ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(199751);
        return stringBuffer2;
    }
}
