package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class lj extends a {
    public long eEP = 0;
    private String eXp = "";
    public long eYC = 0;
    public long eYD = 0;
    private String eYE = "";
    private String eiB = "";
    public long enl = 0;
    public long etp = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20996;
    }

    public final lj aiB() {
        this.enl = 2;
        return this;
    }

    public final lj uR(long j2) {
        this.eYC = j2;
        return this;
    }

    public final lj uS(long j2) {
        this.eYD = j2;
        return this;
    }

    public final lj uT(long j2) {
        this.eEP = j2;
        return this;
    }

    public final lj uU(long j2) {
        this.etp = j2;
        return this;
    }

    public final lj yD(String str) {
        AppMethodBeat.i(187812);
        this.eYE = x("EnterSceneId", str, true);
        AppMethodBeat.o(187812);
        return this;
    }

    public final lj yE(String str) {
        AppMethodBeat.i(187813);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(187813);
        return this;
    }

    public final lj yF(String str) {
        AppMethodBeat.i(187814);
        this.eXp = x("QueryKey", str, true);
        AppMethodBeat.o(187814);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(187815);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.eYC);
        stringBuffer.append(",");
        stringBuffer.append(this.eYD);
        stringBuffer.append(",");
        stringBuffer.append(this.eEP);
        stringBuffer.append(",");
        stringBuffer.append(this.etp);
        stringBuffer.append(",");
        stringBuffer.append(this.eYE);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eXp);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(187815);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(187816);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DismissType:").append(this.eYC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionSourceType:").append(this.eYD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterTimeStamp:").append(this.eEP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterScene:").append(this.etp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterSceneId:").append(this.eYE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("QueryKey:").append(this.eXp);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(187816);
        return stringBuffer2;
    }
}
