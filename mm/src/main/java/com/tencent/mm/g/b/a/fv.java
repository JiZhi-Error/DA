package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fv extends a {
    private long eIe;
    private long eIf;
    private long eIg;
    private String eoj = "";
    private long esJ;
    private String eui = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21150;
    }

    public final fv sO(String str) {
        AppMethodBeat.i(209248);
        this.eoj = x("Feedid", str, true);
        AppMethodBeat.o(209248);
        return this;
    }

    public final fv sP(String str) {
        AppMethodBeat.i(209249);
        this.eui = x("LongVideoId", str, true);
        AppMethodBeat.o(209249);
        return this;
    }

    public final fv pz(long j2) {
        this.eIe = j2;
        return this;
    }

    public final fv pA(long j2) {
        this.eIf = j2;
        return this;
    }

    public final fv pB(long j2) {
        this.eIg = j2;
        return this;
    }

    public final fv pC(long j2) {
        this.esJ = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209250);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoj);
        stringBuffer.append(",");
        stringBuffer.append(this.eui);
        stringBuffer.append(",");
        stringBuffer.append(this.eIe);
        stringBuffer.append(",");
        stringBuffer.append(this.eIf);
        stringBuffer.append(",");
        stringBuffer.append(this.eIg);
        stringBuffer.append(",");
        stringBuffer.append(this.esJ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209250);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209251);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Feedid:").append(this.eoj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LongVideoId:").append(this.eui);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LongVideoDuration:").append(this.eIe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WordingCnt:").append(this.eIf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DurationPosition:").append(this.eIg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Outcome:").append(this.esJ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209251);
        return stringBuffer2;
    }
}
