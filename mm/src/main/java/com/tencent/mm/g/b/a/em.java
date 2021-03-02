package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class em extends a {
    private long eCQ;
    private long eCR;
    private long eCS;
    private String eiC = "";
    private long ejW;
    private String erU = "";
    private String erV = "";
    private long erW;
    private long erX;
    private String euI = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20044;
    }

    public final em me(long j2) {
        this.erW = j2;
        return this;
    }

    public final em rl(String str) {
        AppMethodBeat.i(209229);
        this.erU = x("Sessionid", str, true);
        AppMethodBeat.o(209229);
        return this;
    }

    public final em rm(String str) {
        AppMethodBeat.i(209230);
        this.erV = x("Contextid", str, true);
        AppMethodBeat.o(209230);
        return this;
    }

    public final em rn(String str) {
        AppMethodBeat.i(209231);
        this.eiC = x("ClickTabContextid", str, true);
        AppMethodBeat.o(209231);
        return this;
    }

    public final em ro(String str) {
        AppMethodBeat.i(209232);
        this.euI = x("feedid", str, true);
        AppMethodBeat.o(209232);
        return this;
    }

    public final em mf(long j2) {
        this.ejW = j2;
        return this;
    }

    public final em mg(long j2) {
        this.eCQ = j2;
        return this;
    }

    public final em mh(long j2) {
        this.eCR = j2;
        return this;
    }

    public final em mi(long j2) {
        this.eCS = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209233);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.erU);
        stringBuffer.append(",");
        stringBuffer.append(this.erV);
        stringBuffer.append(",");
        stringBuffer.append(this.eiC);
        stringBuffer.append(",");
        stringBuffer.append(this.euI);
        stringBuffer.append(",");
        stringBuffer.append(this.ejW);
        stringBuffer.append(",");
        stringBuffer.append(this.erX);
        stringBuffer.append(",");
        stringBuffer.append(this.eCQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eCR);
        stringBuffer.append(",");
        stringBuffer.append(this.eCS);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209233);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209234);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Sessionid:").append(this.erU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Contextid:").append(this.erV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextid:").append(this.eiC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("feedid:").append(this.euI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action:").append(this.ejW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasWording:").append(this.erX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickAction:").append(this.eCQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionStatus:").append(this.eCR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("wordingtype:").append(this.eCS);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209234);
        return stringBuffer2;
    }
}
