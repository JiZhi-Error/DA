package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class id extends a {
    public long eJj = 0;
    public String eJk = "";
    public String eMN = "";
    public int eMW;
    public int eMX;
    public long eMY;
    public long eMZ = 0;
    public long eNa = 0;
    public long eNb = 0;
    public long eNc;
    public long eNd;
    public long eNe;
    public long eNf = 0;
    public long eNg = 0;
    public long eNh = 0;
    public long eNi = 0;
    public String eNj = "";
    public long eNk;
    public long eNl;
    public long eNm;
    public long eNn = 0;
    public long eNo = 0;
    public int eNp = 0;
    public long eNq = 0;
    public long eNr;
    public long eNs;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20518;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(187899);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eMN);
        stringBuffer.append(",");
        stringBuffer.append(this.eMW);
        stringBuffer.append(",");
        stringBuffer.append(this.eMX);
        stringBuffer.append(",");
        stringBuffer.append(this.eMY);
        stringBuffer.append(",");
        stringBuffer.append(this.eMZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eJj);
        stringBuffer.append(",");
        stringBuffer.append(this.eJk);
        stringBuffer.append(",");
        stringBuffer.append(this.eNa);
        stringBuffer.append(",");
        stringBuffer.append(this.eNb);
        stringBuffer.append(",");
        stringBuffer.append(this.eNc);
        stringBuffer.append(",");
        stringBuffer.append(this.eNd);
        stringBuffer.append(",");
        stringBuffer.append(this.eNe);
        stringBuffer.append(",");
        stringBuffer.append(this.eNf);
        stringBuffer.append(",");
        stringBuffer.append(this.eNg);
        stringBuffer.append(",");
        stringBuffer.append(this.eNh);
        stringBuffer.append(",");
        stringBuffer.append(this.eNi);
        stringBuffer.append(",");
        stringBuffer.append(this.eNj);
        stringBuffer.append(",");
        stringBuffer.append(this.eNk);
        stringBuffer.append(",");
        stringBuffer.append(this.eNl);
        stringBuffer.append(",");
        stringBuffer.append(this.eNm);
        stringBuffer.append(",");
        stringBuffer.append(this.eNn);
        stringBuffer.append(",");
        stringBuffer.append(this.eNo);
        stringBuffer.append(",");
        stringBuffer.append(this.eNp);
        stringBuffer.append(",");
        stringBuffer.append(this.eNq);
        stringBuffer.append(",");
        stringBuffer.append(this.eNr);
        stringBuffer.append(",");
        stringBuffer.append(this.eNs);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(187899);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(187900);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RoomId:").append(this.eMN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsSharable:").append(this.eMW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasClickedShareEntrance:").append(this.eMX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("InvitedCount:").append(this.eMY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DefaultShareCount:").append(this.eMZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinalShareCount:").append(this.eJj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinalShareCountByType:").append(this.eJk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinalShareSize:").append(this.eNa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExceedCountPopupCount:").append(this.eNb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExceedSizePopupCount:").append(this.eNc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickClearCount:").append(this.eNd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SlideSelectCount:").append(this.eNe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SlideUnSelectCount:").append(this.eNf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickSelectCount:").append(this.eNg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickUnSelectCount:").append(this.eNh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UploadTimeCost:").append(this.eNi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("InvitedUsrs:").append(this.eNj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinalStatus:").append(this.eNk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ManualReTryTime:").append(this.eNl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinalShareTextSize:").append(this.eNm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ReSelectUpSize:").append(this.eNn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ReSelectUpCount:").append(this.eNo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsAssociate:").append(this.eNp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UploadFailedCount:").append(this.eNq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UploadWaitPopupCount:").append(this.eNr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UploadFailPopupCount:").append(this.eNs);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(187900);
        return stringBuffer2;
    }
}
