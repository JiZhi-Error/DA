package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class dn extends a {
    private String eiB = "";
    private long ers;
    private long erw;
    private String esS = "";
    private String esT = "";
    private long esU;
    private long esV;
    private String euI = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19188;
    }

    public final dn pg(String str) {
        AppMethodBeat.i(168908);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(168908);
        return this;
    }

    public final dn kk(long j2) {
        this.erw = j2;
        return this;
    }

    public final dn ph(String str) {
        AppMethodBeat.i(168909);
        this.esS = x("Tag", str, true);
        AppMethodBeat.o(168909);
        return this;
    }

    public final dn pi(String str) {
        AppMethodBeat.i(168910);
        this.esT = x("TagId", str, true);
        AppMethodBeat.o(168910);
        return this;
    }

    public final dn pj(String str) {
        AppMethodBeat.i(168911);
        this.euI = x("feedid", str, true);
        AppMethodBeat.o(168911);
        return this;
    }

    public final dn kl(long j2) {
        this.ers = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(168912);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.erw);
        stringBuffer.append(",");
        stringBuffer.append(this.esS);
        stringBuffer.append(",");
        stringBuffer.append(this.esT);
        stringBuffer.append(",");
        stringBuffer.append(this.esU);
        stringBuffer.append(",");
        stringBuffer.append(this.esV);
        stringBuffer.append(",");
        stringBuffer.append(this.euI);
        stringBuffer.append(",");
        stringBuffer.append(this.ers);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(168912);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(168913);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene:").append(this.erw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Tag:").append(this.esS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TagId:").append(this.esT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsPoi:").append(this.esU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TagFeedCnt:").append(this.esV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("feedid:").append(this.euI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedLikeCount:").append(this.ers);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(168913);
        return stringBuffer2;
    }
}
