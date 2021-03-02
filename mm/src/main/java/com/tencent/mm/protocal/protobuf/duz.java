package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class duz extends a {
    public LinkedList<dvb> MWd = new LinkedList<>();
    public LinkedList<duy> MWe = new LinkedList<>();
    public dva MWf;
    public LinkedList<dvd> MWg = new LinkedList<>();
    public boolean gyp = true;
    public boolean thE = false;

    public duz() {
        AppMethodBeat.i(122527);
        AppMethodBeat.o(122527);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122528);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.gyp);
            aVar.cc(2, this.thE);
            aVar.e(3, 8, this.MWd);
            aVar.e(4, 8, this.MWe);
            if (this.MWf != null) {
                aVar.ni(5, this.MWf.computeSize());
                this.MWf.writeFields(aVar);
            }
            aVar.e(6, 8, this.MWg);
            AppMethodBeat.o(122528);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0 + g.a.a.b.b.a.fS(2) + 1 + g.a.a.a.c(3, 8, this.MWd) + g.a.a.a.c(4, 8, this.MWe);
            if (this.MWf != null) {
                fS += g.a.a.a.nh(5, this.MWf.computeSize());
            }
            int c2 = fS + g.a.a.a.c(6, 8, this.MWg);
            AppMethodBeat.o(122528);
            return c2;
        } else if (i2 == 2) {
            this.MWd.clear();
            this.MWe.clear();
            this.MWg.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122528);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            duz duz = (duz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    duz.gyp = aVar3.UbS.yZ();
                    AppMethodBeat.o(122528);
                    return 0;
                case 2:
                    duz.thE = aVar3.UbS.yZ();
                    AppMethodBeat.o(122528);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dvb dvb = new dvb();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dvb.populateBuilderWithField(aVar4, dvb, a.getNextFieldNumber(aVar4))) {
                        }
                        duz.MWd.add(dvb);
                    }
                    AppMethodBeat.o(122528);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        duy duy = new duy();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = duy.populateBuilderWithField(aVar5, duy, a.getNextFieldNumber(aVar5))) {
                        }
                        duz.MWe.add(duy);
                    }
                    AppMethodBeat.o(122528);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dva dva = new dva();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dva.populateBuilderWithField(aVar6, dva, a.getNextFieldNumber(aVar6))) {
                        }
                        duz.MWf = dva;
                    }
                    AppMethodBeat.o(122528);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dvd dvd = new dvd();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dvd.populateBuilderWithField(aVar7, dvd, a.getNextFieldNumber(aVar7))) {
                        }
                        duz.MWg.add(dvd);
                    }
                    AppMethodBeat.o(122528);
                    return 0;
                default:
                    AppMethodBeat.o(122528);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122528);
            return -1;
        }
    }
}
