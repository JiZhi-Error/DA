package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class et extends a {
    private String eEs = "";
    public long eEt = 0;
    public long eEu = 0;
    public long erW;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19353;
    }

    public final et rR(String str) {
        AppMethodBeat.i(184626);
        this.eEs = x("Roomid", str, true);
        AppMethodBeat.o(184626);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(184627);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eEs);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.eEt);
        stringBuffer.append(",");
        stringBuffer.append(this.eEu);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(184627);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(184628);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Roomid:").append(this.eEs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Result:").append(this.eEt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ErrCode:").append(this.eEu);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(184628);
        return stringBuffer2;
    }
}
