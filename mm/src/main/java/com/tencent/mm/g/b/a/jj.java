package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jj extends a {
    private int eRg = 0;
    private int eRh = 0;
    private int eRi = 0;
    private int eRj = 0;
    private String eRk = "";
    private int eRl = 0;
    private int eRm = 0;
    private String eRn = "";
    private long eRo = 0;
    private String eiB = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16887;
    }

    public final jj wN(String str) {
        AppMethodBeat.i(118490);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(118490);
        return this;
    }

    public final jj lG(int i2) {
        this.eRg = i2;
        return this;
    }

    public final int ahr() {
        return this.eRg;
    }

    public final jj lH(int i2) {
        this.eRh = i2;
        return this;
    }

    public final jj lI(int i2) {
        this.eRi = i2;
        return this;
    }

    public final jj lJ(int i2) {
        this.eRj = i2;
        return this;
    }

    public final int ahs() {
        return this.eRj;
    }

    public final jj wO(String str) {
        AppMethodBeat.i(118491);
        this.eRk = x("ExposeNewUinList", str, true);
        AppMethodBeat.o(118491);
        return this;
    }

    public final jj lK(int i2) {
        this.eRl = i2;
        return this;
    }

    public final jj lL(int i2) {
        this.eRm = i2;
        return this;
    }

    public final int aht() {
        return this.eRm;
    }

    public final jj wP(String str) {
        AppMethodBeat.i(118492);
        this.eRn = x("ExposeBeforeUinList", str, true);
        AppMethodBeat.o(118492);
        return this;
    }

    public final jj sd(long j2) {
        this.eRo = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(118493);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eRg);
        stringBuffer.append(",");
        stringBuffer.append(this.eRh);
        stringBuffer.append(",");
        stringBuffer.append(this.eRi);
        stringBuffer.append(",");
        stringBuffer.append(this.eRj);
        stringBuffer.append(",");
        stringBuffer.append(this.eRk);
        stringBuffer.append(",");
        stringBuffer.append(this.eRl);
        stringBuffer.append(",");
        stringBuffer.append(this.eRm);
        stringBuffer.append(",");
        stringBuffer.append(this.eRn);
        stringBuffer.append(",");
        stringBuffer.append(this.eRo);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(118493);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(118494);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposeViewId:").append(this.eRg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposeOrder:").append(this.eRh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposeNewUinCount:").append(this.eRi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposeNewFavorUinCount:").append(this.eRj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposeNewUinList:").append(this.eRk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposeBeforeUinCount:").append(this.eRl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposeBeforeFavorUinCount:").append(this.eRm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposeBeforeUinList:").append(this.eRn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("InteractiveUserCount:").append(this.eRo);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(118494);
        return stringBuffer2;
    }
}
