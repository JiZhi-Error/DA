package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class eq extends a {
    private long eDY;
    private long eDZ;
    private long eEa;
    private long eEb;
    private long eEc;
    private String eEd = "";
    private String eEe = "";
    private long eEf;
    private long eEg;
    private long eEh;
    private String eEi = "";
    private long eEj;
    private String eEk = "";
    private long eEl;
    public long eEm;
    private String eEn = "";
    private long eEo;
    private String eiB = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20488;
    }

    public final eq mS(long j2) {
        this.eDY = j2;
        return this;
    }

    public final eq mT(long j2) {
        this.eDZ = j2;
        return this;
    }

    public final eq mU(long j2) {
        this.eEa = j2;
        return this;
    }

    public final eq mV(long j2) {
        this.eEb = j2;
        return this;
    }

    public final eq mW(long j2) {
        this.eEc = j2;
        return this;
    }

    public final eq rM(String str) {
        AppMethodBeat.i(190316);
        this.eEe = x("ActionStatus", str, true);
        AppMethodBeat.o(190316);
        return this;
    }

    public final eq mX(long j2) {
        this.eEh = j2;
        return this;
    }

    public final eq rN(String str) {
        AppMethodBeat.i(190317);
        this.eEi = x("from_username", str, true);
        AppMethodBeat.o(190317);
        return this;
    }

    public final eq mY(long j2) {
        this.eEj = j2;
        return this;
    }

    public final eq rO(String str) {
        AppMethodBeat.i(190318);
        this.eEk = x("to_username", str, true);
        AppMethodBeat.o(190318);
        return this;
    }

    public final eq mZ(long j2) {
        this.eEm = j2;
        return this;
    }

    public final eq rP(String str) {
        AppMethodBeat.i(190319);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(190319);
        return this;
    }

    public final eq rQ(String str) {
        AppMethodBeat.i(190320);
        this.eEn = x("ExternInfo", str, true);
        AppMethodBeat.o(190320);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(190321);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eDY);
        stringBuffer.append(",");
        stringBuffer.append(this.eDZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eEa);
        stringBuffer.append(",");
        stringBuffer.append(this.eEb);
        stringBuffer.append(",");
        stringBuffer.append(this.eEc);
        stringBuffer.append(",");
        stringBuffer.append(this.eEd);
        stringBuffer.append(",");
        stringBuffer.append(this.eEe);
        stringBuffer.append(",");
        stringBuffer.append(this.eEf);
        stringBuffer.append(",");
        stringBuffer.append(this.eEg);
        stringBuffer.append(",");
        stringBuffer.append(this.eEh);
        stringBuffer.append(",");
        stringBuffer.append(this.eEi);
        stringBuffer.append(",");
        stringBuffer.append(this.eEj);
        stringBuffer.append(",");
        stringBuffer.append(this.eEk);
        stringBuffer.append(",");
        stringBuffer.append(this.eEl);
        stringBuffer.append(",");
        stringBuffer.append(this.eEm);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eEn);
        stringBuffer.append(",");
        stringBuffer.append(this.eEo);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(190321);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(190322);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SceneID:").append(this.eDY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UIArea:").append(this.eDZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PositionID:").append(this.eEa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionID:").append(this.eEb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceID:").append(this.eEc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GameID:").append(this.eEd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionStatus:").append(this.eEe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GiftID:").append(this.eEf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GiftType:").append(this.eEg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("from_account_type:").append(this.eEh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("from_username:").append(this.eEi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("to_account_type:").append(this.eEj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("to_username:").append(this.eEk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RedDot:").append(this.eEl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TotalNum:").append(this.eEm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExternInfo:").append(this.eEn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Time:").append(this.eEo);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(190322);
        return stringBuffer2;
    }
}
