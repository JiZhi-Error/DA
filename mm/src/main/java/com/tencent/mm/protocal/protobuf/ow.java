package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ow extends a {
    public int KGm;
    public int KIJ;
    public String KUp;
    public int KVA;
    public int KVB;
    public int KVC;
    public int KVD;
    public long KVE;
    public LinkedList<String> KVF = new LinkedList<>();
    public ahh KVG;
    public String KVy;
    public int KVz;
    public int cSx;
    public LinkedList<String> duo = new LinkedList<>();
    public int hXs;
    public int nHh;
    public String url;
    public int weight;

    public ow() {
        AppMethodBeat.i(212246);
        AppMethodBeat.o(212246);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124437);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KVy != null) {
                aVar.e(1, this.KVy);
            }
            aVar.aM(2, this.weight);
            aVar.aM(3, this.KVz);
            aVar.aM(4, this.cSx);
            if (this.url != null) {
                aVar.e(5, this.url);
            }
            aVar.aM(6, this.hXs);
            aVar.aM(7, this.KVA);
            aVar.aM(8, this.KVB);
            aVar.aM(9, this.KVC);
            aVar.aM(10, this.KVD);
            aVar.aM(11, this.KGm);
            aVar.aM(12, this.KIJ);
            aVar.aM(13, this.nHh);
            aVar.e(14, 1, this.duo);
            aVar.bb(15, this.KVE);
            if (this.KUp != null) {
                aVar.e(18, this.KUp);
            }
            aVar.e(19, 1, this.KVF);
            if (this.KVG != null) {
                aVar.ni(20, this.KVG.computeSize());
                this.KVG.writeFields(aVar);
            }
            AppMethodBeat.o(124437);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KVy != null ? g.a.a.b.b.a.f(1, this.KVy) + 0 : 0) + g.a.a.b.b.a.bu(2, this.weight) + g.a.a.b.b.a.bu(3, this.KVz) + g.a.a.b.b.a.bu(4, this.cSx);
            if (this.url != null) {
                f2 += g.a.a.b.b.a.f(5, this.url);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.hXs) + g.a.a.b.b.a.bu(7, this.KVA) + g.a.a.b.b.a.bu(8, this.KVB) + g.a.a.b.b.a.bu(9, this.KVC) + g.a.a.b.b.a.bu(10, this.KVD) + g.a.a.b.b.a.bu(11, this.KGm) + g.a.a.b.b.a.bu(12, this.KIJ) + g.a.a.b.b.a.bu(13, this.nHh) + g.a.a.a.c(14, 1, this.duo) + g.a.a.b.b.a.r(15, this.KVE);
            if (this.KUp != null) {
                bu += g.a.a.b.b.a.f(18, this.KUp);
            }
            int c2 = bu + g.a.a.a.c(19, 1, this.KVF);
            if (this.KVG != null) {
                c2 += g.a.a.a.nh(20, this.KVG.computeSize());
            }
            AppMethodBeat.o(124437);
            return c2;
        } else if (i2 == 2) {
            this.duo.clear();
            this.KVF.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124437);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ow owVar = (ow) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    owVar.KVy = aVar3.UbS.readString();
                    AppMethodBeat.o(124437);
                    return 0;
                case 2:
                    owVar.weight = aVar3.UbS.zi();
                    AppMethodBeat.o(124437);
                    return 0;
                case 3:
                    owVar.KVz = aVar3.UbS.zi();
                    AppMethodBeat.o(124437);
                    return 0;
                case 4:
                    owVar.cSx = aVar3.UbS.zi();
                    AppMethodBeat.o(124437);
                    return 0;
                case 5:
                    owVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(124437);
                    return 0;
                case 6:
                    owVar.hXs = aVar3.UbS.zi();
                    AppMethodBeat.o(124437);
                    return 0;
                case 7:
                    owVar.KVA = aVar3.UbS.zi();
                    AppMethodBeat.o(124437);
                    return 0;
                case 8:
                    owVar.KVB = aVar3.UbS.zi();
                    AppMethodBeat.o(124437);
                    return 0;
                case 9:
                    owVar.KVC = aVar3.UbS.zi();
                    AppMethodBeat.o(124437);
                    return 0;
                case 10:
                    owVar.KVD = aVar3.UbS.zi();
                    AppMethodBeat.o(124437);
                    return 0;
                case 11:
                    owVar.KGm = aVar3.UbS.zi();
                    AppMethodBeat.o(124437);
                    return 0;
                case 12:
                    owVar.KIJ = aVar3.UbS.zi();
                    AppMethodBeat.o(124437);
                    return 0;
                case 13:
                    owVar.nHh = aVar3.UbS.zi();
                    AppMethodBeat.o(124437);
                    return 0;
                case 14:
                    owVar.duo.add(aVar3.UbS.readString());
                    AppMethodBeat.o(124437);
                    return 0;
                case 15:
                    owVar.KVE = aVar3.UbS.zl();
                    AppMethodBeat.o(124437);
                    return 0;
                case 16:
                case 17:
                default:
                    AppMethodBeat.o(124437);
                    return -1;
                case 18:
                    owVar.KUp = aVar3.UbS.readString();
                    AppMethodBeat.o(124437);
                    return 0;
                case 19:
                    owVar.KVF.add(aVar3.UbS.readString());
                    AppMethodBeat.o(124437);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ahh ahh = new ahh();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ahh.populateBuilderWithField(aVar4, ahh, a.getNextFieldNumber(aVar4))) {
                        }
                        owVar.KVG = ahh;
                    }
                    AppMethodBeat.o(124437);
                    return 0;
            }
        } else {
            AppMethodBeat.o(124437);
            return -1;
        }
    }
}
