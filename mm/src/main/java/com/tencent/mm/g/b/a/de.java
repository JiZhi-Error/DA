package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class de extends a {
    private long enl;
    private String etN = "";
    private String etO = "";
    private int etP;
    private String etQ = "";
    private long etR;
    private long ews;
    private String eyL = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21106;
    }

    public final de or(String str) {
        AppMethodBeat.i(220182);
        this.etN = x("FinderUsrname", str, true);
        AppMethodBeat.o(220182);
        return this;
    }

    public final String acG() {
        return this.etN;
    }

    public final de os(String str) {
        AppMethodBeat.i(220183);
        this.etO = x("FinderWxAppInfo", str, true);
        AppMethodBeat.o(220183);
        return this;
    }

    public final String acH() {
        return this.etO;
    }

    public final de kI(int i2) {
        this.etP = i2;
        return this;
    }

    public final int acI() {
        return this.etP;
    }

    public final de ot(String str) {
        AppMethodBeat.i(220184);
        this.etQ = x("FinderSessionId", str, true);
        AppMethodBeat.o(220184);
        return this;
    }

    public final String acJ() {
        return this.etQ;
    }

    public final de iY(long j2) {
        AppMethodBeat.i(220185);
        this.etR = j2;
        super.bi("ActionTimeMs", this.etR);
        AppMethodBeat.o(220185);
        return this;
    }

    public final long acK() {
        return this.etR;
    }

    public final de iZ(long j2) {
        this.enl = j2;
        return this;
    }

    public final long acL() {
        return this.enl;
    }

    public final de ou(String str) {
        AppMethodBeat.i(220186);
        this.eyL = x("ActionJson", str, true);
        AppMethodBeat.o(220186);
        return this;
    }

    public final String aeO() {
        return this.eyL;
    }

    public final de ja(long j2) {
        this.ews = j2;
        return this;
    }

    public final long adn() {
        return this.ews;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(220187);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.etN);
        stringBuffer.append(",");
        stringBuffer.append(this.etO);
        stringBuffer.append(",");
        stringBuffer.append(this.etP);
        stringBuffer.append(",");
        stringBuffer.append(this.etQ);
        stringBuffer.append(",");
        stringBuffer.append(this.etR);
        stringBuffer.append(",");
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.eyL);
        stringBuffer.append(",");
        stringBuffer.append(this.ews);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(220187);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(220188);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FinderUsrname:").append(this.etN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderWxAppInfo:").append(this.etO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsPrivate:").append(this.etP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderSessionId:").append(this.etQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTimeMs:").append(this.etR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionJson:").append(this.eyL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceScene:").append(this.ews);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(220188);
        return stringBuffer2;
    }
}
