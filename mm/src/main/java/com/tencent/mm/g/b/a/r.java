package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class r extends a {
    public String ekH = "";
    public String ekT = "";
    public long ekU;
    public String ekV = "";
    public long ekW;
    public long ekX;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21926;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(238095);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ekH);
        stringBuffer.append(",");
        stringBuffer.append(this.ekV);
        stringBuffer.append(",");
        stringBuffer.append(this.ekW);
        stringBuffer.append(",");
        stringBuffer.append(this.ekX);
        stringBuffer.append(",");
        stringBuffer.append(this.ekT);
        stringBuffer.append(",");
        stringBuffer.append(this.ekU);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(238095);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(238096);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("session_id:").append(this.ekH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action_type:").append(this.ekV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action_channel:").append(this.ekW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("content_type:").append(this.ekX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("content_id:").append(this.ekT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("live_duration:").append(this.ekU);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(238096);
        return stringBuffer2;
    }
}
