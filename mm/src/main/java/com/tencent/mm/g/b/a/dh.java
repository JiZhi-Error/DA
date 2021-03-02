package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class dh extends a {
    private String eiB = "";
    private String err = "";
    private String ezO = "";
    private String ezP = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19792;
    }

    public final dh oC(String str) {
        AppMethodBeat.i(209111);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(209111);
        return this;
    }

    public final dh oD(String str) {
        AppMethodBeat.i(209112);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(209112);
        return this;
    }

    public final dh oE(String str) {
        AppMethodBeat.i(209113);
        this.ezO = x("PostUsername", str, true);
        AppMethodBeat.o(209113);
        return this;
    }

    public final dh oF(String str) {
        AppMethodBeat.i(209114);
        this.ezP = x("mentionedDetailInfo", str, true);
        AppMethodBeat.o(209114);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209115);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.ezO);
        stringBuffer.append(",");
        stringBuffer.append(this.ezP);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209115);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209116);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PostUsername:").append(this.ezO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("mentionedDetailInfo:").append(this.ezP);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209116);
        return stringBuffer2;
    }
}
