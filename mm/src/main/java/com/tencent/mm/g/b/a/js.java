package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class js extends a {
    public long eRo = 0;
    private String eSl = "";
    public long eSm = 0;
    private String eSn = "";
    public long eSo = 0;
    private String eiB = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16843;
    }

    public final js wZ(String str) {
        AppMethodBeat.i(94851);
        this.eSl = x("EnterObjectId", str, true);
        AppMethodBeat.o(94851);
        return this;
    }

    public final js xa(String str) {
        AppMethodBeat.i(94852);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(94852);
        return this;
    }

    public final js xb(String str) {
        AppMethodBeat.i(94853);
        this.eSn = x("ExposeUinList", str, true);
        AppMethodBeat.o(94853);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(94854);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eSl);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eSm);
        stringBuffer.append(",");
        stringBuffer.append(this.eSn);
        stringBuffer.append(",");
        stringBuffer.append(this.eSo);
        stringBuffer.append(",");
        stringBuffer.append(this.eRo);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(94854);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(94855);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EnterObjectId:").append(this.eSl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposeUinCount:").append(this.eSm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposeUinList:").append(this.eSn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposeNewVideoCount:").append(this.eSo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("InteractiveUserCount:").append(this.eRo);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(94855);
        return stringBuffer2;
    }
}
