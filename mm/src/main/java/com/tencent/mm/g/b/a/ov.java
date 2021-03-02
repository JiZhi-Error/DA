package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ov extends a {
    private long eRL;
    private String eoC = "";
    private long eqk;
    private long etp;
    private String sZo = "";
    private String sZq = "";
    private String soR = "";
    private String tCR = "";
    private String tCg = "";
    private String tCh = "";
    private long tCj;
    private String tDA = "";
    private long tKL;
    private long tKM;
    private long tPl;
    private long tPm;
    private long tPn;
    private String tSm = "";
    private long tTu;
    private long tUg;
    private long tUh;
    private long tUj;
    private long tUk;
    private long tUl;
    private long uab;
    private long ueK;
    private long ueL;
    private long ueM;
    private long ueN;
    private long ueO;
    private long ueP;
    private long uer;
    private long ues;
    private long uew;
    private long ufl;
    private long ujO;
    private long uje;
    private long umV;
    private String umW = "";
    private int umY;
    private int umZ;
    private long una;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22219;
    }

    public final ov bwO(String str) {
        AppMethodBeat.i(258291);
        this.eoC = x("SessionID", str, true);
        AppMethodBeat.o(258291);
        return this;
    }

    public final ov bwP(String str) {
        AppMethodBeat.i(258292);
        this.tCg = x("CliPostID", str, true);
        AppMethodBeat.o(258292);
        return this;
    }

    public final ov Ra(long j2) {
        this.etp = j2;
        return this;
    }

    public final ov Rb(long j2) {
        this.eqk = j2;
        return this;
    }

    public final ov bwQ(String str) {
        AppMethodBeat.i(258293);
        this.tCh = x("StatusIcons", str, true);
        AppMethodBeat.o(258293);
        return this;
    }

    public final ov Rc(long j2) {
        this.tCj = j2;
        return this;
    }

    public final ov Rd(long j2) {
        this.eRL = j2;
        return this;
    }

    public final ov bwR(String str) {
        AppMethodBeat.i(258294);
        this.tCR = x("ExitTopicID", str, true);
        AppMethodBeat.o(258294);
        return this;
    }

    public final ov bwS(String str) {
        AppMethodBeat.i(258295);
        this.tDA = x("ExitTextStatusID", str, true);
        AppMethodBeat.o(258295);
        return this;
    }

    public final ov Re(long j2) {
        this.tKL = j2;
        return this;
    }

    public final ov Rf(long j2) {
        this.tKM = j2;
        return this;
    }

    public final ov Rg(long j2) {
        this.tPl = j2;
        return this;
    }

    public final ov Rh(long j2) {
        this.tPm = j2;
        return this;
    }

    public final ov Ri(long j2) {
        this.tPn = j2;
        return this;
    }

    public final ov bwT(String str) {
        AppMethodBeat.i(258296);
        this.soR = x("SourceID", str, true);
        AppMethodBeat.o(258296);
        return this;
    }

    public final ov bwU(String str) {
        AppMethodBeat.i(258297);
        this.sZo = x("SourceActivityID", str, true);
        AppMethodBeat.o(258297);
        return this;
    }

    public final ov bwV(String str) {
        AppMethodBeat.i(258298);
        this.sZq = x("SourceName", str, true);
        AppMethodBeat.o(258298);
        return this;
    }

    public final ov bwW(String str) {
        AppMethodBeat.i(258299);
        this.tSm = x("SourceIcon", str, true);
        AppMethodBeat.o(258299);
        return this;
    }

    public final ov Rj(long j2) {
        this.tTu = j2;
        return this;
    }

    public final ov Rk(long j2) {
        this.tUg = j2;
        return this;
    }

    public final ov Rl(long j2) {
        this.tUh = j2;
        return this;
    }

    public final ov Rm(long j2) {
        this.tUj = j2;
        return this;
    }

    public final ov Rn(long j2) {
        this.tUk = j2;
        return this;
    }

    public final ov Ro(long j2) {
        this.tUl = j2;
        return this;
    }

    public final ov Rp(long j2) {
        this.uab = j2;
        return this;
    }

    public final ov Rq(long j2) {
        this.uer = j2;
        return this;
    }

    public final ov Rr(long j2) {
        this.ueK = j2;
        return this;
    }

    public final ov Rs(long j2) {
        this.ueL = j2;
        return this;
    }

    public final ov Rt(long j2) {
        this.ueM = j2;
        return this;
    }

    public final ov Ru(long j2) {
        this.ueN = j2;
        return this;
    }

    public final ov Rv(long j2) {
        this.ueO = j2;
        return this;
    }

    public final ov Rw(long j2) {
        this.ueP = j2;
        return this;
    }

    public final ov Rx(long j2) {
        this.ufl = j2;
        return this;
    }

    public final ov Ry(long j2) {
        this.uje = j2;
        return this;
    }

    public final ov anN(int i2) {
        this.umY = i2;
        return this;
    }

    public final ov aqe(int i2) {
        this.umZ = i2;
        return this;
    }

    public final ov Rz(long j2) {
        this.una = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(258300);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoC);
        stringBuffer.append(",");
        stringBuffer.append(this.tCg);
        stringBuffer.append(",");
        stringBuffer.append(this.etp);
        stringBuffer.append(",");
        stringBuffer.append(this.eqk);
        stringBuffer.append(",");
        stringBuffer.append(this.tCh);
        stringBuffer.append(",");
        stringBuffer.append(this.tCj);
        stringBuffer.append(",");
        stringBuffer.append(this.eRL);
        stringBuffer.append(",");
        stringBuffer.append(this.tCR);
        stringBuffer.append(",");
        stringBuffer.append(this.tDA);
        stringBuffer.append(",");
        stringBuffer.append(this.tKL);
        stringBuffer.append(",");
        stringBuffer.append(this.tKM);
        stringBuffer.append(",");
        stringBuffer.append(this.tPl);
        stringBuffer.append(",");
        stringBuffer.append(this.tPm);
        stringBuffer.append(",");
        stringBuffer.append(this.tPn);
        stringBuffer.append(",");
        stringBuffer.append(this.soR);
        stringBuffer.append(",");
        stringBuffer.append(this.sZo);
        stringBuffer.append(",");
        stringBuffer.append(this.sZq);
        stringBuffer.append(",");
        stringBuffer.append(this.tSm);
        stringBuffer.append(",");
        stringBuffer.append(this.tTu);
        stringBuffer.append(",");
        stringBuffer.append(this.tUg);
        stringBuffer.append(",");
        stringBuffer.append(this.tUh);
        stringBuffer.append(",");
        stringBuffer.append(this.tUj);
        stringBuffer.append(",");
        stringBuffer.append(this.tUk);
        stringBuffer.append(",");
        stringBuffer.append(this.tUl);
        stringBuffer.append(",");
        stringBuffer.append(this.uab);
        stringBuffer.append(",");
        stringBuffer.append(this.uer);
        stringBuffer.append(",");
        stringBuffer.append(this.ues);
        stringBuffer.append(",");
        stringBuffer.append(this.uew);
        stringBuffer.append(",");
        stringBuffer.append(this.ueK);
        stringBuffer.append(",");
        stringBuffer.append(this.ueL);
        stringBuffer.append(",");
        stringBuffer.append(this.ueM);
        stringBuffer.append(",");
        stringBuffer.append(this.ueN);
        stringBuffer.append(",");
        stringBuffer.append(this.ueO);
        stringBuffer.append(",");
        stringBuffer.append(this.ueP);
        stringBuffer.append(",");
        stringBuffer.append(this.ufl);
        stringBuffer.append(",");
        stringBuffer.append(this.uje);
        stringBuffer.append(",");
        stringBuffer.append(this.ujO);
        stringBuffer.append(",");
        stringBuffer.append(this.umV);
        stringBuffer.append(",");
        stringBuffer.append(this.umW);
        stringBuffer.append(",");
        stringBuffer.append(this.umY);
        stringBuffer.append(",");
        stringBuffer.append(this.umZ);
        stringBuffer.append(",");
        stringBuffer.append(this.una);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(258300);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(258301);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionID:").append(this.eoC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CliPostID:").append(this.tCg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterScene:").append(this.etp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterTime:").append(this.eqk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StatusIcons:").append(this.tCh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExitScene:").append(this.tCj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExitTime:").append(this.eRL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExitTopicID:").append(this.tCR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExitTextStatusID:").append(this.tDA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoOrigLength:").append(this.tKL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoFinalLength:").append(this.tKM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ImgVideoSize:").append(this.tPl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ImgVideoSource:").append(this.tPm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinalTextLength:").append(this.tPn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceID:").append(this.soR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceActivityID:").append(this.sZo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceName:").append(this.sZq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceIcon:").append(this.tSm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EditSourceTextCount:").append(this.tTu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EditSourceStatusIconCount:").append(this.tUg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EditSourceBackgroundCount:").append(this.tUh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TextTooLongHintCount:").append(this.tUj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TextTooShortHintCount:").append(this.tUk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClkReSelectStatusIconCount:").append(this.tUl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClkHashCount:").append(this.uab);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClkCamCount:").append(this.uer);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClkDelBackgroundCount:").append(this.ues);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClkChangeBackgroundCount:").append(this.uew);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClkPoiCount:").append(this.ueK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClkReSelectPoiCount:").append(this.ueL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinalHasPoi:").append(this.ueM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClkUserRangeCount:").append(this.ueN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UserRangeSource:").append(this.ueO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BlurCount:").append(this.ueP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UnBlurCount:").append(this.ufl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinalHasBlur:").append(this.uje);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClkCustomIconCount:").append(this.ujO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CustomTitleTooLongCount:").append(this.umV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinalCustomTitle:").append(this.umW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UserGuideShown:").append(this.umY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UserGuideKnownClicked:").append(this.umZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LimitFunc:").append(this.una);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(258301);
        return stringBuffer2;
    }
}
