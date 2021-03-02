package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class eu extends a {
    private String eEs = "";
    public long eEu;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19352;
    }

    public final eu rS(String str) {
        AppMethodBeat.i(184629);
        this.eEs = x("Roomid", str, true);
        AppMethodBeat.o(184629);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(184630);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eEs);
        stringBuffer.append(",");
        stringBuffer.append(this.eEu);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(184630);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(184631);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Roomid:").append(this.eEs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ErrCode:").append(this.eEu);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(184631);
        return stringBuffer2;
    }
}
