package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class dq extends a {
    private String eBd = "";
    private long eBe;
    private String eBf = "";
    private String eiB = "";
    private String eoz = "";
    private String erH = "";
    private String err = "";
    private long ery;
    private long ett;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19955;
    }

    public final dq pu(String str) {
        AppMethodBeat.i(209151);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(209151);
        return this;
    }

    public final dq pv(String str) {
        AppMethodBeat.i(209152);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(209152);
        return this;
    }

    public final dq pw(String str) {
        AppMethodBeat.i(209153);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(209153);
        return this;
    }

    public final dq px(String str) {
        AppMethodBeat.i(209154);
        this.eBd = x("ExposeItems", str, true);
        AppMethodBeat.o(209154);
        return this;
    }

    public final dq kr(long j2) {
        this.ett = j2;
        return this;
    }

    public final dq py(String str) {
        AppMethodBeat.i(209155);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(209155);
        return this;
    }

    public final dq ks(long j2) {
        this.ery = j2;
        return this;
    }

    public final dq kt(long j2) {
        this.eBe = j2;
        return this;
    }

    public final dq pz(String str) {
        AppMethodBeat.i(209156);
        this.eBf = x("EnterContextId", str, true);
        AppMethodBeat.o(209156);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209157);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.eBd);
        stringBuffer.append(",");
        stringBuffer.append(this.ett);
        stringBuffer.append(",");
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.ery);
        stringBuffer.append(",");
        stringBuffer.append(this.eBe);
        stringBuffer.append(",");
        stringBuffer.append(this.eBf);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209157);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209158);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposeItems:").append(this.eBd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsCgiEnd:").append(this.ett);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentScene:").append(this.ery);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TotalFriendLikeCnt:").append(this.eBe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterContextId:").append(this.eBf);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209158);
        return stringBuffer2;
    }
}
