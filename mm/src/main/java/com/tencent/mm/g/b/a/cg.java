package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class cg extends a {
    private long erz;
    private long evl;
    private String evm = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21680;
    }

    public final cg adb() {
        this.erz = 4;
        return this;
    }

    public final cg fS(long j2) {
        this.evl = j2;
        return this;
    }

    public final cg lH(String str) {
        AppMethodBeat.i(208995);
        this.evm = x("data", str, true);
        AppMethodBeat.o(208995);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208996);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erz);
        stringBuffer.append(",");
        stringBuffer.append(this.evl);
        stringBuffer.append(",");
        stringBuffer.append(this.evm);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208996);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208997);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("InnerVersion:").append(this.erz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("type:").append(this.evl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("data:").append(this.evm);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208997);
        return stringBuffer2;
    }
}
