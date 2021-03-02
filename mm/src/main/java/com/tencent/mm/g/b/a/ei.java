package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ei extends a {
    private long eCE;
    private long eCF;
    private String els = "";
    private long enl;
    private long ery;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19251;
    }

    public final ei qV(String str) {
        AppMethodBeat.i(184185);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(184185);
        return this;
    }

    public final ei afy() {
        this.eCE = 2;
        return this;
    }

    public final ei afz() {
        this.enl = 1;
        return this;
    }

    public final ei afA() {
        this.eCF = 0;
        return this;
    }

    public final ei lS(long j2) {
        this.ery = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(184186);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.eCE);
        stringBuffer.append(",");
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.eCF);
        stringBuffer.append(",");
        stringBuffer.append(this.ery);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(184186);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(184187);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MessageType:").append(this.eCE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsFloat:").append(this.eCF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentScene:").append(this.ery);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(184187);
        return stringBuffer2;
    }
}
