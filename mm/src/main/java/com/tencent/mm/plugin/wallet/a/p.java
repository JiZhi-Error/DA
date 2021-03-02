package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class p extends a {
    public String HEm;
    public int id;
    public String name;
    public String url;
    public String weappPath;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91302);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.id);
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            if (this.HEm != null) {
                aVar.e(4, this.HEm);
            }
            if (this.weappPath != null) {
                aVar.e(5, this.weappPath);
            }
            AppMethodBeat.o(91302);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.id) + 0;
            if (this.name != null) {
                bu += g.a.a.b.b.a.f(2, this.name);
            }
            if (this.url != null) {
                bu += g.a.a.b.b.a.f(3, this.url);
            }
            if (this.HEm != null) {
                bu += g.a.a.b.b.a.f(4, this.HEm);
            }
            if (this.weappPath != null) {
                bu += g.a.a.b.b.a.f(5, this.weappPath);
            }
            AppMethodBeat.o(91302);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91302);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            p pVar = (p) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pVar.id = aVar3.UbS.zi();
                    AppMethodBeat.o(91302);
                    return 0;
                case 2:
                    pVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(91302);
                    return 0;
                case 3:
                    pVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(91302);
                    return 0;
                case 4:
                    pVar.HEm = aVar3.UbS.readString();
                    AppMethodBeat.o(91302);
                    return 0;
                case 5:
                    pVar.weappPath = aVar3.UbS.readString();
                    AppMethodBeat.o(91302);
                    return 0;
                default:
                    AppMethodBeat.o(91302);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91302);
            return -1;
        }
    }
}
