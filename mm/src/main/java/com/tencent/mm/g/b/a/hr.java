package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public final class hr extends a {
    public long eBS = 0;
    private String eMh = "";
    public long eMi = 0;
    public long eMj = 0;
    public long eMk = 0;
    public long eMl = 0;
    private String eMm = "";
    private String eMn = "";
    private String enR = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 14452;
    }

    public final hr vs(String str) {
        AppMethodBeat.i(76364);
        this.eMh = x("statId", str, true);
        AppMethodBeat.o(76364);
        return this;
    }

    public final hr vt(String str) {
        AppMethodBeat.i(76365);
        this.enR = x("appid", str, true);
        AppMethodBeat.o(76365);
        return this;
    }

    public final hr vu(String str) {
        AppMethodBeat.i(76366);
        this.eMm = x(DownloadInfo.NETTYPE, str, true);
        AppMethodBeat.o(76366);
        return this;
    }

    public final hr vv(String str) {
        AppMethodBeat.i(76367);
        this.eMn = x("jsError", str, true);
        AppMethodBeat.o(76367);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(76368);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eMh);
        stringBuffer.append(",");
        stringBuffer.append(this.eMi);
        stringBuffer.append(",");
        stringBuffer.append(this.eMj);
        stringBuffer.append(",");
        stringBuffer.append(this.eMk);
        stringBuffer.append(",");
        stringBuffer.append(this.enR);
        stringBuffer.append(",");
        stringBuffer.append(this.eBS);
        stringBuffer.append(",");
        stringBuffer.append(this.eMl);
        stringBuffer.append(",");
        stringBuffer.append(this.eMm);
        stringBuffer.append(",");
        stringBuffer.append(this.eMn);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(76368);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(76369);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("statId:").append(this.eMh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("statEvent:").append(this.eMi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("statTimeStamp:").append(this.eMj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("success:").append(this.eMk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appid:").append(this.enR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("searchType:").append(this.eBS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("hasInitData:").append(this.eMl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("netType:").append(this.eMm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("jsError:").append(this.eMn);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(76369);
        return stringBuffer2;
    }
}
