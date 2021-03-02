package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class e extends a {
    public long eiR;
    public String ejo = "";
    private long ejp;
    private long ejq;
    public String ejr = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21639;
    }

    public final e bI(long j2) {
        AppMethodBeat.i(238841);
        this.ejp = j2;
        super.bi("StartTimeMs", this.ejp);
        AppMethodBeat.o(238841);
        return this;
    }

    public final e bJ(long j2) {
        AppMethodBeat.i(238842);
        this.ejq = j2;
        super.bi("GetTimeMs", this.ejq);
        AppMethodBeat.o(238842);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(238843);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ejo);
        stringBuffer.append(",");
        stringBuffer.append(this.ejp);
        stringBuffer.append(",");
        stringBuffer.append(this.ejq);
        stringBuffer.append(",");
        stringBuffer.append(this.eiR);
        stringBuffer.append(",");
        stringBuffer.append(this.ejr);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(238843);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(238844);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TipsId:").append(this.ejo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StartTimeMs:").append(this.ejp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GetTimeMs:").append(this.ejq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CostTime:").append(this.eiR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CtrlType:").append(this.ejr);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(238844);
        return stringBuffer2;
    }
}
