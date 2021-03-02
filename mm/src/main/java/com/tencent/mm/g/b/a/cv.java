package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class cv extends a {
    private String els = "";
    private String exA = "";
    private int exC;
    private String exD = "";
    private String exE = "";
    private String exF = "";
    private String exG = "";
    private int exI;
    private int exJ;
    private long exM;
    private String exN = "";
    private long exO;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21248;
    }

    public final cv nD(String str) {
        AppMethodBeat.i(209064);
        this.exA = x("appuin", str, true);
        AppMethodBeat.o(209064);
        return this;
    }

    public final cv aeo() {
        this.exM = 0;
        return this;
    }

    public final cv aep() {
        this.exC = 10;
        return this;
    }

    public final cv nE(String str) {
        AppMethodBeat.i(209065);
        this.exD = x("networktype", str, true);
        AppMethodBeat.o(209065);
        return this;
    }

    public final cv nF(String str) {
        AppMethodBeat.i(209066);
        this.exN = x("prewarmpath", str, true);
        AppMethodBeat.o(209066);
        return this;
    }

    public final cv km(int i2) {
        this.exI = i2;
        return this;
    }

    public final cv kn(int i2) {
        this.exJ = i2;
        return this;
    }

    public final cv nG(String str) {
        AppMethodBeat.i(209067);
        this.exE = x("liveid", str, true);
        AppMethodBeat.o(209067);
        return this;
    }

    public final cv nH(String str) {
        AppMethodBeat.i(209068);
        this.exF = x("finderid", str, true);
        AppMethodBeat.o(209068);
        return this;
    }

    public final cv nI(String str) {
        AppMethodBeat.i(209069);
        this.exG = x("shopwindowid", str, true);
        AppMethodBeat.o(209069);
        return this;
    }

    public final cv nJ(String str) {
        AppMethodBeat.i(209070);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(209070);
        return this;
    }

    public final cv hS(long j2) {
        this.exO = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209071);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.exA);
        stringBuffer.append(",");
        stringBuffer.append(this.exM);
        stringBuffer.append(",");
        stringBuffer.append(this.exC);
        stringBuffer.append(",");
        stringBuffer.append(this.exD);
        stringBuffer.append(",");
        stringBuffer.append(this.exN);
        stringBuffer.append(",");
        stringBuffer.append(this.exI);
        stringBuffer.append(",");
        stringBuffer.append(this.exJ);
        stringBuffer.append(",");
        stringBuffer.append(this.exE);
        stringBuffer.append(",");
        stringBuffer.append(this.exF);
        stringBuffer.append(",");
        stringBuffer.append(this.exG);
        stringBuffer.append(",");
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.exO);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209071);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209072);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appuin:").append(this.exA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appversion:").append(this.exM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("apptype:").append(this.exC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("networktype:").append(this.exD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("prewarmpath:").append(this.exN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ispresend:").append(this.exI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ispreload:").append(this.exJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveid:").append(this.exE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("finderid:").append(this.exF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("shopwindowid:").append(this.exG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("eventtime:").append(this.exO);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209072);
        return stringBuffer2;
    }
}
