package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dct extends a {
    public int MHZ;
    public String Title;
    public String URL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209797);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.URL != null) {
                aVar.e(2, this.URL);
            }
            aVar.aM(3, this.MHZ);
            AppMethodBeat.o(209797);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.URL != null) {
                f2 += g.a.a.b.b.a.f(2, this.URL);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.MHZ);
            AppMethodBeat.o(209797);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209797);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dct dct = (dct) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dct.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(209797);
                    return 0;
                case 2:
                    dct.URL = aVar3.UbS.readString();
                    AppMethodBeat.o(209797);
                    return 0;
                case 3:
                    dct.MHZ = aVar3.UbS.zi();
                    AppMethodBeat.o(209797);
                    return 0;
                default:
                    AppMethodBeat.o(209797);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209797);
            return -1;
        }
    }
}