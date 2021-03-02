package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ada extends a {
    public LinkedList<acz> KHx = new LinkedList<>();
    public long Lnv;
    public long Lnw;
    public int Lom;
    public int Lon;

    public ada() {
        AppMethodBeat.i(90962);
        AppMethodBeat.o(90962);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(90963);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.Lnv);
            aVar.bb(2, this.Lnw);
            aVar.e(3, 8, this.KHx);
            aVar.aM(4, this.Lom);
            aVar.aM(5, this.Lon);
            AppMethodBeat.o(90963);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Lnv) + 0 + g.a.a.b.b.a.r(2, this.Lnw) + g.a.a.a.c(3, 8, this.KHx) + g.a.a.b.b.a.bu(4, this.Lom) + g.a.a.b.b.a.bu(5, this.Lon);
            AppMethodBeat.o(90963);
            return r;
        } else if (i2 == 2) {
            this.KHx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(90963);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ada ada = (ada) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ada.Lnv = aVar3.UbS.zl();
                    AppMethodBeat.o(90963);
                    return 0;
                case 2:
                    ada.Lnw = aVar3.UbS.zl();
                    AppMethodBeat.o(90963);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        acz acz = new acz();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = acz.populateBuilderWithField(aVar4, acz, a.getNextFieldNumber(aVar4))) {
                        }
                        ada.KHx.add(acz);
                    }
                    AppMethodBeat.o(90963);
                    return 0;
                case 4:
                    ada.Lom = aVar3.UbS.zi();
                    AppMethodBeat.o(90963);
                    return 0;
                case 5:
                    ada.Lon = aVar3.UbS.zi();
                    AppMethodBeat.o(90963);
                    return 0;
                default:
                    AppMethodBeat.o(90963);
                    return -1;
            }
        } else {
            AppMethodBeat.o(90963);
            return -1;
        }
    }
}
