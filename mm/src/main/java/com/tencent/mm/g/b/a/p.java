package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class p extends a {
    public String ekH = "";
    public long ekR;
    public long ekS;
    public String ekT = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21931;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(238091);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ekH);
        stringBuffer.append(",");
        stringBuffer.append(this.ekR);
        stringBuffer.append(",");
        stringBuffer.append(this.ekS);
        stringBuffer.append(",");
        stringBuffer.append(this.ekT);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(238091);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(238092);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("session_id:").append(this.ekH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("page_type:").append(this.ekR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("page_feed_index:").append(this.ekS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("content_id:").append(this.ekT);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(238092);
        return stringBuffer2;
    }
}
