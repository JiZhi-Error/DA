package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class e extends a {
    public LinkedList<d> KAA = new LinkedList<>();
    public String KAJ;
    public String KAK;
    public String KAL;
    public String KAM;
    public String KAN;
    public int KAO;
    public int KAz;
    public int nettype;
    public int uin;

    public e() {
        AppMethodBeat.i(143944);
        AppMethodBeat.o(143944);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143945);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.uin);
            aVar.aM(2, this.KAz);
            aVar.aM(3, this.nettype);
            aVar.e(4, 8, this.KAA);
            if (this.KAJ != null) {
                aVar.e(5, this.KAJ);
            }
            if (this.KAK != null) {
                aVar.e(6, this.KAK);
            }
            if (this.KAL != null) {
                aVar.e(7, this.KAL);
            }
            if (this.KAM != null) {
                aVar.e(8, this.KAM);
            }
            if (this.KAN != null) {
                aVar.e(9, this.KAN);
            }
            aVar.aM(10, this.KAO);
            AppMethodBeat.o(143945);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.uin) + 0 + g.a.a.b.b.a.bu(2, this.KAz) + g.a.a.b.b.a.bu(3, this.nettype) + g.a.a.a.c(4, 8, this.KAA);
            if (this.KAJ != null) {
                bu += g.a.a.b.b.a.f(5, this.KAJ);
            }
            if (this.KAK != null) {
                bu += g.a.a.b.b.a.f(6, this.KAK);
            }
            if (this.KAL != null) {
                bu += g.a.a.b.b.a.f(7, this.KAL);
            }
            if (this.KAM != null) {
                bu += g.a.a.b.b.a.f(8, this.KAM);
            }
            if (this.KAN != null) {
                bu += g.a.a.b.b.a.f(9, this.KAN);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.KAO);
            AppMethodBeat.o(143945);
            return bu2;
        } else if (i2 == 2) {
            this.KAA.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143945);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.uin = aVar3.UbS.zi();
                    AppMethodBeat.o(143945);
                    return 0;
                case 2:
                    eVar.KAz = aVar3.UbS.zi();
                    AppMethodBeat.o(143945);
                    return 0;
                case 3:
                    eVar.nettype = aVar3.UbS.zi();
                    AppMethodBeat.o(143945);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        d dVar = new d();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, a.getNextFieldNumber(aVar4))) {
                        }
                        eVar.KAA.add(dVar);
                    }
                    AppMethodBeat.o(143945);
                    return 0;
                case 5:
                    eVar.KAJ = aVar3.UbS.readString();
                    AppMethodBeat.o(143945);
                    return 0;
                case 6:
                    eVar.KAK = aVar3.UbS.readString();
                    AppMethodBeat.o(143945);
                    return 0;
                case 7:
                    eVar.KAL = aVar3.UbS.readString();
                    AppMethodBeat.o(143945);
                    return 0;
                case 8:
                    eVar.KAM = aVar3.UbS.readString();
                    AppMethodBeat.o(143945);
                    return 0;
                case 9:
                    eVar.KAN = aVar3.UbS.readString();
                    AppMethodBeat.o(143945);
                    return 0;
                case 10:
                    eVar.KAO = aVar3.UbS.zi();
                    AppMethodBeat.o(143945);
                    return 0;
                default:
                    AppMethodBeat.o(143945);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143945);
            return -1;
        }
    }
}
