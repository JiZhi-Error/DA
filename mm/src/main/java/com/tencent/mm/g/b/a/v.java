package com.tencent.mm.g.b.a;

import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class v extends a {
    private long ejW;
    private long elA;
    private String elB = "";
    private String elC = "";
    private String elD = "";
    private String els = "";
    private String elt = "";
    private String elu = "";
    private long elv;
    private long elw;
    private String elx = "";
    private long ely;
    private long elz;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21855;
    }

    public final v hU(String str) {
        AppMethodBeat.i(208821);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(208821);
        return this;
    }

    public final v hV(String str) {
        AppMethodBeat.i(208822);
        this.elt = x("contextid", str, true);
        AppMethodBeat.o(208822);
        return this;
    }

    public final v hW(String str) {
        AppMethodBeat.i(208823);
        this.elu = x("clickTabContextid", str, true);
        AppMethodBeat.o(208823);
        return this;
    }

    public final v aca() {
        this.elv = 0;
        return this;
    }

    public final v bR(long j2) {
        this.elw = j2;
        return this;
    }

    public final v hX(String str) {
        AppMethodBeat.i(208824);
        this.elx = x("district", str, true);
        AppMethodBeat.o(208824);
        return this;
    }

    public final v bS(long j2) {
        this.ely = j2;
        return this;
    }

    public final v bT(long j2) {
        this.ejW = j2;
        return this;
    }

    public final v bU(long j2) {
        this.elz = j2;
        return this;
    }

    public final v bV(long j2) {
        this.elA = j2;
        return this;
    }

    public final v hY(String str) {
        AppMethodBeat.i(208825);
        this.elB = x("nearby_username", str, true);
        AppMethodBeat.o(208825);
        return this;
    }

    public final v hZ(String str) {
        AppMethodBeat.i(208826);
        this.elC = x("city", str, true);
        AppMethodBeat.o(208826);
        return this;
    }

    public final v ia(String str) {
        AppMethodBeat.i(208827);
        this.elD = x(UserDataStore.COUNTRY, str, true);
        AppMethodBeat.o(208827);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208828);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.elt);
        stringBuffer.append(",");
        stringBuffer.append(this.elu);
        stringBuffer.append(",");
        stringBuffer.append(this.elv);
        stringBuffer.append(",");
        stringBuffer.append(this.elw);
        stringBuffer.append(",");
        stringBuffer.append(this.elx);
        stringBuffer.append(",");
        stringBuffer.append(this.ely);
        stringBuffer.append(",");
        stringBuffer.append(this.ejW);
        stringBuffer.append(",");
        stringBuffer.append(this.elz);
        stringBuffer.append(",");
        stringBuffer.append(this.elA);
        stringBuffer.append(",");
        stringBuffer.append(this.elB);
        stringBuffer.append(",");
        stringBuffer.append(this.elC);
        stringBuffer.append(",");
        stringBuffer.append(this.elD);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208828);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208829);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("contextid:").append(this.elt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickTabContextid:").append(this.elu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("nearby_uin:").append(this.elv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("distance:").append(this.elw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("district:").append(this.elx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("if_sns:").append(this.ely);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action:").append(this.ejW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionTS:").append(this.elz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("filterType:").append(this.elA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("nearby_username:").append(this.elB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("city:").append(this.elC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("country:").append(this.elD);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208829);
        return stringBuffer2;
    }
}
