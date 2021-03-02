package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class li extends a {
    private long eYA;
    private long eYB;
    private long eYp = 0;
    private String eYq = "";
    private long eYr = 0;
    private String eYs = "";
    private String eYw = "";
    private String eYx = "";
    private String eYy = "";
    private String eYz = "";
    private long enl = 0;
    private long eua = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20997;
    }

    public final li uM(long j2) {
        this.enl = j2;
        return this;
    }

    public final li uN(long j2) {
        this.eua = j2;
        return this;
    }

    public final li aiA() {
        this.eYp = 2;
        return this;
    }

    public final li yx(String str) {
        AppMethodBeat.i(187804);
        this.eYq = x("ResultQuery", str, true);
        AppMethodBeat.o(187804);
        return this;
    }

    public final li uO(long j2) {
        this.eYr = j2;
        return this;
    }

    public final li yy(String str) {
        AppMethodBeat.i(187805);
        this.eYs = x("ShareSceneId", str, true);
        AppMethodBeat.o(187805);
        return this;
    }

    public final li yz(String str) {
        AppMethodBeat.i(187806);
        this.eYw = x("ShareSessionId", str, true);
        AppMethodBeat.o(187806);
        return this;
    }

    public final li yA(String str) {
        AppMethodBeat.i(187807);
        this.eYx = x("ShareSearchId", str, true);
        AppMethodBeat.o(187807);
        return this;
    }

    public final li yB(String str) {
        AppMethodBeat.i(187808);
        this.eYy = x("ShareRequestId", str, true);
        AppMethodBeat.o(187808);
        return this;
    }

    public final li yC(String str) {
        AppMethodBeat.i(187809);
        this.eYz = x("ShareDocId", str, true);
        AppMethodBeat.o(187809);
        return this;
    }

    public final li uP(long j2) {
        this.eYA = j2;
        return this;
    }

    public final li uQ(long j2) {
        this.eYB = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(187810);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.eua);
        stringBuffer.append(",");
        stringBuffer.append(this.eYp);
        stringBuffer.append(",");
        stringBuffer.append(this.eYq);
        stringBuffer.append(",");
        stringBuffer.append(this.eYr);
        stringBuffer.append(",");
        stringBuffer.append(this.eYs);
        stringBuffer.append(",");
        stringBuffer.append(this.eYw);
        stringBuffer.append(",");
        stringBuffer.append(this.eYx);
        stringBuffer.append(",");
        stringBuffer.append(this.eYy);
        stringBuffer.append(",");
        stringBuffer.append(this.eYz);
        stringBuffer.append(",");
        stringBuffer.append(this.eYA);
        stringBuffer.append(",");
        stringBuffer.append(this.eYB);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(187810);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(187811);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTimeStamp:").append(this.eua);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ResultType:").append(this.eYp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ResultQuery:").append(this.eYq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShareScene:").append(this.eYr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShareSceneId:").append(this.eYs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShareSessionId:").append(this.eYw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShareSearchId:").append(this.eYx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShareRequestId:").append(this.eYy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShareDocId:").append(this.eYz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShareBizType:").append(this.eYA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShareSubType:").append(this.eYB);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(187811);
        return stringBuffer2;
    }
}
