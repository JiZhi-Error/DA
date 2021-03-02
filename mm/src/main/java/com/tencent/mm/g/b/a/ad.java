package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ad extends a {
    public String enA = "";
    public int enD = 0;
    public long enE = 0;
    public long enF = 0;
    public long enG = 0;
    private long enH = 0;
    public long enI = 0;
    public String enJ = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15460;
    }

    public final ad bX(long j2) {
        AppMethodBeat.i(121746);
        this.enH = j2;
        super.bi("StayTimeMs", this.enH);
        AppMethodBeat.o(121746);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(121747);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enA);
        stringBuffer.append(",");
        stringBuffer.append(this.enD);
        stringBuffer.append(",");
        stringBuffer.append(this.enE);
        stringBuffer.append(",");
        stringBuffer.append(this.enF);
        stringBuffer.append(",");
        stringBuffer.append(this.enG);
        stringBuffer.append(",");
        stringBuffer.append(this.enH);
        stringBuffer.append(",");
        stringBuffer.append(this.enI);
        stringBuffer.append(",");
        stringBuffer.append(this.enJ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(121747);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(121748);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ChatroomName:").append(this.enA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChatroomMute:").append(this.enD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UnreadCount:").append(this.enE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DisRedDotCount:").append(this.enF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterCount:").append(this.enG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StayTimeMs:").append(this.enH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SendCount:").append(this.enI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Score:").append(this.enJ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(121748);
        return stringBuffer2;
    }
}
