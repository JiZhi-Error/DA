package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bai extends a {
    public LinkedList<bby> LJY = new LinkedList<>();
    public long lastUpdateTime;

    public bai() {
        AppMethodBeat.i(209631);
        AppMethodBeat.o(209631);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209632);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.lastUpdateTime);
            aVar.e(2, 8, this.LJY);
            AppMethodBeat.o(209632);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.lastUpdateTime) + 0 + g.a.a.a.c(2, 8, this.LJY);
            AppMethodBeat.o(209632);
            return r;
        } else if (i2 == 2) {
            this.LJY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209632);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bai bai = (bai) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bai.lastUpdateTime = aVar3.UbS.zl();
                    AppMethodBeat.o(209632);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bby bby = new bby();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bby.populateBuilderWithField(aVar4, bby, a.getNextFieldNumber(aVar4))) {
                        }
                        bai.LJY.add(bby);
                    }
                    AppMethodBeat.o(209632);
                    return 0;
                default:
                    AppMethodBeat.o(209632);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209632);
            return -1;
        }
    }
}
