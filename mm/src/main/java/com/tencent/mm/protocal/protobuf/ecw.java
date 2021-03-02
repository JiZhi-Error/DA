package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ecw extends a {
    public int Ndh;
    public int Ndi;
    public int Ndj;
    public int Ndk;
    public int Ndl;
    public int Ndm;
    public int Timestamp;
    public int oUu;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32457);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.oUu);
            aVar.aM(2, this.Timestamp);
            aVar.aM(3, this.Ndh);
            aVar.aM(4, this.Ndi);
            aVar.aM(5, this.Ndj);
            aVar.aM(6, this.Ndk);
            aVar.aM(7, this.Ndl);
            aVar.aM(8, this.Ndm);
            AppMethodBeat.o(32457);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oUu) + 0 + g.a.a.b.b.a.bu(2, this.Timestamp) + g.a.a.b.b.a.bu(3, this.Ndh) + g.a.a.b.b.a.bu(4, this.Ndi) + g.a.a.b.b.a.bu(5, this.Ndj) + g.a.a.b.b.a.bu(6, this.Ndk) + g.a.a.b.b.a.bu(7, this.Ndl) + g.a.a.b.b.a.bu(8, this.Ndm);
            AppMethodBeat.o(32457);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32457);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ecw ecw = (ecw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ecw.oUu = aVar3.UbS.zi();
                    AppMethodBeat.o(32457);
                    return 0;
                case 2:
                    ecw.Timestamp = aVar3.UbS.zi();
                    AppMethodBeat.o(32457);
                    return 0;
                case 3:
                    ecw.Ndh = aVar3.UbS.zi();
                    AppMethodBeat.o(32457);
                    return 0;
                case 4:
                    ecw.Ndi = aVar3.UbS.zi();
                    AppMethodBeat.o(32457);
                    return 0;
                case 5:
                    ecw.Ndj = aVar3.UbS.zi();
                    AppMethodBeat.o(32457);
                    return 0;
                case 6:
                    ecw.Ndk = aVar3.UbS.zi();
                    AppMethodBeat.o(32457);
                    return 0;
                case 7:
                    ecw.Ndl = aVar3.UbS.zi();
                    AppMethodBeat.o(32457);
                    return 0;
                case 8:
                    ecw.Ndm = aVar3.UbS.zi();
                    AppMethodBeat.o(32457);
                    return 0;
                default:
                    AppMethodBeat.o(32457);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32457);
            return -1;
        }
    }
}
