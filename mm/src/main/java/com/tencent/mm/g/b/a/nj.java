package com.tencent.mm.g.b.a;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class nj extends a {
    private String eBQ = "";
    private String enR = "";
    private long exM = 0;
    private long fde = 0;
    private String fgA = "";
    private long fgs = 0;
    private int fgt = 0;
    private String fgu = "";
    private String fgv = "";
    private String fgw = "";
    private String fgx = "";
    private long fgy = 0;
    private String fgz = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 13582;
    }

    public final nj At(String str) {
        AppMethodBeat.i(43763);
        this.enR = x("appid", str, true);
        AppMethodBeat.o(43763);
        return this;
    }

    public final nj xI(long j2) {
        this.exM = j2;
        return this;
    }

    public final nj xJ(long j2) {
        this.fgs = j2;
        return this;
    }

    public final nj ajp() {
        this.fgt = 9;
        return this;
    }

    public final nj Au(String str) {
        AppMethodBeat.i(43764);
        this.fgv = x("errorMessage", str, true);
        AppMethodBeat.o(43764);
        return this;
    }

    public final nj Av(String str) {
        AppMethodBeat.i(43765);
        this.fgw = x("errorStack", str, true);
        AppMethodBeat.o(43765);
        return this;
    }

    public final nj Aw(String str) {
        AppMethodBeat.i(43766);
        this.fgx = x("sdkversion", str, true);
        AppMethodBeat.o(43766);
        return this;
    }

    public final nj xK(long j2) {
        this.fgy = j2;
        return this;
    }

    public final nj Ax(String str) {
        AppMethodBeat.i(43767);
        this.fgz = x(TencentExtraKeys.LOCATION_KEY_ROUTE, str, true);
        AppMethodBeat.o(43767);
        return this;
    }

    public final nj Ay(String str) {
        AppMethodBeat.i(43768);
        this.eBQ = x(SearchIntents.EXTRA_QUERY, str, true);
        AppMethodBeat.o(43768);
        return this;
    }

    public final nj xL(long j2) {
        this.fde = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(43769);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enR);
        stringBuffer.append(",");
        stringBuffer.append(this.exM);
        stringBuffer.append(",");
        stringBuffer.append(this.fgs);
        stringBuffer.append(",");
        stringBuffer.append(this.fgt);
        stringBuffer.append(",");
        stringBuffer.append(this.fgu);
        stringBuffer.append(",");
        stringBuffer.append(this.fgv);
        stringBuffer.append(",");
        stringBuffer.append(this.fgw);
        stringBuffer.append(",");
        stringBuffer.append(this.fgx);
        stringBuffer.append(",");
        stringBuffer.append(this.fgy);
        stringBuffer.append(",");
        stringBuffer.append(this.fgz);
        stringBuffer.append(",");
        stringBuffer.append(this.eBQ);
        stringBuffer.append(",");
        stringBuffer.append(this.fgA);
        stringBuffer.append(",");
        stringBuffer.append(this.fde);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43769);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43770);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appid:").append(this.enR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appversion:").append(this.exM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appstate:").append(this.fgs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("errorType:").append(this.fgt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("errorName:").append(this.fgu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("errorMessage:").append(this.fgv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("errorStack:").append(this.fgw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sdkversion:").append(this.fgx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("apptype:").append(this.fgy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("route:").append(this.fgz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("query:").append(this.eBQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sdkupdatetime:").append(this.fgA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sceneId:").append(this.fde);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43770);
        return stringBuffer2;
    }
}
