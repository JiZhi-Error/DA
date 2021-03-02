package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ea extends a {
    private String eBY = "";
    private long eBZ;
    private long eCa;
    private String eCb = "";
    private long eCc;
    private long eCd;
    private String eCe = "";
    private long eCf;
    private long eCg;
    private long erW;
    private long evI;
    private String exd = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20747;
    }

    public final ea qm(String str) {
        AppMethodBeat.i(209206);
        this.eBY = x("SessinId", str, true);
        AppMethodBeat.o(209206);
        return this;
    }

    public final ea lg(long j2) {
        this.erW = j2;
        return this;
    }

    public final ea lh(long j2) {
        this.eBZ = j2;
        return this;
    }

    public final ea li(long j2) {
        this.eCa = j2;
        return this;
    }

    public final ea qn(String str) {
        AppMethodBeat.i(209207);
        this.exd = x("SnsFeedId", str, true);
        AppMethodBeat.o(209207);
        return this;
    }

    public final ea qo(String str) {
        AppMethodBeat.i(209208);
        this.eCb = x("FinderFeedId", str, true);
        AppMethodBeat.o(209208);
        return this;
    }

    public final ea lj(long j2) {
        this.eCc = j2;
        return this;
    }

    public final long afk() {
        return this.eCc;
    }

    public final ea lk(long j2) {
        this.eCd = j2;
        return this;
    }

    public final ea qp(String str) {
        AppMethodBeat.i(209209);
        this.eCe = x("Wording", str, true);
        AppMethodBeat.o(209209);
        return this;
    }

    public final ea ll(long j2) {
        this.eCf = j2;
        return this;
    }

    public final ea lm(long j2) {
        this.eCg = j2;
        return this;
    }

    public final ea ln(long j2) {
        this.evI = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209210);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eBY);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.eBZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eCa);
        stringBuffer.append(",");
        stringBuffer.append(this.exd);
        stringBuffer.append(",");
        stringBuffer.append(this.eCb);
        stringBuffer.append(",");
        stringBuffer.append(this.eCc);
        stringBuffer.append(",");
        stringBuffer.append(this.eCd);
        stringBuffer.append(",");
        stringBuffer.append(this.eCe);
        stringBuffer.append(",");
        stringBuffer.append(this.eCf);
        stringBuffer.append(",");
        stringBuffer.append(this.eCg);
        stringBuffer.append(",");
        stringBuffer.append(this.evI);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209210);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209211);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessinId:").append(this.eBY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OperationTimestamp:").append(this.eBZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShootEntranceEndType:").append(this.eCa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SnsFeedId:").append(this.exd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderFeedId:").append(this.eCb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HaveFinderUsername:").append(this.eCc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HavePostFinderVideo:").append(this.eCd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Wording:").append(this.eCe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EntraceExposeMaxTimes:").append(this.eCf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EntractExposeTimes:").append(this.eCg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposeType:").append(this.evI);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209211);
        return stringBuffer2;
    }
}
