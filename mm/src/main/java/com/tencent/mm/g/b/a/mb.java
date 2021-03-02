package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.report.a;

public final class mb extends a {
    private long eFm;
    private String enR = "";
    private String exq = "";
    private String faS = "";
    private String faT = "";
    private long faU;
    private long faV;
    private long faW;
    private int faX;
    private int faY;
    private int faZ;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19127;
    }

    public final mb zl(String str) {
        AppMethodBeat.i(226064);
        this.faS = x("instanceId", str, true);
        AppMethodBeat.o(226064);
        return this;
    }

    public final mb zm(String str) {
        AppMethodBeat.i(226065);
        this.enR = x("appid", str, true);
        AppMethodBeat.o(226065);
        return this;
    }

    public final mb zn(String str) {
        AppMethodBeat.i(226066);
        this.faT = x(ch.COL_USERNAME, str, true);
        AppMethodBeat.o(226066);
        return this;
    }

    public final mb vB(long j2) {
        this.faU = j2;
        return this;
    }

    public final mb vC(long j2) {
        this.faV = j2;
        return this;
    }

    public final mb vD(long j2) {
        this.eFm = j2;
        return this;
    }

    public final mb zo(String str) {
        AppMethodBeat.i(226067);
        this.exq = x("networkType", str, true);
        AppMethodBeat.o(226067);
        return this;
    }

    public final mb vE(long j2) {
        this.faW = j2;
        return this;
    }

    public final mb mn(int i2) {
        this.faX = i2;
        return this;
    }

    public final mb mo(int i2) {
        this.faY = i2;
        return this;
    }

    public final mb mp(int i2) {
        this.faZ = i2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(226068);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.faS);
        stringBuffer.append(",");
        stringBuffer.append(this.enR);
        stringBuffer.append(",");
        stringBuffer.append(this.faT);
        stringBuffer.append(",");
        stringBuffer.append(this.faU);
        stringBuffer.append(",");
        stringBuffer.append(this.faV);
        stringBuffer.append(",");
        stringBuffer.append(this.eFm);
        stringBuffer.append(",");
        stringBuffer.append(this.exq);
        stringBuffer.append(",");
        stringBuffer.append(this.faW);
        stringBuffer.append(",");
        stringBuffer.append(this.faX);
        stringBuffer.append(",");
        stringBuffer.append(this.faY);
        stringBuffer.append(",");
        stringBuffer.append(this.faZ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(226068);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(226069);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("instanceId:").append(this.faS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appid:").append(this.enR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("username:").append(this.faT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("startTimeStamp:").append(this.faU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("endTimeStamp:").append(this.faV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("costTime:").append(this.eFm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("networkType:").append(this.exq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("responseSize:").append(this.faW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ret:").append(this.faX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("bizRet:").append(this.faY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cgiNo:").append(this.faZ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(226069);
        return stringBuffer2;
    }
}
