package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class dj extends a {
    private long euQ;
    private String ezQ = "";
    private String ezR = "";
    private long ezS;
    private long ezT;
    private long ezU;
    private long ezW;
    private long ezX;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21640;
    }

    public final dj oI(String str) {
        AppMethodBeat.i(237152);
        this.ezQ = x("PostId", str, true);
        AppMethodBeat.o(237152);
        return this;
    }

    public final dj oJ(String str) {
        AppMethodBeat.i(237153);
        this.ezR = x("EditId", str, true);
        AppMethodBeat.o(237153);
        return this;
    }

    public final dj jB(long j2) {
        this.ezS = j2;
        return this;
    }

    public final dj jC(long j2) {
        this.ezT = j2;
        return this;
    }

    public final dj jD(long j2) {
        this.ezU = j2;
        return this;
    }

    public final dj jE(long j2) {
        this.ezW = j2;
        return this;
    }

    public final dj jF(long j2) {
        this.ezX = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(237154);
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
        stringBuffer.append(this.ezW);
        stringBuffer.append(",");
        stringBuffer.append(this.ezX);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(237154);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(237155);
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
        stringBuffer.append("mediaViewType:").append(this.ezW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("previewViewScene:").append(this.ezX);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(237155);
        return stringBuffer2;
    }
}
