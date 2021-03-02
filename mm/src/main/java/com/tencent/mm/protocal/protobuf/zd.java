package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class zd extends a {
    public String AOv;
    public String Crt;
    public int Lko;
    public String dQx;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72459);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.dQx != null) {
                aVar.e(2, this.dQx);
            }
            if (this.AOv != null) {
                aVar.e(3, this.AOv);
            }
            if (this.Crt != null) {
                aVar.e(4, this.Crt);
            }
            aVar.aM(5, this.Lko);
            AppMethodBeat.o(72459);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.dQx != null) {
                f2 += g.a.a.b.b.a.f(2, this.dQx);
            }
            if (this.AOv != null) {
                f2 += g.a.a.b.b.a.f(3, this.AOv);
            }
            if (this.Crt != null) {
                f2 += g.a.a.b.b.a.f(4, this.Crt);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.Lko);
            AppMethodBeat.o(72459);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72459);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            zd zdVar = (zd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    zdVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(72459);
                    return 0;
                case 2:
                    zdVar.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(72459);
                    return 0;
                case 3:
                    zdVar.AOv = aVar3.UbS.readString();
                    AppMethodBeat.o(72459);
                    return 0;
                case 4:
                    zdVar.Crt = aVar3.UbS.readString();
                    AppMethodBeat.o(72459);
                    return 0;
                case 5:
                    zdVar.Lko = aVar3.UbS.zi();
                    AppMethodBeat.o(72459);
                    return 0;
                default:
                    AppMethodBeat.o(72459);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72459);
            return -1;
        }
    }
}
