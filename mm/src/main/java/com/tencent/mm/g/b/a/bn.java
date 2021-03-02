package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bn extends a {
    private String eiB = "";
    private String eoz = "";
    private String erH = "";
    private long erW;
    private String err = "";
    private long ers;
    private long ert;
    private long eru;
    private String esK = "";
    private String esL = "";
    private int etc;
    private long etd;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19017;
    }

    public final bn jF(String str) {
        AppMethodBeat.i(184141);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(184141);
        return this;
    }

    public final bn jG(String str) {
        AppMethodBeat.i(184142);
        this.esK = x("ClickUI", str, true);
        AppMethodBeat.o(184142);
        return this;
    }

    public final bn jH(String str) {
        AppMethodBeat.i(184143);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(184143);
        return this;
    }

    public final bn jI(String str) {
        AppMethodBeat.i(184144);
        this.esL = x("FeedUsr", str, true);
        AppMethodBeat.o(184144);
        return this;
    }

    public final bn eh(long j2) {
        this.ers = j2;
        return this;
    }

    public final bn ei(long j2) {
        this.ert = j2;
        return this;
    }

    public final bn ej(long j2) {
        this.eru = j2;
        return this;
    }

    public final bn jW(int i2) {
        this.etc = i2;
        return this;
    }

    public final bn ek(long j2) {
        this.erW = j2;
        return this;
    }

    public final bn el(long j2) {
        this.etd = j2;
        return this;
    }

    public final bn jJ(String str) {
        AppMethodBeat.i(208892);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(208892);
        return this;
    }

    public final bn jK(String str) {
        AppMethodBeat.i(208893);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(208893);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(184145);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.esK);
        stringBuffer.append(",");
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.esL);
        stringBuffer.append(",");
        stringBuffer.append(this.ers);
        stringBuffer.append(",");
        stringBuffer.append(this.ert);
        stringBuffer.append(",");
        stringBuffer.append(this.eru);
        stringBuffer.append(",");
        stringBuffer.append(this.etc);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.etd);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(184145);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(184146);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickUI:").append(this.esK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedUsr:").append(this.esL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedLikeCount:").append(this.ers);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedCommentCount:").append(this.ert);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedFriLikeCount:").append(this.eru);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickAll:").append(this.etc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FullScreenCommentsArea:").append(this.etd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(184146);
        return stringBuffer2;
    }
}
