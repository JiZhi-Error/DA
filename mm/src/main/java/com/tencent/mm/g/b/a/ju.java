package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ju extends a {
    private long eAl = 0;
    private long eQv = 0;
    private String eRJ = "";
    private long eRK = 0;
    private long eSu = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 17090;
    }

    public final ju xf(String str) {
        AppMethodBeat.i(118521);
        this.eRJ = x("StoryId", str, true);
        AppMethodBeat.o(118521);
        return this;
    }

    public final ju sS(long j2) {
        this.eAl = j2;
        return this;
    }

    public final ju sT(long j2) {
        this.eQv = j2;
        return this;
    }

    public final ju sU(long j2) {
        this.eRK = j2;
        return this;
    }

    public final ju sV(long j2) {
        this.eSu = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(118522);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eRJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eAl);
        stringBuffer.append(",");
        stringBuffer.append(this.eQv);
        stringBuffer.append(",");
        stringBuffer.append(this.eRK);
        stringBuffer.append(",");
        stringBuffer.append(this.eSu);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(118522);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(118523);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("StoryId:").append(this.eRJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoType:").append(this.eAl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PreviewEnterScene:").append(this.eQv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ProfileSource:").append(this.eRK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsAlbumStarButton:").append(this.eSu);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(118523);
        return stringBuffer2;
    }
}
