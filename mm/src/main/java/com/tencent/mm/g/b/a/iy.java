package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class iy extends a {
    private String eQe = "";
    public long eQf = 0;
    private String eQj = "";
    public long ekE = 0;
    private String emL = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18252;
    }

    public final iy wx(String str) {
        AppMethodBeat.i(110286);
        this.emL = x("ChatName", str, true);
        AppMethodBeat.o(110286);
        return this;
    }

    public final iy wy(String str) {
        AppMethodBeat.i(110287);
        this.eQe = x("LaunchUserName", str, true);
        AppMethodBeat.o(110287);
        return this;
    }

    public final iy wz(String str) {
        AppMethodBeat.i(110288);
        this.eQj = x("Identifier", str, true);
        AppMethodBeat.o(110288);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(110289);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.emL);
        stringBuffer.append(",");
        stringBuffer.append(this.eQe);
        stringBuffer.append(",");
        stringBuffer.append(this.eQf);
        stringBuffer.append(",");
        stringBuffer.append(this.ekE);
        stringBuffer.append(",");
        stringBuffer.append(this.eQj);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(110289);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(110290);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ChatName:").append(this.emL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LaunchUserName:").append(this.eQe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionID:").append(this.eQf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("reason:").append(this.ekE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Identifier:").append(this.eQj);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(110290);
        return stringBuffer2;
    }
}
