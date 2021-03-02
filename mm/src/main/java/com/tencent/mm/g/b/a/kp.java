package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class kp extends a {
    public long eWC = 0;
    public long eWD = 0;
    public long eWE = 0;
    public long eWF = 0;
    public long eWG = 0;
    public long eWH = 0;
    public long eWI = 0;
    public long eWJ = 0;
    public long eWK = 0;
    public long eWL = 0;
    public long eWM = 0;
    public long eWN = 0;
    public long eWO = 0;
    public long eWP = 0;
    public long eWQ = 0;
    public long eWR = 0;
    public long eWS = 0;
    public long eWT = 0;
    public long eWU = 0;
    public long eWV = 0;
    public long eWW = 0;
    public long eWX = 0;
    public long eWY = 0;
    public long eWZ = 0;
    public long eXa = 0;
    public long eXb = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16375;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(43456);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eWC);
        stringBuffer.append(",");
        stringBuffer.append(this.eWD);
        stringBuffer.append(",");
        stringBuffer.append(this.eWE);
        stringBuffer.append(",");
        stringBuffer.append(this.eWF);
        stringBuffer.append(",");
        stringBuffer.append(this.eWG);
        stringBuffer.append(",");
        stringBuffer.append(this.eWH);
        stringBuffer.append(",");
        stringBuffer.append(this.eWI);
        stringBuffer.append(",");
        stringBuffer.append(this.eWJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eWK);
        stringBuffer.append(",");
        stringBuffer.append(this.eWL);
        stringBuffer.append(",");
        stringBuffer.append(this.eWM);
        stringBuffer.append(",");
        stringBuffer.append(this.eWN);
        stringBuffer.append(",");
        stringBuffer.append(this.eWO);
        stringBuffer.append(",");
        stringBuffer.append(this.eWP);
        stringBuffer.append(",");
        stringBuffer.append(this.eWQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eWR);
        stringBuffer.append(",");
        stringBuffer.append(this.eWS);
        stringBuffer.append(",");
        stringBuffer.append(this.eWT);
        stringBuffer.append(",");
        stringBuffer.append(this.eWU);
        stringBuffer.append(",");
        stringBuffer.append(this.eWV);
        stringBuffer.append(",");
        stringBuffer.append(this.eWW);
        stringBuffer.append(",");
        stringBuffer.append(this.eWX);
        stringBuffer.append(",");
        stringBuffer.append(this.eWY);
        stringBuffer.append(",");
        stringBuffer.append(this.eWZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eXa);
        stringBuffer.append(",");
        stringBuffer.append(this.eXb);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43456);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43457);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("isBindPhone:").append(this.eWC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("bindSuccess:").append(this.eWD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("getPhoneNumberCount:").append(this.eWE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickConfirmCount:").append(this.eWF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickDenyCount:").append(this.eWG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickCancelCount:").append(this.eWH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("confirmBindedPhoneCount:").append(this.eWI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("confirmUnBindPhoneCount:").append(this.eWJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickInfoCount:").append(this.eWK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickUseOtherPhoneCount:").append(this.eWL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickManagePhoneCount:").append(this.eWM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickGetVerifyCodeCount:").append(this.eWN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("getVerifyCodeSuccessCount:").append(this.eWO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("getVerifyCodeFailedCount:").append(this.eWP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickAddPhoneDoneCount:").append(this.eWQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("addPhoneSuccessCount:").append(this.eWR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("addPhoneFailedCount:").append(this.eWS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("addPhoneAndSaveCount:").append(this.eWT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("addPhoneNotSaveCount:").append(this.eWU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickAddPhoneOnManagePageCount:").append(this.eWV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("deletePhoneCount:").append(this.eWW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("deletePhoneSuccessCount:").append(this.eWX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("deletePhoneFailedCount:").append(this.eWY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("verifyCodeCount:").append(this.eWZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("verifyCodeSuccessCount:").append(this.eXa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("verifyCodeFailedCount:").append(this.eXb);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43457);
        return stringBuffer2;
    }
}
