package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class nl extends a {
    public long eMl = 0;
    public long eMp = 0;
    public long ejW = 0;
    private String enR = "";
    public long fgF = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15841;
    }

    public final nl AA(String str) {
        AppMethodBeat.i(76370);
        this.enR = x("appid", str, true);
        AppMethodBeat.o(76370);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(76371);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ejW);
        stringBuffer.append(",");
        stringBuffer.append(this.enR);
        stringBuffer.append(",");
        stringBuffer.append(this.eMp);
        stringBuffer.append(",");
        stringBuffer.append(this.fgF);
        stringBuffer.append(",");
        stringBuffer.append(this.eMl);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(76371);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(76372);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("action:").append(this.ejW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appid:").append(this.enR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("timecost:").append(this.eMp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("drawStrategy:").append(this.fgF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("hasInitData:").append(this.eMl);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(76372);
        return stringBuffer2;
    }
}
