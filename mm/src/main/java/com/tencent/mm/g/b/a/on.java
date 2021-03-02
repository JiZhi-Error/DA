package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class on extends a {
    private long eDd;
    private String eJC = "";
    private String eJK = "";
    private String eJu = "";
    private String eJv = "";
    private String eJw = "";
    private String eJz = "";
    private String ePe = "";
    private long enl;
    private String eno = "";
    private String eoz = "";
    private long erW;
    private String err = "";
    private String etQ = "";
    private String orF = "";
    private String orL = "";
    private long ose;
    private long osf;
    private String osg = "";
    private String osh = "";
    private String osi = "";
    private long osj;
    private long osk;
    private long osl;
    private long osm;
    private long oso;

    public on() {
    }

    public on(String str) {
        String[] split;
        String[] strArr;
        AppMethodBeat.i(259097);
        if (!(str == null || (split = str.split(",")) == null)) {
            if (split.length < 26) {
                strArr = new String[26];
                Arrays.fill(strArr, 0, 26, "");
                System.arraycopy(split, 0, strArr, 0, split.length);
            } else {
                strArr = split;
            }
            bvy(strArr[0]);
            bvz(strArr[1]);
            bvA(strArr[2]);
            bvB(strArr[3]);
            bvC(strArr[4]);
            bvD(strArr[5]);
            bvE(strArr[6]);
            this.enl = Util.getLong(strArr[7], 0);
            this.ose = Util.getLong(strArr[8], 0);
            bvF(strArr[9]);
            bvG(strArr[10]);
            bvH(strArr[11]);
            this.osf = Util.getLong(strArr[12], 0);
            bvI(strArr[13]);
            bvJ(strArr[14]);
            bvK(strArr[15]);
            bvL(strArr[16]);
            bvM(strArr[17]);
            this.eDd = Util.getLong(strArr[18], 0);
            this.osj = Util.getLong(strArr[19], 0);
            this.osk = Util.getLong(strArr[20], 0);
            this.osl = Util.getLong(strArr[21], 0);
            this.osm = Util.getLong(strArr[22], 0);
            this.oso = Util.getLong(strArr[23], 0);
            this.erW = Util.getLong(strArr[24], 0);
            bvN(strArr[25]);
        }
        AppMethodBeat.o(259097);
    }

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22259;
    }

    public final on bvy(String str) {
        AppMethodBeat.i(259098);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(259098);
        return this;
    }

    public final on bvz(String str) {
        AppMethodBeat.i(259099);
        this.orL = x("CreateContextId", str, true);
        AppMethodBeat.o(259099);
        return this;
    }

    public final on bvA(String str) {
        AppMethodBeat.i(259100);
        this.eJu = x("SongName", str, true);
        AppMethodBeat.o(259100);
        return this;
    }

    public final on bvB(String str) {
        AppMethodBeat.i(259101);
        this.eJC = x("SongId", str, true);
        AppMethodBeat.o(259101);
        return this;
    }

    public final on bvC(String str) {
        AppMethodBeat.i(259102);
        this.eJv = x("WebUrl", str, true);
        AppMethodBeat.o(259102);
        return this;
    }

    public final on bvD(String str) {
        AppMethodBeat.i(259103);
        this.eJw = x("DataUrl", str, true);
        AppMethodBeat.o(259103);
        return this;
    }

    public final on bvE(String str) {
        AppMethodBeat.i(259104);
        this.eJK = x("Singer", str, true);
        AppMethodBeat.o(259104);
        return this;
    }

    public final on PV(long j2) {
        this.enl = j2;
        return this;
    }

    public final on PW(long j2) {
        this.ose = j2;
        return this;
    }

    public final on bvF(String str) {
        AppMethodBeat.i(259105);
        this.orF = x("MvUserId", str, true);
        AppMethodBeat.o(259105);
        return this;
    }

    public final on bvG(String str) {
        AppMethodBeat.i(259106);
        this.eJz = x("MvObjectId", str, true);
        AppMethodBeat.o(259106);
        return this;
    }

    public final on bvH(String str) {
        AppMethodBeat.i(259107);
        this.etQ = x("FinderSessionId", str, true);
        AppMethodBeat.o(259107);
        return this;
    }

    public final on PX(long j2) {
        this.osf = j2;
        return this;
    }

    public final on bvI(String str) {
        AppMethodBeat.i(259108);
        this.osg = x("PartList", str, true);
        AppMethodBeat.o(259108);
        return this;
    }

    public final on bvJ(String str) {
        AppMethodBeat.i(259109);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(259109);
        return this;
    }

    public final on bvK(String str) {
        AppMethodBeat.i(259110);
        this.osh = x("FinderUin", str, true);
        AppMethodBeat.o(259110);
        return this;
    }

    public final on bvL(String str) {
        AppMethodBeat.i(259111);
        this.osi = x("KeyWord", str, true);
        AppMethodBeat.o(259111);
        return this;
    }

    public final on bvM(String str) {
        AppMethodBeat.i(259112);
        this.ePe = x("ExpId", str, true);
        AppMethodBeat.o(259112);
        return this;
    }

    public final on PY(long j2) {
        this.eDd = j2;
        return this;
    }

    public final on PZ(long j2) {
        this.osj = j2;
        return this;
    }

    public final on Qa(long j2) {
        this.osk = j2;
        return this;
    }

    public final on Qb(long j2) {
        this.osl = j2;
        return this;
    }

    public final on Qc(long j2) {
        this.osm = j2;
        return this;
    }

    public final on Qd(long j2) {
        this.oso = j2;
        return this;
    }

    public final on Qe(long j2) {
        this.erW = j2;
        return this;
    }

    public final on bvN(String str) {
        AppMethodBeat.i(259113);
        this.eno = x("RequestId", str, true);
        AppMethodBeat.o(259113);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(259114);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.orL);
        stringBuffer.append(",");
        stringBuffer.append(this.eJu);
        stringBuffer.append(",");
        stringBuffer.append(this.eJC);
        stringBuffer.append(",");
        stringBuffer.append(this.eJv);
        stringBuffer.append(",");
        stringBuffer.append(this.eJw);
        stringBuffer.append(",");
        stringBuffer.append(this.eJK);
        stringBuffer.append(",");
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.ose);
        stringBuffer.append(",");
        stringBuffer.append(this.orF);
        stringBuffer.append(",");
        stringBuffer.append(this.eJz);
        stringBuffer.append(",");
        stringBuffer.append(this.etQ);
        stringBuffer.append(",");
        stringBuffer.append(this.osf);
        stringBuffer.append(",");
        stringBuffer.append(this.osg);
        stringBuffer.append(",");
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.osh);
        stringBuffer.append(",");
        stringBuffer.append(this.osi);
        stringBuffer.append(",");
        stringBuffer.append(this.ePe);
        stringBuffer.append(",");
        stringBuffer.append(this.eDd);
        stringBuffer.append(",");
        stringBuffer.append(this.osj);
        stringBuffer.append(",");
        stringBuffer.append(this.osk);
        stringBuffer.append(",");
        stringBuffer.append(this.osl);
        stringBuffer.append(",");
        stringBuffer.append(this.osm);
        stringBuffer.append(",");
        stringBuffer.append(this.oso);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.eno);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(259114);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(259115);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CreateContextId:").append(this.orL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SongName:").append(this.eJu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SongId:").append(this.eJC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WebUrl:").append(this.eJv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DataUrl:").append(this.eJw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Singer:").append(this.eJK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsSave:").append(this.ose);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MvUserId:").append(this.orF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MvObjectId:").append(this.eJz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderSessionId:").append(this.etQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsFinderNew:").append(this.osf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PartList:").append(this.osg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderUin:").append(this.osh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("KeyWord:").append(this.osi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExpId:").append(this.ePe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Position:").append(this.eDd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PartNum:").append(this.osj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PartId:").append(this.osk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedFrom:").append(this.osl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsEdit:").append(this.osm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsNull:").append(this.oso);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RequestId:").append(this.eno);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(259115);
        return stringBuffer2;
    }
}
