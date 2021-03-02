package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class cm extends a {
    private String els = "";
    private String elt = "";
    private long enl;
    private String eoo = "";
    private String euI = "";
    private String evX = "";
    private long evt;
    private String ewb = "";
    private long ewc;
    private String ewd = "";
    private String ewe = "";
    private long ewf;
    private String ewg = "";
    private long ewh;
    private long ewi;
    private long ewj;
    private long ewk;
    private long ewl;
    private long ewm;
    private String ewn = "";
    private String ewo = "";

    public cm() {
    }

    public cm(String str) {
        String[] split;
        String[] strArr;
        AppMethodBeat.i(209031);
        if (!(str == null || (split = str.split(",")) == null)) {
            if (split.length < 21) {
                strArr = new String[21];
                Arrays.fill(strArr, 0, 21, "");
                System.arraycopy(split, 0, strArr, 0, split.length);
            } else {
                strArr = split;
            }
            mm(strArr[0]);
            mn(strArr[1]);
            mo(strArr[2]);
            mp(strArr[3]);
            this.enl = Util.getLong(strArr[4], 0);
            mq(strArr[5]);
            this.ewf = Util.getLong(strArr[6], 0);
            this.ewc = Util.getLong(strArr[7], 0);
            mr(strArr[8]);
            ms(strArr[9]);
            this.ewh = Util.getLong(strArr[10], 0);
            this.ewi = Util.getLong(strArr[11], 0);
            this.ewj = Util.getLong(strArr[12], 0);
            mt(strArr[13]);
            this.evt = Util.getLong(strArr[14], 0);
            this.ewk = Util.getLong(strArr[15], 0);
            this.ewl = Util.getLong(strArr[16], 0);
            this.ewm = Util.getLong(strArr[17], 0);
            mu(strArr[18]);
            mv(strArr[19]);
            mw(strArr[20]);
        }
        AppMethodBeat.o(209031);
    }

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21567;
    }

    public final cm mm(String str) {
        AppMethodBeat.i(209032);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(209032);
        return this;
    }

    public final cm mn(String str) {
        AppMethodBeat.i(209033);
        this.elt = x("contextid", str, true);
        AppMethodBeat.o(209033);
        return this;
    }

    public final cm mo(String str) {
        AppMethodBeat.i(209034);
        this.evX = x("clickTabContextId", str, true);
        AppMethodBeat.o(209034);
        return this;
    }

    public final cm mp(String str) {
        AppMethodBeat.i(209035);
        this.ewe = x("refreshTime", str, true);
        AppMethodBeat.o(209035);
        return this;
    }

    public final cm adi() {
        this.enl = 1;
        return this;
    }

    public final cm mq(String str) {
        AppMethodBeat.i(209036);
        this.ewb = x("cardid", str, true);
        AppMethodBeat.o(209036);
        return this;
    }

    public final cm gA(long j2) {
        this.ewf = j2;
        return this;
    }

    public final cm gB(long j2) {
        this.ewc = j2;
        return this;
    }

    public final cm mr(String str) {
        AppMethodBeat.i(209037);
        this.ewd = x("cardTag", str, true);
        AppMethodBeat.o(209037);
        return this;
    }

    public final cm ms(String str) {
        AppMethodBeat.i(209038);
        this.ewg = x("cardStatus", str, true);
        AppMethodBeat.o(209038);
        return this;
    }

    public final cm gC(long j2) {
        this.ewh = j2;
        return this;
    }

    public final cm gD(long j2) {
        this.ewi = j2;
        return this;
    }

    public final cm gE(long j2) {
        this.ewj = j2;
        return this;
    }

    public final cm mt(String str) {
        AppMethodBeat.i(209039);
        this.euI = x("feedid", str, true);
        AppMethodBeat.o(209039);
        return this;
    }

    public final cm gF(long j2) {
        this.evt = j2;
        return this;
    }

    public final cm gG(long j2) {
        this.ewk = j2;
        return this;
    }

    public final cm gH(long j2) {
        this.ewl = j2;
        return this;
    }

    public final cm gI(long j2) {
        this.ewm = j2;
        return this;
    }

    public final cm mu(String str) {
        AppMethodBeat.i(209040);
        this.eoo = x("SessionBuffer", str, true);
        AppMethodBeat.o(209040);
        return this;
    }

    public final cm mv(String str) {
        AppMethodBeat.i(209041);
        this.ewn = x("lat", str, true);
        AppMethodBeat.o(209041);
        return this;
    }

    public final cm mw(String str) {
        AppMethodBeat.i(209042);
        this.ewo = x("lng", str, true);
        AppMethodBeat.o(209042);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209043);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.elt);
        stringBuffer.append(",");
        stringBuffer.append(this.evX);
        stringBuffer.append(",");
        stringBuffer.append(this.ewe);
        stringBuffer.append(",");
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.ewb);
        stringBuffer.append(",");
        stringBuffer.append(this.ewf);
        stringBuffer.append(",");
        stringBuffer.append(this.ewc);
        stringBuffer.append(",");
        stringBuffer.append(this.ewd);
        stringBuffer.append(",");
        stringBuffer.append(this.ewg);
        stringBuffer.append(",");
        stringBuffer.append(this.ewh);
        stringBuffer.append(",");
        stringBuffer.append(this.ewi);
        stringBuffer.append(",");
        stringBuffer.append(this.ewj);
        stringBuffer.append(",");
        stringBuffer.append(this.euI);
        stringBuffer.append(",");
        stringBuffer.append(this.evt);
        stringBuffer.append(",");
        stringBuffer.append(this.ewk);
        stringBuffer.append(",");
        stringBuffer.append(this.ewl);
        stringBuffer.append(",");
        stringBuffer.append(this.ewm);
        stringBuffer.append(",");
        stringBuffer.append(this.eoo);
        stringBuffer.append(",");
        stringBuffer.append(this.ewn);
        stringBuffer.append(",");
        stringBuffer.append(this.ewo);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209043);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209044);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("contextid:").append(this.elt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickTabContextId:").append(this.evX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("refreshTime:").append(this.ewe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cardid:").append(this.ewb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cardIndex:").append(this.ewf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cardIcon:").append(this.ewc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cardTag:").append(this.ewd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cardStatus:").append(this.ewg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cardExposeTime:").append(this.ewh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cardStartExposeTime:").append(this.ewi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("cardEndExposeTime:").append(this.ewj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("feedid:").append(this.euI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("feedIndex:").append(this.evt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("feedExposeTime:").append(this.ewk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("feedStartExposeTime:").append(this.ewl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("feedEndExposeTime:").append(this.ewm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionBuffer:").append(this.eoo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("lat:").append(this.ewn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("lng:").append(this.ewo);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209044);
        return stringBuffer2;
    }
}
