package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ey extends a {
    public long eEI = 0;
    public long eEJ = 0;
    public long eEK = 0;
    public long eEL = 0;
    public long eEM = 0;
    private String eEN = "";
    public long eEO = 0;
    public long enl = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16724;
    }

    public final ey rU(String str) {
        AppMethodBeat.i(149909);
        this.eEN = x("EmoticonMd5", str, true);
        AppMethodBeat.o(149909);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(149910);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.eEI);
        stringBuffer.append(",");
        stringBuffer.append(this.eEJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eEK);
        stringBuffer.append(",");
        stringBuffer.append(this.eEL);
        stringBuffer.append(",");
        stringBuffer.append(this.eEM);
        stringBuffer.append(",");
        stringBuffer.append(this.eEN);
        stringBuffer.append(",");
        stringBuffer.append(this.eEO);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(149910);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(149911);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Content:").append(this.eEI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChangeAmountTimes:").append(this.eEJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AddSelfieEmoticonTimes:").append(this.eEK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AddCustonEmoticonTimes:").append(this.eEL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AddSelfieEmoticonFormBoardTimes:").append(this.eEM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EmoticonMd5:").append(this.eEN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AddShopEmoticonTimes:").append(this.eEO);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(149911);
        return stringBuffer2;
    }
}
