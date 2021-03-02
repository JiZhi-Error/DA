package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class m extends a {
    public LinkedList<bc> xJs = new LinkedList<>();
    public String xJt;

    public m() {
        AppMethodBeat.i(41712);
        AppMethodBeat.o(41712);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41713);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.xJs);
            if (this.xJt != null) {
                aVar.e(2, this.xJt);
            }
            AppMethodBeat.o(41713);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.xJs) + 0;
            if (this.xJt != null) {
                c2 += g.a.a.b.b.a.f(2, this.xJt);
            }
            AppMethodBeat.o(41713);
            return c2;
        } else if (i2 == 2) {
            this.xJs.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41713);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bc bcVar = new bc();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bcVar.populateBuilderWithField(aVar4, bcVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mVar.xJs.add(bcVar);
                    }
                    AppMethodBeat.o(41713);
                    return 0;
                case 2:
                    mVar.xJt = aVar3.UbS.readString();
                    AppMethodBeat.o(41713);
                    return 0;
                default:
                    AppMethodBeat.o(41713);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41713);
            return -1;
        }
    }
}
