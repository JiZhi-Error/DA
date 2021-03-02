package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ep extends a {
    public long eDV = 0;
    private String eDW = "";
    private String eDX = "";
    public long ejA = 0;
    public long erW = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 17055;
    }

    public final ep rK(String str) {
        AppMethodBeat.i(200108);
        this.eDW = x("FileID", str, true);
        AppMethodBeat.o(200108);
        return this;
    }

    public final ep rL(String str) {
        AppMethodBeat.i(200109);
        this.eDX = x("AesKey", str, true);
        AppMethodBeat.o(200109);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(120834);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.eDV);
        stringBuffer.append(",");
        stringBuffer.append(this.eDW);
        stringBuffer.append(",");
        stringBuffer.append(this.eDX);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(120834);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(120835);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Source:").append(this.eDV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FileID:").append(this.eDW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AesKey:").append(this.eDX);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(120835);
        return stringBuffer2;
    }
}
