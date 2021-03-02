package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class eh extends a {
    private String eiB = "";
    private String esS = "";
    private String esT = "";
    private long esU;
    private long esV;
    private long evg;
    private long evh;
    private String evj = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19187;
    }

    public final eh qR(String str) {
        AppMethodBeat.i(168921);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(168921);
        return this;
    }

    public final eh lP(long j2) {
        this.evg = j2;
        return this;
    }

    public final eh lQ(long j2) {
        this.evh = j2;
        return this;
    }

    public final eh qS(String str) {
        AppMethodBeat.i(168922);
        this.esS = x("Tag", str, true);
        AppMethodBeat.o(168922);
        return this;
    }

    public final eh qT(String str) {
        AppMethodBeat.i(168923);
        this.esT = x("TagId", str, true);
        AppMethodBeat.o(168923);
        return this;
    }

    public final eh lR(long j2) {
        this.esV = j2;
        return this;
    }

    public final eh qU(String str) {
        AppMethodBeat.i(168924);
        this.evj = x("ForwardToUsr", str, true);
        AppMethodBeat.o(168924);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(168925);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.evg);
        stringBuffer.append(",");
        stringBuffer.append(this.evh);
        stringBuffer.append(",");
        stringBuffer.append(this.esS);
        stringBuffer.append(",");
        stringBuffer.append(this.esT);
        stringBuffer.append(",");
        stringBuffer.append(this.esU);
        stringBuffer.append(",");
        stringBuffer.append(this.esV);
        stringBuffer.append(",");
        stringBuffer.append(this.evj);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(168925);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(168926);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ForwardType:").append(this.evg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ForwardResult:").append(this.evh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Tag:").append(this.esS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TagId:").append(this.esT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsPoi:").append(this.esU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TagFeedCnt:").append(this.esV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ForwardToUsr:").append(this.evj);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(168926);
        return stringBuffer2;
    }
}
