package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class hm extends a {
    private String eFE = "";
    public long eLz;
    private long eMc;
    private String eMd = "";
    private String eMe = "";
    public long enM;
    public long erw;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19443;
    }

    public final hm vj(String str) {
        AppMethodBeat.i(184767);
        this.eFE = x("roomId", str, true);
        AppMethodBeat.o(184767);
        return this;
    }

    public final hm aha() {
        this.eMc = 2;
        return this;
    }

    public final hm vk(String str) {
        AppMethodBeat.i(184768);
        this.eMd = x("todoid", str, true);
        AppMethodBeat.o(184768);
        return this;
    }

    public final hm vl(String str) {
        AppMethodBeat.i(194001);
        this.eMe = x("appusername", str, true);
        AppMethodBeat.o(194001);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(184769);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eFE);
        stringBuffer.append(",");
        stringBuffer.append(this.enM);
        stringBuffer.append(",");
        stringBuffer.append(this.eLz);
        stringBuffer.append(",");
        stringBuffer.append(this.erw);
        stringBuffer.append(",");
        stringBuffer.append(this.eMc);
        stringBuffer.append(",");
        stringBuffer.append(this.eMd);
        stringBuffer.append(",");
        stringBuffer.append(this.eMe);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(184769);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(184770);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("roomId:").append(this.eFE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("role:").append(this.enM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("msgType:").append(this.eLz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene:").append(this.erw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("exit:").append(this.eMc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("todoid:").append(this.eMd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appusername:").append(this.eMe);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(184770);
        return stringBuffer2;
    }
}
