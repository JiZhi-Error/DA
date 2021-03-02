package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bk extends a {
    private String eiB = "";
    private String err = "";
    private long erw;
    private String esB = "";
    private String esC = "";
    private String esD = "";
    private long esE;
    private long esF;
    private long esG;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19793;
    }

    public final bk jo(String str) {
        AppMethodBeat.i(208878);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(208878);
        return this;
    }

    public final bk jp(String str) {
        AppMethodBeat.i(208879);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(208879);
        return this;
    }

    public final bk jq(String str) {
        AppMethodBeat.i(208880);
        this.esB = x("PosterUsername", str, true);
        AppMethodBeat.o(208880);
        return this;
    }

    public final bk jr(String str) {
        AppMethodBeat.i(208881);
        this.esC = x("ViewerUsername", str, true);
        AppMethodBeat.o(208881);
        return this;
    }

    public final bk js(String str) {
        AppMethodBeat.i(208882);
        this.esD = x("MentionedUsername", str, true);
        AppMethodBeat.o(208882);
        return this;
    }

    public final bk dL(long j2) {
        this.erw = j2;
        return this;
    }

    public final bk dM(long j2) {
        this.esE = j2;
        return this;
    }

    public final bk dN(long j2) {
        this.esF = j2;
        return this;
    }

    public final bk dO(long j2) {
        this.esG = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208883);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.esB);
        stringBuffer.append(",");
        stringBuffer.append(this.esC);
        stringBuffer.append(",");
        stringBuffer.append(this.esD);
        stringBuffer.append(",");
        stringBuffer.append(this.erw);
        stringBuffer.append(",");
        stringBuffer.append(this.esE);
        stringBuffer.append(",");
        stringBuffer.append(this.esF);
        stringBuffer.append(",");
        stringBuffer.append(this.esG);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208883);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208884);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PosterUsername:").append(this.esB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ViewerUsername:").append(this.esC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MentionedUsername:").append(this.esD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene:").append(this.erw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("recommendtype:").append(this.esE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("likecnt:").append(this.esF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("commcnt:").append(this.esG);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208884);
        return stringBuffer2;
    }
}
