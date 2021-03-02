package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class af extends a {
    public long ejW;
    private String enK = "";
    public long enM = 0;
    public long enP;
    public long enQ = 0;
    public String enR = "";
    public String enS = "";
    public long enT = 0;
    public String enU = "";
    public String enV = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19436;
    }

    public final af ik(String str) {
        AppMethodBeat.i(184764);
        this.enK = x("roomusrname", str, true);
        AppMethodBeat.o(184764);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(184765);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enK);
        stringBuffer.append(",");
        stringBuffer.append(this.ejW);
        stringBuffer.append(",");
        stringBuffer.append(this.enP);
        stringBuffer.append(",");
        stringBuffer.append(this.enQ);
        stringBuffer.append(",");
        stringBuffer.append(this.enM);
        stringBuffer.append(",");
        stringBuffer.append(this.enR);
        stringBuffer.append(",");
        stringBuffer.append(this.enS);
        stringBuffer.append(",");
        stringBuffer.append(this.enT);
        stringBuffer.append(",");
        stringBuffer.append(this.enU);
        stringBuffer.append(",");
        stringBuffer.append(this.enV);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(184765);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(184766);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("roomusrname:").append(this.enK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action:").append(this.ejW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("topCount:").append(this.enP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("usedCount:").append(this.enQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("role:").append(this.enM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appid:").append(this.enR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appname:").append(this.enS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isTop:").append(this.enT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("topAppList:").append(this.enU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("usedAppList:").append(this.enV);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(184766);
        return stringBuffer2;
    }
}
