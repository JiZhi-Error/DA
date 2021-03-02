package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cjv extends a {
    public LinkedList<cjw> Mpl = new LinkedList<>();
    public LinkedList<cjw> Mpm = new LinkedList<>();
    public cjw Mpn;
    public int Mpo;
    public long dTS;
    public String key;
    public int yfC;

    public cjv() {
        AppMethodBeat.i(225972);
        AppMethodBeat.o(225972);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(225973);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.Mpl);
            aVar.e(2, 8, this.Mpm);
            if (this.Mpn != null) {
                aVar.ni(3, this.Mpn.computeSize());
                this.Mpn.writeFields(aVar);
            }
            aVar.aM(4, this.yfC);
            aVar.aM(5, this.Mpo);
            aVar.bb(6, this.dTS);
            if (this.key != null) {
                aVar.e(7, this.key);
            }
            AppMethodBeat.o(225973);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.Mpl) + 0 + g.a.a.a.c(2, 8, this.Mpm);
            if (this.Mpn != null) {
                c2 += g.a.a.a.nh(3, this.Mpn.computeSize());
            }
            int bu = c2 + g.a.a.b.b.a.bu(4, this.yfC) + g.a.a.b.b.a.bu(5, this.Mpo) + g.a.a.b.b.a.r(6, this.dTS);
            if (this.key != null) {
                bu += g.a.a.b.b.a.f(7, this.key);
            }
            AppMethodBeat.o(225973);
            return bu;
        } else if (i2 == 2) {
            this.Mpl.clear();
            this.Mpm.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(225973);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cjv cjv = (cjv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cjw cjw = new cjw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cjw.populateBuilderWithField(aVar4, cjw, a.getNextFieldNumber(aVar4))) {
                        }
                        cjv.Mpl.add(cjw);
                    }
                    AppMethodBeat.o(225973);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cjw cjw2 = new cjw();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cjw2.populateBuilderWithField(aVar5, cjw2, a.getNextFieldNumber(aVar5))) {
                        }
                        cjv.Mpm.add(cjw2);
                    }
                    AppMethodBeat.o(225973);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cjw cjw3 = new cjw();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cjw3.populateBuilderWithField(aVar6, cjw3, a.getNextFieldNumber(aVar6))) {
                        }
                        cjv.Mpn = cjw3;
                    }
                    AppMethodBeat.o(225973);
                    return 0;
                case 4:
                    cjv.yfC = aVar3.UbS.zi();
                    AppMethodBeat.o(225973);
                    return 0;
                case 5:
                    cjv.Mpo = aVar3.UbS.zi();
                    AppMethodBeat.o(225973);
                    return 0;
                case 6:
                    cjv.dTS = aVar3.UbS.zl();
                    AppMethodBeat.o(225973);
                    return 0;
                case 7:
                    cjv.key = aVar3.UbS.readString();
                    AppMethodBeat.o(225973);
                    return 0;
                default:
                    AppMethodBeat.o(225973);
                    return -1;
            }
        } else {
            AppMethodBeat.o(225973);
            return -1;
        }
    }
}
