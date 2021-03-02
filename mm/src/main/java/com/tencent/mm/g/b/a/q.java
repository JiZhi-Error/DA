package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class q extends a {
    public String ekH = "";
    public long ekI;
    public long ekR;
    public long ekU;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21929;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(238093);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ekH);
        stringBuffer.append(",");
        stringBuffer.append(this.ekI);
        stringBuffer.append(",");
        stringBuffer.append(this.ekU);
        stringBuffer.append(",");
        stringBuffer.append(this.ekR);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(238093);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(238094);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("session_id:").append(this.ekH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action_type:").append(this.ekI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("live_duration:").append(this.ekU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("page_type:").append(this.ekR);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(238094);
        return stringBuffer2;
    }
}
