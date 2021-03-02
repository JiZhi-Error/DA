package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gy extends a {
    public long eLg = 0;
    private String eLh = "";
    private String eLi = "";
    public int eLj;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19959;
    }

    public final gy uN(String str) {
        AppMethodBeat.i(231490);
        this.eLi = x("RoomName", str, true);
        AppMethodBeat.o(231490);
        return this;
    }

    public final gy uO(String str) {
        AppMethodBeat.i(231491);
        this.eLh = x("AppList", str, true);
        AppMethodBeat.o(231491);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(231492);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eLi);
        stringBuffer.append(",");
        stringBuffer.append(this.eLg);
        stringBuffer.append(",");
        stringBuffer.append(this.eLh);
        stringBuffer.append(",");
        stringBuffer.append(this.eLj);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(231492);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(231493);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RoomName:").append(this.eLi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsRedDot:").append(this.eLg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppList:").append(this.eLh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PanelPage:").append(this.eLj);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(231493);
        return stringBuffer2;
    }
}
