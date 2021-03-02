package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fd extends a {
    private String eEZ = "";
    public long eFa;
    public long eFb;
    public long enE;
    public long enl = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 11090;
    }

    public final fd sa(String str) {
        AppMethodBeat.i(231482);
        this.eEZ = x("SessionName", str, true);
        AppMethodBeat.o(231482);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(231483);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.eEZ);
        stringBuffer.append(",");
        stringBuffer.append(this.enE);
        stringBuffer.append(",");
        stringBuffer.append(this.eFa);
        stringBuffer.append(",");
        stringBuffer.append(this.eFb);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(231483);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(231484);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionName:").append(this.eEZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UnreadCount:").append(this.enE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionType:").append(this.eFa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasEduWindow:").append(this.eFb);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(231484);
        return stringBuffer2;
    }
}
