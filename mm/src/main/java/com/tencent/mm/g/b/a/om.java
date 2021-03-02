package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class om extends a {
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

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22232;
    }

    public final om aYK(String str) {
        AppMethodBeat.i(259085);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(259085);
        return this;
    }

    public final om aYL(String str) {
        AppMethodBeat.i(259086);
        this.eJu = x("SongName", str, true);
        AppMethodBeat.o(259086);
        return this;
    }

    public final om aZk(String str) {
        AppMethodBeat.i(259087);
        this.eJC = x("SongId", str, true);
        AppMethodBeat.o(259087);
        return this;
    }

    public final om aZl(String str) {
        AppMethodBeat.i(259088);
        this.eJv = x("WebUrl", str, true);
        AppMethodBeat.o(259088);
        return this;
    }

    public final om aZm(String str) {
        AppMethodBeat.i(259089);
        this.eJw = x("DataUrl", str, true);
        AppMethodBeat.o(259089);
        return this;
    }

    public final om PR(long j2) {
        this.enl = j2;
        return this;
    }

    public final om aZn(String str) {
        AppMethodBeat.i(259090);
        this.eJz = x("MvObjectId", str, true);
        AppMethodBeat.o(259090);
        return this;
    }

    public final om baX(String str) {
        AppMethodBeat.i(259091);
        this.eJA = x("MvNonceId", str, true);
        AppMethodBeat.o(259091);
        return this;
    }

    public final om bla(String str) {
        AppMethodBeat.i(259092);
        this.orF = x("MvUserId", str, true);
        AppMethodBeat.o(259092);
        return this;
    }

    public final om PS(long j2) {
        this.orH = j2;
        return this;
    }

    public final om PT(long j2) {
        this.orI = j2;
        return this;
    }

    public final om PU(long j2) {
        this.orJ = j2;
        return this;
    }

    public final om ble(String str) {
        AppMethodBeat.i(259093);
        this.etI = x("CommentId", str, true);
        AppMethodBeat.o(259093);
        return this;
    }

    public final om bnJ(String str) {
        AppMethodBeat.i(259094);
        this.eJK = x("Singer", str, true);
        AppMethodBeat.o(259094);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(259095);
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
        stringBuffer.append(this.eJK);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(259095);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(259096);
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
        stringBuffer.append("Singer:").append(this.eJK);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(259096);
        return stringBuffer2;
    }
}
