package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class v extends a {
    public String iAA;
    public int iAB;
    public int iAC;
    public String iAD;
    public LinkedList<String> iAE = new LinkedList<>();
    public int iAF;
    public ac iAG;
    public long iAH;
    public String iAm;
    public String iAn;
    public String iAo;
    public String iAp;
    public String iAq;
    public int iAr;
    public int iAs;
    public String iAt;
    public int iAu;
    public String iAv;
    public String iAw;
    public String iAx;
    public String iAy;
    public String iAz;
    public int iwf;
    public long time;
    public String title;
    public int type;
    public String url;
    public String vid;
    public int videoHeight;
    public int videoWidth;
    public String weappPath;
    public int weappVersion;

    public v() {
        AppMethodBeat.i(116417);
        AppMethodBeat.o(116417);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116418);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.iAm != null) {
                aVar.e(3, this.iAm);
            }
            if (this.iAn != null) {
                aVar.e(4, this.iAn);
            }
            aVar.bb(5, this.time);
            if (this.iAo != null) {
                aVar.e(6, this.iAo);
            }
            if (this.iAp != null) {
                aVar.e(7, this.iAp);
            }
            if (this.iAq != null) {
                aVar.e(8, this.iAq);
            }
            aVar.aM(9, this.type);
            aVar.aM(10, this.iAr);
            aVar.aM(11, this.iAs);
            if (this.iAt != null) {
                aVar.e(12, this.iAt);
            }
            if (this.weappPath != null) {
                aVar.e(13, this.weappPath);
            }
            aVar.aM(14, this.weappVersion);
            aVar.aM(15, this.iAu);
            if (this.iAv != null) {
                aVar.e(16, this.iAv);
            }
            if (this.iAw != null) {
                aVar.e(17, this.iAw);
            }
            if (this.iAx != null) {
                aVar.e(18, this.iAx);
            }
            if (this.iAy != null) {
                aVar.e(19, this.iAy);
            }
            if (this.iAz != null) {
                aVar.e(20, this.iAz);
            }
            if (this.iAA != null) {
                aVar.e(21, this.iAA);
            }
            aVar.aM(22, this.iAB);
            aVar.aM(23, this.iAC);
            if (this.iAD != null) {
                aVar.e(24, this.iAD);
            }
            aVar.aM(25, this.videoWidth);
            aVar.aM(26, this.videoHeight);
            if (this.vid != null) {
                aVar.e(27, this.vid);
            }
            aVar.e(28, 1, this.iAE);
            aVar.aM(30, this.iwf);
            aVar.aM(31, this.iAF);
            if (this.iAG != null) {
                aVar.ni(32, this.iAG.computeSize());
                this.iAG.writeFields(aVar);
            }
            aVar.bb(33, this.iAH);
            AppMethodBeat.o(116418);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.url != null) {
                f2 += g.a.a.b.b.a.f(2, this.url);
            }
            if (this.iAm != null) {
                f2 += g.a.a.b.b.a.f(3, this.iAm);
            }
            if (this.iAn != null) {
                f2 += g.a.a.b.b.a.f(4, this.iAn);
            }
            int r = f2 + g.a.a.b.b.a.r(5, this.time);
            if (this.iAo != null) {
                r += g.a.a.b.b.a.f(6, this.iAo);
            }
            if (this.iAp != null) {
                r += g.a.a.b.b.a.f(7, this.iAp);
            }
            if (this.iAq != null) {
                r += g.a.a.b.b.a.f(8, this.iAq);
            }
            int bu = r + g.a.a.b.b.a.bu(9, this.type) + g.a.a.b.b.a.bu(10, this.iAr) + g.a.a.b.b.a.bu(11, this.iAs);
            if (this.iAt != null) {
                bu += g.a.a.b.b.a.f(12, this.iAt);
            }
            if (this.weappPath != null) {
                bu += g.a.a.b.b.a.f(13, this.weappPath);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(14, this.weappVersion) + g.a.a.b.b.a.bu(15, this.iAu);
            if (this.iAv != null) {
                bu2 += g.a.a.b.b.a.f(16, this.iAv);
            }
            if (this.iAw != null) {
                bu2 += g.a.a.b.b.a.f(17, this.iAw);
            }
            if (this.iAx != null) {
                bu2 += g.a.a.b.b.a.f(18, this.iAx);
            }
            if (this.iAy != null) {
                bu2 += g.a.a.b.b.a.f(19, this.iAy);
            }
            if (this.iAz != null) {
                bu2 += g.a.a.b.b.a.f(20, this.iAz);
            }
            if (this.iAA != null) {
                bu2 += g.a.a.b.b.a.f(21, this.iAA);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(22, this.iAB) + g.a.a.b.b.a.bu(23, this.iAC);
            if (this.iAD != null) {
                bu3 += g.a.a.b.b.a.f(24, this.iAD);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(25, this.videoWidth) + g.a.a.b.b.a.bu(26, this.videoHeight);
            if (this.vid != null) {
                bu4 += g.a.a.b.b.a.f(27, this.vid);
            }
            int c2 = bu4 + g.a.a.a.c(28, 1, this.iAE) + g.a.a.b.b.a.bu(30, this.iwf) + g.a.a.b.b.a.bu(31, this.iAF);
            if (this.iAG != null) {
                c2 += g.a.a.a.nh(32, this.iAG.computeSize());
            }
            int r2 = c2 + g.a.a.b.b.a.r(33, this.iAH);
            AppMethodBeat.o(116418);
            return r2;
        } else if (i2 == 2) {
            this.iAE.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116418);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            v vVar = (v) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    vVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(116418);
                    return 0;
                case 2:
                    vVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(116418);
                    return 0;
                case 3:
                    vVar.iAm = aVar3.UbS.readString();
                    AppMethodBeat.o(116418);
                    return 0;
                case 4:
                    vVar.iAn = aVar3.UbS.readString();
                    AppMethodBeat.o(116418);
                    return 0;
                case 5:
                    vVar.time = aVar3.UbS.zl();
                    AppMethodBeat.o(116418);
                    return 0;
                case 6:
                    vVar.iAo = aVar3.UbS.readString();
                    AppMethodBeat.o(116418);
                    return 0;
                case 7:
                    vVar.iAp = aVar3.UbS.readString();
                    AppMethodBeat.o(116418);
                    return 0;
                case 8:
                    vVar.iAq = aVar3.UbS.readString();
                    AppMethodBeat.o(116418);
                    return 0;
                case 9:
                    vVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(116418);
                    return 0;
                case 10:
                    vVar.iAr = aVar3.UbS.zi();
                    AppMethodBeat.o(116418);
                    return 0;
                case 11:
                    vVar.iAs = aVar3.UbS.zi();
                    AppMethodBeat.o(116418);
                    return 0;
                case 12:
                    vVar.iAt = aVar3.UbS.readString();
                    AppMethodBeat.o(116418);
                    return 0;
                case 13:
                    vVar.weappPath = aVar3.UbS.readString();
                    AppMethodBeat.o(116418);
                    return 0;
                case 14:
                    vVar.weappVersion = aVar3.UbS.zi();
                    AppMethodBeat.o(116418);
                    return 0;
                case 15:
                    vVar.iAu = aVar3.UbS.zi();
                    AppMethodBeat.o(116418);
                    return 0;
                case 16:
                    vVar.iAv = aVar3.UbS.readString();
                    AppMethodBeat.o(116418);
                    return 0;
                case 17:
                    vVar.iAw = aVar3.UbS.readString();
                    AppMethodBeat.o(116418);
                    return 0;
                case 18:
                    vVar.iAx = aVar3.UbS.readString();
                    AppMethodBeat.o(116418);
                    return 0;
                case 19:
                    vVar.iAy = aVar3.UbS.readString();
                    AppMethodBeat.o(116418);
                    return 0;
                case 20:
                    vVar.iAz = aVar3.UbS.readString();
                    AppMethodBeat.o(116418);
                    return 0;
                case 21:
                    vVar.iAA = aVar3.UbS.readString();
                    AppMethodBeat.o(116418);
                    return 0;
                case 22:
                    vVar.iAB = aVar3.UbS.zi();
                    AppMethodBeat.o(116418);
                    return 0;
                case 23:
                    vVar.iAC = aVar3.UbS.zi();
                    AppMethodBeat.o(116418);
                    return 0;
                case 24:
                    vVar.iAD = aVar3.UbS.readString();
                    AppMethodBeat.o(116418);
                    return 0;
                case 25:
                    vVar.videoWidth = aVar3.UbS.zi();
                    AppMethodBeat.o(116418);
                    return 0;
                case 26:
                    vVar.videoHeight = aVar3.UbS.zi();
                    AppMethodBeat.o(116418);
                    return 0;
                case 27:
                    vVar.vid = aVar3.UbS.readString();
                    AppMethodBeat.o(116418);
                    return 0;
                case 28:
                    vVar.iAE.add(aVar3.UbS.readString());
                    AppMethodBeat.o(116418);
                    return 0;
                case 29:
                default:
                    AppMethodBeat.o(116418);
                    return -1;
                case 30:
                    vVar.iwf = aVar3.UbS.zi();
                    AppMethodBeat.o(116418);
                    return 0;
                case 31:
                    vVar.iAF = aVar3.UbS.zi();
                    AppMethodBeat.o(116418);
                    return 0;
                case 32:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ac acVar = new ac();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = acVar.populateBuilderWithField(aVar4, acVar, a.getNextFieldNumber(aVar4))) {
                        }
                        vVar.iAG = acVar;
                    }
                    AppMethodBeat.o(116418);
                    return 0;
                case 33:
                    vVar.iAH = aVar3.UbS.zl();
                    AppMethodBeat.o(116418);
                    return 0;
            }
        } else {
            AppMethodBeat.o(116418);
            return -1;
        }
    }
}
