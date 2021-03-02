package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class hi extends a {
    private String eLB = "";
    private String eLC = "";
    private long eLD = 0;
    private long eLE = 0;
    private long eLF = 0;
    private String eLG = "";
    private String eLH = "";
    private String eLI = "";
    private String eLJ = "";
    private long ejA = 0;
    private String eqi = "";
    private String eqj = "";
    private long erY = 0;
    private long euV = 0;
    private long exh = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18739;
    }

    public final hi qN(long j2) {
        this.exh = j2;
        return this;
    }

    public final hi qO(long j2) {
        this.ejA = j2;
        return this;
    }

    public final hi uW(String str) {
        AppMethodBeat.i(104424);
        this.eLB = x("SourcePid", str, true);
        AppMethodBeat.o(104424);
        return this;
    }

    public final hi uX(String str) {
        AppMethodBeat.i(104425);
        this.eLC = x("SourceMd5", str, true);
        AppMethodBeat.o(104425);
        return this;
    }

    public final hi uY(String str) {
        AppMethodBeat.i(104426);
        this.eqi = x("Pid", str, true);
        AppMethodBeat.o(104426);
        return this;
    }

    public final String agU() {
        return this.eqi;
    }

    public final hi uZ(String str) {
        AppMethodBeat.i(104427);
        this.eqj = x("Md5", str, true);
        AppMethodBeat.o(104427);
        return this;
    }

    public final String getMd5() {
        return this.eqj;
    }

    public final hi qP(long j2) {
        this.euV = j2;
        return this;
    }

    public final hi agV() {
        this.eLD = 4;
        return this;
    }

    public final hi va(String str) {
        AppMethodBeat.i(104428);
        this.eLG = x("IsFree2", str, true);
        AppMethodBeat.o(104428);
        return this;
    }

    public final String agW() {
        return this.eLG;
    }

    public final hi vb(String str) {
        AppMethodBeat.i(104429);
        this.eLH = x("Type2", str, true);
        AppMethodBeat.o(104429);
        return this;
    }

    public final String agX() {
        return this.eLH;
    }

    public final hi vc(String str) {
        AppMethodBeat.i(104430);
        this.eLI = x("IsLocal2", str, true);
        AppMethodBeat.o(104430);
        return this;
    }

    public final String agY() {
        return this.eLI;
    }

    public final hi vd(String str) {
        AppMethodBeat.i(199743);
        this.eLJ = x("ChatID", str, true);
        AppMethodBeat.o(199743);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(104431);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.exh);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.eLB);
        stringBuffer.append(",");
        stringBuffer.append(this.eLC);
        stringBuffer.append(",");
        stringBuffer.append(this.eqi);
        stringBuffer.append(",");
        stringBuffer.append(this.eqj);
        stringBuffer.append(",");
        stringBuffer.append(this.euV);
        stringBuffer.append(",");
        stringBuffer.append(this.eLD);
        stringBuffer.append(",");
        stringBuffer.append(this.eLE);
        stringBuffer.append(",");
        stringBuffer.append(this.erY);
        stringBuffer.append(",");
        stringBuffer.append(this.eLF);
        stringBuffer.append(",");
        stringBuffer.append(this.eLG);
        stringBuffer.append(",");
        stringBuffer.append(this.eLH);
        stringBuffer.append(",");
        stringBuffer.append(this.eLI);
        stringBuffer.append(",");
        stringBuffer.append(this.eLJ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(104431);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(104432);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.exh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourcePid:").append(this.eLB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceMd5:").append(this.eLC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Pid:").append(this.eqi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Md5:").append(this.eqj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Index:").append(this.euV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MaxRowCount:").append(this.eLD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsFree:").append(this.eLE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Type:").append(this.erY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsLocal:").append(this.eLF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsFree2:").append(this.eLG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Type2:").append(this.eLH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsLocal2:").append(this.eLI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChatID:").append(this.eLJ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(104432);
        return stringBuffer2;
    }
}
