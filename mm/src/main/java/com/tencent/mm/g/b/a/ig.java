package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ig extends a {
    private String eGT = "";
    private String eOk = "";
    private String eOl = "";
    private long eOm = 0;
    private long eOn = 0;
    private long eOo;
    private long eOp = 0;
    private String eiB = "";
    private long enl;
    private String eno = "";
    private long erW = 0;
    private long esW = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19651;
    }

    public final ig vZ(String str) {
        AppMethodBeat.i(210798);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(210798);
        return this;
    }

    public final ig wa(String str) {
        AppMethodBeat.i(210799);
        this.eGT = x("SearchId", str, true);
        AppMethodBeat.o(210799);
        return this;
    }

    public final ig ri(long j2) {
        this.erW = j2;
        return this;
    }

    public final ig wb(String str) {
        AppMethodBeat.i(210800);
        this.eOk = x("ClickMD5", str, true);
        AppMethodBeat.o(210800);
        return this;
    }

    public final ig wc(String str) {
        AppMethodBeat.i(210801);
        this.eOl = x("QueryMD5", str, true);
        AppMethodBeat.o(210801);
        return this;
    }

    public final ig rj(long j2) {
        this.eOm = j2;
        return this;
    }

    public final ig rk(long j2) {
        this.eOn = j2;
        return this;
    }

    public final ig rl(long j2) {
        this.eOo = j2;
        return this;
    }

    public final ig wd(String str) {
        AppMethodBeat.i(210802);
        this.eno = x("RequestId", str, true);
        AppMethodBeat.o(210802);
        return this;
    }

    public final ig rm(long j2) {
        this.enl = j2;
        return this;
    }

    public final ig rn(long j2) {
        this.esW = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(210803);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eGT);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.eOk);
        stringBuffer.append(",");
        stringBuffer.append(this.eOl);
        stringBuffer.append(",");
        stringBuffer.append(this.eOm);
        stringBuffer.append(",");
        stringBuffer.append(this.eOn);
        stringBuffer.append(",");
        stringBuffer.append(this.eOo);
        stringBuffer.append(",");
        stringBuffer.append(this.eno);
        stringBuffer.append(",");
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.eOp);
        stringBuffer.append(",");
        stringBuffer.append(this.esW);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(210803);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(210804);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SearchId:").append(this.eGT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickMD5:").append(this.eOk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("QueryMD5:").append(this.eOl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Offset:").append(this.eOm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Pos:").append(this.eOn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClientTimestamp:").append(this.eOo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RequestId:").append(this.eno);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Tab:").append(this.eOp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsSelf:").append(this.esW);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(210804);
        return stringBuffer2;
    }
}
