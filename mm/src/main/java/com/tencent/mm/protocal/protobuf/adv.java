package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class adv extends a {
    public ehf KEN;
    public String KNW;
    public LinkedList<ehf> Lee = new LinkedList<>();
    public LinkedList<ehf> Lpn = new LinkedList<>();
    public String Lpo;
    public int state;

    public adv() {
        AppMethodBeat.i(91427);
        AppMethodBeat.o(91427);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91428);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.state);
            if (this.KEN != null) {
                aVar.ni(2, this.KEN.computeSize());
                this.KEN.writeFields(aVar);
            }
            aVar.e(3, 8, this.Lee);
            aVar.e(4, 8, this.Lpn);
            if (this.Lpo != null) {
                aVar.e(5, this.Lpo);
            }
            if (this.KNW != null) {
                aVar.e(6, this.KNW);
            }
            AppMethodBeat.o(91428);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.state) + 0;
            if (this.KEN != null) {
                bu += g.a.a.a.nh(2, this.KEN.computeSize());
            }
            int c2 = bu + g.a.a.a.c(3, 8, this.Lee) + g.a.a.a.c(4, 8, this.Lpn);
            if (this.Lpo != null) {
                c2 += g.a.a.b.b.a.f(5, this.Lpo);
            }
            if (this.KNW != null) {
                c2 += g.a.a.b.b.a.f(6, this.KNW);
            }
            AppMethodBeat.o(91428);
            return c2;
        } else if (i2 == 2) {
            this.Lee.clear();
            this.Lpn.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91428);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            adv adv = (adv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    adv.state = aVar3.UbS.zi();
                    AppMethodBeat.o(91428);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ehf ehf = new ehf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ehf.populateBuilderWithField(aVar4, ehf, a.getNextFieldNumber(aVar4))) {
                        }
                        adv.KEN = ehf;
                    }
                    AppMethodBeat.o(91428);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ehf ehf2 = new ehf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ehf2.populateBuilderWithField(aVar5, ehf2, a.getNextFieldNumber(aVar5))) {
                        }
                        adv.Lee.add(ehf2);
                    }
                    AppMethodBeat.o(91428);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ehf ehf3 = new ehf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ehf3.populateBuilderWithField(aVar6, ehf3, a.getNextFieldNumber(aVar6))) {
                        }
                        adv.Lpn.add(ehf3);
                    }
                    AppMethodBeat.o(91428);
                    return 0;
                case 5:
                    adv.Lpo = aVar3.UbS.readString();
                    AppMethodBeat.o(91428);
                    return 0;
                case 6:
                    adv.KNW = aVar3.UbS.readString();
                    AppMethodBeat.o(91428);
                    return 0;
                default:
                    AppMethodBeat.o(91428);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91428);
            return -1;
        }
    }
}
