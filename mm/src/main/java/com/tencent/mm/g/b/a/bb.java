package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bb extends a {
    private String eiB = "";
    private String err = "";
    private long ers;
    private long ert;
    private long eru;
    private String erv = "";
    private long erw;
    private long erx;
    private long ery;
    private long erz;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19185;
    }

    public final bb iI(String str) {
        AppMethodBeat.i(208842);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(208842);
        return this;
    }

    public final bb iJ(String str) {
        AppMethodBeat.i(208843);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(208843);
        return this;
    }

    public final bb cX(long j2) {
        this.ers = j2;
        return this;
    }

    public final bb cY(long j2) {
        this.ert = j2;
        return this;
    }

    public final bb cZ(long j2) {
        this.eru = j2;
        return this;
    }

    public final bb iK(String str) {
        AppMethodBeat.i(208844);
        this.erv = x("CurrentPageName", str, true);
        AppMethodBeat.o(208844);
        return this;
    }

    public final bb da(long j2) {
        this.erw = j2;
        return this;
    }

    public final bb db(long j2) {
        this.erx = j2;
        return this;
    }

    public final bb dc(long j2) {
        this.ery = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208845);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.ers);
        stringBuffer.append(",");
        stringBuffer.append(this.ert);
        stringBuffer.append(",");
        stringBuffer.append(this.eru);
        stringBuffer.append(",");
        stringBuffer.append(this.erv);
        stringBuffer.append(",");
        stringBuffer.append(this.erw);
        stringBuffer.append(",");
        stringBuffer.append(this.erx);
        stringBuffer.append(",");
        stringBuffer.append(this.ery);
        stringBuffer.append(",");
        stringBuffer.append(this.erz);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208845);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208846);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedLikeCount:").append(this.ers);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedCommentCount:").append(this.ert);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedFriLikeCount:").append(this.eru);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CurrentPageName:").append(this.erv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene:").append(this.erw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedType:").append(this.erx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentScene:").append(this.ery);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("InnerVersion:").append(this.erz);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208846);
        return stringBuffer2;
    }
}
