package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dvp extends a {
    public LinkedList<cyk> KVY = new LinkedList<>();
    public String dMl;

    public dvp() {
        AppMethodBeat.i(122544);
        AppMethodBeat.o(122544);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122545);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dMl != null) {
                aVar.e(1, this.dMl);
            }
            aVar.e(2, 8, this.KVY);
            AppMethodBeat.o(122545);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.dMl != null ? g.a.a.b.b.a.f(1, this.dMl) + 0 : 0) + g.a.a.a.c(2, 8, this.KVY);
            AppMethodBeat.o(122545);
            return f2;
        } else if (i2 == 2) {
            this.KVY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122545);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dvp dvp = (dvp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dvp.dMl = aVar3.UbS.readString();
                    AppMethodBeat.o(122545);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cyk cyk = new cyk();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cyk.populateBuilderWithField(aVar4, cyk, a.getNextFieldNumber(aVar4))) {
                        }
                        dvp.KVY.add(cyk);
                    }
                    AppMethodBeat.o(122545);
                    return 0;
                default:
                    AppMethodBeat.o(122545);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122545);
            return -1;
        }
    }
}
