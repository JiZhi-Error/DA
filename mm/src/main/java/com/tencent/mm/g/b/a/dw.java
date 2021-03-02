package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class dw extends a {
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
        return 18690;
    }

    public final dw qf(String str) {
        AppMethodBeat.i(209194);
        this.eno = x("RequestId", str, true);
        AppMethodBeat.o(209194);
        return this;
    }

    public final dw qg(String str) {
        AppMethodBeat.i(209195);
        this.eqv = x("Query", str, true);
        AppMethodBeat.o(209195);
        return this;
    }

    public final dw kX(int i2) {
        this.ezc = i2;
        return this;
    }

    public final dw kY(int i2) {
        this.ezd = i2;
        return this;
    }

    public final dw qh(String str) {
        AppMethodBeat.i(209196);
        this.evo = x("ItemId", str, true);
        AppMethodBeat.o(209196);
        return this;
    }

    public final dw kZ(int i2) {
        this.evp = i2;
        return this;
    }

    public final dw la(int i2) {
        this.enq = i2;
        return this;
    }

    public final dw afi() {
        this.evq = 1;
        return this;
    }

    public final dw qi(String str) {
        AppMethodBeat.i(209197);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(209197);
        return this;
    }

    public final dw qj(String str) {
        AppMethodBeat.i(209198);
        this.esd = x("clicktabcontextid", str, true);
        AppMethodBeat.o(209198);
        return this;
    }

    public final dw lb(int i2) {
        this.evn = i2;
        return this;
    }

    public final dw qk(String str) {
        AppMethodBeat.i(209199);
        this.eze = x("searchSessionid", str, true);
        AppMethodBeat.o(209199);
        return this;
    }

    public final dw afj() {
        this.eqe = 2;
        return this;
    }

    public final dw lc(int i2) {
        this.ezf = i2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209200);
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
        AppMethodBeat.o(209200);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209201);
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
        AppMethodBeat.o(209201);
        return stringBuffer2;
    }
}
