package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class s extends a {
    public String ekH = "";
    public long ekR;
    public long ekY;
    public String ekZ = "";
    private long oqa;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21930;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(238097);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ekH);
        stringBuffer.append(",");
        stringBuffer.append(this.ekY);
        stringBuffer.append(",");
        stringBuffer.append(this.ekR);
        stringBuffer.append(",");
        stringBuffer.append(this.ekZ);
        stringBuffer.append(",");
        stringBuffer.append(this.oqa);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(238097);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(238098);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("session_id:").append(this.ekH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("exp_type:").append(this.ekY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("page_type:").append(this.ekR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("conent_list:").append(this.ekZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("content_status:").append(this.oqa);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(238098);
        return stringBuffer2;
    }
}
