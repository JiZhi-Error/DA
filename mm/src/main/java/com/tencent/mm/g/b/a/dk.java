package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class dk extends a {
    private long enl;
    private long eua;
    private String ezQ = "";
    private String ezY = "";
    private long ezZ;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21149;
    }

    public final dk oK(String str) {
        AppMethodBeat.i(209121);
        this.ezY = x("ClickId", str, true);
        AppMethodBeat.o(209121);
        return this;
    }

    public final dk oL(String str) {
        AppMethodBeat.i(209122);
        this.ezQ = x("PostId", str, true);
        AppMethodBeat.o(209122);
        return this;
    }

    public final dk jG(long j2) {
        this.enl = j2;
        return this;
    }

    public final dk jH(long j2) {
        this.eua = j2;
        return this;
    }

    public final dk jI(long j2) {
        this.ezZ = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209123);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ezY);
        stringBuffer.append(",");
        stringBuffer.append(this.ezQ);
        stringBuffer.append(",");
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.eua);
        stringBuffer.append(",");
        stringBuffer.append(this.ezZ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209123);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209124);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ClickId:").append(this.ezY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PostId:").append(this.ezQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTimeStamp:").append(this.eua);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTab:").append(this.ezZ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209124);
        return stringBuffer2;
    }
}
