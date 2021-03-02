package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class en extends a {
    public boolean xNL;
    public LinkedList<dj> xNM = new LinkedList<>();
    public LinkedList<dj> xNN = new LinkedList<>();

    public en() {
        AppMethodBeat.i(149421);
        AppMethodBeat.o(149421);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(149422);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.xNL);
            aVar.e(3, 8, this.xNM);
            aVar.e(4, 8, this.xNN);
            AppMethodBeat.o(149422);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0 + g.a.a.a.c(3, 8, this.xNM) + g.a.a.a.c(4, 8, this.xNN);
            AppMethodBeat.o(149422);
            return fS;
        } else if (i2 == 2) {
            this.xNM.clear();
            this.xNN.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(149422);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            en enVar = (en) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    enVar.xNL = aVar3.UbS.yZ();
                    AppMethodBeat.o(149422);
                    return 0;
                case 2:
                default:
                    AppMethodBeat.o(149422);
                    return -1;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dj djVar = new dj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = djVar.populateBuilderWithField(aVar4, djVar, a.getNextFieldNumber(aVar4))) {
                        }
                        enVar.xNM.add(djVar);
                    }
                    AppMethodBeat.o(149422);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dj djVar2 = new dj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = djVar2.populateBuilderWithField(aVar5, djVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        enVar.xNN.add(djVar2);
                    }
                    AppMethodBeat.o(149422);
                    return 0;
            }
        } else {
            AppMethodBeat.o(149422);
            return -1;
        }
    }
}
