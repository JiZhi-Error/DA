package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class kd extends a {
    public long eLd;
    public long eMG;
    public long eMH;
    public long eTD;
    public long eTE;
    public String eTH = "";
    public String eTM = "";
    public long eTN;
    public String eTO = "";
    public long eTP;
    public long eTQ;
    public long eTR;
    public long eTS;
    public long eTT;
    public long eTU;
    public long eTV;
    public long eTW;
    public long eTX;
    public String eiB = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19055;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(179061);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eTM);
        stringBuffer.append(",");
        stringBuffer.append(this.eTN);
        stringBuffer.append(",");
        stringBuffer.append(this.eTO);
        stringBuffer.append(",");
        stringBuffer.append(this.eTP);
        stringBuffer.append(",");
        stringBuffer.append(this.eTQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eTR);
        stringBuffer.append(",");
        stringBuffer.append(this.eTS);
        stringBuffer.append(",");
        stringBuffer.append(this.eTT);
        stringBuffer.append(",");
        stringBuffer.append(this.eLd);
        stringBuffer.append(",");
        stringBuffer.append(this.eMG);
        stringBuffer.append(",");
        stringBuffer.append(this.eMH);
        stringBuffer.append(",");
        stringBuffer.append(this.eTD);
        stringBuffer.append(",");
        stringBuffer.append(this.eTU);
        stringBuffer.append(",");
        stringBuffer.append(this.eTV);
        stringBuffer.append(",");
        stringBuffer.append(this.eTW);
        stringBuffer.append(",");
        stringBuffer.append(this.eTX);
        stringBuffer.append(",");
        stringBuffer.append(this.eTH);
        stringBuffer.append(",");
        stringBuffer.append(this.eTE);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(179061);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(179062);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NewFeeds:").append(this.eTM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NewFeedsCount:").append(this.eTN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposureNewFeeds:").append(this.eTO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposureNewFeedsCount:").append(this.eTP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MissReadBreakLayersCount:").append(this.eTQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("JumpableMissReadBreakLayersCount:").append(this.eTR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MissReadJumpBtnExposureCount:").append(this.eTS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MissReadJumpBtnClickCount:").append(this.eTT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Seq:").append(this.eLd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SubSeq:").append(this.eMG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SubSeqSum:").append(this.eMH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MissReadJumpBtnId:").append(this.eTD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MissReadJumpBtnClickType:").append(this.eTU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MissReadJumpBtnFirstExposureTime:").append(this.eTV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("JumpBreakLayerFeedCount:").append(this.eTW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("JumpBreakLayerWeishangFeedCount:").append(this.eTX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("JumpBreakLayerFeeds:").append(this.eTH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MissReadJumpBreakLayerId:").append(this.eTE);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(179062);
        return stringBuffer2;
    }
}
