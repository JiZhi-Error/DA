package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class cy extends a {
    private long emk;
    private long enl;
    private String etN = "";
    private String etO = "";
    private int etP;
    private String etQ = "";
    private long etR;
    private String ewV = "";
    private long ews;
    private String eyL = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21017;
    }

    public final cy ob(String str) {
        AppMethodBeat.i(220175);
        this.etN = x("FinderUsrname", str, true);
        AppMethodBeat.o(220175);
        return this;
    }

    public final String acG() {
        return this.etN;
    }

    public final cy oc(String str) {
        AppMethodBeat.i(220176);
        this.etO = x("FinderWxAppInfo", str, true);
        AppMethodBeat.o(220176);
        return this;
    }

    public final String acH() {
        return this.etO;
    }

    public final cy kA(int i2) {
        this.etP = i2;
        return this;
    }

    public final int acI() {
        return this.etP;
    }

    public final cy od(String str) {
        AppMethodBeat.i(220177);
        this.etQ = x("FinderSessionId", str, true);
        AppMethodBeat.o(220177);
        return this;
    }

    public final String acJ() {
        return this.etQ;
    }

    public final cy iC(long j2) {
        AppMethodBeat.i(220178);
        this.etR = j2;
        super.bi("ActionTimeMs", this.etR);
        AppMethodBeat.o(220178);
        return this;
    }

    public final long acK() {
        return this.etR;
    }

    public final cy iD(long j2) {
        this.enl = j2;
        return this;
    }

    public final long acL() {
        return this.enl;
    }

    public final cy oe(String str) {
        AppMethodBeat.i(220179);
        this.eyL = x("ActionJson", str, true);
        AppMethodBeat.o(220179);
        return this;
    }

    public final String aeO() {
        return this.eyL;
    }

    public final cy iE(long j2) {
        this.ews = j2;
        return this;
    }

    public final long adn() {
        return this.ews;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(220180);
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
        stringBuffer.append(",");
        stringBuffer.append(this.emk);
        stringBuffer.append(",");
        stringBuffer.append(this.ewV);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(220180);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(220181);
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
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ConnectCount:").append(this.emk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ConnectDuration:").append(this.ewV);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(220181);
        return stringBuffer2;
    }
}
