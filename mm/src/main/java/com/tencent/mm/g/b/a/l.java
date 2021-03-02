package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class l extends a {
    private String ekq = "";
    private int ekr;
    private int eks;
    private int ekt;
    private int eku;
    private String ekv = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22146;
    }

    public final l hP(String str) {
        AppMethodBeat.i(199737);
        this.ekq = x("Content", str, true);
        AppMethodBeat.o(199737);
        return this;
    }

    public final l jC(int i2) {
        this.ekr = i2;
        return this;
    }

    public final l jD(int i2) {
        this.eks = i2;
        return this;
    }

    public final l abZ() {
        this.ekt = 1;
        return this;
    }

    public final l jE(int i2) {
        this.eku = i2;
        return this;
    }

    public final l hQ(String str) {
        AppMethodBeat.i(199738);
        this.ekv = x("ChatId", str, true);
        AppMethodBeat.o(199738);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(199739);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ekq);
        stringBuffer.append(",");
        stringBuffer.append(this.ekr);
        stringBuffer.append(",");
        stringBuffer.append(this.eks);
        stringBuffer.append(",");
        stringBuffer.append(this.ekt);
        stringBuffer.append(",");
        stringBuffer.append(this.eku);
        stringBuffer.append(",");
        stringBuffer.append(this.ekv);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(199739);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(199740);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Content:").append(this.ekq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IfPlay:").append(this.ekr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IfPlaySuccess:").append(this.eks);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayFailReason:").append(this.ekt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RecentUse:").append(this.eku);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChatId:").append(this.ekv);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(199740);
        return stringBuffer2;
    }
}
