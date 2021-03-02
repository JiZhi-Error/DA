package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class di extends a {
    private long euQ;
    private String ezQ = "";
    private String ezR = "";
    private long ezS;
    private long ezT;
    private long ezU;
    private long ezV;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21638;
    }

    public final di oG(String str) {
        AppMethodBeat.i(209117);
        this.ezQ = x("PostId", str, true);
        AppMethodBeat.o(209117);
        return this;
    }

    public final di oH(String str) {
        AppMethodBeat.i(209118);
        this.ezR = x("EditId", str, true);
        AppMethodBeat.o(209118);
        return this;
    }

    public final di jx(long j2) {
        this.ezS = j2;
        return this;
    }

    public final di jy(long j2) {
        this.euQ = j2;
        return this;
    }

    public final di jz(long j2) {
        this.ezT = j2;
        return this;
    }

    public final di jA(long j2) {
        this.ezU = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209119);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ezQ);
        stringBuffer.append(",");
        stringBuffer.append(this.ezR);
        stringBuffer.append(",");
        stringBuffer.append(this.ezS);
        stringBuffer.append(",");
        stringBuffer.append(this.euQ);
        stringBuffer.append(",");
        stringBuffer.append(this.ezT);
        stringBuffer.append(",");
        stringBuffer.append(this.ezU);
        stringBuffer.append(",");
        stringBuffer.append(this.ezV);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209119);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209120);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PostId:").append(this.ezQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EditId:").append(this.ezR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoSource:").append(this.ezS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MediaType:").append(this.euQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PicCnt:").append(this.ezT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoLen:").append(this.ezU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DeleteFlag:").append(this.ezV);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209120);
        return stringBuffer2;
    }
}
