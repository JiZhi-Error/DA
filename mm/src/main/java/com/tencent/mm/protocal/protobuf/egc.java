package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class egc extends a {
    public String KSV;
    public LinkedList<String> KUB = new LinkedList<>();
    public int KUh;
    public long KWz;
    public String Luh;
    public String NfW;

    public egc() {
        AppMethodBeat.i(124560);
        AppMethodBeat.o(124560);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124561);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.KWz);
            if (this.KSV != null) {
                aVar.e(2, this.KSV);
            }
            aVar.e(3, 1, this.KUB);
            if (this.Luh != null) {
                aVar.e(4, this.Luh);
            }
            if (this.NfW != null) {
                aVar.e(5, this.NfW);
            }
            aVar.aM(6, this.KUh);
            AppMethodBeat.o(124561);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.KWz) + 0;
            if (this.KSV != null) {
                r += g.a.a.b.b.a.f(2, this.KSV);
            }
            int c2 = r + g.a.a.a.c(3, 1, this.KUB);
            if (this.Luh != null) {
                c2 += g.a.a.b.b.a.f(4, this.Luh);
            }
            if (this.NfW != null) {
                c2 += g.a.a.b.b.a.f(5, this.NfW);
            }
            int bu = c2 + g.a.a.b.b.a.bu(6, this.KUh);
            AppMethodBeat.o(124561);
            return bu;
        } else if (i2 == 2) {
            this.KUB.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124561);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            egc egc = (egc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    egc.KWz = aVar3.UbS.zl();
                    AppMethodBeat.o(124561);
                    return 0;
                case 2:
                    egc.KSV = aVar3.UbS.readString();
                    AppMethodBeat.o(124561);
                    return 0;
                case 3:
                    egc.KUB.add(aVar3.UbS.readString());
                    AppMethodBeat.o(124561);
                    return 0;
                case 4:
                    egc.Luh = aVar3.UbS.readString();
                    AppMethodBeat.o(124561);
                    return 0;
                case 5:
                    egc.NfW = aVar3.UbS.readString();
                    AppMethodBeat.o(124561);
                    return 0;
                case 6:
                    egc.KUh = aVar3.UbS.zi();
                    AppMethodBeat.o(124561);
                    return 0;
                default:
                    AppMethodBeat.o(124561);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124561);
            return -1;
        }
    }
}