package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cbm extends a {
    public LinkedList<cbn> LPG = new LinkedList<>();
    public LinkedList<erd> LPH = new LinkedList<>();
    public LinkedList<cbn> Mho = new LinkedList<>();
    public int aHK;
    public int count = 1;
    public String dMl = "";
    public String dRM = "";
    public long duration = 0;
    public long startTime = 0;

    public cbm() {
        AppMethodBeat.i(122512);
        AppMethodBeat.o(122512);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122513);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dMl != null) {
                aVar.e(1, this.dMl);
            }
            aVar.bb(2, this.startTime);
            aVar.bb(3, this.duration);
            if (this.dRM != null) {
                aVar.e(4, this.dRM);
            }
            aVar.e(5, 8, this.LPG);
            aVar.aM(6, this.count);
            aVar.e(7, 8, this.Mho);
            aVar.e(8, 8, this.LPH);
            aVar.aM(9, this.aHK);
            AppMethodBeat.o(122513);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.dMl != null ? g.a.a.b.b.a.f(1, this.dMl) + 0 : 0) + g.a.a.b.b.a.r(2, this.startTime) + g.a.a.b.b.a.r(3, this.duration);
            if (this.dRM != null) {
                f2 += g.a.a.b.b.a.f(4, this.dRM);
            }
            int c2 = f2 + g.a.a.a.c(5, 8, this.LPG) + g.a.a.b.b.a.bu(6, this.count) + g.a.a.a.c(7, 8, this.Mho) + g.a.a.a.c(8, 8, this.LPH) + g.a.a.b.b.a.bu(9, this.aHK);
            AppMethodBeat.o(122513);
            return c2;
        } else if (i2 == 2) {
            this.LPG.clear();
            this.Mho.clear();
            this.LPH.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122513);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cbm cbm = (cbm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cbm.dMl = aVar3.UbS.readString();
                    AppMethodBeat.o(122513);
                    return 0;
                case 2:
                    cbm.startTime = aVar3.UbS.zl();
                    AppMethodBeat.o(122513);
                    return 0;
                case 3:
                    cbm.duration = aVar3.UbS.zl();
                    AppMethodBeat.o(122513);
                    return 0;
                case 4:
                    cbm.dRM = aVar3.UbS.readString();
                    AppMethodBeat.o(122513);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cbn cbn = new cbn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cbn.populateBuilderWithField(aVar4, cbn, a.getNextFieldNumber(aVar4))) {
                        }
                        cbm.LPG.add(cbn);
                    }
                    AppMethodBeat.o(122513);
                    return 0;
                case 6:
                    cbm.count = aVar3.UbS.zi();
                    AppMethodBeat.o(122513);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cbn cbn2 = new cbn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cbn2.populateBuilderWithField(aVar5, cbn2, a.getNextFieldNumber(aVar5))) {
                        }
                        cbm.Mho.add(cbn2);
                    }
                    AppMethodBeat.o(122513);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        erd erd = new erd();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = erd.populateBuilderWithField(aVar6, erd, a.getNextFieldNumber(aVar6))) {
                        }
                        cbm.LPH.add(erd);
                    }
                    AppMethodBeat.o(122513);
                    return 0;
                case 9:
                    cbm.aHK = aVar3.UbS.zi();
                    AppMethodBeat.o(122513);
                    return 0;
                default:
                    AppMethodBeat.o(122513);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122513);
            return -1;
        }
    }
}
