package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class e extends a {
    public int id;
    public String name;
    public int value;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91271);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.id);
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            aVar.aM(3, this.value);
            AppMethodBeat.o(91271);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.id) + 0;
            if (this.name != null) {
                bu += g.a.a.b.b.a.f(2, this.name);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.value);
            AppMethodBeat.o(91271);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91271);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eVar.id = aVar3.UbS.zi();
                    AppMethodBeat.o(91271);
                    return 0;
                case 2:
                    eVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(91271);
                    return 0;
                case 3:
                    eVar.value = aVar3.UbS.zi();
                    AppMethodBeat.o(91271);
                    return 0;
                default:
                    AppMethodBeat.o(91271);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91271);
            return -1;
        }
    }
}