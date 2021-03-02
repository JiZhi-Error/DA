package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class pk extends a {
    public int KHa;
    public LinkedList<pj> KUf = new LinkedList<>();
    public long KWz;
    public String Title;

    public pk() {
        AppMethodBeat.i(212254);
        AppMethodBeat.o(212254);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212255);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KHa);
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            aVar.e(3, 8, this.KUf);
            aVar.bb(4, this.KWz);
            AppMethodBeat.o(212255);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KHa) + 0;
            if (this.Title != null) {
                bu += g.a.a.b.b.a.f(2, this.Title);
            }
            int c2 = bu + g.a.a.a.c(3, 8, this.KUf) + g.a.a.b.b.a.r(4, this.KWz);
            AppMethodBeat.o(212255);
            return c2;
        } else if (i2 == 2) {
            this.KUf.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212255);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            pk pkVar = (pk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    pkVar.KHa = aVar3.UbS.zi();
                    AppMethodBeat.o(212255);
                    return 0;
                case 2:
                    pkVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(212255);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        pj pjVar = new pj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = pjVar.populateBuilderWithField(aVar4, pjVar, a.getNextFieldNumber(aVar4))) {
                        }
                        pkVar.KUf.add(pjVar);
                    }
                    AppMethodBeat.o(212255);
                    return 0;
                case 4:
                    pkVar.KWz = aVar3.UbS.zl();
                    AppMethodBeat.o(212255);
                    return 0;
                default:
                    AppMethodBeat.o(212255);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212255);
            return -1;
        }
    }
}
