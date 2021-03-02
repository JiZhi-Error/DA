package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class aw extends a {
    public String ekB = "";
    public String eqA = "";
    private long eqB = 0;
    public long eqC = 0;
    public long eqD = 0;
    public long eqE = 0;
    public long eqF = 0;
    public long eqG = 0;
    public long eqH = 0;
    public long eqI = 0;
    public long eqJ = 0;
    public long eqK = 0;
    public long eqz = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 14560;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(186345);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eqz);
        stringBuffer.append(",");
        stringBuffer.append(this.eqA);
        stringBuffer.append(",");
        stringBuffer.append(this.eqB);
        stringBuffer.append(",");
        stringBuffer.append(this.eqC);
        stringBuffer.append(",");
        stringBuffer.append(this.ekB);
        stringBuffer.append(",");
        stringBuffer.append(this.eqD);
        stringBuffer.append(",");
        stringBuffer.append(this.eqE);
        stringBuffer.append(",");
        stringBuffer.append(this.eqF);
        stringBuffer.append(",");
        stringBuffer.append(this.eqG);
        stringBuffer.append(",");
        stringBuffer.append(this.eqH);
        stringBuffer.append(",");
        stringBuffer.append(this.eqI);
        stringBuffer.append(",");
        stringBuffer.append(this.eqJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eqK);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(186345);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(186346);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("calledSessionId:").append(this.eqz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("functionName:").append(this.eqA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("interfaceType:").append(this.eqB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("businessType:").append(this.eqC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appId:").append(this.ekB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isFaceDetectVerifySuccess:").append(this.eqD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("totalTime:").append(this.eqE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("faceDetectCount:").append(this.eqF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BeginFaceTime:").append(this.eqG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BeginLivenessTime:").append(this.eqH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BeginVerifyTime:").append(this.eqI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExitFaceTime:").append(this.eqJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CheckAliveType:").append(this.eqK);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(186346);
        return stringBuffer2;
    }
}
