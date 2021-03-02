package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class hk extends a {
    public long eLQ;
    public long eLR;
    private String eLS = "";
    private String eLT = "";
    private String eLU = "";
    public int eLV;
    public int eLW;
    public int eLX;
    public int enq;
    private String eoK = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20590;
    }

    public final hk ve(String str) {
        AppMethodBeat.i(206899);
        this.eoK = x("UserName", str, true);
        AppMethodBeat.o(206899);
        return this;
    }

    public final hk vf(String str) {
        AppMethodBeat.i(206900);
        this.eLS = x("PattedUserName", str, true);
        AppMethodBeat.o(206900);
        return this;
    }

    public final hk vg(String str) {
        AppMethodBeat.i(206901);
        this.eLT = x("PatSuffix", str, true);
        AppMethodBeat.o(206901);
        return this;
    }

    public final hk vh(String str) {
        AppMethodBeat.i(206902);
        this.eLU = x("ChatRoomName", str, true);
        AppMethodBeat.o(206902);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(206903);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enq);
        stringBuffer.append(",");
        stringBuffer.append(this.eLQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eLR);
        stringBuffer.append(",");
        stringBuffer.append(this.eoK);
        stringBuffer.append(",");
        stringBuffer.append(this.eLS);
        stringBuffer.append(",");
        stringBuffer.append(this.eLT);
        stringBuffer.append(",");
        stringBuffer.append(this.eLU);
        stringBuffer.append(",");
        stringBuffer.append(this.eLV);
        stringBuffer.append(",");
        stringBuffer.append(this.eLW);
        stringBuffer.append(",");
        stringBuffer.append(this.eLX);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(206903);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(206904);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.enq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PatTime:").append(this.eLQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RevokeTime:").append(this.eLR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UserName:").append(this.eoK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PattedUserName:").append(this.eLS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PatSuffix:").append(this.eLT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChatRoomName:").append(this.eLU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RevokeMethod:").append(this.eLV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsSuccess:").append(this.eLW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RevokeAction:").append(this.eLX);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(206904);
        return stringBuffer2;
    }
}
