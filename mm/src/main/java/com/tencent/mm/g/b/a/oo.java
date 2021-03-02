package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class oo extends a {
    private long eJB;
    private String eJC = "";
    private long eJD;
    private long eJE;
    private String eJK = "";
    private String eJu = "";
    private String eJv = "";
    private String eJw = "";
    private String eJx = "";
    private String eJy = "";
    private long eOZ;
    private String eoz = "";
    private long erW;
    private long orH;
    private long orI;
    private long orJ;
    private String osp = "";
    private String osq = "";
    private long osr;
    private long oss;
    private String ost = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22224;
    }

    public final oo bvP(String str) {
        AppMethodBeat.i(259117);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(259117);
        return this;
    }

    public final oo bvQ(String str) {
        AppMethodBeat.i(259118);
        this.eJu = x("SongName", str, true);
        AppMethodBeat.o(259118);
        return this;
    }

    public final oo bvR(String str) {
        AppMethodBeat.i(259119);
        this.eJv = x("WebUrl", str, true);
        AppMethodBeat.o(259119);
        return this;
    }

    public final oo bvS(String str) {
        AppMethodBeat.i(259120);
        this.eJw = x("DataUrl", str, true);
        AppMethodBeat.o(259120);
        return this;
    }

    public final oo Qm(long j2) {
        this.erW = j2;
        return this;
    }

    public final oo bvT(String str) {
        AppMethodBeat.i(259121);
        this.eJy = x("FromSourceId", str, true);
        AppMethodBeat.o(259121);
        return this;
    }

    public final oo bvU(String str) {
        AppMethodBeat.i(259122);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(259122);
        return this;
    }

    public final oo bvV(String str) {
        AppMethodBeat.i(259123);
        this.osp = x("mvObjectId", str, true);
        AppMethodBeat.o(259123);
        return this;
    }

    public final oo bvW(String str) {
        AppMethodBeat.i(259124);
        this.osq = x("mvNonceId", str, true);
        AppMethodBeat.o(259124);
        return this;
    }

    public final oo Qn(long j2) {
        this.eJB = j2;
        return this;
    }

    public final oo Qo(long j2) {
        this.eJD = j2;
        return this;
    }

    public final oo Qp(long j2) {
        this.eJE = j2;
        return this;
    }

    public final oo Qq(long j2) {
        this.osr = j2;
        return this;
    }

    public final oo Qr(long j2) {
        this.orJ = j2;
        return this;
    }

    public final oo Qs(long j2) {
        this.eOZ = j2;
        return this;
    }

    public final oo bvX(String str) {
        AppMethodBeat.i(259125);
        this.eJC = x("SongId", str, true);
        AppMethodBeat.o(259125);
        return this;
    }

    public final oo Qt(long j2) {
        this.orH = j2;
        return this;
    }

    public final oo Qu(long j2) {
        this.orI = j2;
        return this;
    }

    public final long aFP() {
        return this.orI;
    }

    public final oo Qv(long j2) {
        this.oss = j2;
        return this;
    }

    public final oo bvY(String str) {
        AppMethodBeat.i(259126);
        this.ost = x("mvUserId", str, true);
        AppMethodBeat.o(259126);
        return this;
    }

    public final oo bvZ(String str) {
        AppMethodBeat.i(259127);
        this.eJK = x("Singer", str, true);
        AppMethodBeat.o(259127);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(259128);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.eJu);
        stringBuffer.append(",");
        stringBuffer.append(this.eJv);
        stringBuffer.append(",");
        stringBuffer.append(this.eJw);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.eJy);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.osp);
        stringBuffer.append(",");
        stringBuffer.append(this.osq);
        stringBuffer.append(",");
        stringBuffer.append(this.eJB);
        stringBuffer.append(",");
        stringBuffer.append(this.eJD);
        stringBuffer.append(",");
        stringBuffer.append(this.eJE);
        stringBuffer.append(",");
        stringBuffer.append(this.osr);
        stringBuffer.append(",");
        stringBuffer.append(this.orJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eOZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eJC);
        stringBuffer.append(",");
        stringBuffer.append(this.orH);
        stringBuffer.append(",");
        stringBuffer.append(this.orI);
        stringBuffer.append(",");
        stringBuffer.append(this.oss);
        stringBuffer.append(",");
        stringBuffer.append(this.ost);
        stringBuffer.append(",");
        stringBuffer.append(this.eJK);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(259128);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(259129);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SongName:").append(this.eJu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WebUrl:").append(this.eJv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DataUrl:").append(this.eJw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FromSourceId:").append(this.eJy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("mvObjectId:").append(this.osp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("mvNonceId:").append(this.osq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasLyric:").append(this.eJB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PCU:").append(this.eJD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FCU:").append(this.eJE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsCreateMv:").append(this.osr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayMvTime:").append(this.orJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsComment:").append(this.eOZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SongId:").append(this.eJC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MusicLength:").append(this.orH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayMusicTime:").append(this.orI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsDragProcess:").append(this.oss);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("mvUserId:").append(this.ost);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Singer:").append(this.eJK);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(259129);
        return stringBuffer2;
    }
}
