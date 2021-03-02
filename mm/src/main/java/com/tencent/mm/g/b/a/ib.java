package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ib extends a {
    public String eMN = "";
    public long eMO;
    public long eMP = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20543;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(187893);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eMN);
        stringBuffer.append(",");
        stringBuffer.append(this.eMO);
        stringBuffer.append(",");
        stringBuffer.append(this.eMP);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(187893);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(187894);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RoomId:").append(this.eMN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UserRole:").append(this.eMO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HistoryID:").append(this.eMP);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(187894);
        return stringBuffer2;
    }
}
