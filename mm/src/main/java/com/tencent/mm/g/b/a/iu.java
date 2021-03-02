package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class iu extends a {
    public long eDV;
    public String ePK = "";
    public long ePL;
    private long ePM;
    private long ePN;
    private int ePO;
    public long ePP;
    public long ePQ;
    public long ePR;
    private long ePS;
    public long ePT;
    public long ePU;
    public long ePV;
    public long ePW;
    public long ePX;
    public long ePY;
    public long ePZ;
    public long eQa;
    public long eQb;
    public long eQc;
    public String eQd = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18840;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(94849);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ePK);
        stringBuffer.append(",");
        stringBuffer.append(this.eDV);
        stringBuffer.append(",");
        stringBuffer.append(this.ePL);
        stringBuffer.append(",");
        stringBuffer.append(this.ePM);
        stringBuffer.append(",");
        stringBuffer.append(this.ePN);
        stringBuffer.append(",");
        stringBuffer.append(this.ePO);
        stringBuffer.append(",");
        stringBuffer.append(this.ePP);
        stringBuffer.append(",");
        stringBuffer.append(this.ePQ);
        stringBuffer.append(",");
        stringBuffer.append(this.ePR);
        stringBuffer.append(",");
        stringBuffer.append(this.ePS);
        stringBuffer.append(",");
        stringBuffer.append(this.ePT);
        stringBuffer.append(",");
        stringBuffer.append(this.ePU);
        stringBuffer.append(",");
        stringBuffer.append(this.ePV);
        stringBuffer.append(",");
        stringBuffer.append(this.ePW);
        stringBuffer.append(",");
        stringBuffer.append(this.ePX);
        stringBuffer.append(",");
        stringBuffer.append(this.ePY);
        stringBuffer.append(",");
        stringBuffer.append(this.ePZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eQa);
        stringBuffer.append(",");
        stringBuffer.append(this.eQb);
        stringBuffer.append(",");
        stringBuffer.append(this.eQc);
        stringBuffer.append(",");
        stringBuffer.append(this.eQd);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(94849);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(94850);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OwnerUsername:").append(this.ePK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Source:").append(this.eDV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsFriend:").append(this.ePL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OwnerSetting:").append(this.ePM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OwnerPrivacySetting:").append(this.ePN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Sessionid:").append(this.ePO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AlbumEntrancePicCount:").append(this.ePP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AlbumExplodeFeedCount:").append(this.ePQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AlbumClickFeedCount:").append(this.ePR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AlbumClickFeedList:").append(this.ePS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AlbumTimelineStayTime:").append(this.ePT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AlbumTimeDragCount:").append(this.ePU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LikeBanner:").append(this.ePV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GalleryBrowseFeedCount:").append(this.ePW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GalleryBrowsePictureCount:").append(this.ePX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GalleryStayTime:").append(this.ePY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedDetailPageBrowseFeedCount:").append(this.ePZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedDetailPageBrowsePictureCount:").append(this.eQa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedDetailPageStayTime:").append(this.eQb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TotalStayTime:").append(this.eQc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AlbumClickFeedListStr:").append(this.eQd);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(94850);
        return stringBuffer2;
    }
}
