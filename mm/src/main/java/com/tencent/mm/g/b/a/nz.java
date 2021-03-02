package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.smtt.export.external.TbsCoreSettings;

public final class nz extends a {
    private String fgl = "";
    private String fgp = "";
    private String fgq = "";
    private long fiN;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21777;
    }

    public final nz Bh(String str) {
        AppMethodBeat.i(226125);
        this.fgl = x("session", str, true);
        AppMethodBeat.o(226125);
        return this;
    }

    public final nz yv(long j2) {
        this.fiN = j2;
        return this;
    }

    public final nz Bi(String str) {
        AppMethodBeat.i(226126);
        this.fgp = x(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY, str, true);
        AppMethodBeat.o(226126);
        return this;
    }

    public final nz Bj(String str) {
        AppMethodBeat.i(226127);
        this.fgq = x(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY, str, true);
        AppMethodBeat.o(226127);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(226128);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.fgl);
        stringBuffer.append(",");
        stringBuffer.append(this.fiN);
        stringBuffer.append(",");
        stringBuffer.append(this.fgp);
        stringBuffer.append(",");
        stringBuffer.append(this.fgq);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(226128);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(226129);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("session:").append(this.fgl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene_id:").append(this.fiN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("weapp_id:").append(this.fgp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("weapp_name:").append(this.fgq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(226129);
        return stringBuffer2;
    }
}
