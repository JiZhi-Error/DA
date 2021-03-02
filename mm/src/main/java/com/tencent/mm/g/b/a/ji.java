package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ji extends a {
    private long eNd = 0;
    private long eRd = 0;
    private long eRe = 0;
    private long eRf = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16913;
    }

    public final ji rZ(long j2) {
        this.eRd = j2;
        return this;
    }

    public final ji sa(long j2) {
        this.eNd = j2;
        return this;
    }

    public final long ahp() {
        return this.eNd;
    }

    public final ji sb(long j2) {
        this.eRe = j2;
        return this;
    }

    public final long ahq() {
        return this.eRe;
    }

    public final ji sc(long j2) {
        this.eRf = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(118488);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eRd);
        stringBuffer.append(",");
        stringBuffer.append(this.eNd);
        stringBuffer.append(",");
        stringBuffer.append(this.eRe);
        stringBuffer.append(",");
        stringBuffer.append(this.eRf);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(118488);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(118489);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ExposeViewId:").append(this.eRd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickClearCount:").append(this.eNd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickRenewCount:").append(this.eRe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IfDeleteVideo:").append(this.eRf);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(118489);
        return stringBuffer2;
    }
}
