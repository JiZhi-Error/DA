package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gv extends a {
    private String eKZ = "";
    private String eLa = "";
    private String eLb = "";
    private String eLc = "";
    private String eiB = "";
    public long ejA = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19942;
    }

    public final gv uE(String str) {
        AppMethodBeat.i(194451);
        this.eKZ = x("ResignationWorkUsername", str, true);
        AppMethodBeat.o(194451);
        return this;
    }

    public final gv uF(String str) {
        AppMethodBeat.i(194452);
        this.eLa = x("TakeOverWorkUsername", str, true);
        AppMethodBeat.o(194452);
        return this;
    }

    public final gv uG(String str) {
        AppMethodBeat.i(194453);
        this.eLb = x("WorkEnterpriseDescId", str, true);
        AppMethodBeat.o(194453);
        return this;
    }

    public final gv uH(String str) {
        AppMethodBeat.i(194454);
        this.eLc = x("WorkEnterpriseName", str, true);
        AppMethodBeat.o(194454);
        return this;
    }

    public final gv uI(String str) {
        AppMethodBeat.i(194455);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(194455);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(194456);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eKZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eLa);
        stringBuffer.append(",");
        stringBuffer.append(this.eLb);
        stringBuffer.append(",");
        stringBuffer.append(this.eLc);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(194456);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(194457);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ResignationWorkUsername:").append(this.eKZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TakeOverWorkUsername:").append(this.eLa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WorkEnterpriseDescId:").append(this.eLb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WorkEnterpriseName:").append(this.eLc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(194457);
        return stringBuffer2;
    }
}
