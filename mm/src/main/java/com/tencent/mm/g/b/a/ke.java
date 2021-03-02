package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ke extends a {
    private String eOG = "";
    public long eTY;
    public long eTZ;
    private String eUa = "";
    public long eUb;
    public long eUc;
    public String eUd = "";
    public long enl;
    public String erU = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19750;
    }

    public final ke xl(String str) {
        AppMethodBeat.i(201841);
        this.eOG = x("PublishId", str, true);
        AppMethodBeat.o(201841);
        return this;
    }

    public final ke xm(String str) {
        AppMethodBeat.i(201842);
        this.erU = x("Sessionid", str, true);
        AppMethodBeat.o(201842);
        return this;
    }

    public final ke xn(String str) {
        AppMethodBeat.i(201843);
        this.eUa = x("ActionTimeStamp", str, true);
        AppMethodBeat.o(201843);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(201844);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.eOG);
        stringBuffer.append(",");
        stringBuffer.append(this.eTY);
        stringBuffer.append(",");
        stringBuffer.append(this.eTZ);
        stringBuffer.append(",");
        stringBuffer.append(this.erU);
        stringBuffer.append(",");
        stringBuffer.append(this.eUa);
        stringBuffer.append(",");
        stringBuffer.append(this.eUb);
        stringBuffer.append(",");
        stringBuffer.append(this.eUc);
        stringBuffer.append(",");
        stringBuffer.append(this.eUd);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(201844);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(201845);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PublishId:").append(this.eOG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LikeCnt:").append(this.eTY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommCnt:").append(this.eTZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Sessionid:").append(this.erU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTimeStamp:").append(this.eUa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NextAction:").append(this.eUb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposeCnt:").append(this.eUc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NextPublishId:").append(this.eUd);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(201845);
        return stringBuffer2;
    }
}
