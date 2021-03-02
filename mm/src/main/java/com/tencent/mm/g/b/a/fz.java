package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fz extends a {
    private String eIl = "";
    private long eIm;
    private String eIn = "";
    private long eIo;
    private long eIp;
    private String els = "";
    private String elt = "";
    private String eoj = "";
    private String erH = "";
    private String eui = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21154;
    }

    public final fz tf(String str) {
        AppMethodBeat.i(209273);
        this.eIn = x("ClickTimeStamp", str, true);
        AppMethodBeat.o(209273);
        return this;
    }

    public final fz pJ(long j2) {
        this.eIo = j2;
        return this;
    }

    public final fz agK() {
        this.eIp = 1;
        return this;
    }

    public final fz tg(String str) {
        AppMethodBeat.i(209274);
        this.eIl = x("MiniSessionId", str, true);
        AppMethodBeat.o(209274);
        return this;
    }

    public final fz pK(long j2) {
        this.eIm = j2;
        return this;
    }

    public final fz th(String str) {
        AppMethodBeat.i(209275);
        this.eui = x("LongVideoId", str, true);
        AppMethodBeat.o(209275);
        return this;
    }

    public final fz ti(String str) {
        AppMethodBeat.i(209276);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(209276);
        return this;
    }

    public final fz tj(String str) {
        AppMethodBeat.i(209277);
        this.elt = x("contextid", str, true);
        AppMethodBeat.o(209277);
        return this;
    }

    public final fz tk(String str) {
        AppMethodBeat.i(209278);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(209278);
        return this;
    }

    public final fz tl(String str) {
        AppMethodBeat.i(209279);
        this.eoj = x("Feedid", str, true);
        AppMethodBeat.o(209279);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209280);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eIn);
        stringBuffer.append(",");
        stringBuffer.append(this.eIo);
        stringBuffer.append(",");
        stringBuffer.append(this.eIp);
        stringBuffer.append(",");
        stringBuffer.append(this.eIl);
        stringBuffer.append(",");
        stringBuffer.append(this.eIm);
        stringBuffer.append(",");
        stringBuffer.append(this.eui);
        stringBuffer.append(",");
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.elt);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.eoj);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209280);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209281);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ClickTimeStamp:").append(this.eIn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GenerateType:").append(this.eIo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GenerateScene:").append(this.eIp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MiniSessionId:").append(this.eIl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TaskOrder:").append(this.eIm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LongVideoId:").append(this.eui);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("contextid:").append(this.elt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Feedid:").append(this.eoj);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209281);
        return stringBuffer2;
    }
}
