package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ho extends a {
    private String eFc = "";
    public long eLz;
    public long eMc;
    private String eMd = "";
    private String eMe = "";
    public long eMf;
    public long ejW;
    public long enM;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19442;
    }

    public final ho vp(String str) {
        AppMethodBeat.i(184775);
        this.eFc = x("roomid", str, true);
        AppMethodBeat.o(184775);
        return this;
    }

    public final ho vq(String str) {
        AppMethodBeat.i(194003);
        this.eMd = x("todoid", str, true);
        AppMethodBeat.o(194003);
        return this;
    }

    public final ho vr(String str) {
        AppMethodBeat.i(194004);
        this.eMe = x("appusername", str, true);
        AppMethodBeat.o(194004);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(184776);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eFc);
        stringBuffer.append(",");
        stringBuffer.append(this.enM);
        stringBuffer.append(",");
        stringBuffer.append(this.eMc);
        stringBuffer.append(",");
        stringBuffer.append(this.eLz);
        stringBuffer.append(",");
        stringBuffer.append(this.ejW);
        stringBuffer.append(",");
        stringBuffer.append(this.eMf);
        stringBuffer.append(",");
        stringBuffer.append(this.eMd);
        stringBuffer.append(",");
        stringBuffer.append(this.eMe);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(184776);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(184777);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("roomid:").append(this.eFc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("role:").append(this.enM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("exit:").append(this.eMc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("msgType:").append(this.eLz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action:").append(this.ejW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("openHelp:").append(this.eMf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("todoid:").append(this.eMd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appusername:").append(this.eMe);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(184777);
        return stringBuffer2;
    }
}
