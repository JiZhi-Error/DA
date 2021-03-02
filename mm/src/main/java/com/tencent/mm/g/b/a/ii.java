package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class ii extends a {
    public long eOC = 0;
    private long eOD = 0;
    private String eiB = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15987;
    }

    public final ii wg(String str) {
        AppMethodBeat.i(94830);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(94830);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(94832);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eOC);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eOD);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(94832);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(94833);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Entrance:").append(this.eOC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTimeStampMs:").append(this.eOD);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(94833);
        return stringBuffer2;
    }

    public final ii ahh() {
        AppMethodBeat.i(94831);
        this.eOD = Util.nowMilliSecond();
        super.bj("ClickTimeStampMs", this.eOD);
        AppMethodBeat.o(94831);
        return this;
    }
}
