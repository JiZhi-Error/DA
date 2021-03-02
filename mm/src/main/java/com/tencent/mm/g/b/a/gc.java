package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gc extends a {
    public long eIu;
    public long eIv;
    public long ejW;
    private String els = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19818;
    }

    public final gc tm(String str) {
        AppMethodBeat.i(186334);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(186334);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(186335);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.ejW);
        stringBuffer.append(",");
        stringBuffer.append(this.eIu);
        stringBuffer.append(",");
        stringBuffer.append(this.eIv);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(186335);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(186336);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action:").append(this.ejW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("errortype:").append(this.eIu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("pageid:").append(this.eIv);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(186336);
        return stringBuffer2;
    }
}
