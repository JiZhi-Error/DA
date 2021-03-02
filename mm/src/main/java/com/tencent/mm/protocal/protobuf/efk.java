package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class efk extends a {
    public b KZE;
    public String MEq;
    public String MGp;
    public String NfG;
    public b NfH;
    public int xJa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117930);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MGp != null) {
                aVar.e(1, this.MGp);
            }
            if (this.MEq != null) {
                aVar.e(2, this.MEq);
            }
            if (this.KZE != null) {
                aVar.c(3, this.KZE);
            }
            if (this.NfG != null) {
                aVar.e(4, this.NfG);
            }
            aVar.aM(5, this.xJa);
            if (this.NfH != null) {
                aVar.c(6, this.NfH);
            }
            AppMethodBeat.o(117930);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MGp != null ? g.a.a.b.b.a.f(1, this.MGp) + 0 : 0;
            if (this.MEq != null) {
                f2 += g.a.a.b.b.a.f(2, this.MEq);
            }
            if (this.KZE != null) {
                f2 += g.a.a.b.b.a.b(3, this.KZE);
            }
            if (this.NfG != null) {
                f2 += g.a.a.b.b.a.f(4, this.NfG);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.xJa);
            if (this.NfH != null) {
                bu += g.a.a.b.b.a.b(6, this.NfH);
            }
            AppMethodBeat.o(117930);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117930);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            efk efk = (efk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    efk.MGp = aVar3.UbS.readString();
                    AppMethodBeat.o(117930);
                    return 0;
                case 2:
                    efk.MEq = aVar3.UbS.readString();
                    AppMethodBeat.o(117930);
                    return 0;
                case 3:
                    efk.KZE = aVar3.UbS.hPo();
                    AppMethodBeat.o(117930);
                    return 0;
                case 4:
                    efk.NfG = aVar3.UbS.readString();
                    AppMethodBeat.o(117930);
                    return 0;
                case 5:
                    efk.xJa = aVar3.UbS.zi();
                    AppMethodBeat.o(117930);
                    return 0;
                case 6:
                    efk.NfH = aVar3.UbS.hPo();
                    AppMethodBeat.o(117930);
                    return 0;
                default:
                    AppMethodBeat.o(117930);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117930);
            return -1;
        }
    }
}
