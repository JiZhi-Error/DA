package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class hu extends a {
    public long eLQ;
    private String eLS = "";
    private String eLT = "";
    public int eLV;
    public int eLX;
    public long eMu;
    public int eMv;
    public int eMw;
    public int eMx;
    public int eMy;
    private String enA = "";
    public int enq;
    public int eqN;
    private String etW = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19878;
    }

    public final hu vx(String str) {
        AppMethodBeat.i(206905);
        this.etW = x("Username", str, true);
        AppMethodBeat.o(206905);
        return this;
    }

    public final hu vy(String str) {
        AppMethodBeat.i(206906);
        this.eLS = x("PattedUserName", str, true);
        AppMethodBeat.o(206906);
        return this;
    }

    public final hu vz(String str) {
        AppMethodBeat.i(206907);
        this.enA = x("ChatroomName", str, true);
        AppMethodBeat.o(206907);
        return this;
    }

    public final hu vA(String str) {
        AppMethodBeat.i(206908);
        this.eLT = x("PatSuffix", str, true);
        AppMethodBeat.o(206908);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(206909);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enq);
        stringBuffer.append(",");
        stringBuffer.append(this.eLQ);
        stringBuffer.append(",");
        stringBuffer.append(this.etW);
        stringBuffer.append(",");
        stringBuffer.append(this.eLS);
        stringBuffer.append(",");
        stringBuffer.append(this.enA);
        stringBuffer.append(",");
        stringBuffer.append(this.eqN);
        stringBuffer.append(",");
        stringBuffer.append(this.eMu);
        stringBuffer.append(",");
        stringBuffer.append(this.eMv);
        stringBuffer.append(",");
        stringBuffer.append(this.eMw);
        stringBuffer.append(",");
        stringBuffer.append(this.eMx);
        stringBuffer.append(",");
        stringBuffer.append(this.eLT);
        stringBuffer.append(",");
        stringBuffer.append(this.eLX);
        stringBuffer.append(",");
        stringBuffer.append(this.eLV);
        stringBuffer.append(",");
        stringBuffer.append(this.eMy);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(206909);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(206910);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.enq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PatTime:").append(this.eLQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Username:").append(this.etW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PattedUserName:").append(this.eLS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChatroomName:").append(this.enA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ErrorCode:").append(this.eqN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TimeInterval:").append(this.eMu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsHitLocalFrequency:").append(this.eMv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsCreateNewChat:").append(this.eMw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PatSequence:").append(this.eMx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PatSuffix:").append(this.eLT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RevokeAction:").append(this.eLX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RevokeMethod:").append(this.eLV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsEducationGuidance:").append(this.eMy);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(206910);
        return stringBuffer2;
    }
}
