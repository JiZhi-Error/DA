package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ay extends a {
    public long eqP;
    public long eqQ;
    public long eqR;
    private int eqS;
    public int eqT;
    public int eqU;
    public int eqV;
    public long eqW;
    public long eqX;
    public long eqY;
    private String eqZ = "";
    private String era = "";
    public int erb;
    public long erc = 0;
    public long erd = 0;
    public long ere = 0;
    public long erf = 0;
    public long erg = 0;
    public long erh = 0;
    public long eri = 0;
    public long erj = 0;
    public long erk = 0;
    private String erl = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21130;
    }

    public final ay iD(String str) {
        AppMethodBeat.i(186350);
        this.eqZ = x("StateRecord", str, true);
        AppMethodBeat.o(186350);
        return this;
    }

    public final ay iE(String str) {
        AppMethodBeat.i(186351);
        this.era = x("AndroidStateRecord", str, true);
        AppMethodBeat.o(186351);
        return this;
    }

    public final ay iF(String str) {
        AppMethodBeat.i(186352);
        this.erl = x("BioId", str, true);
        AppMethodBeat.o(186352);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(186353);
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
        stringBuffer.append(",");
        stringBuffer.append(this.erc);
        stringBuffer.append(",");
        stringBuffer.append(this.erd);
        stringBuffer.append(",");
        stringBuffer.append(this.ere);
        stringBuffer.append(",");
        stringBuffer.append(this.erf);
        stringBuffer.append(",");
        stringBuffer.append(this.erg);
        stringBuffer.append(",");
        stringBuffer.append(this.erh);
        stringBuffer.append(",");
        stringBuffer.append(this.eri);
        stringBuffer.append(",");
        stringBuffer.append(this.erj);
        stringBuffer.append(",");
        stringBuffer.append(this.erk);
        stringBuffer.append(",");
        stringBuffer.append(this.erl);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(186353);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(186354);
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
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ConfirmPageTimeStamp:").append(this.erc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FlashUIPageTimeStamp:").append(this.erd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ReqConfigTimeStamp:").append(this.ere);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RspConfigTimeStamp:").append(this.erf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VerifyStartTimeStamp:").append(this.erg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VerifyEndTimeStamp:").append(this.erh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CdnEndTimeStamp:").append(this.eri);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RspVerifyTimeStamp:").append(this.erj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExitVerifyTimeStamp:").append(this.erk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BioId:").append(this.erl);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(186354);
        return stringBuffer2;
    }
}
