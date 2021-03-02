package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class os extends a {
    private long eCU;
    private long eDm;
    private long eDo;
    private long erw;
    private String osA = "";
    private String osp = "";
    private String osq = "";
    private String pdR = "";
    private long pdT;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22222;
    }

    public final os QJ(long j2) {
        this.erw = j2;
        return this;
    }

    public final os bww(String str) {
        AppMethodBeat.i(259158);
        this.osA = x("contextId", str, true);
        AppMethodBeat.o(259158);
        return this;
    }

    public final os bwx(String str) {
        AppMethodBeat.i(259159);
        this.osp = x("mvObjectId", str, true);
        AppMethodBeat.o(259159);
        return this;
    }

    public final os bwy(String str) {
        AppMethodBeat.i(259160);
        this.osq = x("mvNonceId", str, true);
        AppMethodBeat.o(259160);
        return this;
    }

    public final os QK(long j2) {
        this.eDm = j2;
        return this;
    }

    public final os QL(long j2) {
        this.eDo = j2;
        return this;
    }

    public final os QM(long j2) {
        this.eCU = j2;
        return this;
    }

    public final os bwz(String str) {
        AppMethodBeat.i(259161);
        this.pdR = x("VideoPlayInfo", str, true);
        AppMethodBeat.o(259161);
        return this;
    }

    public final os QN(long j2) {
        this.pdT = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(259162);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erw);
        stringBuffer.append(",");
        stringBuffer.append(this.osA);
        stringBuffer.append(",");
        stringBuffer.append(this.osp);
        stringBuffer.append(",");
        stringBuffer.append(this.osq);
        stringBuffer.append(",");
        stringBuffer.append(this.eDm);
        stringBuffer.append(",");
        stringBuffer.append(this.eDo);
        stringBuffer.append(",");
        stringBuffer.append(this.eCU);
        stringBuffer.append(",");
        stringBuffer.append(this.pdR);
        stringBuffer.append(",");
        stringBuffer.append(this.pdT);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(259162);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(259163);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("scene:").append(this.erw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("contextId:").append(this.osA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("mvObjectId:").append(this.osp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("mvNonceId:").append(this.osq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FirstFrameTime:").append(this.eDm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WaittingCount:").append(this.eDo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayTime:").append(this.eCU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoPlayInfo:").append(this.pdR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoErrCount:").append(this.pdT);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(259163);
        return stringBuffer2;
    }
}
