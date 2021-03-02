package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ed extends a {
    private long eCA;
    private String els = "";
    private long ers;
    private long ert;
    private long eru;
    private long erw;
    private String euI = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19387;
    }

    public final ed qJ(String str) {
        AppMethodBeat.i(184181);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(184181);
        return this;
    }

    public final ed qK(String str) {
        AppMethodBeat.i(184182);
        this.euI = x("feedid", str, true);
        AppMethodBeat.o(184182);
        return this;
    }

    public final ed lD(long j2) {
        this.erw = j2;
        return this;
    }

    public final ed lE(long j2) {
        this.ers = j2;
        return this;
    }

    public final ed lF(long j2) {
        this.ert = j2;
        return this;
    }

    public final ed lG(long j2) {
        this.eru = j2;
        return this;
    }

    public final ed lH(long j2) {
        this.eCA = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(184183);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.euI);
        stringBuffer.append(",");
        stringBuffer.append(this.erw);
        stringBuffer.append(",");
        stringBuffer.append(this.ers);
        stringBuffer.append(",");
        stringBuffer.append(this.ert);
        stringBuffer.append(",");
        stringBuffer.append(this.eru);
        stringBuffer.append(",");
        stringBuffer.append(this.eCA);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(184183);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(184184);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("feedid:").append(this.euI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene:").append(this.erw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedLikeCount:").append(this.ers);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedCommentCount:").append(this.ert);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedFriLikeCount:").append(this.eru);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RoleBeforeSwitch:").append(this.eCA);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(184184);
        return stringBuffer2;
    }
}
