package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class dp extends a {
    private String eiB = "";
    private long ejA;
    private String eoj = "";
    private String eoz = "";
    private String erH = "";
    private long ery;
    private String etW = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19956;
    }

    public final dp kp(long j2) {
        this.ejA = j2;
        return this;
    }

    public final dp po(String str) {
        AppMethodBeat.i(209144);
        this.etW = x("Username", str, true);
        AppMethodBeat.o(209144);
        return this;
    }

    public final dp pp(String str) {
        AppMethodBeat.i(209145);
        this.eoj = x("Feedid", str, true);
        AppMethodBeat.o(209145);
        return this;
    }

    public final dp pq(String str) {
        AppMethodBeat.i(209146);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(209146);
        return this;
    }

    public final dp pr(String str) {
        AppMethodBeat.i(209147);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(209147);
        return this;
    }

    public final dp pt(String str) {
        AppMethodBeat.i(209148);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(209148);
        return this;
    }

    public final dp kq(long j2) {
        this.ery = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209149);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.etW);
        stringBuffer.append(",");
        stringBuffer.append(this.eoj);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.ery);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209149);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209150);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Username:").append(this.etW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Feedid:").append(this.eoj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentScene:").append(this.ery);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209150);
        return stringBuffer2;
    }
}
