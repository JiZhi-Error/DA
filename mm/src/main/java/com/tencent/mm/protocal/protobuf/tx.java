package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class tx extends a {
    public String KBH;
    public LinkedList<adz> Lch = new LinkedList<>();
    public int Lci;
    public String Lcj;
    public String name;

    public tx() {
        AppMethodBeat.i(32155);
        AppMethodBeat.o(32155);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32156);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.Lch);
            if (this.KBH != null) {
                aVar.e(2, this.KBH);
            }
            aVar.aM(3, this.Lci);
            if (this.Lcj != null) {
                aVar.e(4, this.Lcj);
            }
            if (this.name != null) {
                aVar.e(5, this.name);
            }
            AppMethodBeat.o(32156);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.Lch) + 0;
            if (this.KBH != null) {
                c2 += g.a.a.b.b.a.f(2, this.KBH);
            }
            int bu = c2 + g.a.a.b.b.a.bu(3, this.Lci);
            if (this.Lcj != null) {
                bu += g.a.a.b.b.a.f(4, this.Lcj);
            }
            if (this.name != null) {
                bu += g.a.a.b.b.a.f(5, this.name);
            }
            AppMethodBeat.o(32156);
            return bu;
        } else if (i2 == 2) {
            this.Lch.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32156);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            tx txVar = (tx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        adz adz = new adz();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = adz.populateBuilderWithField(aVar4, adz, a.getNextFieldNumber(aVar4))) {
                        }
                        txVar.Lch.add(adz);
                    }
                    AppMethodBeat.o(32156);
                    return 0;
                case 2:
                    txVar.KBH = aVar3.UbS.readString();
                    AppMethodBeat.o(32156);
                    return 0;
                case 3:
                    txVar.Lci = aVar3.UbS.zi();
                    AppMethodBeat.o(32156);
                    return 0;
                case 4:
                    txVar.Lcj = aVar3.UbS.readString();
                    AppMethodBeat.o(32156);
                    return 0;
                case 5:
                    txVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(32156);
                    return 0;
                default:
                    AppMethodBeat.o(32156);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32156);
            return -1;
        }
    }
}
