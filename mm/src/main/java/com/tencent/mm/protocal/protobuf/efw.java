package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class efw extends a {
    public String Mmv;
    public int NfQ;
    public int NfR;
    public String jfi;
    public String xut;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153306);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mmv != null) {
                aVar.e(1, this.Mmv);
            }
            aVar.aM(2, this.NfQ);
            aVar.aM(3, this.NfR);
            if (this.xut != null) {
                aVar.e(4, this.xut);
            }
            if (this.jfi != null) {
                aVar.e(5, this.jfi);
            }
            AppMethodBeat.o(153306);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Mmv != null ? g.a.a.b.b.a.f(1, this.Mmv) + 0 : 0) + g.a.a.b.b.a.bu(2, this.NfQ) + g.a.a.b.b.a.bu(3, this.NfR);
            if (this.xut != null) {
                f2 += g.a.a.b.b.a.f(4, this.xut);
            }
            if (this.jfi != null) {
                f2 += g.a.a.b.b.a.f(5, this.jfi);
            }
            AppMethodBeat.o(153306);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153306);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            efw efw = (efw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    efw.Mmv = aVar3.UbS.readString();
                    AppMethodBeat.o(153306);
                    return 0;
                case 2:
                    efw.NfQ = aVar3.UbS.zi();
                    AppMethodBeat.o(153306);
                    return 0;
                case 3:
                    efw.NfR = aVar3.UbS.zi();
                    AppMethodBeat.o(153306);
                    return 0;
                case 4:
                    efw.xut = aVar3.UbS.readString();
                    AppMethodBeat.o(153306);
                    return 0;
                case 5:
                    efw.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(153306);
                    return 0;
                default:
                    AppMethodBeat.o(153306);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153306);
            return -1;
        }
    }
}
