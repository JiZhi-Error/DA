package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class dm extends a {
    private long eAY;
    private String eAZ = "";
    private String eAm = "";
    private long eBa;
    private String eBb = "";
    private String eBc = "";
    private long enl;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21172;
    }

    public final dm kj(long j2) {
        this.enl = j2;
        return this;
    }

    public final dm pe(String str) {
        AppMethodBeat.i(209134);
        this.eBb = x("ProfileUsername", str, true);
        AppMethodBeat.o(209134);
        return this;
    }

    public final dm pf(String str) {
        AppMethodBeat.i(209135);
        this.eBc = x("ProfileBizUin", str, true);
        AppMethodBeat.o(209135);
        return this;
    }

    public final dm atx(String str) {
        AppMethodBeat.i(259299);
        this.eAm = x("ExtInfo", str, true);
        AppMethodBeat.o(259299);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209136);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eAY);
        stringBuffer.append(",");
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.eAZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eBa);
        stringBuffer.append(",");
        stringBuffer.append(this.eBb);
        stringBuffer.append(",");
        stringBuffer.append(this.eBc);
        stringBuffer.append(",");
        stringBuffer.append(this.eAm);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209136);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209137);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ProfileUin:").append(this.eAY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AtText:").append(this.eAZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IfClickSucess:").append(this.eBa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ProfileUsername:").append(this.eBb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ProfileBizUin:").append(this.eBc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExtInfo:").append(this.eAm);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209137);
        return stringBuffer2;
    }
}
