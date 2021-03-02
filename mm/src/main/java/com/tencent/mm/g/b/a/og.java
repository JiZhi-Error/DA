package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class og extends a {
    private String ekG = "";
    private int eqe;
    private long oqb;
    private String oqk = "";
    private String oql = "";
    private String oqm = "";
    private int oqn;
    private int oqo;
    private int oqt;
    private int oqu;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22345;
    }

    public final og PG(long j2) {
        this.oqb = j2;
        return this;
    }

    public final og VN(String str) {
        AppMethodBeat.i(261942);
        this.ekG = x("sessionId", str, true);
        AppMethodBeat.o(261942);
        return this;
    }

    public final og VO(String str) {
        AppMethodBeat.i(261943);
        this.oqk = x("wish_session", str, true);
        AppMethodBeat.o(261943);
        return this;
    }

    public final og abw(int i2) {
        this.eqe = i2;
        return this;
    }

    public final og VP(String str) {
        AppMethodBeat.i(261944);
        this.oql = x("position", str, true);
        AppMethodBeat.o(261944);
        return this;
    }

    public final og VS(String str) {
        AppMethodBeat.i(261945);
        this.oqm = x("label", str, true);
        AppMethodBeat.o(261945);
        return this;
    }

    public final og abA(int i2) {
        this.oqn = i2;
        return this;
    }

    public final og abB(int i2) {
        this.oqo = i2;
        return this;
    }

    public final og abC(int i2) {
        this.oqt = i2;
        return this;
    }

    public final og abD(int i2) {
        this.oqu = i2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(261946);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.oqb);
        stringBuffer.append(",");
        stringBuffer.append(this.ekG);
        stringBuffer.append(",");
        stringBuffer.append(this.oqk);
        stringBuffer.append(",");
        stringBuffer.append(this.eqe);
        stringBuffer.append(",");
        stringBuffer.append(this.oql);
        stringBuffer.append(",");
        stringBuffer.append(this.oqm);
        stringBuffer.append(",");
        stringBuffer.append(this.oqn);
        stringBuffer.append(",");
        stringBuffer.append(this.oqo);
        stringBuffer.append(",");
        stringBuffer.append(this.oqt);
        stringBuffer.append(",");
        stringBuffer.append(this.oqu);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(261946);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(261947);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("actiontime:").append(this.oqb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionId:").append(this.ekG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("wish_session:").append(this.oqk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionType:").append(this.eqe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("position:").append(this.oql);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("label:").append(this.oqm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("commexpo:").append(this.oqn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("setstatus:").append(this.oqo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("openRules:").append(this.oqt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isDonate:").append(this.oqu);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(261947);
        return stringBuffer2;
    }
}
