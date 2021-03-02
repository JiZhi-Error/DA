package com.tencent.mm.g.b.a;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jx extends a {
    private long eSQ;
    private long eSR;
    private long eSS;
    private long eST;
    private String eiB = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return CdnLogic.MediaTypeFriendsImageThumb;
    }

    public final jx xi(String str) {
        AppMethodBeat.i(199744);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(199744);
        return this;
    }

    public final jx sZ(long j2) {
        this.eSQ = j2;
        return this;
    }

    public final jx ta(long j2) {
        this.eSR = j2;
        return this;
    }

    public final jx tb(long j2) {
        this.eSS = j2;
        return this;
    }

    public final jx tc(long j2) {
        this.eST = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(199745);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eSQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eSR);
        stringBuffer.append(",");
        stringBuffer.append(this.eSS);
        stringBuffer.append(",");
        stringBuffer.append(this.eST);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(199745);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(199746);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PullStartTimeStamp:").append(this.eSQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PullEndTimeStamp:").append(this.eSR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsSuccess:").append(this.eSS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FailedType:").append(this.eST);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(199746);
        return stringBuffer2;
    }
}
