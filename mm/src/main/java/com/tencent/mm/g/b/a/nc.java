package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class nc extends a {
    private String eJx = "";
    private String eRc = "";
    private long eYW = 0;
    private String eZj = "";
    private long eZk = 0;
    private long ffZ = 0;
    private long fga = 0;
    private long fgb = 2;
    private long fgc = 3;
    private String fgd = "";
    private String fge = "";
    private long fgf = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18144;
    }

    public final nc Al(String str) {
        AppMethodBeat.i(43755);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(43755);
        return this;
    }

    public final String getAppId() {
        return this.eJx;
    }

    public final nc xy(long j2) {
        this.eYW = j2;
        return this;
    }

    public final nc xz(long j2) {
        AppMethodBeat.i(43756);
        this.ffZ = j2;
        super.bi("EventTimeMs", this.ffZ);
        AppMethodBeat.o(43756);
        return this;
    }

    public final nc Am(String str) {
        AppMethodBeat.i(43757);
        this.eZj = x("PagePath", str, true);
        AppMethodBeat.o(43757);
        return this;
    }

    public final nc An(String str) {
        AppMethodBeat.i(43758);
        this.eRc = x("VideoUrl", str, true);
        AppMethodBeat.o(43758);
        return this;
    }

    public final nc xA(long j2) {
        this.eZk = j2;
        return this;
    }

    public final nc xB(long j2) {
        this.fga = j2;
        return this;
    }

    public final nc xC(long j2) {
        this.fgb = j2;
        return this;
    }

    public final nc Ao(String str) {
        AppMethodBeat.i(43759);
        this.fgd = x("ModelName", str, true);
        AppMethodBeat.o(43759);
        return this;
    }

    public final nc Ap(String str) {
        AppMethodBeat.i(43760);
        this.fge = x("ManuFacturer", str, true);
        AppMethodBeat.o(43760);
        return this;
    }

    public final nc xD(long j2) {
        this.fgf = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(43761);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eYW);
        stringBuffer.append(",");
        stringBuffer.append(this.ffZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eZj);
        stringBuffer.append(",");
        stringBuffer.append(this.eRc);
        stringBuffer.append(",");
        stringBuffer.append(this.eZk);
        stringBuffer.append(",");
        stringBuffer.append(this.fga);
        stringBuffer.append(",");
        stringBuffer.append(this.fgb);
        stringBuffer.append(",");
        stringBuffer.append(this.fgc);
        stringBuffer.append(",");
        stringBuffer.append(this.fgd);
        stringBuffer.append(",");
        stringBuffer.append(this.fge);
        stringBuffer.append(",");
        stringBuffer.append(this.fgf);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43761);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43762);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppType:").append(this.eYW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EventTimeMs:").append(this.ffZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PagePath:").append(this.eZj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoUrl:").append(this.eRc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EventId:").append(this.eZk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DeviceCount:").append(this.fga);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CastResult:").append(this.fgb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ProtocolType:").append(this.fgc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ModelName:").append(this.fgd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ManuFacturer:").append(this.fge);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoState:").append(this.fgf);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43762);
        return stringBuffer2;
    }
}
