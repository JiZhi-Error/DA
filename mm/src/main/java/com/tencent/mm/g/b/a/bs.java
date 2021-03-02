package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bs extends a {
    private String eiB = "";
    private String err = "";
    private long etC;
    private long etD;
    private String etE = "";
    private String etF = "";
    private long etG;
    private long etH;
    private String etI = "";
    private long etJ;
    private long etK;
    private long etL;
    private long etM;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19421;
    }

    public final bs ex(long j2) {
        this.etC = j2;
        return this;
    }

    public final bs ey(long j2) {
        this.etD = j2;
        return this;
    }

    public final bs jZ(String str) {
        AppMethodBeat.i(184147);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(184147);
        return this;
    }

    public final bs ka(String str) {
        AppMethodBeat.i(184148);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(184148);
        return this;
    }

    public final bs kb(String str) {
        AppMethodBeat.i(184149);
        this.etE = x("FeedUsername", str, true);
        AppMethodBeat.o(184149);
        return this;
    }

    public final bs kc(String str) {
        AppMethodBeat.i(184150);
        this.etF = x("CommentUsername", str, true);
        AppMethodBeat.o(184150);
        return this;
    }

    public final bs ez(long j2) {
        this.etG = j2;
        return this;
    }

    public final bs eA(long j2) {
        this.etH = j2;
        return this;
    }

    public final bs kd(String str) {
        AppMethodBeat.i(184151);
        this.etI = x("CommentId", str, true);
        AppMethodBeat.o(184151);
        return this;
    }

    public final bs eB(long j2) {
        this.etJ = j2;
        return this;
    }

    public final bs eC(long j2) {
        this.etK = j2;
        return this;
    }

    public final bs eD(long j2) {
        this.etL = j2;
        return this;
    }

    public final bs eE(long j2) {
        this.etM = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(184152);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.etC);
        stringBuffer.append(",");
        stringBuffer.append(this.etD);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.etE);
        stringBuffer.append(",");
        stringBuffer.append(this.etF);
        stringBuffer.append(",");
        stringBuffer.append(this.etG);
        stringBuffer.append(",");
        stringBuffer.append(this.etH);
        stringBuffer.append(",");
        stringBuffer.append(this.etI);
        stringBuffer.append(",");
        stringBuffer.append(this.etJ);
        stringBuffer.append(",");
        stringBuffer.append(this.etK);
        stringBuffer.append(",");
        stringBuffer.append(this.etL);
        stringBuffer.append(",");
        stringBuffer.append(this.etM);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(184152);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(184153);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ExpandType:").append(this.etC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExpandCommentCount:").append(this.etD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedUsername:").append(this.etE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentUsername:").append(this.etF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentLikeCount:").append(this.etG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTime:").append(this.etH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentId:").append(this.etI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SubCommentCount:").append(this.etJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Role:").append(this.etK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentRole:").append(this.etL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedScene:").append(this.etM);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(184153);
        return stringBuffer2;
    }
}
