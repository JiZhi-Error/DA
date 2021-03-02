package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ir extends a {
    private String eOG = "";
    public int ePy = -1;
    public int ePz = -1;
    public int eki = -1;
    public int enq = -1;
    private String etW = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18197;
    }

    public final ir wq(String str) {
        AppMethodBeat.i(94845);
        this.etW = x("Username", str, true);
        AppMethodBeat.o(94845);
        return this;
    }

    public final ir wr(String str) {
        AppMethodBeat.i(94846);
        this.eOG = x("PublishId", str, true);
        AppMethodBeat.o(94846);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(94847);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.etW);
        stringBuffer.append(",");
        stringBuffer.append(this.eOG);
        stringBuffer.append(",");
        stringBuffer.append(this.eki);
        stringBuffer.append(",");
        stringBuffer.append(this.ePy);
        stringBuffer.append(",");
        stringBuffer.append(this.enq);
        stringBuffer.append(",");
        stringBuffer.append(this.ePz);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(94847);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(94848);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Username:").append(this.etW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PublishId:").append(this.eOG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.eki);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OnDestroyAction:").append(this.ePy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.enq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StayTime:").append(this.ePz);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(94848);
        return stringBuffer2;
    }
}
