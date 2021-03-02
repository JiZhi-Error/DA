package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fdz extends a {
    public String KGX;
    public String KHk;
    public int KSa;
    public int Nzs;
    public String Username;
    public String xut;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117959);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Username != null) {
                aVar.e(1, this.Username);
            }
            if (this.xut != null) {
                aVar.e(2, this.xut);
            }
            aVar.aM(3, this.KSa);
            if (this.KGX != null) {
                aVar.e(4, this.KGX);
            }
            aVar.aM(5, this.Nzs);
            if (this.KHk != null) {
                aVar.e(6, this.KHk);
            }
            AppMethodBeat.o(117959);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Username != null ? g.a.a.b.b.a.f(1, this.Username) + 0 : 0;
            if (this.xut != null) {
                f2 += g.a.a.b.b.a.f(2, this.xut);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.KSa);
            if (this.KGX != null) {
                bu += g.a.a.b.b.a.f(4, this.KGX);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.Nzs);
            if (this.KHk != null) {
                bu2 += g.a.a.b.b.a.f(6, this.KHk);
            }
            AppMethodBeat.o(117959);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117959);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fdz fdz = (fdz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fdz.Username = aVar3.UbS.readString();
                    AppMethodBeat.o(117959);
                    return 0;
                case 2:
                    fdz.xut = aVar3.UbS.readString();
                    AppMethodBeat.o(117959);
                    return 0;
                case 3:
                    fdz.KSa = aVar3.UbS.zi();
                    AppMethodBeat.o(117959);
                    return 0;
                case 4:
                    fdz.KGX = aVar3.UbS.readString();
                    AppMethodBeat.o(117959);
                    return 0;
                case 5:
                    fdz.Nzs = aVar3.UbS.zi();
                    AppMethodBeat.o(117959);
                    return 0;
                case 6:
                    fdz.KHk = aVar3.UbS.readString();
                    AppMethodBeat.o(117959);
                    return 0;
                default:
                    AppMethodBeat.o(117959);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117959);
            return -1;
        }
    }
}
