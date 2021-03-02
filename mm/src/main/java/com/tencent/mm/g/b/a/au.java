package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class au extends a {
    public int enW;
    private String eqs = "";
    private String eqt = "";
    public int equ = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18885;
    }

    public final au iA(String str) {
        AppMethodBeat.i(163528);
        this.eqs = x("F2FId", str, true);
        AppMethodBeat.o(163528);
        return this;
    }

    public final au iB(String str) {
        AppMethodBeat.i(163529);
        this.eqt = x("QrCodeId", str, true);
        AppMethodBeat.o(163529);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(163530);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enW);
        stringBuffer.append(",");
        stringBuffer.append(this.eqs);
        stringBuffer.append(",");
        stringBuffer.append(this.eqt);
        stringBuffer.append(",");
        stringBuffer.append(this.equ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(163530);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(163531);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActionType:").append(this.enW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("F2FId:").append(this.eqs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("QrCodeId:").append(this.eqt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TotalAmount:").append(this.equ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(163531);
        return stringBuffer2;
    }
}
