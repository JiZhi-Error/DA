package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ek extends a {
    private String eiB = "";
    private String eoz = "";
    private String erB = "";
    private long erz;
    private long etH;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19433;
    }

    public final ek rb(String str) {
        AppMethodBeat.i(184188);
        this.erB = x("Action", str, true);
        AppMethodBeat.o(184188);
        return this;
    }

    public final ek lY(long j2) {
        this.etH = j2;
        return this;
    }

    public final ek rc(String str) {
        AppMethodBeat.i(184189);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(184189);
        return this;
    }

    public final ek rd(String str) {
        AppMethodBeat.i(209228);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(209228);
        return this;
    }

    public final ek lZ(long j2) {
        this.erz = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(184190);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erB);
        stringBuffer.append(",");
        stringBuffer.append(this.etH);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.erz);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(184190);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(184191);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Action:").append(this.erB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTime:").append(this.etH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("InnerVersion:").append(this.erz);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(184191);
        return stringBuffer2;
    }
}
