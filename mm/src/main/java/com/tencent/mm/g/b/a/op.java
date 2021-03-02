package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class op extends a {
    private long eJB;
    private String eJC = "";
    private String eJK = "";
    private String eJu = "";
    private String eJv = "";
    private String eJw = "";
    private String eJx = "";
    private long enl;
    private String eoz = "";
    private String osu = "";
    private String osv = "";
    private String osw = "";
    private long osx;
    private long osy;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22234;
    }

    public final op bwa(String str) {
        AppMethodBeat.i(259130);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(259130);
        return this;
    }

    public final op bwb(String str) {
        AppMethodBeat.i(259131);
        this.eJu = x("SongName", str, true);
        AppMethodBeat.o(259131);
        return this;
    }

    public final op bwc(String str) {
        AppMethodBeat.i(259132);
        this.eJC = x("SongId", str, true);
        AppMethodBeat.o(259132);
        return this;
    }

    public final op bwd(String str) {
        AppMethodBeat.i(259133);
        this.eJv = x("WebUrl", str, true);
        AppMethodBeat.o(259133);
        return this;
    }

    public final op bwe(String str) {
        AppMethodBeat.i(259134);
        this.eJw = x("DataUrl", str, true);
        AppMethodBeat.o(259134);
        return this;
    }

    public final op bwf(String str) {
        AppMethodBeat.i(259135);
        this.eJK = x("Singer", str, true);
        AppMethodBeat.o(259135);
        return this;
    }

    public final op Qw(long j2) {
        this.enl = j2;
        return this;
    }

    public final op bwg(String str) {
        AppMethodBeat.i(259136);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(259136);
        return this;
    }

    public final op Qx(long j2) {
        this.eJB = j2;
        return this;
    }

    public final op bwh(String str) {
        AppMethodBeat.i(259137);
        this.osu = x("Sect", str, true);
        AppMethodBeat.o(259137);
        return this;
    }

    public final op bwi(String str) {
        AppMethodBeat.i(259138);
        this.osv = x("CoverURL", str, true);
        AppMethodBeat.o(259138);
        return this;
    }

    public final op Qy(long j2) {
        this.osx = j2;
        return this;
    }

    public final op Qz(long j2) {
        this.osy = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(259139);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.eJu);
        stringBuffer.append(",");
        stringBuffer.append(this.eJC);
        stringBuffer.append(",");
        stringBuffer.append(this.eJv);
        stringBuffer.append(",");
        stringBuffer.append(this.eJw);
        stringBuffer.append(",");
        stringBuffer.append(this.eJK);
        stringBuffer.append(",");
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eJB);
        stringBuffer.append(",");
        stringBuffer.append(this.osu);
        stringBuffer.append(",");
        stringBuffer.append(this.osv);
        stringBuffer.append(",");
        stringBuffer.append(this.osw);
        stringBuffer.append(",");
        stringBuffer.append(this.osx);
        stringBuffer.append(",");
        stringBuffer.append(this.osy);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(259139);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(259140);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SongName:").append(this.eJu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SongId:").append(this.eJC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WebUrl:").append(this.eJv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DataUrl:").append(this.eJw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Singer:").append(this.eJK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasLyric:").append(this.eJB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Sect:").append(this.osu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CoverURL:").append(this.osv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Language:").append(this.osw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("JumpSuccess:").append(this.osx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("JumpScene:").append(this.osy);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(259140);
        return stringBuffer2;
    }
}
