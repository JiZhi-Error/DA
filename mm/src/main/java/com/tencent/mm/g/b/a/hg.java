package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class hg extends a {
    public long eLv = 0;
    private String eLw = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16868;
    }

    public final hg uV(String str) {
        AppMethodBeat.i(162225);
        this.eLw = x("emoticonMd5", str, true);
        AppMethodBeat.o(162225);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(149928);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eLv);
        stringBuffer.append(",");
        stringBuffer.append(this.eLw);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(149928);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(149929);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SendScene:").append(this.eLv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("emoticonMd5:").append(this.eLw);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(149929);
        return stringBuffer2;
    }
}
