package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class b extends a {
    public LinkedList<i> AZJ = new LinkedList<>();
    public String name;

    public b() {
        AppMethodBeat.i(91265);
        AppMethodBeat.o(91265);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91266);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            aVar.e(2, 8, this.AZJ);
            AppMethodBeat.o(91266);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.name != null ? g.a.a.b.b.a.f(1, this.name) + 0 : 0) + g.a.a.a.c(2, 8, this.AZJ);
            AppMethodBeat.o(91266);
            return f2;
        } else if (i2 == 2) {
            this.AZJ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91266);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(91266);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        i iVar = new i();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = iVar.populateBuilderWithField(aVar4, iVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bVar.AZJ.add(iVar);
                    }
                    AppMethodBeat.o(91266);
                    return 0;
                default:
                    AppMethodBeat.o(91266);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91266);
            return -1;
        }
    }
}
