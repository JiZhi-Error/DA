package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ic extends a {
    private String eMN = "";
    public long eMP = 0;
    public long eMQ;
    public long eMR = 0;
    public long eMS = 0;
    public long eMT;
    public long eMU;
    private String eMV = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20542;
    }

    public final ic vL(String str) {
        AppMethodBeat.i(187895);
        this.eMN = x("RoomId", str, true);
        AppMethodBeat.o(187895);
        return this;
    }

    public final ic vM(String str) {
        AppMethodBeat.i(187896);
        this.eMV = x("ToUsers", str, true);
        AppMethodBeat.o(187896);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(187897);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eMN);
        stringBuffer.append(",");
        stringBuffer.append(this.eMQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eMR);
        stringBuffer.append(",");
        stringBuffer.append(this.eMS);
        stringBuffer.append(",");
        stringBuffer.append(this.eMT);
        stringBuffer.append(",");
        stringBuffer.append(this.eMU);
        stringBuffer.append(",");
        stringBuffer.append(this.eMP);
        stringBuffer.append(",");
        stringBuffer.append(this.eMV);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(187897);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(187898);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RoomId:").append(this.eMN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OrigInvitedUV:").append(this.eMQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AvailUV:").append(this.eMR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Opt:").append(this.eMS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ToUV:").append(this.eMT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinalResult:").append(this.eMU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HistoryID:").append(this.eMP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ToUsers:").append(this.eMV);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(187898);
        return stringBuffer2;
    }
}
