package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class cs extends a {
    private String ekB = "";
    private String ekG = "";
    private int eql;
    private int exm;
    private int exn;
    private long exo;
    private int exp;
    private String exq = "";
    private String exr = "";
    private int exs;
    private int exu;
    private String exv = "";
    private String exw = "";
    private String exx = "";
    private long exy;
    private String exz = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21188;
    }

    public final cs kf(int i2) {
        this.exm = i2;
        return this;
    }

    public final cs kg(int i2) {
        this.exn = i2;
        return this;
    }

    public final cs nm(String str) {
        AppMethodBeat.i(209045);
        this.ekB = x("appId", str, true);
        AppMethodBeat.o(209045);
        return this;
    }

    public final cs aek() {
        this.exo = 0;
        return this;
    }

    public final cs ael() {
        this.exp = 10;
        return this;
    }

    public final cs kh(int i2) {
        this.eql = i2;
        return this;
    }

    public final cs nn(String str) {
        AppMethodBeat.i(209046);
        this.exq = x("networkType", str, true);
        AppMethodBeat.o(209046);
        return this;
    }

    public final cs no(String str) {
        AppMethodBeat.i(209047);
        this.exr = x("preWarmPath", str, true);
        AppMethodBeat.o(209047);
        return this;
    }

    public final cs ki(int i2) {
        this.exs = i2;
        return this;
    }

    public final cs kj(int i2) {
        this.exu = i2;
        return this;
    }

    public final cs np(String str) {
        AppMethodBeat.i(209048);
        this.exv = x("liveId", str, true);
        AppMethodBeat.o(209048);
        return this;
    }

    public final cs nq(String str) {
        AppMethodBeat.i(209049);
        this.exw = x("finderId", str, true);
        AppMethodBeat.o(209049);
        return this;
    }

    public final cs nr(String str) {
        AppMethodBeat.i(209050);
        this.exx = x("shopwindowId", str, true);
        AppMethodBeat.o(209050);
        return this;
    }

    public final cs ns(String str) {
        AppMethodBeat.i(209051);
        this.ekG = x("sessionId", str, true);
        AppMethodBeat.o(209051);
        return this;
    }

    public final cs hN(long j2) {
        this.exy = j2;
        return this;
    }

    public final cs nt(String str) {
        AppMethodBeat.i(209052);
        this.exz = x("clickId", str, true);
        AppMethodBeat.o(209052);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209053);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.exm);
        stringBuffer.append(",");
        stringBuffer.append(this.exn);
        stringBuffer.append(",");
        stringBuffer.append(this.ekB);
        stringBuffer.append(",");
        stringBuffer.append(this.exo);
        stringBuffer.append(",");
        stringBuffer.append(this.exp);
        stringBuffer.append(",");
        stringBuffer.append(this.eql);
        stringBuffer.append(",");
        stringBuffer.append(this.exq);
        stringBuffer.append(",");
        stringBuffer.append(this.exr);
        stringBuffer.append(",");
        stringBuffer.append(this.exs);
        stringBuffer.append(",");
        stringBuffer.append(this.exu);
        stringBuffer.append(",");
        stringBuffer.append(this.exv);
        stringBuffer.append(",");
        stringBuffer.append(this.exw);
        stringBuffer.append(",");
        stringBuffer.append(this.exx);
        stringBuffer.append(",");
        stringBuffer.append(this.ekG);
        stringBuffer.append(",");
        stringBuffer.append(this.exy);
        stringBuffer.append(",");
        stringBuffer.append(this.exz);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209053);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209054);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("isFirstOpen:").append(this.exm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickScene:").append(this.exn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appId:").append(this.ekB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appVersion:").append(this.exo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("appType:").append(this.exp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene:").append(this.eql);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("networkType:").append(this.exq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("preWarmPath:").append(this.exr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isPresend:").append(this.exs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isPreload:").append(this.exu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveId:").append(this.exv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("finderId:").append(this.exw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("shopwindowId:").append(this.exx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionId:").append(this.ekG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("eventTime:").append(this.exy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("clickId:").append(this.exz);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209054);
        return stringBuffer2;
    }
}
