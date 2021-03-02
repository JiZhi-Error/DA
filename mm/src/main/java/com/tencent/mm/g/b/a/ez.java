package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ez extends a {
    public String ekG = "";
    public String euA = "";
    public int euB = 0;
    public int euC = 0;
    public int euD = 0;
    public int euE = 0;
    public int euv = 0;
    public String euw = "";
    public long eux = 0;
    public long euy = 0;
    public long euz = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16242;
    }

    public final ez rV(String str) {
        AppMethodBeat.i(121749);
        this.euw = x("PName", str, true);
        AppMethodBeat.o(121749);
        return this;
    }

    public final ez rW(String str) {
        AppMethodBeat.i(121750);
        this.ekG = x("sessionId", str, true);
        AppMethodBeat.o(121750);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(121751);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.euv);
        stringBuffer.append(",");
        stringBuffer.append(this.euw);
        stringBuffer.append(",");
        stringBuffer.append(this.ekG);
        stringBuffer.append(",");
        stringBuffer.append(this.eux);
        stringBuffer.append(",");
        stringBuffer.append(this.euy);
        stringBuffer.append(",");
        stringBuffer.append(this.euz);
        stringBuffer.append(",");
        stringBuffer.append(this.euA);
        stringBuffer.append(",");
        stringBuffer.append(this.euB);
        stringBuffer.append(",");
        stringBuffer.append(this.euC);
        stringBuffer.append(",");
        stringBuffer.append(this.euD);
        stringBuffer.append(",");
        stringBuffer.append(this.euE);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(121751);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(121752);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PID:").append(this.euv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PName:").append(this.euw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionId:").append(this.ekG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("frontTime:").append(this.eux);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("stayTotalTime:").append(this.euy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scrollTotalTime:").append(this.euz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("reportFeedList:").append(this.euA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("reportFeedCount:").append(this.euB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Seq:").append(this.euC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SubSeq:").append(this.euD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SubSeqSum:").append(this.euE);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(121752);
        return stringBuffer2;
    }
}
