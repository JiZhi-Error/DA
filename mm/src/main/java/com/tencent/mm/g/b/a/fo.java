package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fo extends a {
    private String eFc = "";
    private long eFd;
    private String eFy = "";
    private long eFz;
    private long eGH;
    private long eGI;
    private String evz = "";
    private long eyI;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19898;
    }

    public final fo sy(String str) {
        AppMethodBeat.i(207447);
        this.eFc = x("roomid", str, true);
        AppMethodBeat.o(207447);
        return this;
    }

    public final fo oO(long j2) {
        this.eyI = j2;
        return this;
    }

    public final fo sz(String str) {
        AppMethodBeat.i(207448);
        this.evz = x("topic", str, true);
        AppMethodBeat.o(207448);
        return this;
    }

    public final fo sA(String str) {
        AppMethodBeat.i(207449);
        this.eFy = x("liveusername", str, true);
        AppMethodBeat.o(207449);
        return this;
    }

    public final fo oP(long j2) {
        this.eFz = j2;
        return this;
    }

    public final fo oQ(long j2) {
        this.eFd = j2;
        return this;
    }

    public final fo oR(long j2) {
        this.eGH = j2;
        return this;
    }

    public final fo oS(long j2) {
        this.eGI = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(207450);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eFc);
        stringBuffer.append(",");
        stringBuffer.append(this.eyI);
        stringBuffer.append(",");
        stringBuffer.append(this.evz);
        stringBuffer.append(",");
        stringBuffer.append(this.eFy);
        stringBuffer.append(",");
        stringBuffer.append(this.eFz);
        stringBuffer.append(",");
        stringBuffer.append(this.eFd);
        stringBuffer.append(",");
        stringBuffer.append(this.eGH);
        stringBuffer.append(",");
        stringBuffer.append(this.eGI);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(207450);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(207451);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("roomid:").append(this.eFc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveid:").append(this.eyI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("topic:").append(this.evz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveusername:").append(this.eFy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveRole:").append(this.eFz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("roomRole:").append(this.eFd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("wholeTime:").append(this.eGH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("viewTime:").append(this.eGI);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(207451);
        return stringBuffer2;
    }
}
