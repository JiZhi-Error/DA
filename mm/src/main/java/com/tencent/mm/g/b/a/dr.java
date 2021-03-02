package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class dr extends a {
    private String eBg = "";
    private String eBh = "";
    private long eBi;
    private String eiB = "";
    private String eoz = "";
    private String erH = "";
    private String err = "";
    private long ery;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19957;
    }

    public final dr pA(String str) {
        AppMethodBeat.i(209159);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(209159);
        return this;
    }

    public final dr pB(String str) {
        AppMethodBeat.i(209160);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(209160);
        return this;
    }

    public final dr pC(String str) {
        AppMethodBeat.i(209161);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(209161);
        return this;
    }

    public final dr pD(String str) {
        AppMethodBeat.i(209162);
        this.eBg = x("AddUsername", str, true);
        AppMethodBeat.o(209162);
        return this;
    }

    public final dr pE(String str) {
        AppMethodBeat.i(209163);
        this.eBh = x("DeleteUsername", str, true);
        AppMethodBeat.o(209163);
        return this;
    }

    public final dr pF(String str) {
        AppMethodBeat.i(209164);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(209164);
        return this;
    }

    public final dr ku(long j2) {
        this.ery = j2;
        return this;
    }

    public final dr kv(long j2) {
        this.eBi = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209165);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.eBg);
        stringBuffer.append(",");
        stringBuffer.append(this.eBh);
        stringBuffer.append(",");
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.ery);
        stringBuffer.append(",");
        stringBuffer.append(this.eBi);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209165);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209166);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AddUsername:").append(this.eBg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DeleteUsername:").append(this.eBh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentScene:").append(this.ery);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("refuseLastCount:").append(this.eBi);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209166);
        return stringBuffer2;
    }
}
