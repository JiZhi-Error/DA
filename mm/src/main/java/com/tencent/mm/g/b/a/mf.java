package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class mf extends a {
    private String ekF = "";
    private String faS = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21750;
    }

    public final mf zt(String str) {
        AppMethodBeat.i(226078);
        this.faS = x("instanceId", str, true);
        AppMethodBeat.o(226078);
        return this;
    }

    public final mf zu(String str) {
        AppMethodBeat.i(226079);
        this.ekF = x("flags", str, true);
        AppMethodBeat.o(226079);
        return this;
    }

    public final String getFlags() {
        return this.ekF;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(226080);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.faS);
        stringBuffer.append(",");
        stringBuffer.append(this.ekF);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(226080);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(226081);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("instanceId:").append(this.faS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("flags:").append(this.ekF);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(226081);
        return stringBuffer2;
    }
}
