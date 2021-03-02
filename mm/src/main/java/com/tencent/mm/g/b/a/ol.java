package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ol extends a {
    private String eJC = "";
    private String eJK = "";
    private String eJu = "";
    private String eJv = "";
    private String eJw = "";
    private String eJx = "";
    private String eJy = "";
    public long enl;
    private String eoz = "";
    public long erW;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22243;
    }

    public final ol axG(String str) {
        AppMethodBeat.i(259303);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(259303);
        return this;
    }

    public final ol aDr(String str) {
        AppMethodBeat.i(259304);
        this.eJu = x("SongName", str, true);
        AppMethodBeat.o(259304);
        return this;
    }

    public final String aFd() {
        return this.eJu;
    }

    public final ol aTg(String str) {
        AppMethodBeat.i(259305);
        this.eJC = x("SongId", str, true);
        AppMethodBeat.o(259305);
        return this;
    }

    public final ol aTq(String str) {
        AppMethodBeat.i(259306);
        this.eJv = x("WebUrl", str, true);
        AppMethodBeat.o(259306);
        return this;
    }

    public final ol aWL(String str) {
        AppMethodBeat.i(259307);
        this.eJw = x("DataUrl", str, true);
        AppMethodBeat.o(259307);
        return this;
    }

    public final ol aWM(String str) {
        AppMethodBeat.i(259308);
        this.eJK = x("Singer", str, true);
        AppMethodBeat.o(259308);
        return this;
    }

    public final String aFO() {
        return this.eJK;
    }

    public final ol PP(long j2) {
        this.enl = j2;
        return this;
    }

    public final long acL() {
        return this.enl;
    }

    public final ol PQ(long j2) {
        this.erW = j2;
        return this;
    }

    public final long agC() {
        return this.erW;
    }

    public final ol aWS(String str) {
        AppMethodBeat.i(259309);
        this.eJy = x("FromSourceId", str, true);
        AppMethodBeat.o(259309);
        return this;
    }

    public final ol aYJ(String str) {
        AppMethodBeat.i(259310);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(259310);
        return this;
    }

    public final String getAppId() {
        return this.eJx;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(259311);
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
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.eJy);
        stringBuffer.append(",");
        stringBuffer.append(this.eJx);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(259311);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(259312);
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
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FromSourceId:").append(this.eJy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppId:").append(this.eJx);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(259312);
        return stringBuffer2;
    }
}
