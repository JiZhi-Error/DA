package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jk extends a {
    private long eRp;
    private long eRq = 0;
    private long eRr = 0;
    private String eRs = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18744;
    }

    public final jk se(long j2) {
        this.eRq = j2;
        return this;
    }

    public final jk sf(long j2) {
        this.eRr = j2;
        return this;
    }

    public final jk wQ(String str) {
        AppMethodBeat.i(118495);
        this.eRs = x("StoryidStr", str, true);
        AppMethodBeat.o(118495);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(118496);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eRp);
        stringBuffer.append(",");
        stringBuffer.append(this.eRq);
        stringBuffer.append(",");
        stringBuffer.append(this.eRr);
        stringBuffer.append(",");
        stringBuffer.append(this.eRs);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(118496);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(118497);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Storyid:").append(this.eRp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseFriendsCount:").append(this.eRq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentFriendsCount:").append(this.eRr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StoryidStr:").append(this.eRs);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(118497);
        return stringBuffer2;
    }
}
