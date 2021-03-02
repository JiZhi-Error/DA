package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class cu extends a {
    private String els = "";
    private String exA = "";
    private String exB = "";
    private int exC;
    private String exD = "";
    private String exE = "";
    private String exF = "";
    private String exG = "";
    private long exH;
    private int exI;
    private int exJ;
    private long exK;
    private long exL;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21249;
    }

    public final cu nw(String str) {
        AppMethodBeat.i(209055);
        this.exA = x("appuin", str, true);
        AppMethodBeat.o(209055);
        return this;
    }

    public final cu nx(String str) {
        AppMethodBeat.i(209056);
        this.exB = x("appversion", str, true);
        AppMethodBeat.o(209056);
        return this;
    }

    public final cu aem() {
        this.exC = 10;
        return this;
    }

    public final cu ny(String str) {
        AppMethodBeat.i(209057);
        this.exD = x("networktype", str, true);
        AppMethodBeat.o(209057);
        return this;
    }

    public final cu nz(String str) {
        AppMethodBeat.i(209058);
        this.exE = x("liveid", str, true);
        AppMethodBeat.o(209058);
        return this;
    }

    public final cu nA(String str) {
        AppMethodBeat.i(209059);
        this.exF = x("finderid", str, true);
        AppMethodBeat.o(209059);
        return this;
    }

    public final cu nB(String str) {
        AppMethodBeat.i(209060);
        this.exG = x("shopwindowid", str, true);
        AppMethodBeat.o(209060);
        return this;
    }

    public final cu nC(String str) {
        AppMethodBeat.i(209061);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(209061);
        return this;
    }

    public final cu aen() {
        this.exH = 0;
        return this;
    }

    public final cu kk(int i2) {
        this.exI = i2;
        return this;
    }

    public final cu kl(int i2) {
        this.exJ = i2;
        return this;
    }

    public final cu hQ(long j2) {
        this.exK = j2;
        return this;
    }

    public final cu hR(long j2) {
        this.exL = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209062);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.exA);
        stringBuffer.append(",");
        stringBuffer.append(this.exB);
        stringBuffer.append(",");
        stringBuffer.append(this.exC);
        stringBuffer.append(",");
        stringBuffer.append(this.exD);
        stringBuffer.append(",");
        stringBuffer.append(this.exE);
        stringBuffer.append(",");
        stringBuffer.append(this.exF);
        stringBuffer.append(",");
        stringBuffer.append(this.exG);
        stringBuffer.append(",");
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.exH);
        stringBuffer.append(",");
        stringBuffer.append(this.exI);
        stringBuffer.append(",");
        stringBuffer.append(this.exJ);
        stringBuffer.append(",");
        stringBuffer.append(this.exK);
        stringBuffer.append(",");
        stringBuffer.append(this.exL);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209062);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209063);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appuin:").append(this.exA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appversion:").append(this.exB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("apptype:").append(this.exC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("networktype:").append(this.exD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveid:").append(this.exE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("finderid:").append(this.exF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("shopwindowid:").append(this.exG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickid:").append(this.exH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ispresend:").append(this.exI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ispreload:").append(this.exJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("prewarmstartime:").append(this.exK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("prewarmendtime:").append(this.exL);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209063);
        return stringBuffer2;
    }
}
