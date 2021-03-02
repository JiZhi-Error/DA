package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cmb extends a {
    public String Mrt;
    public String Mru;
    public String Mrv;
    public String iAo;
    public String iAq;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(103209);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.iAq != null) {
                aVar.e(2, this.iAq);
            }
            if (this.iAo != null) {
                aVar.e(3, this.iAo);
            }
            if (this.Mrt != null) {
                aVar.e(4, this.Mrt);
            }
            if (this.Mru != null) {
                aVar.e(5, this.Mru);
            }
            if (this.Mrv != null) {
                aVar.e(6, this.Mrv);
            }
            AppMethodBeat.o(103209);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.iAq != null) {
                f2 += g.a.a.b.b.a.f(2, this.iAq);
            }
            if (this.iAo != null) {
                f2 += g.a.a.b.b.a.f(3, this.iAo);
            }
            if (this.Mrt != null) {
                f2 += g.a.a.b.b.a.f(4, this.Mrt);
            }
            if (this.Mru != null) {
                f2 += g.a.a.b.b.a.f(5, this.Mru);
            }
            if (this.Mrv != null) {
                f2 += g.a.a.b.b.a.f(6, this.Mrv);
            }
            AppMethodBeat.o(103209);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(103209);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cmb cmb = (cmb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cmb.title = aVar3.UbS.readString();
                    AppMethodBeat.o(103209);
                    return 0;
                case 2:
                    cmb.iAq = aVar3.UbS.readString();
                    AppMethodBeat.o(103209);
                    return 0;
                case 3:
                    cmb.iAo = aVar3.UbS.readString();
                    AppMethodBeat.o(103209);
                    return 0;
                case 4:
                    cmb.Mrt = aVar3.UbS.readString();
                    AppMethodBeat.o(103209);
                    return 0;
                case 5:
                    cmb.Mru = aVar3.UbS.readString();
                    AppMethodBeat.o(103209);
                    return 0;
                case 6:
                    cmb.Mrv = aVar3.UbS.readString();
                    AppMethodBeat.o(103209);
                    return 0;
                default:
                    AppMethodBeat.o(103209);
                    return -1;
            }
        } else {
            AppMethodBeat.o(103209);
            return -1;
        }
    }
}
