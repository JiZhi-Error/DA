package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bha extends a {
    public long KPp;
    public String KPq;
    public LinkedList<erh> LQO = new LinkedList<>();

    public bha() {
        AppMethodBeat.i(110898);
        AppMethodBeat.o(110898);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110899);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.KPp);
            aVar.e(2, 8, this.LQO);
            if (this.KPq != null) {
                aVar.e(3, this.KPq);
            }
            AppMethodBeat.o(110899);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.KPp) + 0 + g.a.a.a.c(2, 8, this.LQO);
            if (this.KPq != null) {
                r += g.a.a.b.b.a.f(3, this.KPq);
            }
            AppMethodBeat.o(110899);
            return r;
        } else if (i2 == 2) {
            this.LQO.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(110899);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bha bha = (bha) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bha.KPp = aVar3.UbS.zl();
                    AppMethodBeat.o(110899);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        erh erh = new erh();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = erh.populateBuilderWithField(aVar4, erh, a.getNextFieldNumber(aVar4))) {
                        }
                        bha.LQO.add(erh);
                    }
                    AppMethodBeat.o(110899);
                    return 0;
                case 3:
                    bha.KPq = aVar3.UbS.readString();
                    AppMethodBeat.o(110899);
                    return 0;
                default:
                    AppMethodBeat.o(110899);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110899);
            return -1;
        }
    }
}
