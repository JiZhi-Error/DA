package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class kc extends a {
    public long eLd;
    public long eMG;
    public long eMH;
    public long eTD;
    public long eTE;
    public long eTF;
    public long eTG;
    public String eTH = "";
    public long eTI;
    public String eTJ = "";
    public long eTK;
    public long eTL;
    public String eiB = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19056;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(179059);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eTD);
        stringBuffer.append(",");
        stringBuffer.append(this.eTE);
        stringBuffer.append(",");
        stringBuffer.append(this.eTF);
        stringBuffer.append(",");
        stringBuffer.append(this.eTG);
        stringBuffer.append(",");
        stringBuffer.append(this.eTH);
        stringBuffer.append(",");
        stringBuffer.append(this.eTI);
        stringBuffer.append(",");
        stringBuffer.append(this.eTJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eTK);
        stringBuffer.append(",");
        stringBuffer.append(this.eTL);
        stringBuffer.append(",");
        stringBuffer.append(this.eLd);
        stringBuffer.append(",");
        stringBuffer.append(this.eMG);
        stringBuffer.append(",");
        stringBuffer.append(this.eMH);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(179059);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(179060);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MissReadJumpBtnId:").append(this.eTD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MissReadJumpBreakLayerId:").append(this.eTE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsJumpToNearestBreakLayer:").append(this.eTF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("JumpSkipFeedsCount:").append(this.eTG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("JumpBreakLayerFeeds:").append(this.eTH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("JumpBreakLayerFeedsCount:").append(this.eTI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("JumpBreakLayerExposureFeeds:").append(this.eTJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("JumpBreakLayerExposureFeedsCount:").append(this.eTK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BreakLayerFirstFeedFromNow:").append(this.eTL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Seq:").append(this.eLd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SubSeq:").append(this.eMG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SubSeqSum:").append(this.eMH);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(179060);
        return stringBuffer2;
    }
}
