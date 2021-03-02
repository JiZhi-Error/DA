package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ff extends a {
    private long eCt;
    private String eFc = "";
    private long eFn = 0;
    private long eFo;
    private String eFp = "";
    private long eFq;
    private long eyI;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19894;
    }

    public final ff sd(String str) {
        AppMethodBeat.i(207414);
        this.eFc = x("roomid", str, true);
        AppMethodBeat.o(207414);
        return this;
    }

    public final ff nq(long j2) {
        this.eyI = j2;
        return this;
    }

    public final ff nr(long j2) {
        this.eFn = j2;
        return this;
    }

    public final ff ns(long j2) {
        this.eFo = j2;
        return this;
    }

    public final ff nt(long j2) {
        this.eFq = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(207415);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eFc);
        stringBuffer.append(",");
        stringBuffer.append(this.eyI);
        stringBuffer.append(",");
        stringBuffer.append(this.eFn);
        stringBuffer.append(",");
        stringBuffer.append(this.eFo);
        stringBuffer.append(",");
        stringBuffer.append(this.eFp);
        stringBuffer.append(",");
        stringBuffer.append(this.eCt);
        stringBuffer.append(",");
        stringBuffer.append(this.eFq);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(207415);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(207416);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("roomid:").append(this.eFc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveid:").append(this.eyI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("waitCount:").append(this.eFn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("allowConnect:").append(this.eFo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("audienceUin:").append(this.eFp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionCode:").append(this.eCt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("linkCount:").append(this.eFq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(207416);
        return stringBuffer2;
    }
}
