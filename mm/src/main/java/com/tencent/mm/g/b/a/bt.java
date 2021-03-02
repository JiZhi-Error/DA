package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bt extends a {
    private long enl;
    private String etN = "";
    private String etO = "";
    private int etP;
    private String etQ = "";
    private long etR;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21113;
    }

    public final bt ke(String str) {
        AppMethodBeat.i(220095);
        this.etN = x("FinderUsrname", str, true);
        AppMethodBeat.o(220095);
        return this;
    }

    public final String acG() {
        return this.etN;
    }

    public final bt kf(String str) {
        AppMethodBeat.i(220096);
        this.etO = x("FinderWxAppInfo", str, true);
        AppMethodBeat.o(220096);
        return this;
    }

    public final String acH() {
        return this.etO;
    }

    public final bt jX(int i2) {
        this.etP = i2;
        return this;
    }

    public final int acI() {
        return this.etP;
    }

    public final bt kg(String str) {
        AppMethodBeat.i(220097);
        this.etQ = x("FinderSessionId", str, true);
        AppMethodBeat.o(220097);
        return this;
    }

    public final String acJ() {
        return this.etQ;
    }

    public final bt eF(long j2) {
        AppMethodBeat.i(220098);
        this.etR = j2;
        super.bi("ActionTimeMs", this.etR);
        AppMethodBeat.o(220098);
        return this;
    }

    public final long acK() {
        return this.etR;
    }

    public final bt eG(long j2) {
        this.enl = j2;
        return this;
    }

    public final long acL() {
        return this.enl;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(220099);
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
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(220099);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(220100);
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
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(220100);
        return stringBuffer2;
    }
}
