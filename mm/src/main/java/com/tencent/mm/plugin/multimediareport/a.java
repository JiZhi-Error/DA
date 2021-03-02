package com.tencent.mm.plugin.multimediareport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bw.a {
    public String key;
    public c zGA;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(194272);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.key != null) {
                aVar.e(1, this.key);
            }
            if (this.zGA != null) {
                aVar.ni(2, this.zGA.computeSize());
                this.zGA.writeFields(aVar);
            }
            AppMethodBeat.o(194272);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.key != null ? g.a.a.b.b.a.f(1, this.key) + 0 : 0;
            if (this.zGA != null) {
                f2 += g.a.a.a.nh(2, this.zGA.computeSize());
            }
            AppMethodBeat.o(194272);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(194272);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aVar4.key = aVar3.UbS.readString();
                    AppMethodBeat.o(194272);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        c cVar = new c();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cVar.populateBuilderWithField(aVar5, cVar, com.tencent.mm.bw.a.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.zGA = cVar;
                    }
                    AppMethodBeat.o(194272);
                    return 0;
                default:
                    AppMethodBeat.o(194272);
                    return -1;
            }
        } else {
            AppMethodBeat.o(194272);
            return -1;
        }
    }
}
