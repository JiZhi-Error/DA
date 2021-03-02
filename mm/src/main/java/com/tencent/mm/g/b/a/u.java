package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class u extends a {
    public long eli;
    public long elj;
    public long elk;
    public String ell = "";
    public long elm;
    public long eln;
    public long elo;
    public String elp = "";
    public String elq = "";
    public long elr;
    public String els = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19824;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(231469);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eli);
        stringBuffer.append(",");
        stringBuffer.append(this.elj);
        stringBuffer.append(",");
        stringBuffer.append(this.elk);
        stringBuffer.append(",");
        stringBuffer.append(this.ell);
        stringBuffer.append(",");
        stringBuffer.append(this.elm);
        stringBuffer.append(",");
        stringBuffer.append(this.eln);
        stringBuffer.append(",");
        stringBuffer.append(this.elo);
        stringBuffer.append(",");
        stringBuffer.append(this.elp);
        stringBuffer.append(",");
        stringBuffer.append(this.elq);
        stringBuffer.append(",");
        stringBuffer.append(this.elr);
        stringBuffer.append(",");
        stringBuffer.append(this.els);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(231469);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(231470);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("actioncode:").append(this.eli);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("selectfriendnum:").append(this.elj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("modifiedsucfriendnum:").append(this.elk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("modifiedsucfriendlist:").append(this.ell);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("beforsocialblackfriendnum:").append(this.elm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("aftersocialblackfriendnum:").append(this.eln);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionnum:").append(this.elo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("selecttagname:").append(this.elp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("selecttagid:").append(this.elq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("staytime:").append(this.elr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionid:").append(this.els);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(231470);
        return stringBuffer2;
    }
}
