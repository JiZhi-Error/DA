package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gs extends a {
    private String eKN = "";
    public long eKO = 0;
    public long eKP = 0;
    public long eKQ = 0;
    public long eKR = 0;
    public long eKS = 0;
    public long eKT = 0;
    private String els = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15855;
    }

    public final gs uu(String str) {
        AppMethodBeat.i(149918);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(149918);
        return this;
    }

    public final gs uv(String str) {
        AppMethodBeat.i(149919);
        this.eKN = x("userName", str, true);
        AppMethodBeat.o(149919);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(149920);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.eKN);
        stringBuffer.append(",");
        stringBuffer.append(this.eKO);
        stringBuffer.append(",");
        stringBuffer.append(this.eKP);
        stringBuffer.append(",");
        stringBuffer.append(this.eKQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eKR);
        stringBuffer.append(",");
        stringBuffer.append(this.eKS);
        stringBuffer.append(",");
        stringBuffer.append(this.eKT);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(149920);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(149921);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("userName:").append(this.eKN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("succeedStatus:").append(this.eKO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("userStatus:").append(this.eKP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("showSucceedMethod:").append(this.eKQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickSucceedAction:").append(this.eKR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("watchMessageRecord:").append(this.eKS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sendMessageStatus:").append(this.eKT);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(149921);
        return stringBuffer2;
    }
}
