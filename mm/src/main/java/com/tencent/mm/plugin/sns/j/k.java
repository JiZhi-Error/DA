package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class k extends a {
    public long DNN;
    public LinkedList<l> DRY = new LinkedList<>();
    public long DRZ;

    public k() {
        AppMethodBeat.i(179119);
        AppMethodBeat.o(179119);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(179120);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.DRY);
            aVar.bb(2, this.DRZ);
            aVar.bb(3, this.DNN);
            AppMethodBeat.o(179120);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.DRY) + 0 + g.a.a.b.b.a.r(2, this.DRZ) + g.a.a.b.b.a.r(3, this.DNN);
            AppMethodBeat.o(179120);
            return c2;
        } else if (i2 == 2) {
            this.DRY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(179120);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        l lVar = new l();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = lVar.populateBuilderWithField(aVar4, lVar, a.getNextFieldNumber(aVar4))) {
                        }
                        kVar.DRY.add(lVar);
                    }
                    AppMethodBeat.o(179120);
                    return 0;
                case 2:
                    kVar.DRZ = aVar3.UbS.zl();
                    AppMethodBeat.o(179120);
                    return 0;
                case 3:
                    kVar.DNN = aVar3.UbS.zl();
                    AppMethodBeat.o(179120);
                    return 0;
                default:
                    AppMethodBeat.o(179120);
                    return -1;
            }
        } else {
            AppMethodBeat.o(179120);
            return -1;
        }
    }
}
