package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class dd extends a {
    private String els = "";
    private String eno = "";
    private int enq;
    private int eqe;
    private String eqv = "";
    private String esd = "";
    private int evn;
    private String evo = "";
    private int evp;
    private int evq;
    private int ezc;
    private int ezd;
    private String eze = "";
    private int ezf;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22178;
    }

    public final dd ol(String str) {
        AppMethodBeat.i(209091);
        this.eno = x("RequestId", str, true);
        AppMethodBeat.o(209091);
        return this;
    }

    public final dd om(String str) {
        AppMethodBeat.i(209092);
        this.eqv = x("Query", str, true);
        AppMethodBeat.o(209092);
        return this;
    }

    public final dd kB(int i2) {
        this.ezc = i2;
        return this;
    }

    public final dd kC(int i2) {
        this.ezd = i2;
        return this;
    }

    public final dd on(String str) {
        AppMethodBeat.i(209093);
        this.evo = x("ItemId", str, true);
        AppMethodBeat.o(209093);
        return this;
    }

    public final dd kD(int i2) {
        this.evp = i2;
        return this;
    }

    public final dd kE(int i2) {
        this.enq = i2;
        return this;
    }

    public final dd afc() {
        this.evq = 1;
        return this;
    }

    public final dd oo(String str) {
        AppMethodBeat.i(209094);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(209094);
        return this;
    }

    public final dd op(String str) {
        AppMethodBeat.i(209095);
        this.esd = x("clicktabcontextid", str, true);
        AppMethodBeat.o(209095);
        return this;
    }

    public final dd kF(int i2) {
        this.evn = i2;
        return this;
    }

    public final dd oq(String str) {
        AppMethodBeat.i(209096);
        this.eze = x("searchSessionid", str, true);
        AppMethodBeat.o(209096);
        return this;
    }

    public final dd kG(int i2) {
        this.eqe = i2;
        return this;
    }

    public final dd kH(int i2) {
        this.ezf = i2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209097);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eno);
        stringBuffer.append(",");
        stringBuffer.append(this.eqv);
        stringBuffer.append(",");
        stringBuffer.append(this.ezc);
        stringBuffer.append(",");
        stringBuffer.append(this.ezd);
        stringBuffer.append(",");
        stringBuffer.append(this.evo);
        stringBuffer.append(",");
        stringBuffer.append(this.evp);
        stringBuffer.append(",");
        stringBuffer.append(this.enq);
        stringBuffer.append(",");
        stringBuffer.append(this.evq);
        stringBuffer.append(",");
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.esd);
        stringBuffer.append(",");
        stringBuffer.append(this.evn);
        stringBuffer.append(",");
        stringBuffer.append(this.eze);
        stringBuffer.append(",");
        stringBuffer.append(this.eqe);
        stringBuffer.append(",");
        stringBuffer.append(this.ezf);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209097);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209098);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RequestId:").append(this.eno);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Query:").append(this.eqv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RequestType:").append(this.ezc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemType:").append(this.ezd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemId:").append(this.evo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Position:").append(this.evp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.enq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("myAccountType:").append(this.evq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clicktabcontextid:").append(this.esd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("commentScene:").append(this.evn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("searchSessionid:").append(this.eze);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionType:").append(this.eqe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("searchType:").append(this.ezf);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209098);
        return stringBuffer2;
    }
}
