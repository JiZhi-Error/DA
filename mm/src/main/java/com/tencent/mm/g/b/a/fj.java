package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fj extends a {
    private long eFC = 0;
    private long eFD;
    private String eFc = "";
    private long eFd;
    private long erw;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19887;
    }

    public final fj aga() {
        this.erw = 1;
        return this;
    }

    public final fj sm(String str) {
        AppMethodBeat.i(207431);
        this.eFc = x("roomid", str, true);
        AppMethodBeat.o(207431);
        return this;
    }

    public final fj nM(long j2) {
        this.eFd = j2;
        return this;
    }

    public final fj nN(long j2) {
        this.eFD = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(207432);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erw);
        stringBuffer.append(",");
        stringBuffer.append(this.eFc);
        stringBuffer.append(",");
        stringBuffer.append(this.eFC);
        stringBuffer.append(",");
        stringBuffer.append(this.eFd);
        stringBuffer.append(",");
        stringBuffer.append(this.eFD);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(207432);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(207433);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("scene:").append(this.erw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("roomid:").append(this.eFc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("reddot:").append(this.eFC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("roomRole:").append(this.eFd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PanelPage:").append(this.eFD);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(207433);
        return stringBuffer2;
    }
}
