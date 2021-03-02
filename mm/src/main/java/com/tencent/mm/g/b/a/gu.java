package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gu extends a {
    private String eKW = "";
    private String eKX = "";
    private String eKY = "";
    private long ejW;
    private String ekH = "";
    private long elz;
    private String enR = "";
    private long erw;
    private String exF = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21837;
    }

    public final gu qE(long j2) {
        this.elz = j2;
        return this;
    }

    public final gu qF(long j2) {
        this.ejW = j2;
        return this;
    }

    public final gu qG(long j2) {
        this.erw = j2;
        return this;
    }

    public final gu uy(String str) {
        AppMethodBeat.i(209299);
        this.eKW = x("setting", str, true);
        AppMethodBeat.o(209299);
        return this;
    }

    public final gu uz(String str) {
        AppMethodBeat.i(209300);
        this.enR = x("appid", str, true);
        AppMethodBeat.o(209300);
        return this;
    }

    public final gu uA(String str) {
        AppMethodBeat.i(209301);
        this.ekH = x("session_id", str, true);
        AppMethodBeat.o(209301);
        return this;
    }

    public final gu uB(String str) {
        AppMethodBeat.i(209302);
        this.exF = x("finderid", str, true);
        AppMethodBeat.o(209302);
        return this;
    }

    public final gu uC(String str) {
        AppMethodBeat.i(209303);
        this.eKX = x("clickid", str, true);
        AppMethodBeat.o(209303);
        return this;
    }

    public final gu uD(String str) {
        AppMethodBeat.i(209304);
        this.eKY = x("requestID", str, true);
        AppMethodBeat.o(209304);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209305);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.elz);
        stringBuffer.append(",");
        stringBuffer.append(this.ejW);
        stringBuffer.append(",");
        stringBuffer.append(this.erw);
        stringBuffer.append(",");
        stringBuffer.append(this.eKW);
        stringBuffer.append(",");
        stringBuffer.append(this.enR);
        stringBuffer.append(",");
        stringBuffer.append(this.ekH);
        stringBuffer.append(",");
        stringBuffer.append(this.exF);
        stringBuffer.append(",");
        stringBuffer.append(this.eKX);
        stringBuffer.append(",");
        stringBuffer.append(this.eKY);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209305);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209306);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("actionTS:").append(this.elz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action:").append(this.ejW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene:").append(this.erw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("setting:").append(this.eKW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appid:").append(this.enR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("session_id:").append(this.ekH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("finderid:").append(this.exF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickid:").append(this.eKX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("requestID:").append(this.eKY);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209306);
        return stringBuffer2;
    }
}
