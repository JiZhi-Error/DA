package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fg extends a {
    private String eFc = "";
    private long eFd;
    private long eFl;
    private long eFr;
    private long eFs;
    private long eFt;
    private long eFu;
    private long eFv;
    private long eFw;
    private long enL;
    private long erw;
    private String evz = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19890;
    }

    public final fg afY() {
        this.erw = 1;
        return this;
    }

    public final fg se(String str) {
        AppMethodBeat.i(207417);
        this.eFc = x("roomid", str, true);
        AppMethodBeat.o(207417);
        return this;
    }

    public final fg nu(long j2) {
        this.eFr = j2;
        return this;
    }

    public final fg nv(long j2) {
        this.eFs = j2;
        return this;
    }

    public final fg sf(String str) {
        AppMethodBeat.i(207418);
        this.evz = x("topic", str, true);
        AppMethodBeat.o(207418);
        return this;
    }

    public final fg nw(long j2) {
        this.eFt = j2;
        return this;
    }

    public final fg nx(long j2) {
        this.eFu = j2;
        return this;
    }

    public final fg ny(long j2) {
        this.eFv = j2;
        return this;
    }

    public final fg nz(long j2) {
        this.enL = j2;
        return this;
    }

    public final fg nA(long j2) {
        this.eFw = j2;
        return this;
    }

    public final fg nB(long j2) {
        this.eFd = j2;
        return this;
    }

    public final fg nC(long j2) {
        this.eFl = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(207419);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erw);
        stringBuffer.append(",");
        stringBuffer.append(this.eFc);
        stringBuffer.append(",");
        stringBuffer.append(this.eFr);
        stringBuffer.append(",");
        stringBuffer.append(this.eFs);
        stringBuffer.append(",");
        stringBuffer.append(this.evz);
        stringBuffer.append(",");
        stringBuffer.append(this.eFt);
        stringBuffer.append(",");
        stringBuffer.append(this.eFu);
        stringBuffer.append(",");
        stringBuffer.append(this.eFv);
        stringBuffer.append(",");
        stringBuffer.append(this.enL);
        stringBuffer.append(",");
        stringBuffer.append(this.eFw);
        stringBuffer.append(",");
        stringBuffer.append(this.eFd);
        stringBuffer.append(",");
        stringBuffer.append(this.eFl);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(207419);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(207420);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("scene:").append(this.erw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("roomid:").append(this.eFc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("rulePop:").append(this.eFr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ruleCheck:").append(this.eFs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("topic:").append(this.evz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("customTopic:").append(this.eFt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cameraStatus:").append(this.eFu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("horizontalStatus:").append(this.eFv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("exitType:").append(this.enL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("errcode:").append(this.eFw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("roomRole:").append(this.eFd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("roomCount:").append(this.eFl);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(207420);
        return stringBuffer2;
    }
}
