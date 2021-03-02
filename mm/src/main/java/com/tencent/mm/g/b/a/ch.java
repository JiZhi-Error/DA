package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ch extends a {
    private String els = "";
    private String elu = "";
    private int enq;
    private int eqe;
    private int evn;
    private String evo = "";
    private int evp;
    private int evq;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22080;
    }

    public final ch lI(String str) {
        AppMethodBeat.i(208998);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(208998);
        return this;
    }

    public final ch lJ(String str) {
        AppMethodBeat.i(208999);
        this.elu = x("clickTabContextid", str, true);
        AppMethodBeat.o(208999);
        return this;
    }

    public final ch kb(int i2) {
        this.evn = i2;
        return this;
    }

    public final ch lK(String str) {
        AppMethodBeat.i(209000);
        this.evo = x("ItemId", str, true);
        AppMethodBeat.o(209000);
        return this;
    }

    public final ch kc(int i2) {
        this.evp = i2;
        return this;
    }

    public final ch adc() {
        this.enq = 1;
        return this;
    }

    public final ch ade() {
        this.evq = 1;
        return this;
    }

    public final ch kd(int i2) {
        this.eqe = i2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209001);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.elu);
        stringBuffer.append(",");
        stringBuffer.append(this.evn);
        stringBuffer.append(",");
        stringBuffer.append(this.evo);
        stringBuffer.append(",");
        stringBuffer.append(this.evp);
        stringBuffer.append(",");
        stringBuffer.append(this.enq);
        stringBuffer.append(",");
        stringBuffer.append(this.evq);
        stringBuffer.append(",");
        stringBuffer.append(this.eqe);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209001);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209002);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickTabContextid:").append(this.elu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("commentScene:").append(this.evn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemId:").append(this.evo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Position:").append(this.evp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.enq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("myAccountType:").append(this.evq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionType:").append(this.eqe);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209002);
        return stringBuffer2;
    }
}
