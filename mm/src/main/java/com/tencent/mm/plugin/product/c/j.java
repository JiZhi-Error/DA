package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class j extends a {
    public g Baa;
    public int cSx;
    public String nnB;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91276);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.cSx);
            if (this.Baa != null) {
                aVar.ni(2, this.Baa.computeSize());
                this.Baa.writeFields(aVar);
            }
            if (this.nnB != null) {
                aVar.e(3, this.nnB);
            }
            AppMethodBeat.o(91276);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.cSx) + 0;
            if (this.Baa != null) {
                bu += g.a.a.a.nh(2, this.Baa.computeSize());
            }
            if (this.nnB != null) {
                bu += g.a.a.b.b.a.f(3, this.nnB);
            }
            AppMethodBeat.o(91276);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91276);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jVar.cSx = aVar3.UbS.zi();
                    AppMethodBeat.o(91276);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        g gVar = new g();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = gVar.populateBuilderWithField(aVar4, gVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jVar.Baa = gVar;
                    }
                    AppMethodBeat.o(91276);
                    return 0;
                case 3:
                    jVar.nnB = aVar3.UbS.readString();
                    AppMethodBeat.o(91276);
                    return 0;
                default:
                    AppMethodBeat.o(91276);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91276);
            return -1;
        }
    }
}
