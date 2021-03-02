package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class hn extends a {
    private String eFE = "";
    public long eLz;
    public long eMc;
    private String eMd = "";
    private String eMe = "";
    public long ejW;
    public long enM;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19444;
    }

    public final hn vm(String str) {
        AppMethodBeat.i(184771);
        this.eFE = x("roomId", str, true);
        AppMethodBeat.o(184771);
        return this;
    }

    public final hn vn(String str) {
        AppMethodBeat.i(184772);
        this.eMd = x("todoid", str, true);
        AppMethodBeat.o(184772);
        return this;
    }

    public final hn vo(String str) {
        AppMethodBeat.i(194002);
        this.eMe = x("appusername", str, true);
        AppMethodBeat.o(194002);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(184773);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eFE);
        stringBuffer.append(",");
        stringBuffer.append(this.enM);
        stringBuffer.append(",");
        stringBuffer.append(this.eLz);
        stringBuffer.append(",");
        stringBuffer.append(this.ejW);
        stringBuffer.append(",");
        stringBuffer.append(this.eMc);
        stringBuffer.append(",");
        stringBuffer.append(this.eMd);
        stringBuffer.append(",");
        stringBuffer.append(this.eMe);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(184773);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(184774);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("roomId:").append(this.eFE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("role:").append(this.enM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("msgType:").append(this.eLz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action:").append(this.ejW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("exit:").append(this.eMc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("todoid:").append(this.eMd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appusername:").append(this.eMe);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(184774);
        return stringBuffer2;
    }
}
