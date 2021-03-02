package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jh extends a {
    private String eRb = "";
    private String eRc = "";
    private String eoR = "";
    public long eoS = 0;
    public long eoT = 0;
    public long eoU = 0;
    public long eoV = 0;
    public long eoW = 0;
    public long eoX = 0;
    public long eoY = 0;
    public long eoZ = 0;
    public long epa = 0;
    private String epb = "";
    public long epc = 0;
    public long epd = 0;
    public long epe = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16665;
    }

    public final jh wK(String str) {
        AppMethodBeat.i(126696);
        this.eRc = x("VideoUrl", str, true);
        AppMethodBeat.o(126696);
        return this;
    }

    public final jh wL(String str) {
        AppMethodBeat.i(126697);
        this.eoR = x("NewMd5", str, true);
        AppMethodBeat.o(126697);
        return this;
    }

    public final jh rN(long j2) {
        this.eoS = j2;
        return this;
    }

    public final jh rO(long j2) {
        this.eoT = j2;
        return this;
    }

    public final jh rP(long j2) {
        this.eoU = j2;
        return this;
    }

    public final jh rQ(long j2) {
        this.eoV = j2;
        return this;
    }

    public final jh rR(long j2) {
        this.eoW = j2;
        return this;
    }

    public final jh rS(long j2) {
        this.eoX = j2;
        return this;
    }

    public final jh rT(long j2) {
        this.eoY = j2;
        return this;
    }

    public final jh rU(long j2) {
        this.eoZ = j2;
        return this;
    }

    public final jh rV(long j2) {
        this.epa = j2;
        return this;
    }

    public final jh wM(String str) {
        AppMethodBeat.i(126698);
        this.epb = x("CDNIp", str, true);
        AppMethodBeat.o(126698);
        return this;
    }

    public final jh rW(long j2) {
        this.epc = j2;
        return this;
    }

    public final jh rX(long j2) {
        this.epd = j2;
        return this;
    }

    public final jh rY(long j2) {
        this.epe = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(126699);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eRb);
        stringBuffer.append(",");
        stringBuffer.append(this.eRc);
        stringBuffer.append(",");
        stringBuffer.append(this.eoR);
        stringBuffer.append(",");
        stringBuffer.append(this.eoS);
        stringBuffer.append(",");
        stringBuffer.append(this.eoT);
        stringBuffer.append(",");
        stringBuffer.append(this.eoU);
        stringBuffer.append(",");
        stringBuffer.append(this.eoV);
        stringBuffer.append(",");
        stringBuffer.append(this.eoW);
        stringBuffer.append(",");
        stringBuffer.append(this.eoX);
        stringBuffer.append(",");
        stringBuffer.append(this.eoY);
        stringBuffer.append(",");
        stringBuffer.append(this.eoZ);
        stringBuffer.append(",");
        stringBuffer.append(this.epa);
        stringBuffer.append(",");
        stringBuffer.append(this.epb);
        stringBuffer.append(",");
        stringBuffer.append(this.epc);
        stringBuffer.append(",");
        stringBuffer.append(this.epd);
        stringBuffer.append(",");
        stringBuffer.append(this.epe);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(126699);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(126700);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Tid:").append(this.eRb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoUrl:").append(this.eRc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NewMd5:").append(this.eoR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DownloadStartTime:").append(this.eoS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DownloadEndTime:").append(this.eoT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoSize:").append(this.eoU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoDuration:").append(this.eoV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoBitrate:").append(this.eoW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AudioBitrate:").append(this.eoX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoFps:").append(this.eoY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoWidth:").append(this.eoZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoHeight:").append(this.epa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CDNIp:").append(this.epb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriginalAudioChannel:").append(this.epc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HadPreloadSize:").append(this.epd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HadPreloadCompletion:").append(this.epe);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(126700);
        return stringBuffer2;
    }
}
