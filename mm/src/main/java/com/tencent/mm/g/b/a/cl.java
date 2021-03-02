package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class cl extends a {
    private String elt = "";
    private String eoo = "";
    private String erU = "";
    private String euI = "";
    private String evX = "";
    private long evY;
    private long evZ;
    private long evt;
    private long ewa;
    private String ewb = "";
    private long ewc;
    private String ewd = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21564;
    }

    public final cl mf(String str) {
        AppMethodBeat.i(209022);
        this.erU = x("Sessionid", str, true);
        AppMethodBeat.o(209022);
        return this;
    }

    public final cl mg(String str) {
        AppMethodBeat.i(209023);
        this.elt = x("contextid", str, true);
        AppMethodBeat.o(209023);
        return this;
    }

    public final cl mh(String str) {
        AppMethodBeat.i(209024);
        this.evX = x("clickTabContextId", str, true);
        AppMethodBeat.o(209024);
        return this;
    }

    public final cl gv(long j2) {
        this.evY = j2;
        return this;
    }

    public final cl gw(long j2) {
        this.evZ = j2;
        return this;
    }

    public final cl gx(long j2) {
        this.ewa = j2;
        return this;
    }

    public final cl mi(String str) {
        AppMethodBeat.i(209025);
        this.ewb = x("cardid", str, true);
        AppMethodBeat.o(209025);
        return this;
    }

    public final cl gy(long j2) {
        this.ewc = j2;
        return this;
    }

    public final cl mj(String str) {
        AppMethodBeat.i(209026);
        this.ewd = x("cardTag", str, true);
        AppMethodBeat.o(209026);
        return this;
    }

    public final cl mk(String str) {
        AppMethodBeat.i(209027);
        this.euI = x("feedid", str, true);
        AppMethodBeat.o(209027);
        return this;
    }

    public final cl gz(long j2) {
        this.evt = j2;
        return this;
    }

    public final cl ml(String str) {
        AppMethodBeat.i(209028);
        this.eoo = x("SessionBuffer", str, true);
        AppMethodBeat.o(209028);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209029);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erU);
        stringBuffer.append(",");
        stringBuffer.append(this.elt);
        stringBuffer.append(",");
        stringBuffer.append(this.evX);
        stringBuffer.append(",");
        stringBuffer.append(this.evY);
        stringBuffer.append(",");
        stringBuffer.append(this.evZ);
        stringBuffer.append(",");
        stringBuffer.append(this.ewa);
        stringBuffer.append(",");
        stringBuffer.append(this.ewb);
        stringBuffer.append(",");
        stringBuffer.append(this.ewc);
        stringBuffer.append(",");
        stringBuffer.append(this.ewd);
        stringBuffer.append(",");
        stringBuffer.append(this.euI);
        stringBuffer.append(",");
        stringBuffer.append(this.evt);
        stringBuffer.append(",");
        stringBuffer.append(this.eoo);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209029);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209030);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Sessionid:").append(this.erU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("contextid:").append(this.elt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickTabContextId:").append(this.evX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("refreshTime:").append(this.evY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickType:").append(this.evZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickTime:").append(this.ewa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cardid:").append(this.ewb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cardIcon:").append(this.ewc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cardTag:").append(this.ewd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("feedid:").append(this.euI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("feedIndex:").append(this.evt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionBuffer:").append(this.eoo);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209030);
        return stringBuffer2;
    }
}
