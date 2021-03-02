package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class j extends a {
    public double HEA;
    public int HEB;
    public String HEC;
    public String HED;
    public b HEI;
    public String HEJ;
    public double HEK;
    public LinkedList<f> HEL = new LinkedList<>();
    public double HEs;
    public LinkedList<t> HEu = new LinkedList<>();
    public double HEz;

    public j() {
        AppMethodBeat.i(91296);
        AppMethodBeat.o(91296);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91297);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.HEJ != null) {
                aVar.e(1, this.HEJ);
            }
            aVar.e(2, this.HEK);
            aVar.e(3, this.HEs);
            aVar.e(4, 8, this.HEL);
            aVar.e(5, 8, this.HEu);
            aVar.e(6, this.HEz);
            aVar.e(7, this.HEA);
            aVar.aM(8, this.HEB);
            if (this.HEC != null) {
                aVar.e(9, this.HEC);
            }
            if (this.HED != null) {
                aVar.e(10, this.HED);
            }
            if (this.HEI != null) {
                aVar.c(11, this.HEI);
            }
            AppMethodBeat.o(91297);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.HEJ != null ? g.a.a.b.b.a.f(1, this.HEJ) + 0 : 0) + g.a.a.b.b.a.fS(2) + 8 + g.a.a.b.b.a.fS(3) + 8 + g.a.a.a.c(4, 8, this.HEL) + g.a.a.a.c(5, 8, this.HEu) + g.a.a.b.b.a.fS(6) + 8 + g.a.a.b.b.a.fS(7) + 8 + g.a.a.b.b.a.bu(8, this.HEB);
            if (this.HEC != null) {
                f2 += g.a.a.b.b.a.f(9, this.HEC);
            }
            if (this.HED != null) {
                f2 += g.a.a.b.b.a.f(10, this.HED);
            }
            if (this.HEI != null) {
                f2 += g.a.a.b.b.a.b(11, this.HEI);
            }
            AppMethodBeat.o(91297);
            return f2;
        } else if (i2 == 2) {
            this.HEL.clear();
            this.HEu.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91297);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jVar.HEJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91297);
                    return 0;
                case 2:
                    jVar.HEK = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91297);
                    return 0;
                case 3:
                    jVar.HEs = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91297);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        f fVar = new f();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fVar.populateBuilderWithField(aVar4, fVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jVar.HEL.add(fVar);
                    }
                    AppMethodBeat.o(91297);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        t tVar = new t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = tVar.populateBuilderWithField(aVar5, tVar, a.getNextFieldNumber(aVar5))) {
                        }
                        jVar.HEu.add(tVar);
                    }
                    AppMethodBeat.o(91297);
                    return 0;
                case 6:
                    jVar.HEz = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91297);
                    return 0;
                case 7:
                    jVar.HEA = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91297);
                    return 0;
                case 8:
                    jVar.HEB = aVar3.UbS.zi();
                    AppMethodBeat.o(91297);
                    return 0;
                case 9:
                    jVar.HEC = aVar3.UbS.readString();
                    AppMethodBeat.o(91297);
                    return 0;
                case 10:
                    jVar.HED = aVar3.UbS.readString();
                    AppMethodBeat.o(91297);
                    return 0;
                case 11:
                    jVar.HEI = aVar3.UbS.hPo();
                    AppMethodBeat.o(91297);
                    return 0;
                default:
                    AppMethodBeat.o(91297);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91297);
            return -1;
        }
    }
}
