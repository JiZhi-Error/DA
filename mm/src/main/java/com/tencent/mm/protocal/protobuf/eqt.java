package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eqt extends a {
    public String KUC;
    public String Noc;
    public String Noo;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212313);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Noc != null) {
                aVar.e(1, this.Noc);
            }
            if (this.KUC != null) {
                aVar.e(2, this.KUC);
            }
            if (this.Noo != null) {
                aVar.e(3, this.Noo);
            }
            aVar.aM(4, this.scene);
            AppMethodBeat.o(212313);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Noc != null ? g.a.a.b.b.a.f(1, this.Noc) + 0 : 0;
            if (this.KUC != null) {
                f2 += g.a.a.b.b.a.f(2, this.KUC);
            }
            if (this.Noo != null) {
                f2 += g.a.a.b.b.a.f(3, this.Noo);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.scene);
            AppMethodBeat.o(212313);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212313);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eqt eqt = (eqt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eqt.Noc = aVar3.UbS.readString();
                    AppMethodBeat.o(212313);
                    return 0;
                case 2:
                    eqt.KUC = aVar3.UbS.readString();
                    AppMethodBeat.o(212313);
                    return 0;
                case 3:
                    eqt.Noo = aVar3.UbS.readString();
                    AppMethodBeat.o(212313);
                    return 0;
                case 4:
                    eqt.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(212313);
                    return 0;
                default:
                    AppMethodBeat.o(212313);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212313);
            return -1;
        }
    }
}
