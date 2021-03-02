package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fq extends a {
    private long eFF;
    private String eGP = "";
    private long eGQ;
    private String eGR = "";
    private long eGS;
    private long erw;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21505;
    }

    public final fq sD(String str) {
        AppMethodBeat.i(196234);
        this.eGP = x("moduleName", str, true);
        AppMethodBeat.o(196234);
        return this;
    }

    public final fq pg(long j2) {
        this.eGQ = j2;
        return this;
    }

    public final fq sE(String str) {
        AppMethodBeat.i(196235);
        this.eGR = x("eventMsg", str, true);
        AppMethodBeat.o(196235);
        return this;
    }

    public final fq ph(long j2) {
        this.eFF = j2;
        return this;
    }

    public final fq pi(long j2) {
        this.erw = j2;
        return this;
    }

    public final long agC() {
        return this.erw;
    }

    public final fq pj(long j2) {
        this.eGS = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(196236);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eGP);
        stringBuffer.append(",");
        stringBuffer.append(this.eGQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eGR);
        stringBuffer.append(",");
        stringBuffer.append(this.eFF);
        stringBuffer.append(",");
        stringBuffer.append(this.erw);
        stringBuffer.append(",");
        stringBuffer.append(this.eGS);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(196236);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(196237);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("moduleName:").append(this.eGP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("eventCode:").append(this.eGQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("eventMsg:").append(this.eGR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveId:").append(this.eFF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene:").append(this.erw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("mode:").append(this.eGS);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(196237);
        return stringBuffer2;
    }
}
