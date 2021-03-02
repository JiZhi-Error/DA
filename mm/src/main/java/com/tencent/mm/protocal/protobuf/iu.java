package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class iu extends a {
    public String HVD;
    public String HVF;
    public String HVI;
    public String HVJ;
    public String KMY;
    public String KMZ;
    public String KNa;
    public String KNb;
    public String KNc;
    public String KNd;
    public String KNe;
    public String KNf;
    public String KNg;
    public long KNh;
    public int KNi;
    public String KNj;
    public String KNk;
    public String KNl;
    public String KNm;
    public iv KNn;
    public dfc KNo;
    public String dSf;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91351);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KMY != null) {
                aVar.e(1, this.KMY);
            }
            if (this.KMZ != null) {
                aVar.e(2, this.KMZ);
            }
            if (this.KNa != null) {
                aVar.e(3, this.KNa);
            }
            if (this.KNb != null) {
                aVar.e(4, this.KNb);
            }
            if (this.KNc != null) {
                aVar.e(5, this.KNc);
            }
            if (this.KNd != null) {
                aVar.e(6, this.KNd);
            }
            if (this.KNe != null) {
                aVar.e(7, this.KNe);
            }
            if (this.KNf != null) {
                aVar.e(8, this.KNf);
            }
            if (this.dSf != null) {
                aVar.e(9, this.dSf);
            }
            if (this.KNg != null) {
                aVar.e(10, this.KNg);
            }
            if (this.HVF != null) {
                aVar.e(11, this.HVF);
            }
            if (this.HVJ != null) {
                aVar.e(12, this.HVJ);
            }
            if (this.HVI != null) {
                aVar.e(13, this.HVI);
            }
            aVar.bb(14, this.KNh);
            aVar.aM(15, this.KNi);
            if (this.KNj != null) {
                aVar.e(16, this.KNj);
            }
            if (this.KNk != null) {
                aVar.e(17, this.KNk);
            }
            if (this.KNl != null) {
                aVar.e(18, this.KNl);
            }
            if (this.HVD != null) {
                aVar.e(19, this.HVD);
            }
            if (this.KNm != null) {
                aVar.e(20, this.KNm);
            }
            if (this.KNn != null) {
                aVar.ni(21, this.KNn.computeSize());
                this.KNn.writeFields(aVar);
            }
            if (this.KNo != null) {
                aVar.ni(23, this.KNo.computeSize());
                this.KNo.writeFields(aVar);
            }
            AppMethodBeat.o(91351);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KMY != null ? g.a.a.b.b.a.f(1, this.KMY) + 0 : 0;
            if (this.KMZ != null) {
                f2 += g.a.a.b.b.a.f(2, this.KMZ);
            }
            if (this.KNa != null) {
                f2 += g.a.a.b.b.a.f(3, this.KNa);
            }
            if (this.KNb != null) {
                f2 += g.a.a.b.b.a.f(4, this.KNb);
            }
            if (this.KNc != null) {
                f2 += g.a.a.b.b.a.f(5, this.KNc);
            }
            if (this.KNd != null) {
                f2 += g.a.a.b.b.a.f(6, this.KNd);
            }
            if (this.KNe != null) {
                f2 += g.a.a.b.b.a.f(7, this.KNe);
            }
            if (this.KNf != null) {
                f2 += g.a.a.b.b.a.f(8, this.KNf);
            }
            if (this.dSf != null) {
                f2 += g.a.a.b.b.a.f(9, this.dSf);
            }
            if (this.KNg != null) {
                f2 += g.a.a.b.b.a.f(10, this.KNg);
            }
            if (this.HVF != null) {
                f2 += g.a.a.b.b.a.f(11, this.HVF);
            }
            if (this.HVJ != null) {
                f2 += g.a.a.b.b.a.f(12, this.HVJ);
            }
            if (this.HVI != null) {
                f2 += g.a.a.b.b.a.f(13, this.HVI);
            }
            int r = f2 + g.a.a.b.b.a.r(14, this.KNh) + g.a.a.b.b.a.bu(15, this.KNi);
            if (this.KNj != null) {
                r += g.a.a.b.b.a.f(16, this.KNj);
            }
            if (this.KNk != null) {
                r += g.a.a.b.b.a.f(17, this.KNk);
            }
            if (this.KNl != null) {
                r += g.a.a.b.b.a.f(18, this.KNl);
            }
            if (this.HVD != null) {
                r += g.a.a.b.b.a.f(19, this.HVD);
            }
            if (this.KNm != null) {
                r += g.a.a.b.b.a.f(20, this.KNm);
            }
            if (this.KNn != null) {
                r += g.a.a.a.nh(21, this.KNn.computeSize());
            }
            if (this.KNo != null) {
                r += g.a.a.a.nh(23, this.KNo.computeSize());
            }
            AppMethodBeat.o(91351);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91351);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            iu iuVar = (iu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iuVar.KMY = aVar3.UbS.readString();
                    AppMethodBeat.o(91351);
                    return 0;
                case 2:
                    iuVar.KMZ = aVar3.UbS.readString();
                    AppMethodBeat.o(91351);
                    return 0;
                case 3:
                    iuVar.KNa = aVar3.UbS.readString();
                    AppMethodBeat.o(91351);
                    return 0;
                case 4:
                    iuVar.KNb = aVar3.UbS.readString();
                    AppMethodBeat.o(91351);
                    return 0;
                case 5:
                    iuVar.KNc = aVar3.UbS.readString();
                    AppMethodBeat.o(91351);
                    return 0;
                case 6:
                    iuVar.KNd = aVar3.UbS.readString();
                    AppMethodBeat.o(91351);
                    return 0;
                case 7:
                    iuVar.KNe = aVar3.UbS.readString();
                    AppMethodBeat.o(91351);
                    return 0;
                case 8:
                    iuVar.KNf = aVar3.UbS.readString();
                    AppMethodBeat.o(91351);
                    return 0;
                case 9:
                    iuVar.dSf = aVar3.UbS.readString();
                    AppMethodBeat.o(91351);
                    return 0;
                case 10:
                    iuVar.KNg = aVar3.UbS.readString();
                    AppMethodBeat.o(91351);
                    return 0;
                case 11:
                    iuVar.HVF = aVar3.UbS.readString();
                    AppMethodBeat.o(91351);
                    return 0;
                case 12:
                    iuVar.HVJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91351);
                    return 0;
                case 13:
                    iuVar.HVI = aVar3.UbS.readString();
                    AppMethodBeat.o(91351);
                    return 0;
                case 14:
                    iuVar.KNh = aVar3.UbS.zl();
                    AppMethodBeat.o(91351);
                    return 0;
                case 15:
                    iuVar.KNi = aVar3.UbS.zi();
                    AppMethodBeat.o(91351);
                    return 0;
                case 16:
                    iuVar.KNj = aVar3.UbS.readString();
                    AppMethodBeat.o(91351);
                    return 0;
                case 17:
                    iuVar.KNk = aVar3.UbS.readString();
                    AppMethodBeat.o(91351);
                    return 0;
                case 18:
                    iuVar.KNl = aVar3.UbS.readString();
                    AppMethodBeat.o(91351);
                    return 0;
                case 19:
                    iuVar.HVD = aVar3.UbS.readString();
                    AppMethodBeat.o(91351);
                    return 0;
                case 20:
                    iuVar.KNm = aVar3.UbS.readString();
                    AppMethodBeat.o(91351);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        iv ivVar = new iv();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ivVar.populateBuilderWithField(aVar4, ivVar, a.getNextFieldNumber(aVar4))) {
                        }
                        iuVar.KNn = ivVar;
                    }
                    AppMethodBeat.o(91351);
                    return 0;
                case 22:
                default:
                    AppMethodBeat.o(91351);
                    return -1;
                case 23:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dfc dfc = new dfc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dfc.populateBuilderWithField(aVar5, dfc, a.getNextFieldNumber(aVar5))) {
                        }
                        iuVar.KNo = dfc;
                    }
                    AppMethodBeat.o(91351);
                    return 0;
            }
        } else {
            AppMethodBeat.o(91351);
            return -1;
        }
    }
}
