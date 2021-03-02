package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.smtt.export.external.TbsCoreSettings;

public final class ng extends a {
    private long ekI;
    private String fgl = "";
    private long fgm;
    private long fgn;
    private long fgo;
    private String fgp = "";
    private String fgq = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21775;
    }

    public final ng Aq(String str) {
        AppMethodBeat.i(226105);
        this.fgl = x("session", str, true);
        AppMethodBeat.o(226105);
        return this;
    }

    public final ng xE(long j2) {
        this.ekI = j2;
        return this;
    }

    public final ng xF(long j2) {
        this.fgm = j2;
        return this;
    }

    public final ng xG(long j2) {
        this.fgn = j2;
        return this;
    }

    public final ng xH(long j2) {
        this.fgo = j2;
        return this;
    }

    public final ng Ar(String str) {
        AppMethodBeat.i(226106);
        this.fgp = x(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY, str, true);
        AppMethodBeat.o(226106);
        return this;
    }

    public final ng As(String str) {
        AppMethodBeat.i(226107);
        this.fgq = x(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY, str, true);
        AppMethodBeat.o(226107);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(226108);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.fgl);
        stringBuffer.append(",");
        stringBuffer.append(this.ekI);
        stringBuffer.append(",");
        stringBuffer.append(this.fgm);
        stringBuffer.append(",");
        stringBuffer.append(this.fgn);
        stringBuffer.append(",");
        stringBuffer.append(this.fgo);
        stringBuffer.append(",");
        stringBuffer.append(this.fgp);
        stringBuffer.append(",");
        stringBuffer.append(this.fgq);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(226108);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(226109);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("session:").append(this.fgl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action_type:").append(this.ekI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene_type:").append(this.fgm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("weapp_sum:").append(this.fgn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("weapp_index:").append(this.fgo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("weapp_id:").append(this.fgp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("weapp_name:").append(this.fgq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(226109);
        return stringBuffer2;
    }
}
