package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ih extends a {
    public long eDV;
    private String eJm = "";
    public long eOA;
    public long eOB;
    public long eOq;
    public long eOr;
    public long eOs;
    public long eOt;
    public long eOu;
    public long eOv;
    public long eOw;
    public long eOx;
    public long eOy;
    public long eOz;
    public String err = "";
    public long erx;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18849;
    }

    public final ih we(String str) {
        AppMethodBeat.i(94826);
        this.eJm = x("ToUsername", str, true);
        AppMethodBeat.o(94826);
        return this;
    }

    public final ih wf(String str) {
        AppMethodBeat.i(94827);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(94827);
        return this;
    }

    public final ih ahg() {
        this.eOq = 1;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(94828);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eJm);
        stringBuffer.append(",");
        stringBuffer.append(this.eDV);
        stringBuffer.append(",");
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.erx);
        stringBuffer.append(",");
        stringBuffer.append(this.eOq);
        stringBuffer.append(",");
        stringBuffer.append(this.eOr);
        stringBuffer.append(",");
        stringBuffer.append(this.eOs);
        stringBuffer.append(",");
        stringBuffer.append(this.eOt);
        stringBuffer.append(",");
        stringBuffer.append(this.eOu);
        stringBuffer.append(",");
        stringBuffer.append(this.eOv);
        stringBuffer.append(",");
        stringBuffer.append(this.eOw);
        stringBuffer.append(",");
        stringBuffer.append(this.eOx);
        stringBuffer.append(",");
        stringBuffer.append(this.eOy);
        stringBuffer.append(",");
        stringBuffer.append(this.eOz);
        stringBuffer.append(",");
        stringBuffer.append(this.eOA);
        stringBuffer.append(",");
        stringBuffer.append(this.eOB);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(94828);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(94829);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ToUsername:").append(this.eJm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Source:").append(this.eDV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedType:").append(this.erx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IfAddText:").append(this.eOq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedMediaCount:").append(this.eOr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsClickedFromAlbum:").append(this.eOs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsClickIntoDetail:").append(this.eOt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowsedPicCountAtDetail:").append(this.eOu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowsedPicCountAtGallery:").append(this.eOv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseTimeAtDetail:").append(this.eOw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseTimeAtGallery:").append(this.eOx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CanViewCommentCount:").append(this.eOy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CanViewLikeCount:").append(this.eOz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentFlag:").append(this.eOA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LikeFlag:").append(this.eOB);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(94829);
        return stringBuffer2;
    }
}
