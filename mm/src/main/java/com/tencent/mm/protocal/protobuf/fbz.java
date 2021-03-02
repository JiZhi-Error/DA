package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fbz extends a {
    public String MiN;
    public String Nyc;
    public String dNI;
    public String dmc;
    public String qcK;
    public String qcM;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214330);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dNI != null) {
                aVar.e(1, this.dNI);
            }
            if (this.Nyc != null) {
                aVar.e(2, this.Nyc);
            }
            if (this.qcK != null) {
                aVar.e(3, this.qcK);
            }
            if (this.dmc != null) {
                aVar.e(4, this.dmc);
            }
            if (this.MiN != null) {
                aVar.e(5, this.MiN);
            }
            if (this.qcM != null) {
                aVar.e(6, this.qcM);
            }
            AppMethodBeat.o(214330);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dNI != null ? g.a.a.b.b.a.f(1, this.dNI) + 0 : 0;
            if (this.Nyc != null) {
                f2 += g.a.a.b.b.a.f(2, this.Nyc);
            }
            if (this.qcK != null) {
                f2 += g.a.a.b.b.a.f(3, this.qcK);
            }
            if (this.dmc != null) {
                f2 += g.a.a.b.b.a.f(4, this.dmc);
            }
            if (this.MiN != null) {
                f2 += g.a.a.b.b.a.f(5, this.MiN);
            }
            if (this.qcM != null) {
                f2 += g.a.a.b.b.a.f(6, this.qcM);
            }
            AppMethodBeat.o(214330);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(214330);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fbz fbz = (fbz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fbz.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(214330);
                    return 0;
                case 2:
                    fbz.Nyc = aVar3.UbS.readString();
                    AppMethodBeat.o(214330);
                    return 0;
                case 3:
                    fbz.qcK = aVar3.UbS.readString();
                    AppMethodBeat.o(214330);
                    return 0;
                case 4:
                    fbz.dmc = aVar3.UbS.readString();
                    AppMethodBeat.o(214330);
                    return 0;
                case 5:
                    fbz.MiN = aVar3.UbS.readString();
                    AppMethodBeat.o(214330);
                    return 0;
                case 6:
                    fbz.qcM = aVar3.UbS.readString();
                    AppMethodBeat.o(214330);
                    return 0;
                default:
                    AppMethodBeat.o(214330);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214330);
            return -1;
        }
    }
}
