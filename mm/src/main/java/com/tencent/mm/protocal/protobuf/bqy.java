package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bqy extends a {
    public int LYw;
    public LinkedList<bqx> LYx = new LinkedList<>();

    public bqy() {
        AppMethodBeat.i(115840);
        AppMethodBeat.o(115840);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115841);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LYw);
            aVar.e(2, 8, this.LYx);
            AppMethodBeat.o(115841);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LYw) + 0 + g.a.a.a.c(2, 8, this.LYx);
            AppMethodBeat.o(115841);
            return bu;
        } else if (i2 == 2) {
            this.LYx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115841);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bqy bqy = (bqy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bqy.LYw = aVar3.UbS.zi();
                    AppMethodBeat.o(115841);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bqx bqx = new bqx();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bqx.populateBuilderWithField(aVar4, bqx, a.getNextFieldNumber(aVar4))) {
                        }
                        bqy.LYx.add(bqx);
                    }
                    AppMethodBeat.o(115841);
                    return 0;
                default:
                    AppMethodBeat.o(115841);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115841);
            return -1;
        }
    }
}