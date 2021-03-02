package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class oq extends a {
    private String eJA = "";
    private String eJC = "";
    private String eJK = "";
    private String eJu = "";
    private String eJv = "";
    private String eJw = "";
    private String eJz = "";
    private long enl;
    private String eoz = "";
    private String etI = "";
    private String orF = "";
    private long orH;
    private long orI;
    private long orJ;
    private String orK = "";
    private String osz = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22230;
    }

    public final oq bwj(String str) {
        AppMethodBeat.i(259141);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(259141);
        return this;
    }

    public final oq bwk(String str) {
        AppMethodBeat.i(259142);
        this.eJu = x("SongName", str, true);
        AppMethodBeat.o(259142);
        return this;
    }

    public final oq bwl(String str) {
        AppMethodBeat.i(259143);
        this.eJC = x("SongId", str, true);
        AppMethodBeat.o(259143);
        return this;
    }

    public final oq bwm(String str) {
        AppMethodBeat.i(259144);
        this.eJv = x("WebUrl", str, true);
        AppMethodBeat.o(259144);
        return this;
    }

    public final oq bwn(String str) {
        AppMethodBeat.i(259145);
        this.eJw = x("DataUrl", str, true);
        AppMethodBeat.o(259145);
        return this;
    }

    public final oq QA(long j2) {
        this.enl = j2;
        return this;
    }

    public final oq bwo(String str) {
        AppMethodBeat.i(259146);
        this.eJz = x("MvObjectId", str, true);
        AppMethodBeat.o(259146);
        return this;
    }

    public final oq bwp(String str) {
        AppMethodBeat.i(259147);
        this.eJA = x("MvNonceId", str, true);
        AppMethodBeat.o(259147);
        return this;
    }

    public final oq bwq(String str) {
        AppMethodBeat.i(259148);
        this.orF = x("MvUserId", str, true);
        AppMethodBeat.o(259148);
        return this;
    }

    public final oq QB(long j2) {
        this.orH = j2;
        return this;
    }

    public final oq QC(long j2) {
        this.orI = j2;
        return this;
    }

    public final oq QD(long j2) {
        this.orJ = j2;
        return this;
    }

    public final oq bwr(String str) {
        AppMethodBeat.i(259149);
        this.etI = x("CommentId", str, true);
        AppMethodBeat.o(259149);
        return this;
    }

    public final oq bws(String str) {
        AppMethodBeat.i(259150);
        this.eJK = x("Singer", str, true);
        AppMethodBeat.o(259150);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(259151);
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
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.eJz);
        stringBuffer.append(",");
        stringBuffer.append(this.eJA);
        stringBuffer.append(",");
        stringBuffer.append(this.orF);
        stringBuffer.append(",");
        stringBuffer.append(this.orH);
        stringBuffer.append(",");
        stringBuffer.append(this.orI);
        stringBuffer.append(",");
        stringBuffer.append(this.orJ);
        stringBuffer.append(",");
        stringBuffer.append(this.etI);
        stringBuffer.append(",");
        stringBuffer.append(this.orK);
        stringBuffer.append(",");
        stringBuffer.append(this.osz);
        stringBuffer.append(",");
        stringBuffer.append(this.eJK);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(259151);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(259152);
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
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MvObjectId:").append(this.eJz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MvNonceId:").append(this.eJA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MvUserId:").append(this.orF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MusicLength:").append(this.orH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayMusicTime:").append(this.orI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayMvTime:").append(this.orJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentId:").append(this.etI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentMessage:").append(this.orK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentUser:").append(this.osz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Singer:").append(this.eJK);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(259152);
        return stringBuffer2;
    }
}
