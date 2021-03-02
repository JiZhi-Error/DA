package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class kg extends a {
    private int eCw = -1;
    private int eUf = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20151;
    }

    public final kg lN(int i2) {
        this.eUf = i2;
        return this;
    }

    public final kg lO(int i2) {
        this.eCw = i2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(220221);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eUf);
        stringBuffer.append(",");
        stringBuffer.append(this.eCw);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(220221);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(220222);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("configId:").append(this.eUf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("result:").append(this.eCw);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(220222);
        return stringBuffer2;
    }
}
