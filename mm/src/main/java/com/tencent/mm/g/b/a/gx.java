package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gx extends a {
    public long eLg = 0;
    private String eLh = "";
    public long ejA = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19194;
    }

    public final gx uM(String str) {
        AppMethodBeat.i(163176);
        this.eLh = x("AppList", str, true);
        AppMethodBeat.o(163176);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(163177);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.eLg);
        stringBuffer.append(",");
        stringBuffer.append(this.eLh);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(163177);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(163178);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsRedDot:").append(this.eLg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppList:").append(this.eLh);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(163178);
        return stringBuffer2;
    }
}
