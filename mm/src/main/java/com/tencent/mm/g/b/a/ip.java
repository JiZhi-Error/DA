package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ip extends a {
    public long eDV = 0;
    public long ePk = 0;
    public long ePl = 0;
    public long ePm = 0;
    private long ePn = 0;
    public String ePo = "";
    public long eqw = 0;
    public long eww = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 13677;
    }

    public final ip rr(long j2) {
        AppMethodBeat.i(94842);
        this.ePn = j2;
        super.bi("EnterStartTimeMs", this.ePn);
        AppMethodBeat.o(94842);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(94843);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eDV);
        stringBuffer.append(",");
        stringBuffer.append(this.ePk);
        stringBuffer.append(",");
        stringBuffer.append(this.ePl);
        stringBuffer.append(",");
        stringBuffer.append(this.eqw);
        stringBuffer.append(",");
        stringBuffer.append(this.eww);
        stringBuffer.append(",");
        stringBuffer.append(this.ePm);
        stringBuffer.append(",");
        stringBuffer.append(this.ePn);
        stringBuffer.append(",");
        stringBuffer.append(this.ePo);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(94843);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(94844);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Source:").append(this.eDV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UnreadLikeCount:").append(this.ePk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UnreadCommentCount:").append(this.ePl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StayTime:").append(this.eqw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickLikeCount:").append(this.eww);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickCommentCount:").append(this.ePm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterStartTimeMs:").append(this.ePn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseJson:").append(this.ePo);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(94844);
        return stringBuffer2;
    }
}
