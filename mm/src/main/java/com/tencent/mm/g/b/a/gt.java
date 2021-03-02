package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gt extends a {
    private String eKU = "";
    private String eKV = "";
    public long ejW;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20246;
    }

    public final gt uw(String str) {
        AppMethodBeat.i(193997);
        this.eKU = x("roomID", str, true);
        AppMethodBeat.o(193997);
        return this;
    }

    public final gt ux(String str) {
        AppMethodBeat.i(193998);
        this.eKV = x("oldRoomID", str, true);
        AppMethodBeat.o(193998);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(193999);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eKU);
        stringBuffer.append(",");
        stringBuffer.append(this.eKV);
        stringBuffer.append(",");
        stringBuffer.append(this.ejW);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(193999);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(194000);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("roomID:").append(this.eKU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("oldRoomID:").append(this.eKV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action:").append(this.ejW);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(194000);
        return stringBuffer2;
    }
}
