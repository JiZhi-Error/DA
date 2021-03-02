package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class iw extends a {
    private String eQe = "";
    private String eQj = "";
    private String eQl = "";
    public long eQm = 0;
    public long eQn = 0;
    public long eQo = 0;
    public long eQp = 0;
    public long eQq = 0;
    private String emL = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18244;
    }

    public final iw wt(String str) {
        AppMethodBeat.i(110278);
        this.emL = x("ChatName", str, true);
        AppMethodBeat.o(110278);
        return this;
    }

    public final iw wu(String str) {
        AppMethodBeat.i(110279);
        this.eQe = x("LaunchUserName", str, true);
        AppMethodBeat.o(110279);
        return this;
    }

    public final iw wv(String str) {
        AppMethodBeat.i(110280);
        this.eQl = x("MsgUserName", str, true);
        AppMethodBeat.o(110280);
        return this;
    }

    public final iw ww(String str) {
        AppMethodBeat.i(110281);
        this.eQj = x("Identifier", str, true);
        AppMethodBeat.o(110281);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(110282);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.emL);
        stringBuffer.append(",");
        stringBuffer.append(this.eQe);
        stringBuffer.append(",");
        stringBuffer.append(this.eQl);
        stringBuffer.append(",");
        stringBuffer.append(this.eQm);
        stringBuffer.append(",");
        stringBuffer.append(this.eQn);
        stringBuffer.append(",");
        stringBuffer.append(this.eQo);
        stringBuffer.append(",");
        stringBuffer.append(this.eQp);
        stringBuffer.append(",");
        stringBuffer.append(this.eQq);
        stringBuffer.append(",");
        stringBuffer.append(this.eQj);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(110282);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(110283);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ChatName:").append(this.emL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LaunchUserName:").append(this.eQe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MsgUserName:").append(this.eQl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionSvrId:").append(this.eQm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasHeader:").append(this.eQn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasTail:").append(this.eQo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasExample:").append(this.eQp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActiveScene:").append(this.eQq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Identifier:").append(this.eQj);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(110283);
        return stringBuffer2;
    }
}
