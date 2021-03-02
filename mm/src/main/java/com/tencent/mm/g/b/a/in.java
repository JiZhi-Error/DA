package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class in extends a {
    private String eOG = "";
    private String eOL = "";
    public int eOM;
    public long eON;
    public long eOO;
    public int eOP;
    private String etI = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20565;
    }

    public final in wk(String str) {
        AppMethodBeat.i(201831);
        this.eOG = x("PublishId", str, true);
        AppMethodBeat.o(201831);
        return this;
    }

    public final in wl(String str) {
        AppMethodBeat.i(201832);
        this.eOL = x("FriendUsername", str, true);
        AppMethodBeat.o(201832);
        return this;
    }

    public final in wm(String str) {
        AppMethodBeat.i(201833);
        this.etI = x("CommentId", str, true);
        AppMethodBeat.o(201833);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(201834);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eOG);
        stringBuffer.append(",");
        stringBuffer.append(this.eOL);
        stringBuffer.append(",");
        stringBuffer.append(this.etI);
        stringBuffer.append(",");
        stringBuffer.append(this.eOM);
        stringBuffer.append(",");
        stringBuffer.append(this.eON);
        stringBuffer.append(",");
        stringBuffer.append(this.eOO);
        stringBuffer.append(",");
        stringBuffer.append(this.eOP);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(201834);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(201835);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PublishId:").append(this.eOG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FriendUsername:").append(this.eOL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentId:").append(this.etI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentType:").append(this.eOM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CurrentLikeCount:").append(this.eON);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CurrentCommentCount:").append(this.eOO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OpResult:").append(this.eOP);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(201835);
        return stringBuffer2;
    }
}
