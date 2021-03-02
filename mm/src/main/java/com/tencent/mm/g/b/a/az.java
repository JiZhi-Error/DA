package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class az extends a {
    public long eqP;
    public long eqQ;
    public long eqR;
    public int eqS;
    public int eqT;
    public int eqU;
    public int eqV;
    public long eqW;
    public long eqX;
    public long eqY;
    private String eqZ = "";
    private String era = "";
    public int erb;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21131;
    }

    public final az iG(String str) {
        AppMethodBeat.i(186355);
        this.eqZ = x("StateRecord", str, true);
        AppMethodBeat.o(186355);
        return this;
    }

    public final az iH(String str) {
        AppMethodBeat.i(186356);
        this.era = x("AndroidStateRecord", str, true);
        AppMethodBeat.o(186356);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(186357);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eqP);
        stringBuffer.append(",");
        stringBuffer.append(this.eqQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eqR);
        stringBuffer.append(",");
        stringBuffer.append(this.eqS);
        stringBuffer.append(",");
        stringBuffer.append(this.eqT);
        stringBuffer.append(",");
        stringBuffer.append(this.eqU);
        stringBuffer.append(",");
        stringBuffer.append(this.eqV);
        stringBuffer.append(",");
        stringBuffer.append(this.eqW);
        stringBuffer.append(",");
        stringBuffer.append(this.eqX);
        stringBuffer.append(",");
        stringBuffer.append(this.eqY);
        stringBuffer.append(",");
        stringBuffer.append(this.eqZ);
        stringBuffer.append(",");
        stringBuffer.append(this.era);
        stringBuffer.append(",");
        stringBuffer.append(this.erb);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(186357);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(186358);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ResultCode:").append(this.eqP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AliveType:").append(this.eqQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinalState:").append(this.eqR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PrepareCgiErrorCode:").append(this.eqS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ConfigCgiErrorCode:").append(this.eqT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CdnErrorCode:").append(this.eqU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VerifyCgiErrorCode:").append(this.eqV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CdnCost:").append(this.eqW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LivenessCost:").append(this.eqX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ResetCount:").append(this.eqY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StateRecord:").append(this.eqZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AndroidStateRecord:").append(this.era);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FaceReset:").append(this.erb);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(186358);
        return stringBuffer2;
    }
}
