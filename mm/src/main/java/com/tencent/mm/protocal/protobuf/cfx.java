package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cfx extends a {
    public int LOF;
    public String hid;
    public String hie;
    public String hif;
    public String hig;
    public String hih;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116336);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.hid != null) {
                aVar.e(1, this.hid);
            }
            if (this.hie != null) {
                aVar.e(2, this.hie);
            }
            if (this.hif != null) {
                aVar.e(3, this.hif);
            }
            if (this.hig != null) {
                aVar.e(4, this.hig);
            }
            if (this.hih != null) {
                aVar.e(5, this.hih);
            }
            aVar.aM(6, this.LOF);
            AppMethodBeat.o(116336);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.hid != null ? g.a.a.b.b.a.f(1, this.hid) + 0 : 0;
            if (this.hie != null) {
                f2 += g.a.a.b.b.a.f(2, this.hie);
            }
            if (this.hif != null) {
                f2 += g.a.a.b.b.a.f(3, this.hif);
            }
            if (this.hig != null) {
                f2 += g.a.a.b.b.a.f(4, this.hig);
            }
            if (this.hih != null) {
                f2 += g.a.a.b.b.a.f(5, this.hih);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.LOF);
            AppMethodBeat.o(116336);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116336);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cfx cfx = (cfx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cfx.hid = aVar3.UbS.readString();
                    AppMethodBeat.o(116336);
                    return 0;
                case 2:
                    cfx.hie = aVar3.UbS.readString();
                    AppMethodBeat.o(116336);
                    return 0;
                case 3:
                    cfx.hif = aVar3.UbS.readString();
                    AppMethodBeat.o(116336);
                    return 0;
                case 4:
                    cfx.hig = aVar3.UbS.readString();
                    AppMethodBeat.o(116336);
                    return 0;
                case 5:
                    cfx.hih = aVar3.UbS.readString();
                    AppMethodBeat.o(116336);
                    return 0;
                case 6:
                    cfx.LOF = aVar3.UbS.zi();
                    AppMethodBeat.o(116336);
                    return 0;
                default:
                    AppMethodBeat.o(116336);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116336);
            return -1;
        }
    }
}
