package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class cx extends a {
    private long evv;
    private int eyA;
    private int eyB;
    private String eyC = "";
    private int eyD;
    private int eyE;
    private String eyF = "";
    private String eyG = "";
    private String eyH = "";
    private long eyI;
    private long eyJ;
    private String eyK = "";
    private int eyp;
    private int eyq;
    private int eyr;
    private int eys;
    private long eyt;
    private long eyu;
    private long eyv;
    private long eyw;
    private int eyx;
    private int eyy;
    private String eyz = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21313;
    }

    public final cx iv(long j2) {
        this.evv = j2;
        return this;
    }

    public final cx kq(int i2) {
        this.eyp = i2;
        return this;
    }

    public final cx kr(int i2) {
        this.eyq = i2;
        return this;
    }

    public final cx ks(int i2) {
        this.eyr = i2;
        return this;
    }

    public final cx kt(int i2) {
        this.eys = i2;
        return this;
    }

    public final cx iw(long j2) {
        this.eyt = j2;
        return this;
    }

    public final cx ix(long j2) {
        this.eyu = j2;
        return this;
    }

    public final cx iy(long j2) {
        this.eyv = j2;
        return this;
    }

    public final cx iz(long j2) {
        this.eyw = j2;
        return this;
    }

    public final cx ku(int i2) {
        this.eyx = i2;
        return this;
    }

    public final cx kv(int i2) {
        this.eyy = i2;
        return this;
    }

    public final cx nV(String str) {
        AppMethodBeat.i(209073);
        this.eyz = x("statistics", str, true);
        AppMethodBeat.o(209073);
        return this;
    }

    public final cx kw(int i2) {
        this.eyA = i2;
        return this;
    }

    public final cx kx(int i2) {
        this.eyB = i2;
        return this;
    }

    public final cx nW(String str) {
        AppMethodBeat.i(209074);
        this.eyC = x("cgiErrmsg", str, true);
        AppMethodBeat.o(209074);
        return this;
    }

    public final cx ky(int i2) {
        this.eyD = i2;
        return this;
    }

    public final cx kz(int i2) {
        this.eyE = i2;
        return this;
    }

    public final cx nX(String str) {
        AppMethodBeat.i(209075);
        this.eyF = x("liveEventMsg", str, true);
        AppMethodBeat.o(209075);
        return this;
    }

    public final cx nY(String str) {
        AppMethodBeat.i(209076);
        this.eyG = x("extra", str, true);
        AppMethodBeat.o(209076);
        return this;
    }

    public final cx nZ(String str) {
        AppMethodBeat.i(209077);
        this.eyH = x("snn", str, true);
        AppMethodBeat.o(209077);
        return this;
    }

    public final cx iA(long j2) {
        this.eyI = j2;
        return this;
    }

    public final cx iB(long j2) {
        this.eyJ = j2;
        return this;
    }

    public final cx oa(String str) {
        AppMethodBeat.i(209078);
        this.eyK = x("localsession", str, true);
        AppMethodBeat.o(209078);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209079);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.evv);
        stringBuffer.append(",");
        stringBuffer.append(this.eyp);
        stringBuffer.append(",");
        stringBuffer.append(this.eyq);
        stringBuffer.append(",");
        stringBuffer.append(this.eyr);
        stringBuffer.append(",");
        stringBuffer.append(this.eys);
        stringBuffer.append(",");
        stringBuffer.append(this.eyt);
        stringBuffer.append(",");
        stringBuffer.append(this.eyu);
        stringBuffer.append(",");
        stringBuffer.append(this.eyv);
        stringBuffer.append(",");
        stringBuffer.append(this.eyw);
        stringBuffer.append(",");
        stringBuffer.append(this.eyx);
        stringBuffer.append(",");
        stringBuffer.append(this.eyy);
        stringBuffer.append(",");
        stringBuffer.append(this.eyz);
        stringBuffer.append(",");
        stringBuffer.append(this.eyA);
        stringBuffer.append(",");
        stringBuffer.append(this.eyB);
        stringBuffer.append(",");
        stringBuffer.append(this.eyC);
        stringBuffer.append(",");
        stringBuffer.append(this.eyD);
        stringBuffer.append(",");
        stringBuffer.append(this.eyE);
        stringBuffer.append(",");
        stringBuffer.append(this.eyF);
        stringBuffer.append(",");
        stringBuffer.append(this.eyG);
        stringBuffer.append(",");
        stringBuffer.append(this.eyH);
        stringBuffer.append(",");
        stringBuffer.append(this.eyI);
        stringBuffer.append(",");
        stringBuffer.append(this.eyJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eyK);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209079);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209080);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("innerVersion:").append(this.evv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveRole:").append(this.eyp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("shop:").append(this.eyq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("prerenderType:").append(this.eyr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("performanceLevel:").append(this.eys);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("postTime:").append(this.eyt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("shareLiveTime:").append(this.eyu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("joinLiveTime:").append(this.eyv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("enterRoomTime:").append(this.eyw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveStates:").append(this.eyx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("uiStates:").append(this.eyy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("statistics:").append(this.eyz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cgiErrcode:").append(this.eyA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cgiErrtype:").append(this.eyB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cgiErrmsg:").append(this.eyC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveEventCode:").append(this.eyD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveEventSubCode:").append(this.eyE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveEventMsg:").append(this.eyF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("extra:").append(this.eyG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("snn:").append(this.eyH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveid:").append(this.eyI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("networkQuality:").append(this.eyJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("localsession:").append(this.eyK);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209080);
        return stringBuffer2;
    }
}
