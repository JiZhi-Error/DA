package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class or extends a {
    private long eDm;
    private long erw;
    private int oIt;
    private int oIu;
    private String osA = "";
    private int osB;
    private String osp = "";
    private String osq = "";
    private long pdO;
    private long pdP;
    private long pdQ;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22278;
    }

    public final or QE(long j2) {
        this.erw = j2;
        return this;
    }

    public final or bwt(String str) {
        AppMethodBeat.i(259153);
        this.osA = x("contextId", str, true);
        AppMethodBeat.o(259153);
        return this;
    }

    public final or bwu(String str) {
        AppMethodBeat.i(259154);
        this.osp = x("mvObjectId", str, true);
        AppMethodBeat.o(259154);
        return this;
    }

    public final or bwv(String str) {
        AppMethodBeat.i(259155);
        this.osq = x("mvNonceId", str, true);
        AppMethodBeat.o(259155);
        return this;
    }

    public final or abO(int i2) {
        this.osB = i2;
        return this;
    }

    public final or akp(int i2) {
        this.oIt = i2;
        return this;
    }

    public final or akq(int i2) {
        this.oIu = i2;
        return this;
    }

    public final or QF(long j2) {
        this.eDm = j2;
        return this;
    }

    public final or QG(long j2) {
        this.pdO = j2;
        return this;
    }

    public final or QH(long j2) {
        this.pdP = j2;
        return this;
    }

    public final or QI(long j2) {
        this.pdQ = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(259156);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erw);
        stringBuffer.append(",");
        stringBuffer.append(this.osA);
        stringBuffer.append(",");
        stringBuffer.append(this.osp);
        stringBuffer.append(",");
        stringBuffer.append(this.osq);
        stringBuffer.append(",");
        stringBuffer.append(this.osB);
        stringBuffer.append(",");
        stringBuffer.append(this.oIt);
        stringBuffer.append(",");
        stringBuffer.append(this.oIu);
        stringBuffer.append(",");
        stringBuffer.append(this.eDm);
        stringBuffer.append(",");
        stringBuffer.append(this.pdO);
        stringBuffer.append(",");
        stringBuffer.append(this.pdP);
        stringBuffer.append(",");
        stringBuffer.append(this.pdQ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(259156);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(259157);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("scene:").append(this.erw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("contextId:").append(this.osA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("mvObjectId:").append(this.osp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("mvNonceId:").append(this.osq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("mvIndex:").append(this.osB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isChanged:").append(this.oIt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isLocal:").append(this.oIu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FirstFrameTime:").append(this.eDm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WaitCount:").append(this.pdO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayErrType:").append(this.pdP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayErrCode:").append(this.pdQ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(259157);
        return stringBuffer2;
    }
}
