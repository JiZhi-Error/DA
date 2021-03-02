package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class eg extends a {
    private long eCD;
    private String eiB = "";
    private long ers;
    private long ert;
    private long eru;
    private String erv = "";
    private long erw;
    private String esS = "";
    private String esT = "";
    private long esU;
    private long esV;
    private String euI = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19186;
    }

    public final eg qM(String str) {
        AppMethodBeat.i(168914);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(168914);
        return this;
    }

    public final eg qN(String str) {
        AppMethodBeat.i(168915);
        this.erv = x("CurrentPageName", str, true);
        AppMethodBeat.o(168915);
        return this;
    }

    public final eg lK(long j2) {
        this.erw = j2;
        return this;
    }

    public final eg qO(String str) {
        AppMethodBeat.i(168916);
        this.euI = x("feedid", str, true);
        AppMethodBeat.o(168916);
        return this;
    }

    public final eg lL(long j2) {
        this.eCD = j2;
        return this;
    }

    public final eg qP(String str) {
        AppMethodBeat.i(168917);
        this.esS = x("Tag", str, true);
        AppMethodBeat.o(168917);
        return this;
    }

    public final eg qQ(String str) {
        AppMethodBeat.i(168918);
        this.esT = x("TagId", str, true);
        AppMethodBeat.o(168918);
        return this;
    }

    public final eg lM(long j2) {
        this.ers = j2;
        return this;
    }

    public final eg lN(long j2) {
        this.ert = j2;
        return this;
    }

    public final eg lO(long j2) {
        this.eru = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(168919);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.erv);
        stringBuffer.append(",");
        stringBuffer.append(this.erw);
        stringBuffer.append(",");
        stringBuffer.append(this.euI);
        stringBuffer.append(",");
        stringBuffer.append(this.eCD);
        stringBuffer.append(",");
        stringBuffer.append(this.esS);
        stringBuffer.append(",");
        stringBuffer.append(this.esT);
        stringBuffer.append(",");
        stringBuffer.append(this.esU);
        stringBuffer.append(",");
        stringBuffer.append(this.esV);
        stringBuffer.append(",");
        stringBuffer.append(this.ers);
        stringBuffer.append(",");
        stringBuffer.append(this.ert);
        stringBuffer.append(",");
        stringBuffer.append(this.eru);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(168919);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(168920);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CurrentPageName:").append(this.erv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene:").append(this.erw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("feedid:").append(this.euI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("feedtype:").append(this.eCD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Tag:").append(this.esS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TagId:").append(this.esT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsPoi:").append(this.esU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TagFeedCnt:").append(this.esV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedLikeCount:").append(this.ers);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedCommentCount:").append(this.ert);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedFriLikeCount:").append(this.eru);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(168920);
        return stringBuffer2;
    }
}
