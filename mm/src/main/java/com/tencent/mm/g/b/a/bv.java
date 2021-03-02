package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bv extends a {
    private String eiB = "";
    private String err = "";
    private long ers;
    private long ert;
    private long erz;
    private long etK;
    private long etM;
    private long etT;
    private String etU = "";
    private long etV;
    private String etW = "";
    private long etX;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19405;
    }

    public final bv kk(String str) {
        AppMethodBeat.i(184154);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(184154);
        return this;
    }

    public final bv kl(String str) {
        AppMethodBeat.i(184155);
        this.etU = x("FinderUsername", str, true);
        AppMethodBeat.o(184155);
        return this;
    }

    public final bv eI(long j2) {
        this.etV = j2;
        return this;
    }

    public final bv km(String str) {
        AppMethodBeat.i(184156);
        this.etW = x("Username", str, true);
        AppMethodBeat.o(184156);
        return this;
    }

    public final bv eJ(long j2) {
        this.etK = j2;
        return this;
    }

    public final bv eK(long j2) {
        this.ers = j2;
        return this;
    }

    public final bv eL(long j2) {
        this.ert = j2;
        return this;
    }

    public final bv kn(String str) {
        AppMethodBeat.i(184157);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(184157);
        return this;
    }

    public final bv eM(long j2) {
        this.etM = j2;
        return this;
    }

    public final bv eN(long j2) {
        this.etX = j2;
        return this;
    }

    public final bv eO(long j2) {
        this.erz = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(184158);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.etT);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.etU);
        stringBuffer.append(",");
        stringBuffer.append(this.etV);
        stringBuffer.append(",");
        stringBuffer.append(this.etW);
        stringBuffer.append(",");
        stringBuffer.append(this.etK);
        stringBuffer.append(",");
        stringBuffer.append(this.ers);
        stringBuffer.append(",");
        stringBuffer.append(this.ert);
        stringBuffer.append(",");
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.etM);
        stringBuffer.append(",");
        stringBuffer.append(this.etX);
        stringBuffer.append(",");
        stringBuffer.append(this.erz);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(184158);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(184159);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ClickAvatarScene:").append(this.etT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderUsername:").append(this.etU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderRole:").append(this.etV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Username:").append(this.etW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Role:").append(this.etK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedLikeCount:").append(this.ers);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedCommentCount:").append(this.ert);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedScene:").append(this.etM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NewAvatarClickScene:").append(this.etX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("InnerVersion:").append(this.erz);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(184159);
        return stringBuffer2;
    }
}
