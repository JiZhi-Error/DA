package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class gq extends a {
    public int KKn;
    public int KKo;
    public int KKv;
    public gr KKw;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32120);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KKn);
            aVar.aM(2, this.KKo);
            aVar.aM(3, this.KKv);
            if (this.KKw != null) {
                aVar.ni(4, this.KKw.computeSize());
                this.KKw.writeFields(aVar);
            }
            AppMethodBeat.o(32120);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KKn) + 0 + g.a.a.b.b.a.bu(2, this.KKo) + g.a.a.b.b.a.bu(3, this.KKv);
            if (this.KKw != null) {
                bu += g.a.a.a.nh(4, this.KKw.computeSize());
            }
            AppMethodBeat.o(32120);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32120);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            gq gqVar = (gq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    gqVar.KKn = aVar3.UbS.zi();
                    AppMethodBeat.o(32120);
                    return 0;
                case 2:
                    gqVar.KKo = aVar3.UbS.zi();
                    AppMethodBeat.o(32120);
                    return 0;
                case 3:
                    gqVar.KKv = aVar3.UbS.zi();
                    AppMethodBeat.o(32120);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        gr grVar = new gr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = grVar.populateBuilderWithField(aVar4, grVar, a.getNextFieldNumber(aVar4))) {
                        }
                        gqVar.KKw = grVar;
                    }
                    AppMethodBeat.o(32120);
                    return 0;
                default:
                    AppMethodBeat.o(32120);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32120);
            return -1;
        }
    }
}
