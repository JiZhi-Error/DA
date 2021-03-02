package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class cq extends a {
    private long ejA;
    private String eoD = "";
    private String erH = "";
    private long erO;
    private long erR;
    private long exg;
    private long exh;
    private String exi = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21631;
    }

    public final cq hI(long j2) {
        this.erR = j2;
        return this;
    }

    public final long acw() {
        return this.erR;
    }

    public final cq hJ(long j2) {
        this.erO = j2;
        return this;
    }

    public final long acs() {
        return this.erO;
    }

    public final cq hK(long j2) {
        this.ejA = j2;
        return this;
    }

    public final long act() {
        return this.ejA;
    }

    public final long aec() {
        return this.exg;
    }

    public final cq nb(String str) {
        AppMethodBeat.i(220138);
        this.eoD = x("ContextID", str, true);
        AppMethodBeat.o(220138);
        return this;
    }

    public final String aed() {
        return this.eoD;
    }

    public final cq nc(String str) {
        AppMethodBeat.i(220139);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(220139);
        return this;
    }

    public final String ack() {
        return this.erH;
    }

    public final cq nd(String str) {
        AppMethodBeat.i(220140);
        this.exi = x("Session_Id", str, true);
        AppMethodBeat.o(220140);
        return this;
    }

    public final String aee() {
        return this.exi;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(220141);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erR);
        stringBuffer.append(",");
        stringBuffer.append(this.erO);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.exg);
        stringBuffer.append(",");
        stringBuffer.append(this.exh);
        stringBuffer.append(",");
        stringBuffer.append(this.eoD);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.exi);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(220141);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(220142);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PageType:").append(this.erR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTS:").append(this.erO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Clickid:").append(this.exg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.exh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextID:").append(this.eoD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Session_Id:").append(this.exi);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(220142);
        return stringBuffer2;
    }
}
