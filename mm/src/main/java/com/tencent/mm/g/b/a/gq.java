package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gq extends a {
    private String eKK = "";
    public long erw = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15848;
    }

    public final gq us(String str) {
        AppMethodBeat.i(149912);
        this.eKK = x("chatRoomUserName", str, true);
        AppMethodBeat.o(149912);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(149913);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eKK);
        stringBuffer.append(",");
        stringBuffer.append(this.erw);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(149913);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(149914);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("chatRoomUserName:").append(this.eKK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene:").append(this.erw);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(149914);
        return stringBuffer2;
    }
}
