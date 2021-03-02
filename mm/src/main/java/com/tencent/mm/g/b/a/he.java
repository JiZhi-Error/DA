package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class he extends a {
    public long eLv = 0;
    private String eLw = "";
    public long eLx = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16872;
    }

    public final he bwA(String str) {
        AppMethodBeat.i(263515);
        this.eLw = x("emoticonMd5", str, true);
        AppMethodBeat.o(263515);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(149924);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eLv);
        stringBuffer.append(",");
        stringBuffer.append(this.eLw);
        stringBuffer.append(",");
        stringBuffer.append(this.eLx);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(149924);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(149925);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SendScene:").append(this.eLv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("emoticonMd5:").append(this.eLw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("hasTxt:").append(this.eLx);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(149925);
        return stringBuffer2;
    }
}
